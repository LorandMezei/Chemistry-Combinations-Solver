package combinations;
import java.awt.Color;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class MyFrame extends JFrame implements ActionListener, TableModelListener{
	
	static final int TEXTFIELD_SIZE = 20;
	
	private String componentToSort = "";
	
	private long startTime = System.currentTimeMillis();
	
	private JFrame frame;
	private JPanel mainPanel;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JTable componentsTable;
	private JLabel populateButtonLabel;
	private JLabel fileLoadLabel;
	private JLabel useAllLabel;
	private JLabel optionalComponentsLabel;
	private JLabel targetLabel;
	private JLabel rangeLabel;
	private JLabel chargeLabel;
	private JLabel fileSaveLabel;
	private JCheckBox useAllCheckBox;
	private JTextField fileLoadTextField;
	private JTextField optionalComponentsTextField;
	private JTextField targetTextField;
	private JTextField rangeTextField;
	private JTextField chargeTextField;
	private JTextField fileSaveTextField;
	private JButton calculateButton;
	private JButton populateButton;
	private JScrollPane componentsTableScrollPane;
		
	MyFrame() {
		this.prepareFileLoad();
		this.preparePopulate();
	    this.prepareComponentsTable();
        this.prepareUseAll();
        this.prepareOptionalComponents();
        this.prepareTarget();
        this.prepareRange();
        this.prepareCharge();
        this.prepareFileSave();
        this.prepareCalculate();
        this.preparePanel1();
        this.preparePanel2();
        this.preparePanel3();
        this.prepareMainPanel();
        this.prepareFrame();
	}
	
	public static void main(String[] args) {    
        final MyFrame myFrame = new MyFrame();
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == populateButton) {
			this.populate();
		
		} else if (e.getSource() == calculateButton
				&& componentsTable != null) {
			this.calculate();
		}
	}
	
	public void tableChanged(TableModelEvent e) {
        
    }
	
	private void populate() {
		if (fileLoadTextField != null 
				&& fileLoadTextField.getText() != null) {
			
			final String fileLoadPath = fileLoadTextField.getText().equals("") ? "components.txt" : fileLoadTextField.getText();
			
			Components.populateData(fileLoadPath.trim());
			
			final List<String> symbols = Components.getSymbols();
			Collections.sort(symbols, String.CASE_INSENSITIVE_ORDER);
			
			final List<Double> weights = new ArrayList<>();
			final List<Integer> charges = new ArrayList<>();
			for (final String s : symbols) {
				weights.add(Components.getSymbolsToWeights().get(s).doubleValue());
				charges.add(Components.getSymbolsToCharges().get(s));
			}
			
			this.loadTable(this.createTableModel(symbols, weights, charges));
		}
	}
	
	private void calculate() {
		try {
			final LinkedHashSet<String> solutions = new LinkedHashSet<>();
			final List<Double> weights = this.loadWeights();

			this.loadOptionalComponents(weights);
			this.createFiles(weights, solutions);
			
			final long endTime = System.currentTimeMillis();
			System.out.println("Program took " + ((endTime - startTime) / 1000) + " seconds to finish.");
				
	    } catch (IOException ex) {
		      System.out.println("Problem creating files");
	    }
	}
	
	private void createFiles(final List<Double> weights,
					      	 final LinkedHashSet<String> solutions) throws IOException {
		if (fileSaveTextField != null 
				&& fileSaveTextField.getText() != null) {
			
			final String fileSavePath = fileSaveTextField.getText().equals("") ? "combinations.txt" : fileSaveTextField.getText() + ".txt";
			
			final FileWriter fileWriter = new FileWriter(fileSavePath.trim());
			
			if (targetTextField != null 
					&& targetTextField.getText() != null
					&& !targetTextField.getText().equals("")) {
				
				final double targetSum = Double.parseDouble(targetTextField.getText().trim());
				
				final boolean useAll = useAllCheckBox.isSelected();
					
				findCombinationsExactMatch(weights, targetSum, solutions, fileWriter, useAll);
				
				if (rangeTextField != null 
						&& rangeTextField.getText() != null 
						&& !rangeTextField.getText().equals("")) {
					
					final int range = Integer.parseInt(rangeTextField.getText());
					
					findCombinationsLowerMatch(weights, targetSum, range, solutions, fileWriter, useAll);
					findCombinationsUpperMatch(weights, targetSum, range, solutions, fileWriter, useAll);
				}
				
				this.createSortFile(fileSavePath, solutions);
			}
			
			fileWriter.close();
		}
	}
	
	private void createSortFile(final String fileSavePath,
								final LinkedHashSet<String> solutions ) throws IOException {
		final boolean isThereAComponentSelectedToSort = !componentToSort.equals("");
		if (isThereAComponentSelectedToSort) {
			// combinations.txt
			String fileSavePath2 = fileSavePath.substring(0, fileSavePath.length() - 4);
			fileSavePath2 += "_sorted.txt";
			
			final FileWriter fileWriter2 = new FileWriter(fileSavePath2);
			
			final ArrayList<String> solutionsList = new ArrayList<>(solutions);
			this.sortList(solutionsList);
			
			for (final String s : solutionsList) {
				try {
					fileWriter2.append(s);
					//System.out.println(s);
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
			
			fileWriter2.close();
		}
	}
	
	private void sortList(final ArrayList<String> solutionsList) {
		Collections.sort(solutionsList, new Comparator<String>() {
		    @Override
		    public int compare(String s1, 
		    		           String s2) {
		    	
		    	boolean s1ContainsSortComponent = s1.contains(componentToSort);
		    	boolean s2ContainsSortComponent = s2.contains(componentToSort);	
		    	if (s1ContainsSortComponent 
		    			&& !s2ContainsSortComponent) {
		    		return -1; // sort largest to smallest. opposite would be return 1
		    		
		    	} else if (!s1ContainsSortComponent 
		    			&& s2ContainsSortComponent) {
		    		return 1; // sort largest to smallest. opposite would be return -1
		    		
		    	} else if (!s1ContainsSortComponent 
		    			&& !s2ContainsSortComponent) {
		    		return 0;
		    		
		    	} else {
			    	final Integer s1CountInt = getCount(s1);
					final Integer s2CountInt = getCount(s2);
					
					// largest to smallest. opposite would be s1CountInt.compareTo(s2CountInt)
			        return s2CountInt.compareTo(s1CountInt);
		    	}
		    }
		    
		    private Integer getCount(final String solution) {
				
		    	final boolean isComponentCompound = componentToSort.length() > 2;
		    	
		    	String count = "";
		    	final int componentIndex = solution.indexOf(componentToSort);
		    	
		    	int countIndex = isComponentCompound ? componentIndex + componentToSort.length() + 1 : componentIndex + componentToSort.length();
		    	while (countIndex < solution.length()) {
		    		char c = solution.charAt(countIndex);
		    		if (this.isSubscript(c)) {
		    			count += Formatter.getSubscriptsToDigits().get(c);
		    		} else {
		    			break;
		    		}
		    		countIndex++;
		    	}
		     	
		    	return Integer.parseInt(count);
		    	
			}
		    
		    public boolean isSubscript(char c) {
		    	return Formatter.getSubscriptsToDigits().containsKey(c);
		    }
		});
	}
	
	private DefaultTableModel createTableModel(final List<String> symbols,
											   final List<Double> weights,
											   final List<Integer> charges) {
		final DefaultTableModel model = new DefaultTableModel(new Object[]{"Component", "Weight", "Charge", "Use", "Sort (Optional)"}, 0) {
			@Override
	        public Class getColumnClass(int columnIndex) {
				if (columnIndex == 3 
						|| columnIndex == 4) {
	        		return Boolean.class;
	        	} else {
	        		return String.class;
	        	}
	            
	         }
	    };
	    for (int i = 0; i < symbols.size(); i++) {
	    	model.addRow(new Object[] {symbols.get(i), weights.get(i), charges.get(i), false, false});
	    }
	    
	    return model;
	}
	
	private void loadTable(final DefaultTableModel model) {
		componentsTable = new JTable(model) // add striping to table
		{
		    public Component prepareRenderer(TableCellRenderer renderer, int row, int column)
		    {
		        final Component c = super.prepareRenderer(renderer, row, column);

		        //  Alternate row color 
		        if (!isRowSelected(row))
		            c.setBackground(row % 2 == 0 ? getBackground() :  new Color(240,240,240));

		        return c;
		    }
		};
		componentsTableScrollPane.getViewport().add(componentsTable);
	}
	
	private List<Double> loadWeights() {
		final List<Double> weights = new ArrayList<>();
		for (int i = 0; i < componentsTable.getRowCount(); i++) {
			final String symbol = componentsTable.getValueAt(i, 0).toString();
			final Double weight = Components.getSymbolsToWeights().get(symbol).doubleValue();
			final Boolean useSelected = Boolean.valueOf(componentsTable.getValueAt(i, 3).toString());
			final Boolean sortSelected = Boolean.valueOf(componentsTable.getValueAt(i,4).toString());
			
			if (useSelected) {
				weights.add(weight);
			}
			
			if (sortSelected) {
				componentToSort = symbol;
			}
		}
		
		return weights;
	}
	
	private void loadOptionalComponents(final List<Double> weights) {
		if (optionalComponentsTextField != null 
				&& optionalComponentsTextField.getText() != null 
				&& !optionalComponentsTextField.getText().equals("")) {
			
			final StringTokenizer outerTokenizer = new StringTokenizer(optionalComponentsTextField.getText(), ";");
		    while (outerTokenizer.hasMoreElements()) {
		    	final List<String> values = new ArrayList<>();
		    	final StringTokenizer innerTokenizer = new StringTokenizer(outerTokenizer.nextToken(), ",");
		        while(innerTokenizer.hasMoreElements()) {
		        	values.add(innerTokenizer.nextToken());
		        }
		    	
		        if (values.size() == 2) {
		        	final String symbol = values.get(0);
		        	final BigDecimal weight = new BigDecimal(values.get(1));
		        	
		        	weights.add(weight.doubleValue());
		        	Components.addToSymbolsToWeights(symbol, weight);
		        	Components.addToWeightsToSymbols(weight, symbol);
		        }
		    }
		}
	}
		    	
	private void findCombinationsLowerMatch(final List<Double> weights, 
								         final double targetSum,
								         final int range,
								         LinkedHashSet<String> solutions,
								         final FileWriter fileWriter,
								         final boolean useAll) { 
		// Sort the list of weights from smallest to largest.
		Collections.sort(weights);
	    
	    // This list will hold a single path.
	    final List<Double> solution = new ArrayList<>();
	    
	    this.findLowerMatch(0, weights, targetSum, range, 0, solution, solutions, fileWriter, useAll);
	}
	
	private void findCombinationsUpperMatch(final List<Double> weights, 
	         final double targetSum,
	         final int range,
	         LinkedHashSet<String> solutions,
	         final FileWriter fileWriter,
	         final boolean useAll) { 
		Collections.sort(weights);
		
		// This list will hold a single path.
		final List<Double> solution = new ArrayList<>();
		
		this.findUpperMatch(0, weights, targetSum, range, 0, solution, solutions, fileWriter, useAll);
	}
	
	private void findCombinationsExactMatch(final List<Double> weights, 
	         							 final double targetSum,
	         							 LinkedHashSet<String> solutions,
	         							 final FileWriter fileWriter,
	         							 final boolean useAll) { 
		Collections.sort(weights);
		
		// This list will hold a single path.
		final List<Double> solution = new ArrayList<>();
		
		this.findExactMatch(0, weights, targetSum, 0, solution, solutions, fileWriter, useAll);
	}
					
	private void findLowerMatch(final int weightsIndex,
			 List<Double> weights, 
			 final double targetSum,
		     final int range,
		     double currentSum,
		     List<Double> path,
		     LinkedHashSet<String> solutions,
		     final FileWriter fileWriter,
		     final boolean useAll) {
		
		BigDecimal currentSumRounded = BigDecimal.valueOf(currentSum);
		currentSumRounded = currentSumRounded.setScale(3, RoundingMode.CEILING);
				
		BigDecimal targetSumRounded = BigDecimal.valueOf(targetSum);
		targetSumRounded = targetSumRounded.setScale(3, RoundingMode.CEILING);
		
		if (currentSumRounded.compareTo(getUpperBound(targetSumRounded, range)) > 0) {
			return;
		 
		// The target sum range has been reached.
		} else if (isWithinSumRange(currentSumRounded, targetSumRounded, range)
						&& currentSumRounded.compareTo(targetSumRounded) < 0) {
			
			final boolean usesAllComponents = isUsingAllComponents(path, weights);
			if (useAll) {
				if (usesAllComponents) {
					// The current path is a solution. 
					// Add the path to the list of solutions.
					final String solution = "ALL lower "
							+ currentSumRounded 
							+ "\n" 
							+ getFormula(path, weights) 
							+ "\n" 
							+ "____________________________________" 
							+ "\n";
					
					if (chargeTextField != null 
							&& chargeTextField.getText() != null 
							&& !chargeTextField.getText().equals("")) {
						
						final Integer currentCharge = this.getTotalCharge(solution);
						final Integer targetCharge = Integer.parseInt(chargeTextField.getText());
						if (currentCharge.equals(targetCharge ) 
								&& solutions.add(solution)) {
							try {
								fileWriter.append(solution);
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						
					} else {
						if (solutions.add(solution)) {
							try {
								fileWriter.append(solution);
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}
				}
				
			} else {
				
				// The current path is a solution. 
				// Add the path to the list of solutions.
				String solution = "";
				 
				if (usesAllComponents) {
					solution += "ALL ";
				}
				 
				solution += "lower "
						+ currentSumRounded 
						+ "\n" 
						+ getFormula(path, weights) 
						+ "\n" 
						+ "____________________________________" 
						+ "\n";
				
				if (chargeTextField != null 
						&& chargeTextField.getText() != null 
						&& !chargeTextField.getText().equals("")) {
					
					final Integer currentCharge = this.getTotalCharge(solution);
					final Integer targetCharge = Integer.parseInt(chargeTextField.getText());
					if (currentCharge.equals(targetCharge ) 
							&& solutions.add(solution)) {
						try {
							fileWriter.append(solution);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					
				} else {
					if (solutions.add(solution)) {
						try {
							fileWriter.append(solution);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
						
			return;
		 
		// The target sum has not been reached yet.
		} else if (currentSumRounded.compareTo(getLowerBound(targetSumRounded, range)) < 0) {
			for (int i = weightsIndex; i < weights.size(); ++i) {
				// Add the current weight to the path
			path.add(weights.get(i));
					  
			final double nextTargetSum = currentSum + weights.get(i);
			  
			this.findLowerMatch(i, weights, targetSum, range, nextTargetSum, path, solutions, fileWriter, useAll);
			  
			// Remove the last weight in the path because it is extra and not actually part of the path.
				path.remove(path.size() - 1);
			}
		}		
	}
		
	private void findUpperMatch(final int weightsIndex,
			 List<Double> weights, 
			 final double targetSum,
		     final int range,
		     double currentSum,
		     List<Double> path,
		     LinkedHashSet<String> solutions,
		     final FileWriter fileWriter,
		     final boolean useAll) {
		
		BigDecimal currentSumRounded = BigDecimal.valueOf(currentSum);
		currentSumRounded = currentSumRounded.setScale(3, RoundingMode.CEILING);
				
		BigDecimal targetSumRounded = BigDecimal.valueOf(targetSum);
		targetSumRounded = targetSumRounded.setScale(3, RoundingMode.CEILING);
		
		if (currentSumRounded.compareTo(getUpperBound(targetSumRounded, range)) > 0) {
			return;
		 
		} else if (isWithinSumRange(currentSumRounded, targetSumRounded, range)
						&& currentSumRounded.compareTo(targetSumRounded) > 0
						&& !((currentSumRounded.add(BigDecimal.valueOf(weights.get(weightsIndex)))).compareTo(getUpperBound(targetSumRounded, range)) <= 0)) {
			
			final boolean usesAllComponents = isUsingAllComponents(path, weights);
			if (useAll) {
				if (usesAllComponents) {
					// The current path is a solution. 
					// Add the path to the list of solutions.
					final String solution = "ALL upper "
							+ currentSumRounded 
							+ "\n" 
							+ getFormula(path, weights) 
							+ "\n" 
							+ "____________________________________" 
							+ "\n";
					
					if (chargeTextField != null 
							&& chargeTextField.getText() != null 
							&& !chargeTextField.getText().equals("")) {
						
						final Integer currentCharge = this.getTotalCharge(solution);
						final Integer targetCharge = Integer.parseInt(chargeTextField.getText());
						if (currentCharge.equals(targetCharge ) 
								&& solutions.add(solution)) {
							try {
								fileWriter.append(solution);
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						
					} else {
						if (solutions.add(solution)) {
							try {
								fileWriter.append(solution);
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}
				}
				
			} else {
				
				// The current path is a solution. 
				// Add the path to the list of solutions.
				String solution = "";
				 
				if (usesAllComponents) {
					solution += "ALL ";
				}
				 
				solution += "upper "
						+ currentSumRounded 
						+ "\n" 
						+ getFormula(path, weights) 
						+ "\n" 
						+ "____________________________________" 
						+ "\n";
				
				if (chargeTextField != null 
						&& chargeTextField.getText() != null 
						&& !chargeTextField.getText().equals("")) {
					
					final Integer currentCharge = this.getTotalCharge(solution);
					final Integer targetCharge = Integer.parseInt(chargeTextField.getText());
					if (currentCharge.equals(targetCharge ) 
							&& solutions.add(solution)) {
						try {
							fileWriter.append(solution);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					
				} else {
					if (solutions.add(solution)) {
						try {
							fileWriter.append(solution);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
						
			return;
		 
		// The target sum has not been reached yet.
		} else if (currentSumRounded.compareTo(getUpperBound(targetSumRounded, range)) < 0) {
			for (int i = weightsIndex; i < weights.size(); ++i) {
				// Add the current weight to the path
				path.add(weights.get(i));
			
				final double nextTargetSum = currentSum + weights.get(i);
				  
				this.findUpperMatch(i, weights, targetSum, range, nextTargetSum, path, solutions, fileWriter, useAll);
				  
				// The if (targetSum < 0) and if (targetSum == 0) will bring the code here.
				// Remove the last weight in the path because it is extra and not actually part of the path.
				path.remove(path.size() - 1);
			}
		}
	}
		
	private void findExactMatch(final int weightsIndex,
			  				 List<Double> weights, 
			  				 final double targetSum,
			  			     double currentSum,
			  			     List<Double> path,
			  			     LinkedHashSet<String> solutions,
			  			     final FileWriter fileWriter,
			  			     final boolean useAll) {
		
		BigDecimal currentSumRounded = BigDecimal.valueOf(currentSum);
		currentSumRounded = currentSumRounded.setScale(3, RoundingMode.CEILING);
				
		BigDecimal targetSumRounded = BigDecimal.valueOf(targetSum);
		targetSumRounded = targetSumRounded.setScale(3, RoundingMode.CEILING);
		
		if (currentSum > targetSum) {
			return;
			  
		} else if (currentSumRounded.equals(targetSumRounded)) {
			final boolean usesAllComponents = isUsingAllComponents(path, weights);
			if (useAll) {
				if (usesAllComponents) {
					// The current path is a solution. 
					// Add the path to the list of solutions.
					final String solution = "ALL exact "
							+ currentSumRounded 
							+ "\n" 
							+ getFormula(path, weights) 
							+ "\n" 
							+ "____________________________________" 
							+ "\n";
					
					if (chargeTextField != null 
							&& chargeTextField.getText() != null 
							&& !chargeTextField.getText().equals("")) {
						
						final Integer currentCharge = this.getTotalCharge(solution);
						final Integer targetCharge = Integer.parseInt(chargeTextField.getText());
						if (currentCharge.equals(targetCharge ) 
								&& solutions.add(solution)) {
							try {
								fileWriter.append(solution);
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						
					} else {
						if (solutions.add(solution)) {
							try {
								fileWriter.append(solution);
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}
				}
				
			} else {
				
				// The current path is a solution. 
				// Add the path to the list of solutions.
				String solution = "";
				 
				if (usesAllComponents) {
					solution += "ALL ";
				}
				 
				solution += "exact "
						+ currentSumRounded 
						+ "\n" 
						+ getFormula(path, weights) 
						+ "\n" 
						+ "____________________________________" 
						+ "\n";
				
				if (chargeTextField != null 
						&& chargeTextField.getText() != null 
						&& !chargeTextField.getText().equals("")) {
					
					final Integer currentCharge = this.getTotalCharge(solution);
					final Integer targetCharge = Integer.parseInt(chargeTextField.getText());
					if (currentCharge.equals(targetCharge ) 
							&& solutions.add(solution)) {
						try {
							fileWriter.append(solution);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					
				} else {
					if (solutions.add(solution)) {
						try {
							fileWriter.append(solution);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}
						
			return;
		 
		// The target sum has not been reached yet.
		} else if (currentSum < targetSum) {
			for (int i = weightsIndex; i < weights.size(); ++i) {
				// Add the current weight to the path
				path.add(weights.get(i));

				final double nextTargetSum = currentSum + weights.get(i);
				  
				this.findExactMatch(i, weights, targetSum, nextTargetSum, path, solutions, fileWriter, useAll);
				  
				// The if (targetSum < 0) and if (targetSum == 0) will bring the code here.
				// Remove the last weight in the path because it is extra and not actually part of the path.
				path.remove(path.size() - 1);
			}
		}
	}
	
	private String getFormula(final List<Double> path,
						      final List<Double> weights) {
		String formula = "";
		
        final Map<Double, Integer> weightsToFrequency = new HashMap<>();
 
        for (final Double i : path) {
            Integer j = weightsToFrequency.get(i);
            weightsToFrequency.put(i, (j == null) ? 1 : j + 1);
        }
        
        Integer totalCharge = 0;
           
    	final List<Map.Entry<Double, Integer>> entrySet = new ArrayList<>(weightsToFrequency.entrySet());
        for (int i = 0; i < entrySet.size(); i++) {
        	final BigDecimal key = BigDecimal.valueOf(entrySet.get(i).getKey());
        	final Integer value = entrySet.get(i).getValue();
        	final Integer charge = Components.getWeightsToCharges().get(key);
        	
        	totalCharge += charge * value;
        	
        	String subscript = "";
        	for (final char c : String.valueOf(value).toCharArray()) {
        		subscript += Formatter.getDigitsToSubscripts().get(c);
        	}
        	
        	if (Components.getWeightsToSymbols().containsKey(key)) {
        		final String symbol = Components.getWeightsToSymbols().get(key);
        		if (symbol.length() > 2) {
        			formula += "(" + symbol + ")" + subscript;
        		} else {
        			formula += Components.getWeightsToSymbols().get(key) + subscript;
        		}
        	
        	} else {
        		formula += " " + entrySet.get(i).getKey() + " " + entrySet.get(i).getValue() + " times" + "\n";

        		if (i == entrySet.size() - 1) {
            		formula = formula.substring(0, formula.length() - 1);
            	}
        	} 
        } 
        
        formula += " : " + totalCharge;
        
        if (!componentToSort.equals("") 
        		&& formula.contains(componentToSort)) {
        	final int[][] indices = this.getIndicesOfSortedComponent(formula);
        	final String sortedComponent =  formula.substring(indices[0][0], indices[0][1]);
        	final String newFormula = sortedComponent + formula.replace(sortedComponent, "");
        	formula = newFormula;
        }
    
        return formula;
    }
	
	private Integer getTotalCharge(final String solution) {
		final StringBuilder charge = new StringBuilder("");;
		for (int i = solution.length() - 39; i >= 0; i--) {
			if (solution.charAt(i) != ' ') {
				charge.append(solution.charAt(i));
			} else {
				break;
			}
		}
		
		return Integer.parseInt(charge.reverse().toString());
	}
	
	private int[][] getIndicesOfSortedComponent(final String solution) {
		final int[][] indices = new int[1][2];
		
    	final boolean isComponentCompound = componentToSort.length() > 2;
    	
    	final int componentIndex = solution.indexOf(componentToSort);
    	
    	int countIndex = isComponentCompound ? componentIndex + componentToSort.length() + 1 : componentIndex + componentToSort.length();
    	while (countIndex < solution.length()) {
    		char c = solution.charAt(countIndex);
    		if (this.isSubscript(c)) {
    		} else {
    			break;
    		}
    		countIndex++;
    	}
    	
    	indices[0][0] = componentIndex;
    	indices[0][1] = countIndex;
    	
		return indices;
	}
	
	public boolean isSubscript(char c) {
    	return Formatter.getSubscriptsToDigits().containsKey(c);
    }
	
	private boolean isUsingAllComponents(final List<Double> path, 
										 final List<Double> weights) {
		for (final Double d : weights) {
			if (!path.contains(d)) {
				return false;
			}
		}
		
		return true;
	}
		
	private boolean isWithinSumRange(final BigDecimal value, 
									 final BigDecimal sum,
									 final int range) {
		return isWithinLowerBound(value, sum, range) 
				&& isWithinUpperBound(value, sum, range);
	}
	
	private boolean isWithinLowerBound(final BigDecimal value, 
	        						   final BigDecimal sum,
	                                   final int range) {
		//value >= getLowerBound(sum, rangePercentage);
		return value.compareTo(getLowerBound(sum, range)) >= 0;
	}
	
	private boolean isWithinUpperBound(final BigDecimal value, 
	                                   final BigDecimal sum,
	                                   final int range) {
		// value <= getUpperBound(sum, rangePercentage); 
		return value.compareTo(getUpperBound(sum, range)) <= 0;
	}
	
	private BigDecimal getLowerBound(final BigDecimal sum,
								     final int range) {
		// sum * (1 - rangePercentage);
		//return sum.multiply((new BigDecimal("1.000")).subtract(BigDecimal.valueOf(range)));
		return sum.subtract(BigDecimal.valueOf(range));
	}
	
	private BigDecimal getUpperBound(final BigDecimal sum,
	        					     final int range) {
		// sum * (1 + rangePercentage);
		//return sum.multiply((new BigDecimal("1.000")).add(BigDecimal.valueOf(range)));
		return sum.add(BigDecimal.valueOf(range));
	}	
	
	//------------------------------------------------------------------------------------------------------------------------------------------------------
	
	private void prepareFileLoad() {
		fileLoadLabel = new JLabel("Components File Path (Optional): ");
		fileLoadTextField = new JTextField(20);
	}
	
	private void preparePopulate() {
		populateButtonLabel = new JLabel("Must press Populate before Calculate");
		populateButton = new JButton("Populate");
	    populateButton.setBounds(200, 100, 100, 50);
	    populateButton.addActionListener(this);
	}
	
	private void prepareComponentsTable() {
		componentsTableScrollPane = new JScrollPane(new JTable(new DefaultTableModel(new Object[]{"Component", "Weight", "Charge", "Use", "Sort (Optional)"}, 0)));
		componentsTableScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        componentsTableScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	}
	
	private void prepareUseAll() {
		useAllLabel = new JLabel("Use All Components Only (Optional): ");
        useAllCheckBox = new JCheckBox();
	}
	
	private void prepareOptionalComponents() {
		optionalComponentsLabel = new JLabel("Use More Components (Optional): ");
        optionalComponentsTextField = new JTextField(TEXTFIELD_SIZE);
	}
	
	private void prepareTarget() {
		targetLabel = new JLabel("Target Sum: ");
        targetTextField = new JTextField(TEXTFIELD_SIZE);
	}
	
	private void prepareRange() {
		rangeLabel = new JLabel("Range +- (Optional): ");
        rangeTextField = new JTextField(TEXTFIELD_SIZE);
	}
	
	private void prepareCharge() {
		chargeLabel = new JLabel("Target Charge (Optional): ");
		chargeTextField = new JTextField(TEXTFIELD_SIZE);
	}
	
	private void prepareFileSave() {
		fileSaveLabel = new JLabel("File Path To Save (Optional): ");
        fileSaveTextField = new JTextField(TEXTFIELD_SIZE);
	}
	
	private void prepareCalculate() {
		calculateButton = new JButton("Calculate");
        calculateButton.setBounds(200, 100, 100, 50);
        calculateButton.addActionListener(this);
	}
	
	private void preparePanel1() {
		panel1 = new JPanel(new GridLayout(4, 1, 0, 0));      
        panel1.add(fileLoadLabel);
        panel1.add(fileLoadTextField);
        panel1.add(populateButtonLabel);
        panel1.add(populateButton);
	}
	
	private void preparePanel2() {
		panel2 = new JPanel();    
        panel2.add(componentsTableScrollPane);
	}
	
	private void preparePanel3() {
		panel3 = new JPanel(new GridLayout(7, 1, 0, 0));
        panel3.add(useAllLabel);
        panel3.add(useAllCheckBox);
        panel3.add(optionalComponentsLabel);
        panel3.add(optionalComponentsTextField);
        panel3.add(targetLabel);
        panel3.add(targetTextField);
        panel3.add(rangeLabel);
        panel3.add(rangeTextField);
        panel3.add(chargeLabel);
        panel3.add(chargeTextField);
        panel3.add(fileSaveLabel);
        panel3.add(fileSaveTextField);
        panel3.add(calculateButton);
	}
	
	private void prepareMainPanel() {
		mainPanel = new JPanel(); 
        mainPanel.add(panel1);
        mainPanel.add(panel2);
        mainPanel.add(panel3);
	}
	
	private void prepareFrame() {
		frame = new JFrame("Combinations - Lorand Mezei");
	    frame.add(mainPanel);
	    frame.setSize(1920, 1080);
	    frame.show();
	}
	
}
