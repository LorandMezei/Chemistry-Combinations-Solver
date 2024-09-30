package calculationAlgorithms;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import javax.swing.JTextField;

import setupHelpers.ComponentRange;
import setupHelpers.ComponentsService2;
import setupHelpers.Formatter;

public class Recursion {
	
	private static final String SOLUTION_SEPARATION_LINE = "____________________________________";
	
	public void findCombinationsLowerMatch(final List<String> weights, 
									        final double targetSum,
									        final int range,
									        final LinkedHashSet<String> solutions,
									        final FileWriter fileWriter,
									        final boolean useAll,
									        final JTextField chargeTextField,
									        final String componentToSort,
									        final HashMap<String, ComponentRange> symbolsToRanges,
									        final List<String> componentsToForce) { 
		
			Collections.sort(weights, Collections.reverseOrder());
		    
		    // This list will hold a single path.
		    final List<String> solution = new ArrayList<>();
		    
		    System.out.println("################### Starting search for combinations in lower range of target sum ###################");
		    
		    this.findLowerMatch(0, weights, targetSum, range, 0, solution, solutions, fileWriter,
		    		useAll, chargeTextField, componentToSort, symbolsToRanges, componentsToForce);
		}
		
		public void findCombinationsUpperMatch(final List<String> weights, 
									            final double targetSum,
									            final int range,
									            final LinkedHashSet<String> solutions,
									            final FileWriter fileWriter,
									            final boolean useAll,
									            final JTextField chargeTextField,
							  			        final String componentToSort,
							  			        final HashMap<String, ComponentRange> symbolsToRanges,
							  			        final List<String> componentsToForce) { 
			
			Collections.sort(weights, Collections.reverseOrder());
			
			// This list will hold a single path.
			final List<String> solution = new ArrayList<>();
			
			System.out.println("################### Starting search for combinations in upper range of target sum ###################");
			
			this.findUpperMatch(0, weights, targetSum, range, 0, solution, solutions, fileWriter, useAll,
					chargeTextField, componentToSort, symbolsToRanges, componentsToForce);
		}
		
		public void findCombinationsExactMatch(final List<String> weights, 
		         							    final double targetSum,
		         							    final LinkedHashSet<String> solutions,
		         							    final FileWriter fileWriter,
		         							    final boolean useAll,
		         							    final JTextField chargeTextField,
							  			        final String componentToSort,
							  			        final HashMap<String, ComponentRange> symbolsToRanges,
							  			        final List<String> componentsToForce) { 
			
			Collections.sort(weights, Collections.reverseOrder());
			
			// This list will hold a single path.
			final List<String> solution = new ArrayList<>();
			
			System.out.println("################### Starting search for combinations that are exact target sum ###################");
			
			this.findExactMatch(0, weights, targetSum, 0, solution, solutions, fileWriter, useAll,
					chargeTextField, componentToSort, symbolsToRanges, componentsToForce);
		}
						
