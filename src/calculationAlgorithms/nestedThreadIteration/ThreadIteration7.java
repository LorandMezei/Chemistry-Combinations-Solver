package calculationAlgorithms.nestedThreadIteration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import setupHelpers.ComponentRange;

public class ThreadIteration7 extends Thread {
	private final double a;
	private final double b;
	private final double c;
	private final double d;
	private final double e;
	private final double f;
	private final double g;
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
    
    public ThreadIteration7(  
    		final double a,
    		final double b,
    		final double c,
    		final double d,
    		final double e,
    		final double f,
    		final double g,
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
				+ g*doubleWeights[6];
		double s1 = 0;
		
		double c0 = a*charges[0] + b*charges[1] + c*charges[2] + d*charges[3] + e*charges[4] + f*charges[5] + g*charges[6];
		double c1 = 0;
		
		final List<Thread> threads = new ArrayList<Thread>();
		
		for (double h = mins[7]; h <= maxes[7]; h++) {
			s1 = s0 + h*doubleWeights[7];
			c1 = c0 + h*charges[7];
			
			// create threads here for each value of b
			final ThreadIteration8 iteration = new ThreadIteration8(
					this.a, this.b, this.c, this.d, this.e, this.f, this.g, h, 
					this.weights, this.targetSum, this.range, this.charge, this.symbolsToRanges, this.solutionsList,
					this.doubleWeights, this.symbols, this.charges, this.mins, this.maxes);
			
			final Thread thread = new Thread(iteration);
			thread.start();
			
			System.out.println("Starting thread : ");
			
			threads.add(thread);
		}
		
		for (final Thread t : threads) {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
