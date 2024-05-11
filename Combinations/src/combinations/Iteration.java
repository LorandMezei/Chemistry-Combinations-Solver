package combinations;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.swing.JTextField;

public class Iteration extends Thread {
	private final double a;
	private final List<String> weights; 
    private final double targetSum;
    private final int range;
    private final int charge;
    private final HashMap<String, ComponentRange> symbolsToRanges;
    private final ArrayList<String> solutionsList;
    
    public Iteration(  
    		final double a,
			 final List<String> weights, 
	         final double targetSum,
	         final int range,
	         final int charge,
	         final HashMap<String, ComponentRange> symbolsToRanges,
	         final ArrayList<String> solutionsList,
	         final JTextField rangeTextField,
	         final JTextField chargeTextField) {
    	
    	this.a = a;
    	this.weights = weights;
    	this.targetSum = targetSum;
    	this.range = range;
    	this.charge = charge;
    	this.symbolsToRanges = symbolsToRanges;
    	this.solutionsList = solutionsList;
    }
	         
	@Override
	public void run() {
		this.findCombinations();
	}
	
	private void findCombinations() {
		if (weights.size() == 1) {
			this.findCombinations1Weight();
		} else if (weights.size() == 2) {
			this.findCombinations2Weights();
		} else if (weights.size() == 3) {
			this.findCombinations3Weights();
		} else if (weights.size() == 4) {
			this.findCombinations4Weights();
		} else if (weights.size() == 5) {
			this.findCombinations5Weights();
		} else if (weights.size() == 6) {
			this.findCombinations6Weights();
		} else if (weights.size() == 7) {
			this.findCombinations7Weights();
		} else if (weights.size() == 8) {
			this.findCombinations8Weights();
		} else if (weights.size() == 9) {
			this.findCombinations9Weights();
		} else if (weights.size() == 10) {
			this.findCombinations10Weights();
		} else if (weights.size() == 11) {
			this.findCombinations11Weights();
		} else if (weights.size() == 12) {
			this.findCombinations12Weights();
		} else if (weights.size() == 13) {
			this.findCombinations13Weights();
		} else if (weights.size() == 14) {
			this.findCombinations14Weights();
		} else if (weights.size() == 15) {
			this.findCombinations15Weights();
		} else if (weights.size() == 16) {
			this.findCombinations16Weights();
		} else if (weights.size() == 17) {
			this.findCombinations17Weights();
		} else if (weights.size() == 18) {
			this.findCombinations18Weights();
		} else if (weights.size() == 19) {
			this.findCombinations19Weights();
		} else if (weights.size() == 20) {
			this.findCombinations20Weights();
		}	
	}
	
