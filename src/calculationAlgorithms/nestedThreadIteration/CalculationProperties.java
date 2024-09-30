package calculationAlgorithms.nestedThreadIteration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import setupHelpers.ComponentRange;
import setupHelpers.ComponentsService2;

public class CalculationProperties {
	
	private static List<String> weights; 
    private static double targetSum;
    private static int range;
    private static int charge;
    private static HashMap<String, ComponentRange> symbolsToRanges;
    private static ArrayList<String> solutionsList;
    
    private static double[] doubleWeights;
    private static String[] symbols;
    private static int[] charges;
    private static double[] mins;
    private static double[] maxes;
    
    public static void loadProperties(
    		final List<String> weights, 
	        final double targetSum,
	        final int range,
	        final int charge,
	        final HashMap<String, ComponentRange> symbolsToRanges,
	        final ArrayList<String> solutionsList) {
    	
        CalculationProperties.weights = weights;
        CalculationProperties.targetSum = targetSum;
    	CalculationProperties.range = range;
    	CalculationProperties.charge = charge;
    	CalculationProperties.symbolsToRanges = symbolsToRanges;
    	CalculationProperties.solutionsList = solutionsList;
    	
        CalculationProperties.doubleWeights = new double[CalculationProperties.weights.size()];
    	CalculationProperties.symbols = new String[CalculationProperties.weights.size()];
    	CalculationProperties.charges = new int[CalculationProperties.weights.size()];
        CalculationProperties.mins = new double[CalculationProperties.weights.size()];
    	CalculationProperties.maxes = new double[CalculationProperties.weights.size()];
    	
    	for (int i = 0; i < CalculationProperties.weights.size(); i++) {
			CalculationProperties.doubleWeights[i] = Double.parseDouble(CalculationProperties.weights.get(i));
			CalculationProperties.symbols[i] = ComponentsService2.getWeightsToSymbols().get(CalculationProperties.weights.get(i));
			CalculationProperties.charges[i] = ComponentsService2.getWeightsToCharges().get(CalculationProperties.weights.get(i));
			CalculationProperties.mins[i] = CalculationProperties.symbolsToRanges.get(CalculationProperties.symbols[i]).getMin();
			CalculationProperties.maxes[i] = CalculationProperties.symbolsToRanges.get(CalculationProperties.symbols[i]).getMax();
		}
    }
    
	public static List<String> getWeights() {
		return weights;
	}

	public static double getTargetSum() {
		return targetSum;
	}

	public static int getRange() {
		return range;
	}

	public static int getCharge() {
		return charge;
	}

	public static HashMap<String, ComponentRange> getSymbolsToRanges() {
		return symbolsToRanges;
	}

	public static ArrayList<String> getSolutionsList() {
		return solutionsList;
	}

	public static double[] getDoubleWeights() {
		return doubleWeights;
	}

	public static String[] getSymbols() {
		return symbols;
	}

	public static int[] getCharges() {
		return charges;
	}

	public static double[] getMins() {
		return mins;
	}

	public static double[] getMaxes() {
		return maxes;
	}
}
