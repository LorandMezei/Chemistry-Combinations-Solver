package calculationAlgorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import setupHelpers.ComponentRange;
import setupHelpers.ComponentsService2;

public class Iteration1 extends Thread {
	private final double a;
	private final List<String> weights; 
    private final double targetSum;
    private final int range;
    private final int charge;
    private final HashMap<String, ComponentRange> symbolsToRanges;
    private final ArrayList<String> solutionsList;
    
    private final double[] doubleWeights;
    private final String[] symbols;
    private final int[] charges;
    private final double[] mins;
    private final double[] maxes;
    
    public static final String SOLUTION_SEPARATION_LINE = 
    		"_____________________________________________________________________________________________________________";
    
    public Iteration1(  
    		final double a,
			final List<String> weights, 
	        final double targetSum,
	        final int range,
	        final int charge,
	        final HashMap<String, ComponentRange> symbolsToRanges,
	        final ArrayList<String> solutionsList) {
    	
    	this.a = a;
    	this.weights = weights;
    	this.targetSum = targetSum;
    	this.range = range;
    	this.charge = charge;
    	this.symbolsToRanges = symbolsToRanges;
    	this.solutionsList = solutionsList;
    	
    	this.doubleWeights = new double[weights.size()];
    	this.symbols = new String[weights.size()];
    	this.charges = new int[weights.size()];
    	this.mins = new double[weights.size()];
    	this.maxes = new double[weights.size()];
    }
	         
	@Override
	public void run() {
		this.findCombinations();
	}
	
	private void findCombinations() {
		if (weights.size() == 0) {
			return;
		} 
		
		for (int i = 0; i < weights.size(); i++) {
			doubleWeights[i] = Double.parseDouble(weights.get(i));
			symbols[i] = ComponentsService2.getWeightsToSymbols().get(weights.get(i));
			charges[i] = ComponentsService2.getWeightsToCharges().get(weights.get(i));
			mins[i] = symbolsToRanges.get(symbols[i]).getMin();
			maxes[i] = symbolsToRanges.get(symbols[i]).getMax();
		}
		
		switch (weights.size()) {
			case 1:
				this.findCombinations1Weights();
				break;
			case 2:
				this.findCombinations2Weights();
				break;
			case 3:
				this.findCombinations3Weights();
				break;
			case 4:
				this.findCombinations4Weights();
				break;
			case 5:
				this.findCombinations5Weights();
				break;
			case 6:
				this.findCombinations6Weights();
				break;
			case 7:
				this.findCombinations7Weights();
				break;
			case 8:
				this.findCombinations8Weights();
				break;
			case 9:
				this.findCombinations9Weights();
				break;
			case 10:
				this.findCombinations10Weights();
				break;
			case 11:
				this.findCombinations11Weights();
				break;
			case 12:
				this.findCombinations12Weights();
				break;
			case 13:
				this.findCombinations13Weights();
				break;
			case 14:
				this.findCombinations14Weights();
				break;
			case 15:
				this.findCombinations15Weights();
				break;
			case 16:
				this.findCombinations16Weights();
				break;
			case 17:
				this.findCombinations17Weights();
				break;
			case 18:
				this.findCombinations18Weights();
				break;
			case 19:
				this.findCombinations19Weights();
				break;
			case 20:
				this.findCombinations20Weights();
				break;
			default:
		}
	}
	
	private void findCombinations1Weights() {
		final double currentSum = a*doubleWeights[0];
		
		final double totalCharge = a*charges[0];

		if (totalCharge == charge 
				&& (currentSum >= targetSum - range 
				&& currentSum <= targetSum + range)) {
			
			final String solution = currentSum + "\n"
					+ totalCharge  + "\n"
					+ "(" + symbols[0] + ")" + String.valueOf((int)a) + " + "
					+ "\n" 
					+ SOLUTION_SEPARATION_LINE
					+ "\n";
			
			solutionsList.add(solution);
			System.out.println(solution);
		}
	}
	
