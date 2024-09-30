package calculationAlgorithms.nestedThreadIteration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import setupHelpers.ComponentRange;

public class ThreadIteration8 extends Thread {
	private final double a;
	private final double b;
	private final double c;
	private final double d;
	private final double e;
	private final double f;
	private final double g;
	private final double h;
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
    
    private static final String SOLUTION_SEPARATION_LINE = 
    		"_____________________________________________________________________________________________________________";
    
    public ThreadIteration8(  
    		final double a,
    		final double b,
    		final double c,
    		final double d,
    		final double e,
    		final double f,
    		final double g,
    		final double h,
			final List<String> weights, 
	        final double targetSum,
	        final int range,
	        final int charge,
	        final HashMap<String, ComponentRange> symbolsToRanges,
	        final ArrayList<String> solutionsList,
	        final double[] doubleWeights,
		    final String[] symbols,
		    final int[] charges,
		    final double[] mins,
		    final double[] maxes) {
    	
    	this.a = a;
    	this.b = b;
    	this.c = c;
    	this.d = d;
    	this.e = e;
    	this.f = f;
    	this.g = g;
    	this.h = h;
    	this.weights = weights;
    	this.targetSum = targetSum;
    	this.range = range;
    	this.charge = charge;
    	this.symbolsToRanges = symbolsToRanges;
    	this.solutionsList = solutionsList;
    	
    	this.doubleWeights = doubleWeights;
    	this.symbols = symbols;
    	this.charges = charges;
    	this.mins = mins;
    	this.maxes = maxes;
    }
	         
	@Override
	public void run() {
		this.findCombinations();
	}
	
	private void findCombinations() {
		switch (weights.size()) {
			case 9:
				this.findCombinations9Weights();
				break;
		}
	}
	
	private void findCombinations9Weights() {
		double s0 = a*doubleWeights[0] + b*doubleWeights[1] + c*doubleWeights[2] + d*doubleWeights[3] + e*doubleWeights[4] + f*doubleWeights[5]
				+ g*doubleWeights[6] + h*doubleWeights[7];
		
		double c0 = a*charges[0] + b*charges[1] + c*charges[2] + d*charges[3] + e*charges[4] + f*charges[5] + g*charges[6] + h*charges[7];
		
		for (double i = mins[8]; i <= maxes[8]; i++) {
			final double currentSum = s0 + i*doubleWeights[8];
			final double totalCharge = c0 + i*charges[8];
			
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
