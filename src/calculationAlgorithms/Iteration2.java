package calculationAlgorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import setupHelpers.ComponentRange;
import setupHelpers.ComponentsService2;

public class Iteration2 extends Thread {
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
    
    public Iteration2(  
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
		if (this.weights.size() == 0) {
			return;
		} 
		
		for (int i = 0; i < this.weights.size(); i++) {
			this.doubleWeights[i] = Double.parseDouble(this.weights.get(i));
			this.symbols[i] = ComponentsService2.getWeightsToSymbols().get(this.weights.get(i));
			this.charges[i] = ComponentsService2.getWeightsToCharges().get(this.weights.get(i));
			this.mins[i] = this.symbolsToRanges.get(this.symbols[i]).getMin();
			this.maxes[i] = this.symbolsToRanges.get(this.symbols[i]).getMax();
		}
		
		this.findCombinationsForComponents();
	}
		
	private void findCombinationsForComponents() {
		final int size = weights.size();
		
		double s0 = this.a*this.doubleWeights[0];
		double s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12 = 0;
		
		double c0 = this.a*this.charges[0];
		double c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12 = 0;
					
		outerLoop:
		for (double b = this.mins[1]; b <= this.maxes[1]; b++) {
			s1 = s0 + b*this.doubleWeights[1];
			c1 = c0 + b*this.charges[1];
			this.tryValues(new double[]{this.a,b}, s1, c1);
						
			if (size == 2) {
				continue;
		    }

			for (double c = this.mins[2]; c <= this.maxes[2]; c++) {
				s2 = s1 + c*this.doubleWeights[2];
				c2 = c1 + c*this.charges[2];
				this.tryValues(new double[]{this.a,b,c}, s2, c2);
								
				if (size == 3) {
					continue;
				}
				
				for (double d = this.mins[3]; d <= this.maxes[3]; d++) {
					s3 = s2 + d*this.doubleWeights[3];
					c3 = c2 + d*this.charges[3];
					this.tryValues(new double[]{this.a,b,c,d}, s3, c3);
					
					if (size == 4) {
						continue;
					}
					
					for (double e = this.mins[4]; e <= this.maxes[4]; e++) {	
						s4 = s3 + e*this.doubleWeights[4];
						c4 = c3 + e*this.charges[4];
						this.tryValues(new double[]{this.a,b,c,d,e}, s4, c4);
										
						if (size == 5) {
							continue;
						}
			
						for (double f = this.mins[5]; f <= this.maxes[5]; f++) {
							s5 = s4 + f*this.doubleWeights[5];
							c5 = c4 + f*this.charges[5];						
							this.tryValues(new double[]{this.a,b,c,d,e,f}, s5, c5);
											
							if (size == 6) {
								continue;
							}
			
							for (double g = mins[6]; g <= this.maxes[6]; g++) {
								s6 = s5 + g*this.doubleWeights[6];
								c6 = c5 + g*this.charges[6];							
								this.tryValues(new double[]{this.a,b,c,d,e,f,g}, s6, c6);
												
								if (size == 7) {
									continue;
								}
				
								for (double h = this.mins[7]; h <= this.maxes[7]; h++) {
									s7 = s6 + h*this.doubleWeights[7];
									c7 = c6 + h*this.charges[7];								
									this.tryValues(new double[]{this.a,b,c,d,e,f,g,h}, s7, c7);
													
									if (size == 8) {
										continue;
									}
					
									for (double i = this.mins[8]; i <= this.maxes[8]; i++) {
										s8 = s7 + i*this.doubleWeights[8];
										c8 = c7 + i*this.charges[8];									
										this.tryValues(new double[]{this.a,b,c,d,e,f,g,h,i}, s8, c8);
														
										if (size == 9) {
											continue;
										}
						
										for (double j = this.mins[9]; j <= this.maxes[9]; j++) {
											s9 = s8 + j*this.doubleWeights[9];
											c9 = c8 + j*this.charges[9];										
											this.tryValues(new double[]{this.a,b,c,d,e,f,g,h,i,j}, s9, c9);
															
											if (size == 10) {
												continue;
											}
							
											for (double k = this.mins[10]; k <= this.maxes[10]; k++) {
												s10 = s9 + k*this.doubleWeights[10];
												c10 = c9 + k*this.charges[10];											
												this.tryValues(new double[]{this.a,b,c,d,e,f,g,h,i,j,k}, s10, c10);
																
												if (size == 11) {
													continue;
												}
												
												for (double l = this.mins[11]; l <= this.maxes[11]; l++) {
													s11 = s10 + l*this.doubleWeights[11];
													c11 = c10 + l*this.charges[11];												
													this.tryValues(new double[]{this.a,b,c,d,e,f,g,h,i,j,k,l}, s11, c11);
																
													if (size == 12) {
														continue;
													}
													
													for (double m = this.mins[12]; m <= this.maxes[12]; m++) {
														s12 = s11 + m*this.doubleWeights[12];
														c12 = c11 + m*this.charges[12];													
														this.tryValues(new double[]{this.a,b,c,d,e,f,g,h,i,j,k,l,m}, s12, c12);				
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
	
	private void tryValues(final double[] coefficients,
						   final double totalSum,
						   final double totalCharge) {
		if (totalCharge == this.charge 
						&& (totalSum >= this.targetSum - this.range 
						&& totalSum <= this.targetSum + this.range)) {
					
			String solution = totalSum + "\n" + totalCharge + "\n";
			for (int i = 0; i < coefficients.length; i++) {
				solution += "(" + this.symbols[i] + ")" + String.valueOf((int)coefficients[i]);
				if (i != coefficients.length - 1) {
					solution += " + ";
				}
			}
			solution +=  "\n" + SOLUTION_SEPARATION_LINE + "\n";
				
			this.solutionsList.add(solution);
			System.out.println(solution);
		}
	}
}