	private void findCombinations2Weights() {
		double s0 = a*doubleWeights[0];

		double c0 = a*charges[0];
		
		for (double b = mins[1]; b <= maxes[1]; b++) {
			final double currentSum = s0 + b*doubleWeights[1];
			final double totalCharge = c0 + b*charges[1];

			if (totalCharge == charge 
					&& (currentSum >= targetSum - range 
					&& currentSum <= targetSum + range)) {
				
				final String solution = currentSum + "\n"
						+ totalCharge  + "\n"
						+ "(" + symbols[0] + ")" + String.valueOf((int)a) + " + "
						+ "(" + symbols[1] + ")" + String.valueOf((int)b)
						+ "\n" 
						+ SOLUTION_SEPARATION_LINE
						+ "\n";
				
				solutionsList.add(solution);
				System.out.println(solution);
			}
		}
	}
	
	private void findCombinations3Weights() {
		double s0 = a*doubleWeights[0];
		double s1 = 0;

		double c0 = a*charges[0];
		double c1= 0;

		for (double b = mins[1]; b <= maxes[1]; b++) {
			s1 = s0 + b*doubleWeights[1];
			c1 = c0 + b*charges[1];

			for (double c = mins[2]; c <= mins[2]; c++) {
				final double currentSum = s1 + c*doubleWeights[2];
				final double totalCharge = c1 + c*doubleWeights[2];

				if (totalCharge == charge 
						&& (currentSum >= targetSum - range 
						&& currentSum <= targetSum + range)) {
					
					final String solution = currentSum + "\n"
							+ totalCharge  + "\n"
							+ "(" + symbols[0] + ")" + String.valueOf((int)a) + " + "
							+ "(" + symbols[1] + ")" + String.valueOf((int)b) + " + "
							+ "(" + symbols[2] + ")" + String.valueOf((int)c)
							+ "\n" 
							+ SOLUTION_SEPARATION_LINE
							+ "\n";
					
					solutionsList.add(solution);
					System.out.println(solution);
				}
			}
		}
	}
	
	private void findCombinations4Weights() {
		double s0 = a*doubleWeights[0];
		double s1,s2 = 0;

		double c0 = a*charges[0];
		double c1,c2 = 0;

		for (double b = mins[1]; b <= maxes[1]; b++) {
			s1 = s0 + b*doubleWeights[1];
			c1 = c0 + b*charges[1];

			for (double c = mins[2]; c <= maxes[2]; c++) {
				s2 = s1 + c*doubleWeights[2];
				c2 = c1 + c*charges[2];
				
				for (double d = mins[3]; d <= maxes[3]; d++) {
					final double currentSum = s2 + d*doubleWeights[3];
					final double totalCharge = c2 + d*charges[3];

					if (totalCharge == charge 
							&& (currentSum >= targetSum - range 
							&& currentSum <= targetSum + range)) {
						
						final String solution = currentSum + "\n"
								+ totalCharge  + "\n"
								+ "(" + symbols[0] + ")" + String.valueOf((int)a) + " + "
								+ "(" + symbols[1] + ")" + String.valueOf((int)b) + " + "
								+ "(" + symbols[2] + ")" + String.valueOf((int)c) + " + "
								+ "(" + symbols[3] + ")" + String.valueOf((int)d)
								+ "\n" 
								+ SOLUTION_SEPARATION_LINE
								+ "\n";
						
						solutionsList.add(solution);
						System.out.println(solution);
					}
				}
			}
		}
	}
	
