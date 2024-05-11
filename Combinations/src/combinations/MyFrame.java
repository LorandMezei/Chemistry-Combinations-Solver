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
	
	private static final Object[] TABLE_COLUMN_NAMES = new Object[]{"Component", "Weight", "Charge", "Use", "Sort", "Force", "Min", "Max"};
	private static final String DEFAULT_FILE_SAVE_NAME = "combinations.txt";
	private static final String SORTED_FILE_APPEND_NAME = "_sorted.txt";
	private static final int TEXTFIELD_SIZE = 20;
	private static final int SYMBOL_TABLE_INDEX = 0;
	private static final int USE_TABLE_INDEX = 3;
	private static final int SORT_TABLE_INDEX = 4;
	private static final int FORCE_TABLE_INDEX = 5;
	private static final int MIN_TABLE_INDEX = 6;
	private static final int MAX_TABLE_INDEX = 7;
	
	private String componentToSort = "";
	private List<String> componentsToForce = new ArrayList<>();
	private HashMap<String, ComponentRange> symbolsToRanges = new HashMap<>();
	
	private JFrame frame;
	private JPanel mainPanel;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JTable componentsTable;
	private JLabel populateButtonLabel;
	private JLabel fileLoadLabel;
	private JLabel useRecursionLabel;
	private JLabel useAllLabel;
	private JLabel optionalComponentsLabel;
	private JLabel targetLabel;
	private JLabel rangeLabel;
	private JLabel chargeLabel;
	private JLabel fileSaveLabel;
	private JCheckBox useRecursionCheckBox;
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
	    this.prepareRecursion();
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
			
			ComponentsService.populateData(fileLoadPath.trim());
			
			final List<String> symbols = ComponentsService.getSymbols();
			Collections.sort(symbols, String.CASE_INSENSITIVE_ORDER);
			
			final List<Double> weights = new ArrayList<>();
			final List<Integer> charges = new ArrayList<>();
			for (final String s : symbols) {
				weights.add(ComponentsService.getSymbolsToWeights().get(s).doubleValue());
				charges.add(ComponentsService.getSymbolsToCharges().get(s));
			}
			
			this.loadTable(this.createTableModel(symbols, weights, charges));
		}
	}
	
	private void calculate() {
		try {
			long startTime = System.currentTimeMillis();
			
			final LinkedHashSet<String> solutions = new LinkedHashSet<>();
			final List<String> weights = this.loadComponents();

			//this.loadOptionalComponents(weights);
			this.createFiles(weights, solutions);
			
			final long endTime = System.currentTimeMillis();
			final long totalTime = endTime - startTime;
			System.out.println("Calculation took about " + (totalTime / 1000) + " seconds. Took exactly " + (totalTime) + " milliseconds." + "\n");
				
	    } catch (IOException ex) {
		      System.out.println("Problem creating files");
	    }
	}
	
	private void createFiles(final List<String> weights,
					      	 final LinkedHashSet<String> solutions) throws IOException {
		if (weights.size() > 0) {
		if (fileSaveTextField != null 
				&& fileSaveTextField.getText() != null) {
			
			final String fileSavePath = fileSaveTextField.getText().equals("") ? DEFAULT_FILE_SAVE_NAME : fileSaveTextField.getText() + ".txt";
			
			final FileWriter fileWriter = new FileWriter(fileSavePath.trim());
			
			if (targetTextField != null 
					&& targetTextField.getText() != null
					&& !targetTextField.getText().equals("")) {
				
				final double targetSum = Double.parseDouble(targetTextField.getText().trim());
				
				final boolean useAll = useAllCheckBox.isSelected();
				
				final boolean useRecursion = useRecursionCheckBox.isSelected();
				
				if (useRecursion) {
					final Recursion recursion = new Recursion();
					
					if (rangeTextField != null 
							&& rangeTextField.getText() != null 
							&& !rangeTextField.getText().equals("")) {
						
						final int range = Integer.parseInt(rangeTextField.getText().trim());
						
						recursion.findCombinationsLowerMatch(weights, targetSum, range, solutions, fileWriter, useAll,
								chargeTextField, componentToSort, symbolsToRanges, componentsToForce);
						recursion.findCombinationsUpperMatch(weights, targetSum, range, solutions, fileWriter, useAll,
								chargeTextField, componentToSort, symbolsToRanges, componentsToForce);
					}
					
					recursion.findCombinationsExactMatch(weights, targetSum, solutions, fileWriter, useAll,
							chargeTextField, componentToSort, symbolsToRanges, componentsToForce);
							
					this.createSortFile(fileSavePath, solutions, weights);
					
					System.out.println("Number of solutions: " + solutions.size());
					
				} else {
					
					Collections.sort(weights, new Comparator<String>() {
					    @Override
					    public int compare(String s1,
					    		           String s2) {
					    	final double min1 = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(s1))).getMin();
					    	final double max1 = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(s1))).getMax();
					    	final double s1Range = max1 - min1 + 1;
					    	
					    	final double min2 = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(s2))).getMin();
					    	final double max2 = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(s2))).getMax();
					    	final double s2Range = max2 - min2 + 1;
					    	
					    	return Double.compare(s2Range, s1Range);
					    }
					});
					
					if (rangeTextField != null 
							&& rangeTextField.getText() != null 
							&& !rangeTextField.getText().equals("")) {
						
						final int range = Integer.parseInt(rangeTextField.getText().trim());
						
						final ArrayList<ArrayList<String>> listOfSolutionsList = new ArrayList<>();
								
						final double min = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(0)))).getMin();
						final double max = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(0)))).getMax();
						
						final List<Thread> threads = new ArrayList<Thread>();	
						for (double a = min; a <= max; a++) {
							final ArrayList<String> solutionsList = new ArrayList<>();
							listOfSolutionsList.add(solutionsList);
							final Iteration i = new Iteration(
									a, weights, targetSum, Integer.parseInt(rangeTextField.getText()),
								    Integer.parseInt(chargeTextField.getText()), symbolsToRanges, solutionsList, rangeTextField, chargeTextField);
							
							final Thread thread = new Thread(i);
							thread.start();
							
							System.out.println("Starting thread : " + a);
	
							threads.add(thread);
						}
						
						for (final Thread t : threads) {
							try {
								t.join();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						
						int numberOfSolutions = 0;
						for (final ArrayList<String> list : listOfSolutionsList) {
							numberOfSolutions += list.size();
							for (final String s : list) {
								try {
									fileWriter.append(s);
								} catch (IOException ex) { 
									ex.printStackTrace();
								}
							}
						}
						
						this.createSortFile2(fileSavePath, listOfSolutionsList, weights);
					
						System.out.println("Number of solutions: " + numberOfSolutions);
					}
				}
			}
			
			fileWriter.close();
		}	
		}
	}
	
	private void createSortFile(final String fileSavePath,
								final LinkedHashSet<String> solutions,
								final List<String> weights) throws IOException {
		final boolean isThereAComponentSelectedToSort = !componentToSort.equals("");
		if (isThereAComponentSelectedToSort) {
			// combinations.txt
			String fileSavePath2 = fileSavePath.substring(0, fileSavePath.length() - 4);
			fileSavePath2 += SORTED_FILE_APPEND_NAME;
			
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
	
	private void createSortFile2(final String fileSavePath,
			final ArrayList<ArrayList<String>> listOfSolutionsList,
			final List<String> weights) throws IOException {
		final boolean isThereAComponentSelectedToSort = !componentToSort.equals("");
		if (isThereAComponentSelectedToSort) {
			// combinations.txt
			String fileSavePath2 = fileSavePath.substring(0, fileSavePath.length() - 4);
			fileSavePath2 += SORTED_FILE_APPEND_NAME;
			
			final FileWriter fileWriter2 = new FileWriter(fileSavePath2);
			
			final ArrayList<String> allSolutions = new ArrayList<String>();
			for (ArrayList<String> solutionsList : listOfSolutionsList) {
				for (String solution : solutionsList) {
					allSolutions.add(solution);
				}
			}
			
			this.sortList(allSolutions);
			
			for (final String solution : allSolutions) {
				try {
					fileWriter2.append(solution);
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
		    public int compare(String s1, String s2) {
		    	
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
		    		if (useRecursionCheckBox.isSelected()) {
		    			final Integer s1CountInt = getCount(s1);
						final Integer s2CountInt = getCount(s2);
						
						// largest to smallest. opposite would be s1CountInt.compareTo(s2CountInt)
				        return s2CountInt.compareTo(s1CountInt);
				        
		    		} else {
		    			final Integer s1CountInt = getCount2(s1);
						final Integer s2CountInt = getCount2(s2);
						
						// largest to smallest. opposite would be s1CountInt.compareTo(s2CountInt)
				        return s2CountInt.compareTo(s1CountInt);
		    		}
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
		    private Integer getCount2(final String solution) {		    	
		    	String count = "";
		    	final int componentIndex = solution.indexOf(componentToSort);
		    	
		    	int countIndex = componentIndex + componentToSort.length() + 1;
		    	while (countIndex < solution.length()) {
		    		char c = solution.charAt(countIndex);
		    		if (Character.isDigit(c)) {
		    			count += c;
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
		final DefaultTableModel model = new DefaultTableModel(TABLE_COLUMN_NAMES, 0) {
			@Override
	        public Class getColumnClass(int columnIndex) {
				if (columnIndex == USE_TABLE_INDEX 
						|| columnIndex == SORT_TABLE_INDEX
						|| columnIndex == FORCE_TABLE_INDEX) {
	        		return Boolean.class;
	        	} else {
	        		return String.class;
	        	}
	            
	         }
	    };
	    for (int i = 0; i < symbols.size(); i++) {
	    	model.addRow(new Object[] {symbols.get(i), weights.get(i), charges.get(i), false, false, false, "0", "50"});
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
	
	private List<String> loadComponents() {
		final List<String> weights = new ArrayList<>();
		for (int i = 0; i < componentsTable.getRowCount(); i++) {
			final String symbol = componentsTable.getValueAt(i, SYMBOL_TABLE_INDEX).toString();
			final String weight = ComponentsService.getSymbolsToWeights().get(symbol).toString();
			final Boolean useSelected = Boolean.valueOf(componentsTable.getValueAt(i, USE_TABLE_INDEX).toString());
			final Boolean sortSelected = Boolean.valueOf(componentsTable.getValueAt(i, SORT_TABLE_INDEX).toString());
			final Boolean forceSelected = Boolean.valueOf(componentsTable.getValueAt(i, FORCE_TABLE_INDEX).toString());
			
			if (useSelected) {
				weights.add(weight);
			}
			
			if (sortSelected) {
				componentToSort = symbol;
			}
			
			if (forceSelected) {
				componentsToForce.add(symbol);
			}
			
			final int min = Integer.parseInt(componentsTable.getValueAt(i, MIN_TABLE_INDEX).toString().trim());
			final int max = Integer.parseInt(componentsTable.getValueAt(i, MAX_TABLE_INDEX).toString().trim());
			final ComponentRange cr = new ComponentRange(min, max);
			symbolsToRanges.put(symbol, cr);
		}
		
		return weights;
	}
	
//	private void loadOptionalComponents(final List<String> weights) {
//		if (optionalComponentsTextField != null 
//				&& optionalComponentsTextField.getText() != null 
//				&& !optionalComponentsTextField.getText().equals("")) {
//			
//			final StringTokenizer outerTokenizer = new StringTokenizer(optionalComponentsTextField.getText(), ";");
//		    while (outerTokenizer.hasMoreElements()) {
//		    	final List<String> values = new ArrayList<>();
//		    	final StringTokenizer innerTokenizer = new StringTokenizer(outerTokenizer.nextToken(), ",");
//		        while(innerTokenizer.hasMoreElements()) {
//		        	values.add(innerTokenizer.nextToken());
//		        }
//		    	
//		        if (values.size() == ComponentsService.NUM_FILE_ARGUMENTS) {
//		        	final String symbol = values.get(ComponentsService.SYMBOL_FILE_INDEX);
//		        	final BigDecimal weight = new BigDecimal(values.get(ComponentsService.WEIGHT_FILE_INDEX));
//		        	final Integer charge = Integer.parseInt(values.get(ComponentsService.CHARGE_FILE_INDEX));
//		        	
//		        	weights.add(weight.doubleValue());
//		        	ComponentsService.addToSymbolsToWeights(symbol, weight);
//		        	ComponentsService.addToWeightsToSymbols(weight, symbol);
//		        	ComponentsService.addToWeightsToCharges(weight, charge);
//		        	ComponentsService.addToSymbolsToCharges(symbol, charge);
//		        }
//		    }
//		}
//	}
			    	
	//------------------------------------------------------------------------------------------------------------------------------------------------------
	
	private void prepareFileLoad() {
		fileLoadLabel = new JLabel("Components File Path (Optional): ");
		fileLoadTextField = new JTextField(TEXTFIELD_SIZE);
	}
	
	private void preparePopulate() {
		populateButtonLabel = new JLabel("Must press Populate before Calculate");
		populateButton = new JButton("Populate");
	    populateButton.setBounds(200, 100, 100, 50);
	    populateButton.addActionListener(this);
	}
	
	private void prepareComponentsTable() {
		componentsTableScrollPane = new JScrollPane(new JTable(new DefaultTableModel(TABLE_COLUMN_NAMES, 0)));
		componentsTableScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        componentsTableScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	}
	
	private void prepareRecursion() {
		useRecursionLabel = new JLabel("Use Recursion (Optional):");
		useRecursionCheckBox = new JCheckBox();
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
		panel3 = new JPanel(new GridLayout(8, 1, 0, 0));
		panel3.add(useRecursionLabel);
		panel3.add(useRecursionCheckBox);
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
