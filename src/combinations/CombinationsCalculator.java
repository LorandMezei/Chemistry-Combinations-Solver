package combinations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import calculationAlgorithms.FastestIteration;
import setupHelpers.ComponentRange;
import setupHelpers.ComponentsService2;

public class CombinationsCalculator {
	
	private static HashMap<String, ComponentRange> SYMBOLS_TO_RANGES = new HashMap<>();
	private static final int SYMBOL_TABLE_INDEX = 0;
	private static final int USE_TABLE_INDEX = 3;
	private static final int SORT_TABLE_INDEX = 4;
	private static final int FORCE_TABLE_INDEX = 5;
	private static final int MIN_TABLE_INDEX = 6;
	private static final int MAX_TABLE_INDEX = 7;
	
	private static String COMPONENT_TO_SORT = "";
	private static List<String> COMPONENTS_TO_FORCE = new ArrayList<>();
	
	public static ArrayList<ArrayList<String>> calculate() {
		final List<String> weights = loadComponents();
		return startCalculations(weights);
	}
	
	private static ArrayList<ArrayList<String>> startCalculations(final List<String> weights) {
		if (weights.size() > 0) {
			if (Frame.getTargetTextField() != null 
						&& Frame.getTargetTextField().getText() != null
						&& !"".equals(Frame.getTargetTextField().getText())) {
				
				final double targetSum = Double.parseDouble(Frame.getTargetTextField().getText().trim());
						
				Collections.sort(weights, new Comparator<String>() {
				    @Override
				    public int compare(String s1,
				    		           String s2) {
				    	final double min1 = SYMBOLS_TO_RANGES.get(ComponentsService2.getWeightsToSymbols().get(s1)).getMin();
				    	final double max1 = SYMBOLS_TO_RANGES.get(ComponentsService2.getWeightsToSymbols().get(s1)).getMax();
				    	final double s1Range = max1 - min1 + 1;
				    	
				    	final double min2 = SYMBOLS_TO_RANGES.get(ComponentsService2.getWeightsToSymbols().get(s2)).getMin();
				    	final double max2 = SYMBOLS_TO_RANGES.get(ComponentsService2.getWeightsToSymbols().get(s2)).getMax();
				    	final double s2Range = max2 - min2 + 1;
				    	
				    	return Double.compare(s2Range, s1Range);
				    }
				});
				
				if (Frame.getRangeTextField() != null 
						&& Frame.getRangeTextField().getText() != null 
						&& !"".equals(Frame.getRangeTextField().getText())
						&& Frame.getChargeTextField().getText() != null 
						&& !"".equals(Frame.getChargeTextField().getText())) {
					
					return findSolutions(weights, targetSum);
		
//					final int range = Integer.parseInt(this.rangeTextField.getText().trim()); // <------------------------
//					final int charge = Integer.parseInt(this.chargeTextField.getText().trim());
//					
//					final double firstWeightMin = this.symbolsToRanges.get(ComponentsService2.getWeightsToSymbols().get(weights.get(0))).getMin();
//					final double firstWeightMax = this.symbolsToRanges.get(ComponentsService2.getWeightsToSymbols().get(weights.get(0))).getMax();
//					
//					final ArrayList<String> solutionsList = new ArrayList<>();
//					CalculationProperties.loadProperties(weights, targetSum, range, charge, this.symbolsToRanges, solutionsList);
//					for (double a = firstWeightMin; a <= firstWeightMax; a++) {
//						final ThreadIteration1 iteration = new ThreadIteration1(a);
//						
//						final Thread thread = new Thread(iteration);
//						thread.start();
//						try {
//							thread.join();
//						} catch (InterruptedException e) {
//							e.printStackTrace();
//						}
//					}
//					
//					System.out.println("Num sol:" + CalculationProperties.getSolutionsList().size()); // <------------------------
				}
			}
		}
		return null;
	}
	
	private static ArrayList<ArrayList<String>> findSolutions(final List<String> weights, 
												       final double targetSum) {
		final int range = Integer.parseInt(Frame.getRangeTextField().getText().trim()); 
		final int charge = Integer.parseInt(Frame.getChargeTextField().getText().trim());
		
		final ArrayList<ArrayList<String>> listOfSolutionsList = new ArrayList<>();
				
		final double firstWeightMin = SYMBOLS_TO_RANGES.get(ComponentsService2.getWeightsToSymbols().get(weights.get(0))).getMin();
		final double firstWeightMax = SYMBOLS_TO_RANGES.get(ComponentsService2.getWeightsToSymbols().get(weights.get(0))).getMax();
		
		int i = 0;
		final List<Thread> threads = new ArrayList<Thread>();	
		for (double a = firstWeightMin; a <= firstWeightMax; a++) {
			final ArrayList<String> solutionsList = new ArrayList<>();
			listOfSolutionsList.add(solutionsList);
			
			final FastestIteration iteration = new FastestIteration(
					a, weights, targetSum, range, charge, SYMBOLS_TO_RANGES, solutionsList);
			
			final Thread thread = new Thread(iteration);
			thread.start();
			threads.add(thread);
			
			System.out.println("Starting thread : " + i);
			i++;
		}
		
		for (final Thread t : threads) {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		return listOfSolutionsList;
	}
	
	private static List<String> loadComponents() {
		final List<String> weights = new ArrayList<>();
		for (int i = 0; i < Frame.getComponentsTable().getRowCount(); i++) {
			final String symbol = Frame.getComponentsTable().getValueAt(i, SYMBOL_TABLE_INDEX).toString();
			final String weight = ComponentsService2.getSymbolsToWeights().get(symbol).toString();
			final Boolean useSelected = Boolean.valueOf(Frame.getComponentsTable().getValueAt(i, USE_TABLE_INDEX).toString());
			final Boolean sortSelected = Boolean.valueOf(Frame.getComponentsTable().getValueAt(i, SORT_TABLE_INDEX).toString());
			final Boolean forceSelected = Boolean.valueOf(Frame.getComponentsTable().getValueAt(i, FORCE_TABLE_INDEX).toString());
			final int min = Integer.parseInt(Frame.getComponentsTable().getValueAt(i, MIN_TABLE_INDEX).toString().trim());
			final int max = Integer.parseInt(Frame.getComponentsTable().getValueAt(i, MAX_TABLE_INDEX).toString().trim());
			
			if (useSelected) {
				weights.add(weight);
			}
			
			if (sortSelected) {
				COMPONENT_TO_SORT = symbol;
			}
			
			if (forceSelected) {
				COMPONENTS_TO_FORCE.add(symbol);
			}
			
			final ComponentRange cr = new ComponentRange(min, max);
			SYMBOLS_TO_RANGES.put(symbol, cr);
		}
		
		return weights;
	}
	
	public static String getCOMPONENT_TO_SORT() {
		return COMPONENT_TO_SORT;
	}
}