		private void findLowerMatch(final int weightsIndex,
									 final List<String> weights, 
									 final double targetSum,
								     final int range,
								     double currentSum,
								     final List<String> path,
								     final LinkedHashSet<String> solutions,
								     final FileWriter fileWriter,
								     final boolean useAll,
								     final JTextField chargeTextField,
					  			     final String componentToSort,
					  			     final HashMap<String, ComponentRange> symbolsToRanges,
					  			     final List<String> componentsToForce) {
			
			if (this.isAComponentOverMax(path, weights, symbolsToRanges)) {
				return;
			}
			
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
								+ getFormula(path, weights, componentToSort) 
								+ "\n" 
								+ SOLUTION_SEPARATION_LINE
								+ "\n";
						
						boolean containsAllForced = this.containsAllForced(solution, componentsToForce);
						boolean areAllInRange = this.areAllComponentsInRange(solution, weights, symbolsToRanges);
						
						if (containsAllForced 
								&& areAllInRange) {
							
							if (chargeTextField != null 
									&& chargeTextField.getText() != null 
									&& !chargeTextField.getText().equals("")) {
								
								final Integer currentCharge = this.getTotalCharge(solution);
								final Integer targetCharge = Integer.parseInt(chargeTextField.getText().trim());
								if (currentCharge.equals(targetCharge ) 
										&& solutions.add(solution)) {
									try {
										System.out.println(solution);
										fileWriter.append(solution);
									} catch (IOException e) {
										e.printStackTrace();
									}
								}
								
							} else {
								if (solutions.add(solution)) {
									try {
										System.out.println(solution);
										fileWriter.append(solution);
									} catch (IOException e) {
										e.printStackTrace();
									}
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
							+ getFormula(path, weights, componentToSort) 
							+ "\n" 
							+ SOLUTION_SEPARATION_LINE
							+ "\n";
					
					boolean containsAllForced = this.containsAllForced(solution, componentsToForce);
					boolean areAllInRange = this.areAllComponentsInRange(solution, weights, symbolsToRanges);
					
					if (containsAllForced 
							&& areAllInRange) {
						
						if (chargeTextField != null 
								&& chargeTextField.getText() != null 
								&& !chargeTextField.getText().equals("")) {
							
							final Integer currentCharge = this.getTotalCharge(solution);
							final Integer targetCharge = Integer.parseInt(chargeTextField.getText().trim());
							if (currentCharge.equals(targetCharge ) 
									&& solutions.add(solution)) {
								try {
									System.out.println(solution);
									fileWriter.append(solution);
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
							
						} else {
							if (solutions.add(solution)) {
								try {
									System.out.println(solution);
									fileWriter.append(solution);
								} catch (IOException e) {
									e.printStackTrace();
								}
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
						  
				final double nextTargetSum = currentSum + Double.parseDouble(weights.get(i));
				  
				this.findLowerMatch(i, weights, targetSum, range, nextTargetSum, path, solutions, fileWriter, useAll,
						chargeTextField, componentToSort, symbolsToRanges, componentsToForce);
				  
				// Remove the last weight in the path because it is extra and not actually part of the path.
					path.remove(path.size() - 1);
				}
			}		
		}
			
		private void findUpperMatch(final int weightsIndex,
									 final List<String> weights, 
									 final double targetSum,
								     final int range,
								     double currentSum,
								     final List<String> path,
								     final LinkedHashSet<String> solutions,
								     final FileWriter fileWriter,
								     final boolean useAll,
								     final JTextField chargeTextField,
					  			     final String componentToSort,
					  			     final HashMap<String, ComponentRange> symbolsToRanges,
					  			     final List<String> componentsToForce) {
			
			if (this.isAComponentOverMax(path, weights, symbolsToRanges)) {
				return;
			}
			
			BigDecimal currentSumRounded = BigDecimal.valueOf(currentSum);
			currentSumRounded = currentSumRounded.setScale(3, RoundingMode.CEILING);
					
			BigDecimal targetSumRounded = BigDecimal.valueOf(targetSum);
			targetSumRounded = targetSumRounded.setScale(3, RoundingMode.CEILING);
			
			if (currentSumRounded.compareTo(getUpperBound(targetSumRounded, range)) > 0) {
				return;
			 
			} else if (isWithinSumRange(currentSumRounded, targetSumRounded, range)
							&& currentSumRounded.compareTo(targetSumRounded) > 0
							&& !((currentSumRounded.add(new BigDecimal(weights.get(weightsIndex)))).compareTo(getUpperBound(targetSumRounded, range)) <= 0)) {
				
				final boolean usesAllComponents = isUsingAllComponents(path, weights);
				if (useAll) {
					if (usesAllComponents) {
						// The current path is a solution. 
						// Add the path to the list of solutions.
						final String solution = "ALL upper "
								+ currentSumRounded 
								+ "\n" 
								+ getFormula(path, weights, componentToSort) 
								+ "\n" 
								+ SOLUTION_SEPARATION_LINE
								+ "\n";
						
						boolean containsAllForced = this.containsAllForced(solution, componentsToForce);
						boolean areAllInRange = this.areAllComponentsInRange(solution, weights, symbolsToRanges);
						
						if (containsAllForced 
								&& areAllInRange) {
							
							if (chargeTextField != null 
									&& chargeTextField.getText() != null 
									&& !chargeTextField.getText().equals("")) {
								
								final Integer currentCharge = this.getTotalCharge(solution);
								final Integer targetCharge = Integer.parseInt(chargeTextField.getText().trim());
								if (currentCharge.equals(targetCharge ) 
										&& solutions.add(solution)) {
									try {
										System.out.println(solution);
										fileWriter.append(solution);
									} catch (IOException e) {
										e.printStackTrace();
									}
								}
								
							} else {
								if (solutions.add(solution)) {
									try {
										System.out.println(solution);
										fileWriter.append(solution);
									} catch (IOException e) {
										e.printStackTrace();
									}
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
							+ getFormula(path, weights, componentToSort) 
							+ "\n" 
							+ SOLUTION_SEPARATION_LINE
							+ "\n";
					
					boolean containsAllForced = this.containsAllForced(solution, componentsToForce);
					boolean areAllInRange = this.areAllComponentsInRange(solution, weights, symbolsToRanges);
					
					if (containsAllForced 
							&& areAllInRange) {
						
						if (chargeTextField != null 
								&& chargeTextField.getText() != null 
								&& !chargeTextField.getText().equals("")) {
							
							final Integer currentCharge = this.getTotalCharge(solution);
							final Integer targetCharge = Integer.parseInt(chargeTextField.getText().trim());
							if (currentCharge.equals(targetCharge) 
									&& solutions.add(solution)) {
								try {
									System.out.println(solution);
									fileWriter.append(solution);
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
							
						} else {
							if (solutions.add(solution)) {
								try {
									System.out.println(solution);
									fileWriter.append(solution);
								} catch (IOException e) {
									e.printStackTrace();
								}
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
				
					final double nextTargetSum = currentSum + Double.parseDouble(weights.get(i));
					  
					this.findUpperMatch(i, weights, targetSum, range, nextTargetSum, path, solutions, fileWriter, useAll, 
							chargeTextField, componentToSort, symbolsToRanges, componentsToForce);
					  
					// Remove the last weight in the path because it is extra and not actually part of the path.
					path.remove(path.size() - 1);
				}
			}
		}
			
		private void findExactMatch(final int weightsIndex,
					  				 final List<String> weights, 
					  				 final double targetSum,
					  			     double currentSum,
					  			     final List<String> path,
					  			     final LinkedHashSet<String> solutions,
					  			     final FileWriter fileWriter,
					  			     final boolean useAll,
					  			     final JTextField chargeTextField,
					  			     final String componentToSort,
					  			     final HashMap<String, ComponentRange> symbolsToRanges,
					  			     final List<String> componentsToForce) {
			
			if (this.isAComponentOverMax(path, weights, symbolsToRanges)) {
				return;
			}
			
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
								+ getFormula(path, weights, componentToSort) 
								+ "\n" 
								+ SOLUTION_SEPARATION_LINE
								+ "\n";
						
						boolean containsAllForced = this.containsAllForced(solution, componentsToForce);
						boolean areAllInRange = this.areAllComponentsInRange(solution, weights, symbolsToRanges);
						
						if (containsAllForced 
								&& areAllInRange) {
							
							if (chargeTextField != null 
									&& chargeTextField.getText() != null 
									&& !chargeTextField.getText().equals("")) {
								
								final Integer currentCharge = this.getTotalCharge(solution);
								final Integer targetCharge = Integer.parseInt(chargeTextField.getText().trim());
								if (currentCharge.equals(targetCharge ) 
										&& solutions.add(solution)) {
									try {
										System.out.println(solution);
										fileWriter.append(solution);
									} catch (IOException e) {
										e.printStackTrace();
									}
								}
								
							} else {
								if (solutions.add(solution)) {
									try {
										System.out.println(solution);
										fileWriter.append(solution);
									} catch (IOException e) {
										e.printStackTrace();
									}
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
							+ getFormula(path, weights, componentToSort) 
							+ "\n" 
							+ SOLUTION_SEPARATION_LINE
							+ "\n";
					
					boolean containsAllForced = this.containsAllForced(solution, componentsToForce);
					boolean areAllInRange = this.areAllComponentsInRange(solution, weights, symbolsToRanges);
					
					if (containsAllForced 
							&& areAllInRange) {
						
						if (chargeTextField != null 
								&& chargeTextField.getText() != null 
								&& !chargeTextField.getText().equals("")) {
							
							final Integer currentCharge = this.getTotalCharge(solution);
							final Integer targetCharge = Integer.parseInt(chargeTextField.getText().trim());
							if (currentCharge.equals(targetCharge ) 
									&& solutions.add(solution)) {
								try {
									System.out.println(solution);
									fileWriter.append(solution);
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
							
						} else {
							if (solutions.add(solution)) {
								try {
									System.out.println(solution);
									fileWriter.append(solution);
								} catch (IOException e) {
									e.printStackTrace();
								}
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
	
					final double nextTargetSum = currentSum + Double.parseDouble(weights.get(i));
					  
					this.findExactMatch(i, weights, targetSum, nextTargetSum, path, solutions, fileWriter, useAll,
							chargeTextField, componentToSort, symbolsToRanges, componentsToForce);
					  
					// Remove the last weight in the path because it is extra and not actually part of the path.
					path.remove(path.size() - 1);
				}
			}
		}
		
		private String getFormula(final List<String> path,
							      final List<String> weights,
							      final String componentToSort) {
			String formula = "";
			
	        final Map<String, Integer> weightsToFrequency = new HashMap<>();
	 
	        for (final String i : path) {
	            Integer j = weightsToFrequency.get(i);
	            weightsToFrequency.put(i, (j == null) ? 1 : j + 1);
	        }
	        
	        Integer totalCharge = 0;
	           
	    	final List<Map.Entry<String, Integer>> entrySet = new ArrayList<>(weightsToFrequency.entrySet());
	        for (int i = 0; i < entrySet.size(); i++) {
	        	final BigDecimal weight = new BigDecimal(entrySet.get(i).getKey());
	        	final Integer count = entrySet.get(i).getValue();
	        	final Integer charge = ComponentsService2.getWeightsToCharges().get(weight);
	        	
	        	totalCharge += charge * count;
	        	
	        	String subscript = "";
	        	for (final char c : String.valueOf(count).toCharArray()) {
	        		subscript += Formatter.getDigitsToSubscripts().get(c);
	        	}
	        	
	        	if (ComponentsService2.getWeightsToSymbols().containsKey(weight)) {
	        		final String symbol = ComponentsService2.getWeightsToSymbols().get(weight);
	        		if (symbol.length() > 2) {
	        			formula += "(" + symbol + ")" + subscript;
	        		} else {
	        			formula += ComponentsService2.getWeightsToSymbols().get(weight) + subscript;
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
	        	final int[][] indices = this.getIndicesOfSortedComponent(formula, componentToSort);
	        	final String sortedComponent =  formula.substring(indices[0][0], indices[0][1]);
	        	final String newFormula = sortedComponent + formula.replace(sortedComponent, "");
	        	formula = newFormula;
	        }
	    
	        return formula;
	    }
		
		private Integer getCount(final String solution, 
				                 final String component) {
			
	    	final boolean isComponentCompound = component.length() > 2;
	    	
	    	String count = "";
	    	final int componentIndex = solution.indexOf(component);
	    	
	    	int countIndex = isComponentCompound ? componentIndex + component.length() + 1 : componentIndex + component.length();
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
		
		private int[][] getIndicesOfSortedComponent(final String solution,
													final String componentToSort) {
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
	    	
	    	if (isComponentCompound) {
	    		indices[0][0] = componentIndex - 1;
	    	} else {
	    		indices[0][0] = componentIndex;
	    	}
	    	indices[0][1] = countIndex;
	    	
			return indices;
		}
		
		public boolean isSubscript(char c) {
	    	return Formatter.getSubscriptsToDigits().containsKey(c);
	    }
		
		private boolean areAllComponentsInRange(final String solution,
											    final List<String> weights,
											    final HashMap<String, ComponentRange> symbolsToRanges) {
			for (int i = 0; i < weights.size(); i++) {
				final String symbol = ComponentsService2.getWeightsToSymbols().get(new BigDecimal(weights.get(i)));
				final ComponentRange cr = symbolsToRanges.get(symbol);
				final double min = cr.getMin();
				final double max = cr.getMax();
				
				if (solution.contains(symbol)) {
					final Integer count = this.getCount(solution, symbol);
					
					if (!(count >= min && count <= max)) {
						return false;
					}
				} else {
					if (min > 0) {
						return false;
					} 
				}
			}
			return true;
		}
		
		private boolean isAComponentOverMax(final List<String> path,
			    final List<String> weights,
			    final HashMap<String, ComponentRange> symbolsToRanges) {
			
			final Map<String, Integer> weightsToFrequency = new HashMap<>(); 
	        for (final String s : path) {
	            Integer i = weightsToFrequency.get(s);
	            weightsToFrequency.put(s, (i == null) ? 1 : i + 1);
	        }
	                   
	    	final List<Map.Entry<String, Integer>> entrySet = new ArrayList<>(weightsToFrequency.entrySet());
	        for (int i = 0; i < entrySet.size(); i++) {
	        	final BigDecimal weight = new BigDecimal(entrySet.get(i).getKey());
	        	final String symbol = ComponentsService2.getWeightsToSymbols().get(weight);
	        	final Integer count = entrySet.get(i).getValue();
	        	
	        	final ComponentRange cr = symbolsToRanges.get(symbol);
				final double max = cr.getMax();
				
				if (count > max) {
					return true;
				}
	        }
	        
	        return false;
		}
		
		private boolean isUsingAllComponents(final List<String> path, 
											 final List<String> weights) {
			for (final String d : weights) {
				if (!path.contains(d)) {
					return false;
				}
			}
			
			return true;
		}
		
		private boolean containsAllForced(final String solution,
										  final List<String> componentsToForce) {
			for (int i = 0; i < componentsToForce.size(); i++) {
				if (!solution.contains(componentsToForce.get(i))) {
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
}
