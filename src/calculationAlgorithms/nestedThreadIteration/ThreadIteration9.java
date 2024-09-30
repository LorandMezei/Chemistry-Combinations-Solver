package calculationAlgorithms.nestedThreadIteration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import setupHelpers.ComponentRange;
import setupHelpers.ComponentsService2;

public class ThreadIteration9 extends Thread {
	private final double a;
	private final double b;
	private final double c;
	private final double d;
	private final double e;
	private final double f;
	private final double g;
	private final double h;
	private final double i;
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
    
    public ThreadIteration9(  
    		final double a,
    		final double b,
    		final double c,
    		final double d,
    		final double e,
    		final double f,
    		final double g,
    		final double h,
    		final double i,
			final List<String> weights, 
	        final double targetSum,
	        final int range,
	        final int charge,
	        final HashMap<String, ComponentRange> symbolsToRanges,
	        final ArrayList<String> solutionsList) {
    	
    	this.a = a;
    	this.b = b;
    	this.c = c;
    	this.d = d;
    	this.e = e;
    	this.f = f;
    	this.g = g;
    	this.h = h;
    	this.i = i;
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
	
		}
	}
}