	private void findCombinations5Weights() {
		double s0 = a*doubleWeights[0];
		double s1,s2,s3 = 0;

		double c0 = a*charges[0];
		double c1,c2,c3 = 0;

		for (double b = mins[1]; b <= maxes[1]; b++) {
			s1 = s0 + b*doubleWeights[1];
			c1 = c0 + b*charges[1];

			for (double c = mins[2]; c <= maxes[2]; c++) {
				s2 = s1 + c*doubleWeights[2];
				c2 = c1 + c*charges[2];
				
				for (double d = mins[3]; d <= maxes[3]; d++) {
					s3 = s2 + d*doubleWeights[3];
					c3 = c2 + d*charges[3];
	
					for (double e = mins[4]; e <= maxes[4]; e++) {
						final double currentSum = s3 + e*doubleWeights[4];
						final double totalCharge = c3 + e*charges[4];

						if (totalCharge == charge 
								&& (currentSum >= targetSum - range 
								&& currentSum <= targetSum + range)) {
							
							final String solution = currentSum + "\n"
									+ totalCharge  + "\n"
									+ "(" + symbols[0] + ")" + String.valueOf((int)a) + " + "
									+ "(" + symbols[1] + ")" + String.valueOf((int)b) + " + "
									+ "(" + symbols[2] + ")" + String.valueOf((int)c) + " + "
									+ "(" + symbols[3] + ")" + String.valueOf((int)d) + " + "
									+ "(" + symbols[4] + ")" + String.valueOf((int)e)
									+ "\n" 
									+ SOLUTION_SEPARATION_LINE
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
		double s0 = a*doubleWeights[0];
		double s1,s2,s3,s4 = 0;

		double c0 = a*charges[0];
		double c1,c2,c3,c4 = 0;

		for (double b = mins[1]; b <= maxes[1]; b++) {
			s1 = s0 + b*doubleWeights[1];
			c1 = c0 + b*charges[1];

			for (double c = mins[2]; c <= maxes[2]; c++) {
				s2 = s1 + c*doubleWeights[2];
				c2 = c1 + c*charges[2];
				
				for (double d = mins[3]; d <= maxes[3]; d++) {
					s3 = s2 + d*doubleWeights[3];
					c3 = c2 + d*charges[3];
	
					for (double e = mins[4]; e <= maxes[4]; e++) {
						s4 = s3 + e*doubleWeights[4];
						c4 = c3 + e*charges[4];
			
						for (double f = mins[5]; f <= maxes[5]; f++) {
							final double currentSum = s4 + f*doubleWeights[5];
							final double totalCharge = c4 + f*charges[5];

							if (totalCharge == charge 
									&& (currentSum >= targetSum - range 
									&& currentSum <= targetSum + range)) {
								
								final String solution = currentSum + "\n"
										+ totalCharge  + "\n"
										+ "(" + symbols[0] + ")" + String.valueOf((int)a) + " + "
										+ "(" + symbols[1] + ")" + String.valueOf((int)b) + " + "
										+ "(" + symbols[2] + ")" + String.valueOf((int)c) + " + "
										+ "(" + symbols[3] + ")" + String.valueOf((int)d) + " + "
										+ "(" + symbols[4] + ")" + String.valueOf((int)e) + " + "
										+ "(" + symbols[5] + ")" + String.valueOf((int)f)
										+ "\n" 
										+ SOLUTION_SEPARATION_LINE
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
		double s0 = a*doubleWeights[0];
		double s1,s2,s3,s4,s5 = 0;
		
		double c0 = a*charges[0];
		double c1,c2,c3,c4,c5 = 0;

		for (double b = mins[1]; b <= maxes[1]; b++) {
			s1 = s0 + b*doubleWeights[1];
			c1 = c0 + b*charges[1];

			for (double c = mins[2]; c <= maxes[2]; c++) {
				s2 = s1 + c*doubleWeights[2];
				c2 = c1 + c*charges[2];
				
				for (double d = mins[3]; d <= maxes[3]; d++) {
					s3 = s2 + d*doubleWeights[3];
					c3 = c2 + d*charges[3];
	
					for (double e = mins[4]; e <= maxes[4]; e++) {
						s4 = s3 + e*doubleWeights[4];
						c4 = c3 + e*charges[4];
			
						for (double f = mins[5]; f <= maxes[5]; f++) {
							s5 = s4 + f*doubleWeights[5];
							c5 = c4 + f*charges[5];
			
							for (double g = mins[6]; g <= maxes[6]; g++) {
								final double currentSum = s5 + g*doubleWeights[6];
								final double totalCharge = c5 + g*charges[6];

								if (totalCharge == charge 
										&& (currentSum >= targetSum - range 
										&& currentSum <= targetSum + range)) {
									
									final String solution = currentSum + "\n"
											+ totalCharge  + "\n"
											+ "(" + symbols[0] + ")" + String.valueOf((int)a) + " + "
											+ "(" + symbols[1] + ")" + String.valueOf((int)b) + " + "
											+ "(" + symbols[2] + ")" + String.valueOf((int)c) + " + "
											+ "(" + symbols[3] + ")" + String.valueOf((int)d) + " + "
											+ "(" + symbols[4] + ")" + String.valueOf((int)e) + " + "
											+ "(" + symbols[5] + ")" + String.valueOf((int)f) + " + "
											+ "(" + symbols[6] + ")" + String.valueOf((int)g)
											+ "\n" 
											+ SOLUTION_SEPARATION_LINE
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
		double s0 = a*doubleWeights[0];
		double s1,s2,s3,s4,s5,s6 = 0;
		
		double c0 = a*charges[0];
		double c1,c2,c3,c4,c5,c6 = 0;

		for (double b = mins[1]; b <= maxes[1]; b++) {
			s1 = s0 + b*doubleWeights[1];
			c1 = c0 + b*charges[1];

			for (double c = mins[2]; c <= maxes[2]; c++) {
				s2 = s1 + c*doubleWeights[2];
				c2 = c1 + c*charges[2];
				
				for (double d = mins[3]; d <= maxes[3]; d++) {
					s3 = s2 + d*doubleWeights[3];
					c3 = c2 + d*charges[3];
	
					for (double e = mins[4]; e <= maxes[4]; e++) {
						s4 = s3 + e*doubleWeights[4];
						c4 = c3 + e*charges[4];
			
						for (double f = mins[5]; f <= maxes[5]; f++) {
							s5 = s4 + f*doubleWeights[5];
							c5 = c4 + f*charges[5];
			
							for (double g = mins[6]; g <= maxes[6]; g++) {
								s6 = s5 + g*doubleWeights[6];
								c6 = c5 + g*charges[6];
				
								for (double h = mins[7]; h <= maxes[7]; h++) {
									final double currentSum = s6 + h*doubleWeights[7];
									final double totalCharge = c6 + h*charges[7];

									if (totalCharge == charge 
											&& (currentSum >= targetSum - range 
											&& currentSum <= targetSum + range)) {
										
										final String solution = currentSum + "\n"
												+ totalCharge  + "\n"
												+ "(" + symbols[0] + ")" + String.valueOf((int)a) + " + "
												+ "(" + symbols[1] + ")" + String.valueOf((int)b) + " + "
												+ "(" + symbols[2] + ")" + String.valueOf((int)c) + " + "
												+ "(" + symbols[3] + ")" + String.valueOf((int)d) + " + "
												+ "(" + symbols[4] + ")" + String.valueOf((int)e) + " + "
												+ "(" + symbols[5] + ")" + String.valueOf((int)f) + " + "
												+ "(" + symbols[6] + ")" + String.valueOf((int)g) + " + "
												+ "(" + symbols[7] + ")" + String.valueOf((int)h)
												+ "\n" 
												+ SOLUTION_SEPARATION_LINE
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
		double s0 = a*doubleWeights[0];
		double s1,s2,s3,s4,s5,s6,s7 = 0;
		
		double c0 = a*charges[0];
		double c1,c2,c3,c4,c5,c6,c7 = 0;
		
		for (double b = mins[1]; b <= maxes[1]; b++) {
			s1 = s0 + b*doubleWeights[1];
			c1 = c0 + b*charges[1];

			for (double c = mins[2]; c <= maxes[2]; c++) {
				s2 = s1 + c*doubleWeights[2];
				c2 = c1 + c*charges[2];
				
				for (double d = mins[3]; d <= maxes[3]; d++) {
					s3 = s2 + d*doubleWeights[3];
					c3 = c2 + d*charges[3];
	
					for (double e = mins[4]; e <= maxes[4]; e++) {
						s4 = s3 + e*doubleWeights[4];
						c4 = c3 + e*charges[4];
			
						for (double f = mins[5]; f <= maxes[5]; f++) {
							s5 = s4 + f*doubleWeights[5];
							c5 = c4 + f*charges[5];
			
							for (double g = mins[6]; g <= maxes[6]; g++) {
								s6 = s5 + g*doubleWeights[6];
								c6 = c5 + g*charges[6];
				
								for (double h = mins[7]; h <= maxes[7]; h++) {
									s7 = s6 + h*doubleWeights[7];
									c7 = c6 + h*charges[7];
					
									for (double i = mins[8]; i <= maxes[8]; i++) {
										final double currentSum = s7 + i*doubleWeights[8];
										final double totalCharge = c7 + i*charges[8];

										if (totalCharge == charge 
												&& (currentSum >= targetSum - range 
												&& currentSum <= targetSum + range)) {
											
											final String solution = currentSum + "\n"
													+ totalCharge  + "\n"
													+ "(" + symbols[0] + ")" + String.valueOf((int)a) + " + "
													+ "(" + symbols[1] + ")" + String.valueOf((int)b) + " + "
													+ "(" + symbols[2] + ")" + String.valueOf((int)c) + " + "
													+ "(" + symbols[3] + ")" + String.valueOf((int)d) + " + "
													+ "(" + symbols[4] + ")" + String.valueOf((int)e) + " + "
													+ "(" + symbols[5] + ")" + String.valueOf((int)f) + " + "
													+ "(" + symbols[6] + ")" + String.valueOf((int)g) + " + "
													+ "(" + symbols[7] + ")" + String.valueOf((int)h) + " + "
													+ "(" + symbols[8] + ")" + String.valueOf((int)i)
													+ "\n" 
													+ SOLUTION_SEPARATION_LINE
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
		double s0 = a*doubleWeights[0];
		double s1,s2,s3,s4,s5,s6,s7,s8 = 0;
		
		double c0 = a*charges[0];
		double c1,c2,c3,c4,c5,c6,c7,c8 = 0;
		
		for (double b = mins[1]; b <= maxes[1]; b++) {
			s1 = s0 + b*doubleWeights[1];
			c1 = c0 + b*charges[1];

			for (double c = mins[2]; c <= maxes[2]; c++) {
				s2 = s1 + c*doubleWeights[2];
				c2 = c1 + c*charges[2];
				
				for (double d = mins[3]; d <= maxes[3]; d++) {
					s3 = s2 + d*doubleWeights[3];
					c3 = c2 + d*charges[3];
	
					for (double e = mins[4]; e <= maxes[4]; e++) {
						s4 = s3 + e*doubleWeights[4];
						c4 = c3 + e*charges[4];
			
						for (double f = mins[5]; f <= maxes[5]; f++) {
							s5 = s4 + f*doubleWeights[5];
							c5 = c4 + f*charges[5];
			
							for (double g = mins[6]; g <= maxes[6]; g++) {
								s6 = s5 + g*doubleWeights[6];
								c6 = c5 + g*charges[6];
				
								for (double h = mins[7]; h <= maxes[7]; h++) {
									s7 = s6 + h*doubleWeights[7];
									c7 = c6 + h*charges[7];
					
									for (double i = mins[8]; i <= maxes[8]; i++) {
										s8 = s7 + i*doubleWeights[8];
										c8 = c7 + i*charges[8];
						
										for (double j = mins[9]; j <= maxes[9]; j++) {
											final double currentSum = s8 + j*doubleWeights[9];
											final double totalCharge = c8 + j*charges[9];

											if (totalCharge == charge 
													&& (currentSum >= targetSum - range 
													&& currentSum <= targetSum + range)) {
												
												final String solution = currentSum + "\n"
														+ totalCharge  + "\n"
														+ "(" + symbols[0] + ")" + String.valueOf((int)a) + " + "
														+ "(" + symbols[1] + ")" + String.valueOf((int)b) + " + "
														+ "(" + symbols[2] + ")" + String.valueOf((int)c) + " + "
														+ "(" + symbols[3] + ")" + String.valueOf((int)d) + " + "
														+ "(" + symbols[4] + ")" + String.valueOf((int)e) + " + "
														+ "(" + symbols[5] + ")" + String.valueOf((int)f) + " + "
														+ "(" + symbols[6] + ")" + String.valueOf((int)g) + " + "
														+ "(" + symbols[7] + ")" + String.valueOf((int)h) + " + "
														+ "(" + symbols[8] + ")" + String.valueOf((int)i) + " + "
														+ "(" + symbols[9] + ")" + String.valueOf((int)j)
														+ "\n" 
														+ SOLUTION_SEPARATION_LINE
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
		double s0 = a*doubleWeights[0];
		double s1,s2,s3,s4,s5,s6,s7,s8,s9 = 0;
		
		double c0 = a*charges[0];
		double c1,c2,c3,c4,c5,c6,c7,c8,c9 = 0;
		
		for (double b = mins[1]; b <= maxes[1]; b++) {
			s1 = s0 + b*doubleWeights[1];
			c1 = c0 + b*charges[1];

			for (double c = mins[2]; c <= maxes[2]; c++) {
				s2 = s1 + c*doubleWeights[2];
				c2 = c1 + c*charges[2];
				
				for (double d = mins[3]; d <= maxes[3]; d++) {
					s3 = s2 + d*doubleWeights[3];
					c3 = c2 + d*charges[3];
	
					for (double e = mins[4]; e <= maxes[4]; e++) {
						s4 = s3 + e*doubleWeights[4];
						c4 = c3 + e*charges[4];
			
						for (double f = mins[5]; f <= maxes[5]; f++) {
							s5 = s4 + f*doubleWeights[5];
							c5 = c4 + f*charges[5];
			
							for (double g = mins[6]; g <= maxes[6]; g++) {
								s6 = s5 + g*doubleWeights[6];
								c6 = c5 + g*charges[6];
				
								for (double h = mins[7]; h <= maxes[7]; h++) {
									s7 = s6 + h*doubleWeights[7];
									c7 = c6 + h*charges[7];
					
									for (double i = mins[8]; i <= maxes[8]; i++) {
										s8 = s7 + i*doubleWeights[8];
										c8 = c7 + i*charges[8];
						
										for (double j = mins[9]; j <= maxes[9]; j++) {
											s9 = s8 + j*doubleWeights[9];
											c9 = c8 + j*charges[9];
							
											for (double k = mins[10]; k <= maxes[10]; k++) {
												final double currentSum = s9 + k*doubleWeights[10];
												final double totalCharge = c9 + k*charges[10];

												if (totalCharge == charge 
														&& (currentSum >= targetSum - range 
														&& currentSum <= targetSum + range)) {
													
													final String solution = currentSum + "\n"
															+ totalCharge  + "\n"
															+ "(" + symbols[0] + ")" + String.valueOf((int)a) + " + "
															+ "(" + symbols[1] + ")" + String.valueOf((int)b) + " + "
															+ "(" + symbols[2] + ")" + String.valueOf((int)c) + " + "
															+ "(" + symbols[3] + ")" + String.valueOf((int)d) + " + "
															+ "(" + symbols[4] + ")" + String.valueOf((int)e) + " + "
															+ "(" + symbols[5] + ")" + String.valueOf((int)f) + " + "
															+ "(" + symbols[6] + ")" + String.valueOf((int)g) + " + "
															+ "(" + symbols[7] + ")" + String.valueOf((int)h) + " + "
															+ "(" + symbols[8] + ")" + String.valueOf((int)i) + " + "
															+ "(" + symbols[9] + ")" + String.valueOf((int)j) + " + " 
															+ "(" + symbols[10] + ")" + String.valueOf((int)k)
															+ "\n" 
															+ SOLUTION_SEPARATION_LINE
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
		double s0 = a*doubleWeights[0];
		double s1,s2,s3,s4,s5,s6,s7,s8,s9,s10 = 0;
		
		double c0 = a*charges[0];
		double c1,c2,c3,c4,c5,c6,c7,c8,c9,c10 = 0;
		
		for (double b = mins[1]; b <= maxes[1]; b++) {
			s1 = s0 + b*doubleWeights[1];
			c1 = c0 + b*charges[1];

			for (double c = mins[2]; c <= maxes[2]; c++) {
				s2 = s1 + c*doubleWeights[2];
				c2 = c1 + c*charges[2];
				
				for (double d = mins[3]; d <= maxes[3]; d++) {
					s3 = s2 + d*doubleWeights[3];
					c3 = c2 + d*charges[3];
	
					for (double e = mins[4]; e <= maxes[4]; e++) {
						s4 = s3 + e*doubleWeights[4];
						c4 = c3 + e*charges[4];
			
						for (double f = mins[5]; f <= maxes[5]; f++) {
							s5 = s4 + f*doubleWeights[5];
							c5 = c4 + f*charges[5];
			
							for (double g = mins[6]; g <= maxes[6]; g++) {
								s6 = s5 + g*doubleWeights[6];
								c6 = c5 + g*charges[6];
				
								for (double h = mins[7]; h <= maxes[7]; h++) {
									s7 = s6 + h*doubleWeights[7];
									c7 = c6 + h*charges[7];
					
									for (double i = mins[8]; i <= maxes[8]; i++) {
										s8 = s7 + i*doubleWeights[8];
										c8 = c7 + i*charges[8];
						
										for (double j = mins[9]; j <= maxes[9]; j++) {
											s9 = s8 + j*doubleWeights[9];
											c9 = c8 + j*charges[9];
							
											for (double k = mins[10]; k <= maxes[10]; k++) {
												s10 = s9 + k*doubleWeights[10];
												c10 = c9 + k*charges[10];
												
												for (double l = mins[11]; l <= maxes[11]; l++) {
													final double currentSum = s10 + l*doubleWeights[11];
													final double totalCharge = c10 + l*charges[11];

													if (totalCharge == charge 
															&& (currentSum >= targetSum - range 
															&& currentSum <= targetSum + range)) {
														
														final String solution = currentSum + "\n"
																+ totalCharge  + "\n"
																+ "(" + symbols[0] + ")" + String.valueOf((int)a) + " + "
																+ "(" + symbols[1] + ")" + String.valueOf((int)b) + " + "
																+ "(" + symbols[2] + ")" + String.valueOf((int)c) + " + "
																+ "(" + symbols[3] + ")" + String.valueOf((int)d) + " + "
																+ "(" + symbols[4] + ")" + String.valueOf((int)e) + " + "
																+ "(" + symbols[5] + ")" + String.valueOf((int)f) + " + "
																+ "(" + symbols[6] + ")" + String.valueOf((int)g) + " + "
																+ "(" + symbols[7] + ")" + String.valueOf((int)h) + " + "
																+ "(" + symbols[8] + ")" + String.valueOf((int)i) + " + "
																+ "(" + symbols[9] + ")" + String.valueOf((int)j) + " + " 
																+ "(" + symbols[10] + ")" + String.valueOf((int)k) + " + "
																+ "(" + symbols[11] + ")" + String.valueOf((int)l)
																+ "\n" 
																+ SOLUTION_SEPARATION_LINE
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
		double s0 = a*doubleWeights[0];
		double s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11 = 0;
		
		double c0 = a*charges[0];
		double c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11 = 0;
		
		for (double b = mins[1]; b <= maxes[1]; b++) {
			s1 = s0 + b*doubleWeights[1];
			c1 = c0 + b*charges[1];

			for (double c = mins[2]; c <= maxes[2]; c++) {
				s2 = s1 + c*doubleWeights[2];
				c2 = c1 + c*charges[2];
				
				for (double d = mins[3]; d <= maxes[3]; d++) {
					s3 = s2 + d*doubleWeights[3];
					c3 = c2 + d*charges[3];
	
					for (double e = mins[4]; e <= maxes[4]; e++) {
						s4 = s3 + e*doubleWeights[4];
						c4 = c3 + e*charges[4];
			
						for (double f = mins[5]; f <= maxes[5]; f++) {
							s5 = s4 + f*doubleWeights[5];
							c5 = c4 + f*charges[5];
			
							for (double g = mins[6]; g <= maxes[6]; g++) {
								s6 = s5 + g*doubleWeights[6];
								c6 = c5 + g*charges[6];
				
								for (double h = mins[7]; h <= maxes[7]; h++) {
									s7 = s6 + h*doubleWeights[7];
									c7 = c6 + h*charges[7];
					
									for (double i = mins[8]; i <= maxes[8]; i++) {
										s8 = s7 + i*doubleWeights[8];
										c8 = c7 + i*charges[8];
						
										for (double j = mins[9]; j <= maxes[9]; j++) {
											s9 = s8 + j*doubleWeights[9];
											c9 = c8 + j*charges[9];
							
											for (double k = mins[10]; k <= maxes[10]; k++) {
												s10 = s9 + k*doubleWeights[10];
												c10 = c9 + k*charges[10];
												
												for (double l = mins[11]; l <= maxes[11]; l++) {
													s11 = s10 + l*doubleWeights[11];
													c11 = c10 + l*charges[11];
													
													for (double m = mins[12]; m <= maxes[12]; m++) {
														final double currentSum = s11 + m*doubleWeights[12];
														final double totalCharge = c11 + m*charges[12];

														if (totalCharge == charge 
																&& (currentSum >= targetSum - range 
																&& currentSum <= targetSum + range)) {
															
															final String solution = currentSum + "\n"
																+ totalCharge  + "\n"
																+ "(" + symbols[0] + ")" + String.valueOf((int)a) + " + "
																+ "(" + symbols[1] + ")" + String.valueOf((int)b) + " + "
																+ "(" + symbols[2] + ")" + String.valueOf((int)c) + " + "
																+ "(" + symbols[3] + ")" + String.valueOf((int)d) + " + "
																+ "(" + symbols[4] + ")" + String.valueOf((int)e) + " + "
																+ "(" + symbols[5] + ")" + String.valueOf((int)f) + " + "
																+ "(" + symbols[6] + ")" + String.valueOf((int)g) + " + "
																+ "(" + symbols[7] + ")" + String.valueOf((int)h) + " + "
																+ "(" + symbols[8] + ")" + String.valueOf((int)i) + " + "
																+ "(" + symbols[9] + ")" + String.valueOf((int)j) + " + " 
																+ "(" + symbols[10] + ")" + String.valueOf((int)k) + " + "
																+ "(" + symbols[11] + ")" + String.valueOf((int)l) + " + "
																+ "(" + symbols[12] + ")" + String.valueOf((int)m) 
																+ "\n" 
																+ SOLUTION_SEPARATION_LINE
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
		
	}
	
	private void findCombinations15Weights() {
	
	}
	
	private void findCombinations16Weights() {
		
	}
	
	private void findCombinations17Weights() {
		
	}
	
	private void findCombinations18Weights() {
	
	}
	
	private void findCombinations19Weights() {
		
	}
	
	private void findCombinations20Weights() {
		
	}
}