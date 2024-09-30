package calculationAlgorithms.nestedThreadIteration;

import calculationAlgorithms.Iteration1;

public class ThreadIteration4 extends Thread {
	private final double a;
	private final double b;
	private final double c;
	private final double d;
    
    public ThreadIteration4(  
    		final double a,
    		final double b,
    		final double c,
    		final double d) {
    	this.a = a;
    	this.b = b;
    	this.c = c;
    	this.d = d;
    }
	         
	@Override
	public void run() {
		this.fifthThreadLevel();
		//this.elevenWeights();
		//this.findCombinationsForComponents();
	}
	
	private void fifthThreadLevel() {
		for (double e = CalculationProperties.getMins()[4]; e <= CalculationProperties.getMaxes()[4]; e++) {
			final ThreadIteration5 iteration = new ThreadIteration5(
					this.a, this.b, this.c, this.d, e);
			
			final Thread thread = new Thread(iteration);
			thread.start();
			try {
				thread.join();
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	private void elevenWeights() {
		double s3 = this.a*CalculationProperties.getDoubleWeights()[0] 
				+ this.b*CalculationProperties.getDoubleWeights()[1]
			    + this.c*CalculationProperties.getDoubleWeights()[2]
			    + this.d*CalculationProperties.getDoubleWeights()[3];
		double s4,s5,s6,s7,s8,s9 = 0;
		
		double c3 = this.a*CalculationProperties.getCharges()[0] 
				+ this.b*CalculationProperties.getCharges()[1]
				+ this.c*CalculationProperties.getCharges()[2]
				+ this.d*CalculationProperties.getCharges()[3];
		double c4,c5,c6,c7,c8,c9 = 0;
			
		for (double e = CalculationProperties.getMins()[4]; e <= CalculationProperties.getMaxes()[4]; e++) {
			s4 = s3 + e*CalculationProperties.getDoubleWeights()[4];
			c4 = c3 + e*CalculationProperties.getCharges()[4];

			for (double f = CalculationProperties.getMins()[5]; f <= CalculationProperties.getMaxes()[5]; f++) {
				s5 = s4 + f*CalculationProperties.getDoubleWeights()[5];
				c5 = c4 + f*CalculationProperties.getCharges()[5];

				for (double g = CalculationProperties.getMins()[6]; g <= CalculationProperties.getMaxes()[6]; g++) {
					s6 = s5 + g*CalculationProperties.getDoubleWeights()[6];
					c6 = c5 + g*CalculationProperties.getCharges()[6];
	
					for (double h = CalculationProperties.getMins()[7]; h <= CalculationProperties.getMaxes()[7]; h++) {
						s7 = s6 + h*CalculationProperties.getDoubleWeights()[7];
						c7 = c6 + h*CalculationProperties.getCharges()[7];
		
						for (double i = CalculationProperties.getMins()[8]; i <= CalculationProperties.getMaxes()[8]; i++) {
							s8 = s7 + i*CalculationProperties.getDoubleWeights()[8];
							c8 = c7 + i*CalculationProperties.getCharges()[8];
							
							for (double j = CalculationProperties.getMins()[9]; j <= CalculationProperties.getMaxes()[9]; j++) {
								s9 = s8 + j*CalculationProperties.getDoubleWeights()[9];
								c8 = c8 + j*CalculationProperties.getCharges()[9];
								
								for (double k = CalculationProperties.getMins()[10]; k <= CalculationProperties.getMaxes()[10]; k++) {
									final double currentSum = s9 + k*CalculationProperties.getDoubleWeights()[10];
									final double totalCharge = c9 + k*CalculationProperties.getCharges()[10];
								
									if (totalCharge == CalculationProperties.getCharge() 
										&& (currentSum >= CalculationProperties.getTargetSum() - CalculationProperties.getRange() 
										&& currentSum <= CalculationProperties.getTargetSum() + CalculationProperties.getRange())) {
									
										final String solution = currentSum + "\n"
												+ totalCharge  + "\n"
												+ "(" + CalculationProperties.getSymbols()[0] + ")" + String.valueOf((int)this.a) + " + "
												+ "(" + CalculationProperties.getSymbols()[1] + ")" + String.valueOf((int)this.b) + " + "
												+ "(" + CalculationProperties.getSymbols()[2] + ")" + String.valueOf((int)this.c) + " + "
												+ "(" + CalculationProperties.getSymbols()[3] + ")" + String.valueOf((int)this.d) + " + "
												+ "(" + CalculationProperties.getSymbols()[4] + ")" + String.valueOf((int)e) + " + "
												+ "(" + CalculationProperties.getSymbols()[5] + ")" + String.valueOf((int)f) + " + "
												+ "(" + CalculationProperties.getSymbols()[6] + ")" + String.valueOf((int)g) + " + "
												+ "(" + CalculationProperties.getSymbols()[7] + ")" + String.valueOf((int)h) + " + "
												+ "(" + CalculationProperties.getSymbols()[8] + ")" + String.valueOf((int)i) + " + "
												+ "(" + CalculationProperties.getSymbols()[9] + ")" + String.valueOf((int)j) + " + "
												+ "(" + CalculationProperties.getSymbols()[10] + ")" + String.valueOf((int)k)
												+ "\n" 
												+ Iteration1.SOLUTION_SEPARATION_LINE
												+ "\n";
										
										CalculationProperties.getSolutionsList().add(solution);
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
		
	private void findCombinationsForComponents() {
		double s0 = this.a*CalculationProperties.getDoubleWeights()[0] 
				+ this.b*CalculationProperties.getDoubleWeights()[1]
				+ this.c*CalculationProperties.getDoubleWeights()[2]
			    + this.d*CalculationProperties.getDoubleWeights()[3];
		
		double c0 = this.a*CalculationProperties.getCharges()[0] 
				+ this.b*CalculationProperties.getCharges()[1]
				+ this.c*CalculationProperties.getCharges()[2]
				+ this.d*CalculationProperties.getCharges()[3];
		
		if (CalculationProperties.getWeights().size() == 5) {
			for (double e = CalculationProperties.getMins()[4]; e <= CalculationProperties.getMaxes()[4]; e++) {
				final double currentSum = s0 + e*CalculationProperties.getDoubleWeights()[4];
				final double totalCharge = c0 + e*CalculationProperties.getDoubleWeights()[4];
	
				if (totalCharge == CalculationProperties.getCharge() 
						&& (currentSum >= CalculationProperties.getTargetSum() - CalculationProperties.getRange()  
						&& currentSum <= CalculationProperties.getTargetSum() + CalculationProperties.getRange())) {
					
					final String solution = currentSum + "\n"
							+ totalCharge  + "\n"
							+ "(" + CalculationProperties.getSymbols()[0] + ")" + String.valueOf((int)this.a) + " + "
							+ "(" + CalculationProperties.getSymbols()[1] + ")" + String.valueOf((int)this.b) + " + "
							+ "(" + CalculationProperties.getSymbols()[2] + ")" + String.valueOf((int)this.c) + " + "
							+ "(" + CalculationProperties.getSymbols()[3] + ")" + String.valueOf((int)this.d) + " + "
							+ "(" + CalculationProperties.getSymbols()[4] + ")" + String.valueOf((int)e)
							+ "\n" 
							+ Iteration1.SOLUTION_SEPARATION_LINE
							+ "\n";
					
					CalculationProperties.getSolutionsList().add(solution);
					System.out.println(solution);
				}
			}
			
		} else {
//			for (double e = CalculationProperties.getMins()[4]; e <= CalculationProperties.getMaxes()[4]; e++) {
//				// create threads here for each value of b
//				final ThreadIteration4 iteration = new ThreadIteration4(
//						this.a, this.b, this.c, this.d, e);
//				
//				final Thread thread = new Thread(iteration);
//				thread.start();
//				try {
//					thread.join();
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
		}
	}
}