	private void findCombinations1Weight() {
		final double currentSum = 
				a*Double.parseDouble(weights.get(0));
		
		final double totalCharge =
				a*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(0)));
		
		
		if (totalCharge == charge 
				&& (currentSum >= targetSum - range 
				&& currentSum <= targetSum + range)) {
			
			final String solution = new BigDecimal(currentSum) + "\n"
					+ totalCharge  + "\n"
					+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(0))) + ")" + String.valueOf((int)a)
					+ "\n" 
					+ "_____________________________________________________________________________________________________________"
					+ "\n";
			
			solutionsList.add(solution);
			System.out.println(solution);
		}
	}
	
	private void findCombinations2Weights() {
		for (double b = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(1)))).getMin();
				b <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(1)))).getMax();
				b++) {
		
			final double currentSum = 
					a*Double.parseDouble(weights.get(0)) 
					+ b*Double.parseDouble(weights.get(1));
			
			final double totalCharge =
					a*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(0)))
					+ b*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(1)));
			
			
			if (totalCharge == charge 
					&& (currentSum >= targetSum - range 
					&& currentSum <= targetSum + range)) {
				
				final String solution = new BigDecimal(currentSum) + "\n"
						+ totalCharge  + "\n"
						+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(0))) + ")" + String.valueOf((int)a) + " + "
						+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(1))) + ")" + String.valueOf((int)b)
						+ "\n" 
						+ "_____________________________________________________________________________________________________________"
						+ "\n";
						
				solutionsList.add(solution);
				System.out.println(solution);
			}
		}
	}
	
	private void findCombinations3Weights() {
		for (double b = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(1)))).getMin();
				b <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(1)))).getMax();
				b++) {
		
			for (double c = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(2)))).getMin(); 
					c <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(2)))).getMax();
					c++) {
				
				final double currentSum = 
						a*Double.parseDouble(weights.get(0)) 
						+ b*Double.parseDouble(weights.get(1)) 
						+ c*Double.parseDouble(weights.get(2));
				
				final double totalCharge =
						a*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(0)))
						+ b*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(1)))
						+ c*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(2)));
				
				
				if (totalCharge == charge 
						&& (currentSum >= targetSum - range 
						&& currentSum <= targetSum + range)) {
					
					final String solution = new BigDecimal(currentSum) + "\n"
							+ totalCharge  + "\n"
							+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(0))) + ")" + String.valueOf((int)a) + " + "
							+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(1))) + ")" + String.valueOf((int)b) + " + "
							+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(2))) + ")" + String.valueOf((int)c)
							+ "\n" 
							+ "_____________________________________________________________________________________________________________"
							+ "\n";
							
					solutionsList.add(solution);
					System.out.println(solution);
				}
			}
		}	
	}
	
	private void findCombinations4Weights() {
		for (double b = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(1)))).getMin();
				b <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(1)))).getMax();
				b++) {
		
			for (double c = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(2)))).getMin(); 
					c <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(2)))).getMax();
					c++) {
			
				for (double d = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(3)))).getMin();
						d <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(3)))).getMax(); 
						d++) {
				
					final double currentSum = 
							a*Double.parseDouble(weights.get(0)) 
							+ b*Double.parseDouble(weights.get(1)) 
							+ c*Double.parseDouble(weights.get(2)) 
							+ d*Double.parseDouble(weights.get(3));
					
					final double totalCharge =
							a*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(0)))
							+ b*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(1)))
							+ c*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(2)))
							+ d*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(3)));
					
					
					if (totalCharge == charge 
							&& (currentSum >= targetSum - range 
							&& currentSum <= targetSum + range)) {
						
						final String solution = new BigDecimal(currentSum) + "\n"
								+ totalCharge  + "\n"
								+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(0))) + ")" + String.valueOf((int)a) + " + "
								+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(1))) + ")" + String.valueOf((int)b) + " + "
								+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(2))) + ")" + String.valueOf((int)c) + " + "
								+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(3))) + ")" + String.valueOf((int)d) + " + "
								+ "\n" 
								+ "_____________________________________________________________________________________________________________"
								+ "\n";
								
						solutionsList.add(solution);
						System.out.println(solution);
					}
				}
			}
		}
	}
	
	private void findCombinations5Weights() {
		for (double b = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(1)))).getMin();
				b <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(1)))).getMax();
				b++) {
		
			for (double c = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(2)))).getMin(); 
					c <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(2)))).getMax();
					c++) {
			
				for (double d = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(3)))).getMin();
						d <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(3)))).getMax(); 
						d++) {
				
					for (double e = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(4)))).getMin();
							e <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(4)))).getMax();
							e++) {
						
						final double currentSum = 
								a*Double.parseDouble(weights.get(0)) 
								+ b*Double.parseDouble(weights.get(1)) 
								+ c*Double.parseDouble(weights.get(2)) 
								+ d*Double.parseDouble(weights.get(3))
								+ e*Double.parseDouble(weights.get(4));
						
						final double totalCharge =
								a*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(0)))
								+ b*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(1)))
								+ c*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(2)))
								+ d*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(3)))
								+ e*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(4)));
						
						
						if (totalCharge == charge 
								&& (currentSum >= targetSum - range 
								&& currentSum <= targetSum + range)) {

							final String solution = new BigDecimal(currentSum) + "\n"
									+ totalCharge  + "\n"
									+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(0))) + ")" + String.valueOf((int)a) + " + "
									+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(1))) + ")" + String.valueOf((int)b) + " + "
									+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(2))) + ")" + String.valueOf((int)c) + " + "
									+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(3))) + ")" + String.valueOf((int)d) + " + "
									+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(4))) + ")" + String.valueOf((int)e)
									+ "\n" 
									+ "_____________________________________________________________________________________________________________"
									+ "\n";
							
							solutionsList.add(solution);
							System.out.println(solution);
						}
					}
				}
			}
		}
	}
	
	private void findCombinations6Weights() {
		for (double b = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(1)))).getMin();
				b <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(1)))).getMax();
				b++) {
		
			for (double c = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(2)))).getMin(); 
					c <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(2)))).getMax();
					c++) {
			
				for (double d = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(3)))).getMin();
						d <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(3)))).getMax(); 
						d++) {
				
					for (double e = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(4)))).getMin();
							e <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(4)))).getMax();
							e++) {
						
						for (double f =symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(5)))).getMin();
								f <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(5)))).getMax();
								f++) {
						
							final double currentSum = 
									a*Double.parseDouble(weights.get(0)) 
									+ b*Double.parseDouble(weights.get(1)) 
									+ c*Double.parseDouble(weights.get(2)) 
									+ d*Double.parseDouble(weights.get(3))
									+ e*Double.parseDouble(weights.get(4))
									+ f*Double.parseDouble(weights.get(5));
							
							final double totalCharge =
									a*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(0)))
									+ b*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(1)))
									+ c*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(2)))
									+ d*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(3)))
									+ e*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(4)))
									+ f*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(5)));
							
							
							if (totalCharge == charge 
									&& (currentSum >= targetSum - range 
									&& currentSum <= targetSum + range)) {
								
								final String solution = new BigDecimal(currentSum) + "\n"
										+ totalCharge  + "\n"
										+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(0))) + ")" + String.valueOf((int)a) + " + "
										+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(1))) + ")" + String.valueOf((int)b) + " + "
										+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(2))) + ")" + String.valueOf((int)c) + " + "
										+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(3))) + ")" + String.valueOf((int)d) + " + "
										+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(4))) + ")" + String.valueOf((int)e) + " + "
										+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(5))) + ")" + String.valueOf((int)f)
										+ "\n" 
										+ "_____________________________________________________________________________________________________________"
										+ "\n";
								
								solutionsList.add(solution);
								System.out.println(solution);
							}
						}
					}
				}
			}
		}
	}
	
	private void findCombinations7Weights() {
		for (double b = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(1)))).getMin();
				b <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(1)))).getMax();
				b++) {
		
			for (double c = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(2)))).getMin(); 
					c <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(2)))).getMax();
					c++) {
			
				for (double d = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(3)))).getMin();
						d <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(3)))).getMax(); 
						d++) {
				
					for (double e = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(4)))).getMin();
							e <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(4)))).getMax();
							e++) {
						
						for (double f =symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(5)))).getMin();
								f <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(5)))).getMax();
								f++) {
						
							for (double g = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(6)))).getMin();
									g <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(6)))).getMax();
									g++) {
								
								final double currentSum = 
										a*Double.parseDouble(weights.get(0)) 
										+ b*Double.parseDouble(weights.get(1)) 
										+ c*Double.parseDouble(weights.get(2)) 
										+ d*Double.parseDouble(weights.get(3))
										+ e*Double.parseDouble(weights.get(4))
										+ f*Double.parseDouble(weights.get(5))
										+ g*Double.parseDouble(weights.get(6));
								
								final double totalCharge =
										a*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(0)))
										+ b*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(1)))
										+ c*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(2)))
										+ d*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(3)))
										+ e*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(4)))
										+ f*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(5)))
										+ g*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(6)));
								
								
								if (totalCharge == charge 
										&& (currentSum >= targetSum - range 
										&& currentSum <= targetSum + range)) {
									
									final String solution = new BigDecimal(currentSum) + "\n"
											+ totalCharge  + "\n"
											+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(0))) + ")" + String.valueOf((int)a) + " + "
											+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(1))) + ")" + String.valueOf((int)b) + " + "
											+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(2))) + ")" + String.valueOf((int)c) + " + "
											+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(3))) + ")" + String.valueOf((int)d) + " + "
											+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(4))) + ")" + String.valueOf((int)e) + " + "
											+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(5))) + ")" + String.valueOf((int)f) + " + "
											+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(6))) + ")" + String.valueOf((int)g)
											+ "\n" 
											+ "_____________________________________________________________________________________________________________"
											+ "\n";
									
									solutionsList.add(solution);
									System.out.println(solution);
								}
							}
						}
					}
				}
			}
		}
	}
	
	private void findCombinations8Weights() {
		for (double b = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(1)))).getMin();
				b <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(1)))).getMax();
				b++) {
		
			for (double c = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(2)))).getMin(); 
					c <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(2)))).getMax();
					c++) {
			
				for (double d = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(3)))).getMin();
						d <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(3)))).getMax(); 
						d++) {
				
					for (double e = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(4)))).getMin();
							e <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(4)))).getMax();
							e++) {
						
						for (double f =symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(5)))).getMin();
								f <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(5)))).getMax();
								f++) {
						
							for (double g = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(6)))).getMin();
									g <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(6)))).getMax();
									g++) {
								
								for (double h = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(7)))).getMin();
										h <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(7)))).getMax();
										h++) {
							
									final double currentSum = 
											a*Double.parseDouble(weights.get(0)) 
											+ b*Double.parseDouble(weights.get(1)) 
											+ c*Double.parseDouble(weights.get(2)) 
											+ d*Double.parseDouble(weights.get(3))
											+ e*Double.parseDouble(weights.get(4))
											+ f*Double.parseDouble(weights.get(5))
											+ g*Double.parseDouble(weights.get(6))
											+ h*Double.parseDouble(weights.get(7));
									
									final double totalCharge =
											a*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(0)))
											+ b*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(1)))
											+ c*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(2)))
											+ d*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(3)))
											+ e*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(4)))
											+ f*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(5)))
											+ g*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(6)))
											+ h*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(7)));
									
									
									if (totalCharge == charge 
											&& (currentSum >= targetSum - range 
											&& currentSum <= targetSum + range)) {
										
										final String solution = new BigDecimal(currentSum) + "\n"
												+ totalCharge  + "\n"
												+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(0))) + ")" + String.valueOf((int)a) + " + "
												+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(1))) + ")" + String.valueOf((int)b) + " + "
												+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(2))) + ")" + String.valueOf((int)c) + " + "
												+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(3))) + ")" + String.valueOf((int)d) + " + "
												+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(4))) + ")" + String.valueOf((int)e) + " + "
												+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(5))) + ")" + String.valueOf((int)f) + " + "
												+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(6))) + ")" + String.valueOf((int)g) + " + "
												+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(7))) + ")" + String.valueOf((int)h)
												+ "\n" 
												+ "_____________________________________________________________________________________________________________"
												+ "\n";
										
										solutionsList.add(solution);
										System.out.println(solution);
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	private void findCombinations9Weights() {
		for (double b = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(1)))).getMin();
				b <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(1)))).getMax();
				b++) {
		
			for (double c = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(2)))).getMin(); 
					c <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(2)))).getMax();
					c++) {
			
				for (double d = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(3)))).getMin();
						d <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(3)))).getMax(); 
						d++) {
				
					for (double e = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(4)))).getMin();
							e <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(4)))).getMax();
							e++) {
						
						for (double f =symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(5)))).getMin();
								f <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(5)))).getMax();
								f++) {
						
							for (double g = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(6)))).getMin();
									g <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(6)))).getMax();
									g++) {
								
								for (double h = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(7)))).getMin();
										h <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(7)))).getMax();
										h++) {
								
									for (double i = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(8)))).getMin(); 
											i <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(8)))).getMax();
											i++) {
										
										final double currentSum = 
												a*Double.parseDouble(weights.get(0))
												+ b*Double.parseDouble(weights.get(1))
												+ c*Double.parseDouble(weights.get(2)) 
												+ d*Double.parseDouble(weights.get(3))
												+ e*Double.parseDouble(weights.get(4))
												+ f*Double.parseDouble(weights.get(5))
												+ g*Double.parseDouble(weights.get(6))
												+ h*Double.parseDouble(weights.get(7))
												+ i*Double.parseDouble(weights.get(8));
										
										final double totalCharge =
												a*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(0)))
												+ b*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(1)))
												+ c*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(2)))
												+ d*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(3)))
												+ e*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(4)))
												+ f*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(5)))
												+ g*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(6)))
												+ h*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(7)))
												+ i*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(8)));
										
										
										if (totalCharge == charge 
												&& (currentSum >= targetSum - range 
												&& currentSum <= targetSum + range)) {
											
											final String solution = new BigDecimal(currentSum) + "\n"
													+ totalCharge  + "\n"
													+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(0))) + ")" + String.valueOf((int)a) + " + "
													+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(1))) + ")" + String.valueOf((int)b) + " + "
													+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(2))) + ")" + String.valueOf((int)c) + " + "
													+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(3))) + ")" + String.valueOf((int)d) + " + "
													+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(4))) + ")" + String.valueOf((int)e) + " + "
													+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(5))) + ")" + String.valueOf((int)f) + " + "
													+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(6))) + ")" + String.valueOf((int)g) + " + "
													+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(7))) + ")" + String.valueOf((int)h) + " + "
													+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(8))) + ")" + String.valueOf((int)i)
													+ "\n" 
													+ "_____________________________________________________________________________________________________________"
													+ "\n";
											
											solutionsList.add(solution);
											System.out.println(solution);
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	private void findCombinations10Weights() {
		for (double b = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(1)))).getMin();
				b <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(1)))).getMax();
				b++) {
		
			for (double c = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(2)))).getMin(); 
					c <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(2)))).getMax();
					c++) {
			
				for (double d = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(3)))).getMin();
						d <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(3)))).getMax(); 
						d++) {
				
					for (double e = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(4)))).getMin();
							e <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(4)))).getMax();
							e++) {
						
						for (double f =symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(5)))).getMin();
								f <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(5)))).getMax();
								f++) {
						
							for (double g = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(6)))).getMin();
									g <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(6)))).getMax();
									g++) {
								
								for (double h = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(7)))).getMin();
										h <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(7)))).getMax();
										h++) {
								
									for (double i = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(8)))).getMin(); 
											i <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(8)))).getMax();
											i++) {
										
										for (double j = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(9)))).getMin(); 
												j <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(9)))).getMax();
												j++) {
											
											final double currentSum = 
													a*Double.parseDouble(weights.get(0)) 
													+ b*Double.parseDouble(weights.get(1)) 
													+ c*Double.parseDouble(weights.get(2)) 
													+ d*Double.parseDouble(weights.get(3))
													+ e*Double.parseDouble(weights.get(4))
													+ f*Double.parseDouble(weights.get(5))
													+ g*Double.parseDouble(weights.get(6))
													+ h*Double.parseDouble(weights.get(7))
													+ i*Double.parseDouble(weights.get(8))
													+ j*Double.parseDouble(weights.get(9));
											
											final double totalCharge =
													a*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(0)))
													+ b*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(1)))
													+ c*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(2)))
													+ d*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(3)))
													+ e*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(4)))
													+ f*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(5)))
													+ g*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(6)))
													+ h*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(7)))
													+ i*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(8)))
													+ j*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(9)));
											
											
											if (totalCharge == charge 
													&& (currentSum >= targetSum - range 
													&& currentSum <= targetSum + range)) {
												
												final String solution = new BigDecimal(currentSum) + "\n"
														+ totalCharge  + "\n"
														+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(0))) + ")" + String.valueOf((int)a) + " + "
														+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(1))) + ")" + String.valueOf((int)b) + " + "
														+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(2))) + ")" + String.valueOf((int)c) + " + "
														+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(3))) + ")" + String.valueOf((int)d) + " + "
														+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(4))) + ")" + String.valueOf((int)e) + " + "
														+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(5))) + ")" + String.valueOf((int)f) + " + "
														+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(6))) + ")" + String.valueOf((int)g) + " + "
														+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(7))) + ")" + String.valueOf((int)h) + " + "
														+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(8))) + ")" + String.valueOf((int)i) + " + "
														+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(9))) + ")" + String.valueOf((int)j)
														+ "\n" 
														+ "_____________________________________________________________________________________________________________"
														+ "\n";
												
												solutionsList.add(solution);
												System.out.println(solution);
											}
										}
										
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	private void findCombinations11Weights() {
		for (double b = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(1)))).getMin();
				b <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(1)))).getMax();
				b++) {
		
			for (double c = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(2)))).getMin(); 
					c <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(2)))).getMax();
					c++) {
			
				for (double d = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(3)))).getMin();
						d <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(3)))).getMax(); 
						d++) {
				
					for (double e = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(4)))).getMin();
							e <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(4)))).getMax();
							e++) {
						
						for (double f =symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(5)))).getMin();
								f <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(5)))).getMax();
								f++) {
						
							for (double g = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(6)))).getMin();
									g <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(6)))).getMax();
									g++) {
								
								for (double h = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(7)))).getMin();
										h <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(7)))).getMax();
										h++) {
								
									for (double i = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(8)))).getMin(); 
											i <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(8)))).getMax();
											i++) {
										
										for (double j = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(9)))).getMin(); 
												j <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(9)))).getMax();
												j++) {
											
											for (double k = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(10)))).getMin(); 
													k <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(10)))).getMax();
													k++) {
												
												final double currentSum = 
														a*Double.parseDouble(weights.get(0)) 
														+ b*Double.parseDouble(weights.get(1)) 
														+ c*Double.parseDouble(weights.get(2)) 
														+ d*Double.parseDouble(weights.get(3))
														+ e*Double.parseDouble(weights.get(4))
														+ f*Double.parseDouble(weights.get(5))
														+ g*Double.parseDouble(weights.get(6))
														+ h*Double.parseDouble(weights.get(7))
														+ i*Double.parseDouble(weights.get(8))
														+ j*Double.parseDouble(weights.get(9))
														+ k*Double.parseDouble(weights.get(10));
												
												final double totalCharge =
														a*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(0)))
														+ b*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(1)))
														+ c*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(2)))
														+ d*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(3)))
														+ e*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(4)))
														+ f*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(5)))
														+ g*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(6)))
														+ h*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(7)))
														+ i*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(8)))
														+ j*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(9)))
														+ k*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(10)));
												
												
												if (totalCharge == charge 
														&& (currentSum >= targetSum - range 
														&& currentSum <= targetSum + range)) {
													
													final String solution = new BigDecimal(currentSum) + "\n"
															+ totalCharge  + "\n"
															+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(0))) + ")" + String.valueOf((int)a) + " + "
															+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(1))) + ")" + String.valueOf((int)b) + " + "
															+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(2))) + ")" + String.valueOf((int)c) + " + "
															+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(3))) + ")" + String.valueOf((int)d) + " + "
															+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(4))) + ")" + String.valueOf((int)e) + " + "
															+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(5))) + ")" + String.valueOf((int)f) + " + "
															+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(6))) + ")" + String.valueOf((int)g) + " + "
															+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(7))) + ")" + String.valueOf((int)h) + " + "
															+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(8))) + ")" + String.valueOf((int)i) + " + "
															+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(9))) + ")" + String.valueOf((int)j) + " + "
															+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(10))) + ")" + String.valueOf((int)k)
															+ "\n" 
															+ "_____________________________________________________________________________________________________________"
															+ "\n";
													
													solutionsList.add(solution);
													System.out.println(solution);
												}
											}
											
										}
										
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	private void findCombinations12Weights() {
		for (double b = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(1)))).getMin();
				b <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(1)))).getMax();
				b++) {
		
			for (double c = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(2)))).getMin(); 
					c <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(2)))).getMax();
					c++) {
			
				for (double d = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(3)))).getMin();
						d <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(3)))).getMax(); 
						d++) {
				
					for (double e = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(4)))).getMin();
							e <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(4)))).getMax();
							e++) {
						
						for (double f =symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(5)))).getMin();
								f <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(5)))).getMax();
								f++) {
						
							for (double g = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(6)))).getMin();
									g <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(6)))).getMax();
									g++) {
								
								for (double h = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(7)))).getMin();
										h <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(7)))).getMax();
										h++) {
								
									for (double i = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(8)))).getMin(); 
											i <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(8)))).getMax();
											i++) {
										
										for (double j = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(9)))).getMin(); 
												j <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(9)))).getMax();
												j++) {
											
											for (double k = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(10)))).getMin(); 
													k <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(10)))).getMax();
													k++) {
												
												for (double l = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(11)))).getMin(); 
														l <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(11)))).getMax();
														l++) {
													
													final double currentSum = 
															a*Double.parseDouble(weights.get(0)) 
															+ b*Double.parseDouble(weights.get(1)) 
															+ c*Double.parseDouble(weights.get(2)) 
															+ d*Double.parseDouble(weights.get(3))
															+ e*Double.parseDouble(weights.get(4))
															+ f*Double.parseDouble(weights.get(5))
															+ g*Double.parseDouble(weights.get(6))
															+ h*Double.parseDouble(weights.get(7))
															+ i*Double.parseDouble(weights.get(8))
															+ j*Double.parseDouble(weights.get(9))
															+ k*Double.parseDouble(weights.get(10))
															+ l*Double.parseDouble(weights.get(11));
													
													final double totalCharge =
															a*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(0)))
															+ b*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(1)))
															+ c*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(2)))
															+ d*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(3)))
															+ e*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(4)))
															+ f*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(5)))
															+ g*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(6)))
															+ h*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(7)))
															+ i*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(8)))
															+ j*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(9)))
															+ k*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(10)))
															+ l*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(11)));
													
													
													if (totalCharge == charge 
															&& (currentSum >= targetSum - range 
															&& currentSum <= targetSum + range)) {
														
														final String solution = new BigDecimal(currentSum) + "\n"
																+ totalCharge  + "\n"
																+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(0))) + ")" + String.valueOf((int)a) + " + "
																+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(1))) + ")" + String.valueOf((int)b) + " + "
																+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(2))) + ")" + String.valueOf((int)c) + " + "
																+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(3))) + ")" + String.valueOf((int)d) + " + "
																+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(4))) + ")" + String.valueOf((int)e) + " + "
																+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(5))) + ")" + String.valueOf((int)f) + " + "
																+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(6))) + ")" + String.valueOf((int)g) + " + "
																+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(7))) + ")" + String.valueOf((int)h) + " + "
																+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(8))) + ")" + String.valueOf((int)i) + " + "
																+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(9))) + ")" + String.valueOf((int)j) + " + "
																+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(10))) + ")" + String.valueOf((int)k) + " + "
																+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(11))) + ")" + String.valueOf((int)l)
																+ "\n" 
																+ "_____________________________________________________________________________________________________________"
																+ "\n";
														
														solutionsList.add(solution);
														System.out.println(solution);
													}
												}
												
											}
											
										}
										
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	private void findCombinations13Weights() {
		for (double b = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(1)))).getMin();
				b <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(1)))).getMax();
				b++) {
		
			for (double c = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(2)))).getMin(); 
					c <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(2)))).getMax();
					c++) {
			
				for (double d = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(3)))).getMin();
						d <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(3)))).getMax(); 
						d++) {
				
					for (double e = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(4)))).getMin();
							e <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(4)))).getMax();
							e++) {
						
						for (double f =symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(5)))).getMin();
								f <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(5)))).getMax();
								f++) {
						
							for (double g = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(6)))).getMin();
									g <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(6)))).getMax();
									g++) {
								
								for (double h = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(7)))).getMin();
										h <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(7)))).getMax();
										h++) {
								
									for (double i = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(8)))).getMin(); 
											i <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(8)))).getMax();
											i++) {
										
										for (double j = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(9)))).getMin(); 
												j <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(9)))).getMax();
												j++) {
											
											for (double k = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(10)))).getMin(); 
													k <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(10)))).getMax();
													k++) {
												
												for (double l = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(11)))).getMin(); 
														l <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(11)))).getMax();
														l++) {
													
													for (double m = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(12)))).getMin(); 
															m <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(12)))).getMax();
															m++) {
													
														final double currentSum = 
																a*Double.parseDouble(weights.get(0)) 
																+ b*Double.parseDouble(weights.get(1)) 
																+ c*Double.parseDouble(weights.get(2)) 
																+ d*Double.parseDouble(weights.get(3))
																+ e*Double.parseDouble(weights.get(4))
																+ f*Double.parseDouble(weights.get(5))
																+ g*Double.parseDouble(weights.get(6))
																+ h*Double.parseDouble(weights.get(7))
																+ i*Double.parseDouble(weights.get(8))
																+ j*Double.parseDouble(weights.get(9))
																+ k*Double.parseDouble(weights.get(10))
																+ l*Double.parseDouble(weights.get(11))
																+ m*Double.parseDouble(weights.get(12));
														
														final double totalCharge =
																a*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(0)))
																+ b*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(1)))
																+ c*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(2)))
																+ d*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(3)))
																+ e*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(4)))
																+ f*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(5)))
																+ g*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(6)))
																+ h*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(7)))
																+ i*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(8)))
																+ j*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(9)))
																+ k*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(10)))
																+ l*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(11)))
																+ m*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(12)));
														
														
														if (totalCharge == charge 
																&& (currentSum >= targetSum - range 
																&& currentSum <= targetSum + range)) {
															
															final String solution = new BigDecimal(currentSum) + "\n"
																	+ totalCharge  + "\n"
																	+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(0))) + ")" + String.valueOf((int)a) + " + "
																	+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(1))) + ")" + String.valueOf((int)b) + " + "
																	+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(2))) + ")" + String.valueOf((int)c) + " + "
																	+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(3))) + ")" + String.valueOf((int)d) + " + "
																	+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(4))) + ")" + String.valueOf((int)e) + " + "
																	+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(5))) + ")" + String.valueOf((int)f) + " + "
																	+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(6))) + ")" + String.valueOf((int)g) + " + "
																	+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(7))) + ")" + String.valueOf((int)h) + " + "
																	+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(8))) + ")" + String.valueOf((int)i) + " + "
																	+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(9))) + ")" + String.valueOf((int)j) + " + "
																	+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(10))) + ")" + String.valueOf((int)k) + " + "
																	+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(11))) + ")" + String.valueOf((int)l) + " + "
																	+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(12))) + ")" + String.valueOf((int)m)
																	+ "\n" 
																	+ "_____________________________________________________________________________________________________________"
																	+ "\n";
															
															solutionsList.add(solution);
															System.out.println(solution);
														}
													}
												}
												
											}
											
										}
										
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	private void findCombinations14Weights() {
		for (double b = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(1)))).getMin();
				b <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(1)))).getMax();
				b++) {
		
			for (double c = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(2)))).getMin(); 
					c <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(2)))).getMax();
					c++) {
			
				for (double d = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(3)))).getMin();
						d <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(3)))).getMax(); 
						d++) {
				
					for (double e = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(4)))).getMin();
							e <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(4)))).getMax();
							e++) {
						
						for (double f =symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(5)))).getMin();
								f <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(5)))).getMax();
								f++) {
						
							for (double g = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(6)))).getMin();
									g <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(6)))).getMax();
									g++) {
								
								for (double h = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(7)))).getMin();
										h <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(7)))).getMax();
										h++) {
								
									for (double i = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(8)))).getMin(); 
											i <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(8)))).getMax();
											i++) {
										
										for (double j = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(9)))).getMin(); 
												j <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(9)))).getMax();
												j++) {
											
											for (double k = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(10)))).getMin(); 
													k <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(10)))).getMax();
													k++) {
												
												for (double l = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(11)))).getMin(); 
														l <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(11)))).getMax();
														l++) {
													
													for (double m = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(12)))).getMin(); 
															m <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(12)))).getMax();
															m++) {
														
														for (double n = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(13)))).getMin(); 
																n <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(13)))).getMax();
																n++) {
															
															final double currentSum = 
																	a*Double.parseDouble(weights.get(0)) 
																	+ b*Double.parseDouble(weights.get(1)) 
																	+ c*Double.parseDouble(weights.get(2)) 
																	+ d*Double.parseDouble(weights.get(3))
																	+ e*Double.parseDouble(weights.get(4))
																	+ f*Double.parseDouble(weights.get(5))
																	+ g*Double.parseDouble(weights.get(6))
																	+ h*Double.parseDouble(weights.get(7))
																	+ i*Double.parseDouble(weights.get(8))
																	+ j*Double.parseDouble(weights.get(9))
																	+ k*Double.parseDouble(weights.get(10))
																	+ l*Double.parseDouble(weights.get(11))
																	+ m*Double.parseDouble(weights.get(12))
																	+ n*Double.parseDouble(weights.get(13));
															
															final double totalCharge =
																	a*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(0)))
																	+ b*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(1)))
																	+ c*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(2)))
																	+ d*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(3)))
																	+ e*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(4)))
																	+ f*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(5)))
																	+ g*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(6)))
																	+ h*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(7)))
																	+ i*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(8)))
																	+ j*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(9)))
																	+ k*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(10)))
																	+ l*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(11)))
																	+ m*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(12)))
																	+ n*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(13)));
															
															
															if (totalCharge == charge 
																	&& (currentSum >= targetSum - range 
																	&& currentSum <= targetSum + range)) {
																
																final String solution = new BigDecimal(currentSum) + "\n"
																		+ totalCharge  + "\n"
																		+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(0))) + ")" + String.valueOf((int)a) + " + "
																		+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(1))) + ")" + String.valueOf((int)b) + " + "
																		+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(2))) + ")" + String.valueOf((int)c) + " + "
																		+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(3))) + ")" + String.valueOf((int)d) + " + "
																		+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(4))) + ")" + String.valueOf((int)e) + " + "
																		+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(5))) + ")" + String.valueOf((int)f) + " + "
																		+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(6))) + ")" + String.valueOf((int)g) + " + "
																		+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(7))) + ")" + String.valueOf((int)h) + " + "
																		+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(8))) + ")" + String.valueOf((int)i) + " + "
																		+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(9))) + ")" + String.valueOf((int)j) + " + "
																		+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(10))) + ")" + String.valueOf((int)k) + " + "
																		+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(11))) + ")" + String.valueOf((int)l) + " + "
																		+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(12))) + ")" + String.valueOf((int)m) + " + "
																		+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(13))) + ")" + String.valueOf((int)n)
																		+ "\n" 
																		+ "_____________________________________________________________________________________________________________"
																		+ "\n";
																
																solutionsList.add(solution);
																System.out.println(solution);
															}
														}
													}
												}
												
											}
											
										}
										
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	private void findCombinations15Weights() {
		for (double b = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(1)))).getMin();
				b <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(1)))).getMax();
				b++) {
		
			for (double c = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(2)))).getMin(); 
					c <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(2)))).getMax();
					c++) {
			
				for (double d = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(3)))).getMin();
						d <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(3)))).getMax(); 
						d++) {
				
					for (double e = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(4)))).getMin();
							e <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(4)))).getMax();
							e++) {
						
						for (double f =symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(5)))).getMin();
								f <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(5)))).getMax();
								f++) {
						
							for (double g = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(6)))).getMin();
									g <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(6)))).getMax();
									g++) {
								
								for (double h = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(7)))).getMin();
										h <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(7)))).getMax();
										h++) {
								
									for (double i = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(8)))).getMin(); 
											i <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(8)))).getMax();
											i++) {
										
										for (double j = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(9)))).getMin(); 
												j <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(9)))).getMax();
												j++) {
											
											for (double k = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(10)))).getMin(); 
													k <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(10)))).getMax();
													k++) {
												
												for (double l = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(11)))).getMin(); 
														l <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(11)))).getMax();
														l++) {
													
													for (double m = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(12)))).getMin(); 
															m <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(12)))).getMax();
															m++) {
														
														for (double n = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(13)))).getMin(); 
																n <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(13)))).getMax();
																n++) {
															
															for (double o = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(14)))).getMin(); 
																	o <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(14)))).getMax();
																	o++) {
															
																final double currentSum = 
																		a*Double.parseDouble(weights.get(0)) 
																		+ b*Double.parseDouble(weights.get(1)) 
																		+ c*Double.parseDouble(weights.get(2)) 
																		+ d*Double.parseDouble(weights.get(3))
																		+ e*Double.parseDouble(weights.get(4))
																		+ f*Double.parseDouble(weights.get(5))
																		+ g*Double.parseDouble(weights.get(6))
																		+ h*Double.parseDouble(weights.get(7))
																		+ i*Double.parseDouble(weights.get(8))
																		+ j*Double.parseDouble(weights.get(9))
																		+ k*Double.parseDouble(weights.get(10))
																		+ l*Double.parseDouble(weights.get(11))
																		+ m*Double.parseDouble(weights.get(12))
																		+ n*Double.parseDouble(weights.get(13))
																		+ o*Double.parseDouble(weights.get(14));
																
																final double totalCharge =
																		a*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(0)))
																		+ b*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(1)))
																		+ c*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(2)))
																		+ d*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(3)))
																		+ e*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(4)))
																		+ f*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(5)))
																		+ g*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(6)))
																		+ h*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(7)))
																		+ i*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(8)))
																		+ j*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(9)))
																		+ k*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(10)))
																		+ l*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(11)))
																		+ m*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(12)))
																		+ n*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(13)))
																		+ o*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(14)));
																
																
																if (totalCharge == charge 
																		&& (currentSum >= targetSum - range 
																		&& currentSum <= targetSum + range)) {
																	
																	final String solution = new BigDecimal(currentSum) + "\n"
																			+ totalCharge  + "\n"
																			+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(0))) + ")" + String.valueOf((int)a) + " + "
																			+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(1))) + ")" + String.valueOf((int)b) + " + "
																			+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(2))) + ")" + String.valueOf((int)c) + " + "
																			+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(3))) + ")" + String.valueOf((int)d) + " + "
																			+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(4))) + ")" + String.valueOf((int)e) + " + "
																			+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(5))) + ")" + String.valueOf((int)f) + " + "
																			+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(6))) + ")" + String.valueOf((int)g) + " + "
																			+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(7))) + ")" + String.valueOf((int)h) + " + "
																			+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(8))) + ")" + String.valueOf((int)i) + " + "
																			+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(9))) + ")" + String.valueOf((int)j) + " + "
																			+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(10))) + ")" + String.valueOf((int)k) + " + "
																			+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(11))) + ")" + String.valueOf((int)l) + " + "
																			+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(12))) + ")" + String.valueOf((int)m) + " + "
																			+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(13))) + ")" + String.valueOf((int)n) + " + " 
																			+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(14))) + ")" + String.valueOf((int)o)
																			+ "\n" 
																			+ "_____________________________________________________________________________________________________________"
																			+ "\n";
																	
																	solutionsList.add(solution);
																	System.out.println(solution);
																}
															}
														}
													}
												}
												
											}
											
										}
										
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	private void findCombinations16Weights() {
		for (double b = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(1)))).getMin();
				b <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(1)))).getMax();
				b++) {
		
			for (double c = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(2)))).getMin(); 
					c <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(2)))).getMax();
					c++) {
			
				for (double d = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(3)))).getMin();
						d <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(3)))).getMax(); 
						d++) {
				
					for (double e = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(4)))).getMin();
							e <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(4)))).getMax();
							e++) {
						
						for (double f =symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(5)))).getMin();
								f <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(5)))).getMax();
								f++) {
						
							for (double g = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(6)))).getMin();
									g <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(6)))).getMax();
									g++) {
								
								for (double h = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(7)))).getMin();
										h <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(7)))).getMax();
										h++) {
								
									for (double i = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(8)))).getMin(); 
											i <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(8)))).getMax();
											i++) {
										
										for (double j = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(9)))).getMin(); 
												j <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(9)))).getMax();
												j++) {
											
											for (double k = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(10)))).getMin(); 
													k <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(10)))).getMax();
													k++) {
												
												for (double l = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(11)))).getMin(); 
														l <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(11)))).getMax();
														l++) {
													
													for (double m = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(12)))).getMin(); 
															m <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(12)))).getMax();
															m++) {
														
														for (double n = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(13)))).getMin(); 
																n <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(13)))).getMax();
																n++) {
															
															for (double o = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(14)))).getMin(); 
																	o <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(14)))).getMax();
																	o++) {
																
																for (double p = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(15)))).getMin(); 
																		p <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(15)))).getMax();
																		p++) {
																	
																	final double currentSum = 
																			a*Double.parseDouble(weights.get(0)) 
																			+ b*Double.parseDouble(weights.get(1)) 
																			+ c*Double.parseDouble(weights.get(2)) 
																			+ d*Double.parseDouble(weights.get(3))
																			+ e*Double.parseDouble(weights.get(4))
																			+ f*Double.parseDouble(weights.get(5))
																			+ g*Double.parseDouble(weights.get(6))
																			+ h*Double.parseDouble(weights.get(7))
																			+ i*Double.parseDouble(weights.get(8))
																			+ j*Double.parseDouble(weights.get(9))
																			+ k*Double.parseDouble(weights.get(10))
																			+ l*Double.parseDouble(weights.get(11))
																			+ m*Double.parseDouble(weights.get(12))
																			+ n*Double.parseDouble(weights.get(13))
																			+ o*Double.parseDouble(weights.get(14))
																			+ p*Double.parseDouble(weights.get(15));
																	
																	final double totalCharge =
																			a*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(0)))
																			+ b*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(1)))
																			+ c*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(2)))
																			+ d*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(3)))
																			+ e*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(4)))
																			+ f*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(5)))
																			+ g*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(6)))
																			+ h*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(7)))
																			+ i*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(8)))
																			+ j*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(9)))
																			+ k*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(10)))
																			+ l*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(11)))
																			+ m*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(12)))
																			+ n*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(13)))
																			+ o*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(14)))
																			+ p*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(15)));
																	
																	
																	if (totalCharge == charge 
																			&& (currentSum >= targetSum - range 
																			&& currentSum <= targetSum + range)) {
																		
																		final String solution = new BigDecimal(currentSum) + "\n"
																				+ totalCharge  + "\n"
																				+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(0))) + ")" + String.valueOf((int)a) + " + "
																				+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(1))) + ")" + String.valueOf((int)b) + " + "
																				+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(2))) + ")" + String.valueOf((int)c) + " + "
																				+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(3))) + ")" + String.valueOf((int)d) + " + "
																				+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(4))) + ")" + String.valueOf((int)e) + " + "
																				+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(5))) + ")" + String.valueOf((int)f) + " + "
																				+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(6))) + ")" + String.valueOf((int)g) + " + "
																				+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(7))) + ")" + String.valueOf((int)h) + " + "
																				+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(8))) + ")" + String.valueOf((int)i) + " + "
																				+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(9))) + ")" + String.valueOf((int)j) + " + "
																				+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(10))) + ")" + String.valueOf((int)k) + " + "
																				+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(11))) + ")" + String.valueOf((int)l) + " + "
																				+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(12))) + ")" + String.valueOf((int)m) + " + "
																				+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(13))) + ")" + String.valueOf((int)n) + " + " 
																				+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(14))) + ")" + String.valueOf((int)o) + " + "
																				+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(15))) + ")" + String.valueOf((int)p)
																				+ "\n" 
																				+ "_____________________________________________________________________________________________________________"
																				+ "\n";
																		
																		solutionsList.add(solution);
																		System.out.println(solution);
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	private void findCombinations17Weights() {
		for (double b = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(1)))).getMin();
				b <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(1)))).getMax();
				b++) {
		
			for (double c = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(2)))).getMin(); 
					c <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(2)))).getMax();
					c++) {
			
				for (double d = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(3)))).getMin();
						d <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(3)))).getMax(); 
						d++) {
				
					for (double e = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(4)))).getMin();
							e <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(4)))).getMax();
							e++) {
						
						for (double f =symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(5)))).getMin();
								f <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(5)))).getMax();
								f++) {
						
							for (double g = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(6)))).getMin();
									g <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(6)))).getMax();
									g++) {
								
								for (double h = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(7)))).getMin();
										h <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(7)))).getMax();
										h++) {
								
									for (double i = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(8)))).getMin(); 
											i <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(8)))).getMax();
											i++) {
										
										for (double j = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(9)))).getMin(); 
												j <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(9)))).getMax();
												j++) {
											
											for (double k = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(10)))).getMin(); 
													k <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(10)))).getMax();
													k++) {
												
												for (double l = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(11)))).getMin(); 
														l <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(11)))).getMax();
														l++) {
													
													for (double m = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(12)))).getMin(); 
															m <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(12)))).getMax();
															m++) {
														
														for (double n = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(13)))).getMin(); 
																n <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(13)))).getMax();
																n++) {
															
															for (double o = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(14)))).getMin(); 
																	o <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(14)))).getMax();
																	o++) {
																
																for (double p = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(15)))).getMin(); 
																		p <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(15)))).getMax();
																		p++) {
																	
																	for (double q = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(16)))).getMin(); 
																			q <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(16)))).getMax();
																			q++) {
																		
																		final double currentSum = 
																				a*Double.parseDouble(weights.get(0)) 
																				+ b*Double.parseDouble(weights.get(1)) 
																				+ c*Double.parseDouble(weights.get(2)) 
																				+ d*Double.parseDouble(weights.get(3))
																				+ e*Double.parseDouble(weights.get(4))
																				+ f*Double.parseDouble(weights.get(5))
																				+ g*Double.parseDouble(weights.get(6))
																				+ h*Double.parseDouble(weights.get(7))
																				+ i*Double.parseDouble(weights.get(8))
																				+ j*Double.parseDouble(weights.get(9))
																				+ k*Double.parseDouble(weights.get(10))
																				+ l*Double.parseDouble(weights.get(11))
																				+ m*Double.parseDouble(weights.get(12))
																				+ n*Double.parseDouble(weights.get(13))
																				+ o*Double.parseDouble(weights.get(14))
																				+ p*Double.parseDouble(weights.get(15))
																			    + q*Double.parseDouble(weights.get(16));
																		
																		final double totalCharge =
																				a*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(0)))
																				+ b*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(1)))
																				+ c*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(2)))
																				+ d*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(3)))
																				+ e*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(4)))
																				+ f*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(5)))
																				+ g*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(6)))
																				+ h*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(7)))
																				+ i*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(8)))
																				+ j*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(9)))
																				+ k*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(10)))
																				+ l*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(11)))
																				+ m*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(12)))
																				+ n*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(13)))
																				+ o*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(14)))
																				+ p*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(15)))
																				+ q*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(16)));
																		
																		
																		if (totalCharge == charge 
																				&& (currentSum >= targetSum - range 
																				&& currentSum <= targetSum + range)) {
																			
																			final String solution = new BigDecimal(currentSum) + "\n"
																					+ totalCharge  + "\n"
																					+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(0))) + ")" + String.valueOf((int)a) + " + "
																					+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(1))) + ")" + String.valueOf((int)b) + " + "
																					+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(2))) + ")" + String.valueOf((int)c) + " + "
																					+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(3))) + ")" + String.valueOf((int)d) + " + "
																					+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(4))) + ")" + String.valueOf((int)e) + " + "
																					+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(5))) + ")" + String.valueOf((int)f) + " + "
																					+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(6))) + ")" + String.valueOf((int)g) + " + "
																					+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(7))) + ")" + String.valueOf((int)h) + " + "
																					+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(8))) + ")" + String.valueOf((int)i) + " + "
																					+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(9))) + ")" + String.valueOf((int)j) + " + "
																					+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(10))) + ")" + String.valueOf((int)k) + " + "
																					+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(11))) + ")" + String.valueOf((int)l) + " + "
																					+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(12))) + ")" + String.valueOf((int)m) + " + "
																					+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(13))) + ")" + String.valueOf((int)n) + " + " 
																					+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(14))) + ")" + String.valueOf((int)o) + " + "
																					+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(15))) + ")" + String.valueOf((int)p) + " + "
																					+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(16))) + ")" + String.valueOf((int)q)
																					+ "\n" 
																					+ "_____________________________________________________________________________________________________________"
																					+ "\n";
																			
																			solutionsList.add(solution);
																			System.out.println(solution);
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	private void findCombinations18Weights() {
		for (double b = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(1)))).getMin();
				b <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(1)))).getMax();
				b++) {
		
			for (double c = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(2)))).getMin(); 
					c <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(2)))).getMax();
					c++) {
			
				for (double d = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(3)))).getMin();
						d <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(3)))).getMax(); 
						d++) {
				
					for (double e = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(4)))).getMin();
							e <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(4)))).getMax();
							e++) {
						
						for (double f =symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(5)))).getMin();
								f <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(5)))).getMax();
								f++) {
						
							for (double g = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(6)))).getMin();
									g <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(6)))).getMax();
									g++) {
								
								for (double h = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(7)))).getMin();
										h <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(7)))).getMax();
										h++) {
								
									for (double i = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(8)))).getMin(); 
											i <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(8)))).getMax();
											i++) {
										
										for (double j = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(9)))).getMin(); 
												j <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(9)))).getMax();
												j++) {
											
											for (double k = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(10)))).getMin(); 
													k <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(10)))).getMax();
													k++) {
												
												for (double l = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(11)))).getMin(); 
														l <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(11)))).getMax();
														l++) {
													
													for (double m = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(12)))).getMin(); 
															m <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(12)))).getMax();
															m++) {
														
														for (double n = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(13)))).getMin(); 
																n <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(13)))).getMax();
																n++) {
															
															for (double o = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(14)))).getMin(); 
																	o <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(14)))).getMax();
																	o++) {
																
																for (double p = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(15)))).getMin(); 
																		p <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(15)))).getMax();
																		p++) {
																	
																	for (double q = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(16)))).getMin(); 
																			q <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(16)))).getMax();
																			q++) {
																		
																		for (double r = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(17)))).getMin(); 
																				r <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(17)))).getMax();
																				r++) {
																			
																			final double currentSum = 
																					a*Double.parseDouble(weights.get(0)) 
																					+ b*Double.parseDouble(weights.get(1)) 
																					+ c*Double.parseDouble(weights.get(2)) 
																					+ d*Double.parseDouble(weights.get(3))
																					+ e*Double.parseDouble(weights.get(4))
																					+ f*Double.parseDouble(weights.get(5))
																					+ g*Double.parseDouble(weights.get(6))
																					+ h*Double.parseDouble(weights.get(7))
																					+ i*Double.parseDouble(weights.get(8))
																					+ j*Double.parseDouble(weights.get(9))
																					+ k*Double.parseDouble(weights.get(10))
																					+ l*Double.parseDouble(weights.get(11))
																					+ m*Double.parseDouble(weights.get(12))
																					+ n*Double.parseDouble(weights.get(13))
																					+ o*Double.parseDouble(weights.get(14))
																					+ p*Double.parseDouble(weights.get(15))
																				    + q*Double.parseDouble(weights.get(16))
																				    + r*Double.parseDouble(weights.get(17));
																			
																			final double totalCharge =
																					a*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(0)))
																					+ b*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(1)))
																					+ c*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(2)))
																					+ d*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(3)))
																					+ e*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(4)))
																					+ f*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(5)))
																					+ g*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(6)))
																					+ h*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(7)))
																					+ i*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(8)))
																					+ j*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(9)))
																					+ k*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(10)))
																					+ l*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(11)))
																					+ m*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(12)))
																					+ n*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(13)))
																					+ o*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(14)))
																					+ p*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(15)))
																					+ q*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(16)))
																					+ r*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(17)));
																			
																			
																			if (totalCharge == charge 
																					&& (currentSum >= targetSum - range 
																					&& currentSum <= targetSum + range)) {
																				
																				final String solution = new BigDecimal(currentSum) + "\n"
																						+ totalCharge  + "\n"
																						+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(0))) + ")" + String.valueOf((int)a) + " + "
																						+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(1))) + ")" + String.valueOf((int)b) + " + "
																						+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(2))) + ")" + String.valueOf((int)c) + " + "
																						+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(3))) + ")" + String.valueOf((int)d) + " + "
																						+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(4))) + ")" + String.valueOf((int)e) + " + "
																						+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(5))) + ")" + String.valueOf((int)f) + " + "
																						+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(6))) + ")" + String.valueOf((int)g) + " + "
																						+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(7))) + ")" + String.valueOf((int)h) + " + "
																						+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(8))) + ")" + String.valueOf((int)i) + " + "
																						+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(9))) + ")" + String.valueOf((int)j) + " + "
																						+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(10))) + ")" + String.valueOf((int)k) + " + "
																						+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(11))) + ")" + String.valueOf((int)l) + " + "
																						+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(12))) + ")" + String.valueOf((int)m) + " + "
																						+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(13))) + ")" + String.valueOf((int)n) + " + " 
																						+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(14))) + ")" + String.valueOf((int)o) + " + "
																						+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(15))) + ")" + String.valueOf((int)p) + " + "
																						+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(16))) + ")" + String.valueOf((int)q) + " + "
																						+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(17))) + ")" + String.valueOf((int)r)
																						+ "\n" 
																						+ "_____________________________________________________________________________________________________________"
																						+ "\n";
																				
																				solutionsList.add(solution);
																				System.out.println(solution);
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	private void findCombinations19Weights() {
		for (double b = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(1)))).getMin();
				b <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(1)))).getMax();
				b++) {
		
			for (double c = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(2)))).getMin(); 
					c <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(2)))).getMax();
					c++) {
			
				for (double d = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(3)))).getMin();
						d <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(3)))).getMax(); 
						d++) {
				
					for (double e = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(4)))).getMin();
							e <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(4)))).getMax();
							e++) {
						
						for (double f =symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(5)))).getMin();
								f <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(5)))).getMax();
								f++) {
						
							for (double g = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(6)))).getMin();
									g <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(6)))).getMax();
									g++) {
								
								for (double h = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(7)))).getMin();
										h <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(7)))).getMax();
										h++) {
								
									for (double i = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(8)))).getMin(); 
											i <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(8)))).getMax();
											i++) {
										
										for (double j = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(9)))).getMin(); 
												j <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(9)))).getMax();
												j++) {
											
											for (double k = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(10)))).getMin(); 
													k <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(10)))).getMax();
													k++) {
												
												for (double l = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(11)))).getMin(); 
														l <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(11)))).getMax();
														l++) {
													
													for (double m = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(12)))).getMin(); 
															m <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(12)))).getMax();
															m++) {
														
														for (double n = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(13)))).getMin(); 
																n <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(13)))).getMax();
																n++) {
															
															for (double o = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(14)))).getMin(); 
																	o <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(14)))).getMax();
																	o++) {
																
																for (double p = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(15)))).getMin(); 
																		p <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(15)))).getMax();
																		p++) {
																	
																	for (double q = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(16)))).getMin(); 
																			q <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(16)))).getMax();
																			q++) {
																		
																		for (double r = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(17)))).getMin(); 
																				r <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(17)))).getMax();
																				r++) {
																			
																			for (double s = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(18)))).getMin(); 
																					s <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(18)))).getMax();
																					s++) {
																				
																				final double currentSum = 
																						a*Double.parseDouble(weights.get(0)) 
																						+ b*Double.parseDouble(weights.get(1)) 
																						+ c*Double.parseDouble(weights.get(2)) 
																						+ d*Double.parseDouble(weights.get(3))
																						+ e*Double.parseDouble(weights.get(4))
																						+ f*Double.parseDouble(weights.get(5))
																						+ g*Double.parseDouble(weights.get(6))
																						+ h*Double.parseDouble(weights.get(7))
																						+ i*Double.parseDouble(weights.get(8))
																						+ j*Double.parseDouble(weights.get(9))
																						+ k*Double.parseDouble(weights.get(10))
																						+ l*Double.parseDouble(weights.get(11))
																						+ m*Double.parseDouble(weights.get(12))
																						+ n*Double.parseDouble(weights.get(13))
																						+ o*Double.parseDouble(weights.get(14))
																						+ p*Double.parseDouble(weights.get(15))
																					    + q*Double.parseDouble(weights.get(16))
																					    + r*Double.parseDouble(weights.get(17))
																					    + s*Double.parseDouble(weights.get(18));
																				
																				final double totalCharge =
																						a*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(0)))
																						+ b*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(1)))
																						+ c*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(2)))
																						+ d*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(3)))
																						+ e*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(4)))
																						+ f*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(5)))
																						+ g*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(6)))
																						+ h*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(7)))
																						+ i*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(8)))
																						+ j*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(9)))
																						+ k*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(10)))
																						+ l*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(11)))
																						+ m*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(12)))
																						+ n*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(13)))
																						+ o*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(14)))
																						+ p*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(15)))
																						+ q*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(16)))
																						+ r*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(17)))
																						+ s*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(18)));
																				
																				
																				if (totalCharge == charge 
																						&& (currentSum >= targetSum - range 
																						&& currentSum <= targetSum + range)) {
																					
																					final String solution = new BigDecimal(currentSum) + "\n"
																							+ totalCharge  + "\n"
																							+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(0))) + ")" + String.valueOf((int)a) + " + "
																							+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(1))) + ")" + String.valueOf((int)b) + " + "
																							+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(2))) + ")" + String.valueOf((int)c) + " + "
																							+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(3))) + ")" + String.valueOf((int)d) + " + "
																							+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(4))) + ")" + String.valueOf((int)e) + " + "
																							+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(5))) + ")" + String.valueOf((int)f) + " + "
																							+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(6))) + ")" + String.valueOf((int)g) + " + "
																							+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(7))) + ")" + String.valueOf((int)h) + " + "
																							+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(8))) + ")" + String.valueOf((int)i) + " + "
																							+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(9))) + ")" + String.valueOf((int)j) + " + "
																							+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(10))) + ")" + String.valueOf((int)k) + " + "
																							+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(11))) + ")" + String.valueOf((int)l) + " + "
																							+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(12))) + ")" + String.valueOf((int)m) + " + "
																							+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(13))) + ")" + String.valueOf((int)n) + " + " 
																							+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(14))) + ")" + String.valueOf((int)o) + " + "
																							+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(15))) + ")" + String.valueOf((int)p) + " + "
																							+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(16))) + ")" + String.valueOf((int)q) + " + "
																							+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(17))) + ")" + String.valueOf((int)r) + " + "
																							+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(18))) + ")" + String.valueOf((int)s)
																							+ "\n" 
																							+ "_____________________________________________________________________________________________________________"
																							+ "\n";
																					
																					solutionsList.add(solution);
																					System.out.println(solution);
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
	
	private void findCombinations20Weights() {
		for (double b = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(1)))).getMin();
				b <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(1)))).getMax();
				b++) {
		
			for (double c = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(2)))).getMin(); 
					c <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(2)))).getMax();
					c++) {
			
				for (double d = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(3)))).getMin();
						d <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(3)))).getMax(); 
						d++) {
				
					for (double e = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(4)))).getMin();
							e <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(4)))).getMax();
							e++) {
						
						for (double f =symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(5)))).getMin();
								f <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(5)))).getMax();
								f++) {
						
							for (double g = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(6)))).getMin();
									g <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(6)))).getMax();
									g++) {
								
								for (double h = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(7)))).getMin();
										h <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(7)))).getMax();
										h++) {
								
									for (double i = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(8)))).getMin(); 
											i <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(8)))).getMax();
											i++) {
										
										for (double j = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(9)))).getMin(); 
												j <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(9)))).getMax();
												j++) {
											
											for (double k = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(10)))).getMin(); 
													k <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(10)))).getMax();
													k++) {
												
												for (double l = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(11)))).getMin(); 
														l <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(11)))).getMax();
														l++) {
													
													for (double m = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(12)))).getMin(); 
															m <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(12)))).getMax();
															m++) {
														
														for (double n = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(13)))).getMin(); 
																n <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(13)))).getMax();
																n++) {
															
															for (double o = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(14)))).getMin(); 
																	o <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(14)))).getMax();
																	o++) {
																
																for (double p = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(15)))).getMin(); 
																		p <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(15)))).getMax();
																		p++) {
																	
																	for (double q = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(16)))).getMin(); 
																			q <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(16)))).getMax();
																			q++) {
																		
																		for (double r = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(17)))).getMin(); 
																				r <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(17)))).getMax();
																				r++) {
																			
																			for (double s = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(18)))).getMin(); 
																					s <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(18)))).getMax();
																					s++) {
																				
																				for (double t = symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(19)))).getMin(); 
																						t <= symbolsToRanges.get(ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(19)))).getMax();
																						t++) {
																					
																					final double currentSum = 
																							a*Double.parseDouble(weights.get(0)) 
																							+ b*Double.parseDouble(weights.get(1)) 
																							+ c*Double.parseDouble(weights.get(2)) 
																							+ d*Double.parseDouble(weights.get(3))
																							+ e*Double.parseDouble(weights.get(4))
																							+ f*Double.parseDouble(weights.get(5))
																							+ g*Double.parseDouble(weights.get(6))
																							+ h*Double.parseDouble(weights.get(7))
																							+ i*Double.parseDouble(weights.get(8))
																							+ j*Double.parseDouble(weights.get(9))
																							+ k*Double.parseDouble(weights.get(10))
																							+ l*Double.parseDouble(weights.get(11))
																							+ m*Double.parseDouble(weights.get(12))
																							+ n*Double.parseDouble(weights.get(13))
																							+ o*Double.parseDouble(weights.get(14))
																							+ p*Double.parseDouble(weights.get(15))
																						    + q*Double.parseDouble(weights.get(16))
																						    + r*Double.parseDouble(weights.get(17))
																						    + s*Double.parseDouble(weights.get(18))
																						    + t*Double.parseDouble(weights.get(19));
																					
																					final double totalCharge =
																							a*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(0)))
																							+ b*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(1)))
																							+ c*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(2)))
																							+ d*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(3)))
																							+ e*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(4)))
																							+ f*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(5)))
																							+ g*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(6)))
																							+ h*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(7)))
																							+ i*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(8)))
																							+ j*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(9)))
																							+ k*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(10)))
																							+ l*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(11)))
																							+ m*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(12)))
																							+ n*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(13)))
																							+ o*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(14)))
																							+ p*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(15)))
																							+ q*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(16)))
																							+ r*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(17)))
																							+ s*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(18)))
																							+ t*ComponentsService.getWeightsToCharges().get(new BigDecimal(weights.get(19)));
																					
																					
																					if (totalCharge == charge 
																							&& (currentSum >= targetSum - range 
																							&& currentSum <= targetSum + range)) {
																					
																						final String solution = new BigDecimal(currentSum) + "\n"
																								+ totalCharge  + "\n"
																								+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(0))) + ")" + String.valueOf((int)a) + " + "
																								+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(1))) + ")" + String.valueOf((int)b) + " + "
																								+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(2))) + ")" + String.valueOf((int)c) + " + "
																								+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(3))) + ")" + String.valueOf((int)d) + " + "
																								+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(4))) + ")" + String.valueOf((int)e) + " + "
																								+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(5))) + ")" + String.valueOf((int)f) + " + "
																								+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(6))) + ")" + String.valueOf((int)g) + " + "
																								+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(7))) + ")" + String.valueOf((int)h) + " + "
																								+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(8))) + ")" + String.valueOf((int)i) + " + "
																								+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(9))) + ")" + String.valueOf((int)j) + " + "
																								+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(10))) + ")" + String.valueOf((int)k) + " + "
																								+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(11))) + ")" + String.valueOf((int)l) + " + "
																								+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(12))) + ")" + String.valueOf((int)m) + " + "
																								+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(13))) + ")" + String.valueOf((int)n) + " + " 
																								+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(14))) + ")" + String.valueOf((int)o) + " + "
																								+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(15))) + ")" + String.valueOf((int)p) + " + "
																								+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(16))) + ")" + String.valueOf((int)q) + " + "
																								+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(17))) + ")" + String.valueOf((int)r) + " + "
																								+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(18))) + ")" + String.valueOf((int)s) + " + "
																								+ "(" + ComponentsService.getWeightsToSymbols().get(new BigDecimal(weights.get(19))) + ")" + String.valueOf((int)t)
																								+ "\n" 
																								+ "_____________________________________________________________________________________________________________"
																								+ "\n";
																						
																						solutionsList.add(solution);
																						System.out.println(solution);
																					}
																				}
																			}
																		}
																	}
																}
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
