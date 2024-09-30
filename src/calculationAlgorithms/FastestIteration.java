package calculationAlgorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import setupHelpers.ComponentRange;
import setupHelpers.ComponentsService2;

public class FastestIteration extends Thread {
	private final double a;
	private final List<String> weights; 
    private final double targetSum;
    private final int range;
    private final int charge;
    private final HashMap<String, ComponentRange> symbolsToRanges;
    private final ArrayList<String> solutionsList;
    
    private String stringWeight0;
	private String stringWeight1;
	private String stringWeight2;
	private String stringWeight3;
	private String stringWeight4;
	private String stringWeight5;
	private String stringWeight6;
	private String stringWeight7;
	private String stringWeight8;
	private String stringWeight9;
	private String stringWeight10;
	private String stringWeight11;
	private String stringWeight12;
	private String stringWeight13;
	private String stringWeight14;
	
	private double weight0;
	private double weight1;
	private double weight2;
	private double weight3;
	private double weight4;
	private double weight5;
	private double weight6;
	private double weight7;
	private double weight8;
	private double weight9;
	private double weight10;
	private double weight11;
	private double weight12;
	private double weight13;
	private double weight14;
	
	private String symbol0;
	private String symbol1;
	private String symbol2;
	private String symbol3;
	private String symbol4;
	private String symbol5;
	private String symbol6;
	private String symbol7;
	private String symbol8;
	private String symbol9;
	private String symbol10;
	private String symbol11;
	private String symbol12;
	private String symbol13;
	private String symbol14;
	
	private int charge0;
	private int charge1;
	private int charge2;
	private int charge3;
	private int charge4;
	private int charge5;
	private int charge6;
	private int charge7;
	private int charge8;
	private int charge9;
	private int charge10;
	private int charge11;
	private int charge12;
	private int charge13;
	private int charge14;
	
	private double bMin;
	private double bMax;
	
	private double cMin;
	private double cMax;
	
	private double dMin;
	private double dMax;
	
	private double eMin;
	private double eMax;
	
	private double fMin;
	private double fMax;
	
	private double gMin;
	private double gMax;
	
	private double hMin;
	private double hMax;
	
	private double iMin;
	private double iMax;
	
	private double jMin;
	private double jMax;
	
	private double kMin;
	private double kMax;
	
	private double lMin;
	private double lMax;
	
	private double mMin;
	private double mMax;
	
	private double nMin;
	private double nMax;
	
	private double oMin;
	private double oMax;
    
    public FastestIteration(  
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
    }
	         
	@Override
	public void run() {
		this.findCombinations();
	}
	
	private void findCombinations() {
		if (weights.size() == 0) {
			return;
			
		} else if (weights.size() == 1) {
			stringWeight0 = weights.get(0);
			weight0 = Double.parseDouble(stringWeight0);
			symbol0 = ComponentsService2.getWeightsToSymbols().get(stringWeight0);
			charge0 = ComponentsService2.getWeightsToCharges().get(stringWeight0);
			
			this.findCombinations1Weight();
			
		} else if (weights.size() == 2) {
			stringWeight0 = weights.get(0);
			weight0 = Double.parseDouble(stringWeight0);
			symbol0 = ComponentsService2.getWeightsToSymbols().get(stringWeight0);
			charge0 = ComponentsService2.getWeightsToCharges().get(stringWeight0);
			
			stringWeight1 = weights.get(1);
			weight1 = Double.parseDouble(stringWeight1);
			symbol1 = ComponentsService2.getWeightsToSymbols().get(stringWeight1);
			charge1 = ComponentsService2.getWeightsToCharges().get(stringWeight1);
			bMin = symbolsToRanges.get(symbol1).getMin();
    		bMax = symbolsToRanges.get(symbol1).getMax();
    		
			this.findCombinations2Weights();
			
		} else if (weights.size() == 3) {
			stringWeight0 = weights.get(0);
			weight0 = Double.parseDouble(stringWeight0);
			symbol0 = ComponentsService2.getWeightsToSymbols().get(stringWeight0);
			charge0 = ComponentsService2.getWeightsToCharges().get(stringWeight0);
			
			stringWeight1 = weights.get(1);
			weight1 = Double.parseDouble(stringWeight1);
			symbol1 = ComponentsService2.getWeightsToSymbols().get(stringWeight1);
			charge1 = ComponentsService2.getWeightsToCharges().get(stringWeight1);
			bMin = symbolsToRanges.get(symbol1).getMin();
    		bMax = symbolsToRanges.get(symbol1).getMax();
    		
			stringWeight2 = weights.get(2);
			weight2 = Double.parseDouble(stringWeight2);
			symbol2 = ComponentsService2.getWeightsToSymbols().get(stringWeight2);
			charge2 = ComponentsService2.getWeightsToCharges().get(stringWeight2);
			cMin = symbolsToRanges.get(symbol2).getMin();
    		cMax = symbolsToRanges.get(symbol2).getMax();
    		
			this.findCombinations3Weights();
			
		} else if (weights.size() == 4) {
			stringWeight0 = weights.get(0);
			weight0 = Double.parseDouble(stringWeight0);
			symbol0 = ComponentsService2.getWeightsToSymbols().get(stringWeight0);
			charge0 = ComponentsService2.getWeightsToCharges().get(stringWeight0);
			
			stringWeight1 = weights.get(1);
			weight1 = Double.parseDouble(stringWeight1);
			symbol1 = ComponentsService2.getWeightsToSymbols().get(stringWeight1);
			charge1 = ComponentsService2.getWeightsToCharges().get(stringWeight1);
			bMin = symbolsToRanges.get(symbol1).getMin();
    		bMax = symbolsToRanges.get(symbol1).getMax();
    		
			stringWeight2 = weights.get(2);
			weight2 = Double.parseDouble(stringWeight2);
			symbol2 = ComponentsService2.getWeightsToSymbols().get(stringWeight2);
			charge2 = ComponentsService2.getWeightsToCharges().get(stringWeight2);
			cMin = symbolsToRanges.get(symbol2).getMin();
    		cMax = symbolsToRanges.get(symbol2).getMax();
    		
			stringWeight3 = weights.get(3);
			weight3 = Double.parseDouble(stringWeight3);
			symbol3 = ComponentsService2.getWeightsToSymbols().get(stringWeight3);
			charge3 = ComponentsService2.getWeightsToCharges().get(stringWeight3);
			dMin = symbolsToRanges.get(symbol3).getMin();
    		dMax = symbolsToRanges.get(symbol3).getMax();
    		
			this.findCombinations4Weights();
			
		} else if (weights.size() == 5) {
			stringWeight0 = weights.get(0);
			weight0 = Double.parseDouble(stringWeight0);
			symbol0 = ComponentsService2.getWeightsToSymbols().get(stringWeight0);
			charge0 = ComponentsService2.getWeightsToCharges().get(stringWeight0);
			
			stringWeight1 = weights.get(1);
			weight1 = Double.parseDouble(stringWeight1);
			symbol1 = ComponentsService2.getWeightsToSymbols().get(stringWeight1);
			charge1 = ComponentsService2.getWeightsToCharges().get(stringWeight1);
			bMin = symbolsToRanges.get(symbol1).getMin();
    		bMax = symbolsToRanges.get(symbol1).getMax();
    		
			stringWeight2 = weights.get(2);
			weight2 = Double.parseDouble(stringWeight2);
			symbol2 = ComponentsService2.getWeightsToSymbols().get(stringWeight2);
			charge2 = ComponentsService2.getWeightsToCharges().get(stringWeight2);
			cMin = symbolsToRanges.get(symbol2).getMin();
    		cMax = symbolsToRanges.get(symbol2).getMax();
    		
			stringWeight3 = weights.get(3);
			weight3 = Double.parseDouble(stringWeight3);
			symbol3 = ComponentsService2.getWeightsToSymbols().get(stringWeight3);
			charge3 = ComponentsService2.getWeightsToCharges().get(stringWeight3);
			dMin = symbolsToRanges.get(symbol3).getMin();
    		dMax = symbolsToRanges.get(symbol3).getMax();
    		
			stringWeight4 = weights.get(4);
			weight4 = Double.parseDouble(stringWeight4);
			symbol4 = ComponentsService2.getWeightsToSymbols().get(stringWeight4);
			charge4 = ComponentsService2.getWeightsToCharges().get(stringWeight4);
			eMin = symbolsToRanges.get(symbol4).getMin();
    		eMax = symbolsToRanges.get(symbol4).getMax();
    		
			this.findCombinations5Weights();
			
		} else if (weights.size() == 6) {
			stringWeight0 = weights.get(0);
			weight0 = Double.parseDouble(stringWeight0);
			symbol0 = ComponentsService2.getWeightsToSymbols().get(stringWeight0);
			charge0 = ComponentsService2.getWeightsToCharges().get(stringWeight0);
			
			stringWeight1 = weights.get(1);
			weight1 = Double.parseDouble(stringWeight1);
			symbol1 = ComponentsService2.getWeightsToSymbols().get(stringWeight1);
			charge1 = ComponentsService2.getWeightsToCharges().get(stringWeight1);
			bMin = symbolsToRanges.get(symbol1).getMin();
    		bMax = symbolsToRanges.get(symbol1).getMax();
    		
			stringWeight2 = weights.get(2);
			weight2 = Double.parseDouble(stringWeight2);
			symbol2 = ComponentsService2.getWeightsToSymbols().get(stringWeight2);
			charge2 = ComponentsService2.getWeightsToCharges().get(stringWeight2);
			cMin = symbolsToRanges.get(symbol2).getMin();
    		cMax = symbolsToRanges.get(symbol2).getMax();
    		
			stringWeight3 = weights.get(3);
			weight3 = Double.parseDouble(stringWeight3);
			symbol3 = ComponentsService2.getWeightsToSymbols().get(stringWeight3);
			charge3 = ComponentsService2.getWeightsToCharges().get(stringWeight3);
			dMin = symbolsToRanges.get(symbol3).getMin();
    		dMax = symbolsToRanges.get(symbol3).getMax();
    		
			stringWeight4 = weights.get(4);
			weight4 = Double.parseDouble(stringWeight4);
			symbol4 = ComponentsService2.getWeightsToSymbols().get(stringWeight4);
			charge4 = ComponentsService2.getWeightsToCharges().get(stringWeight4);
			eMin = symbolsToRanges.get(symbol4).getMin();
    		eMax = symbolsToRanges.get(symbol4).getMax();
    		
			stringWeight5 = weights.get(5);
			weight5 = Double.parseDouble(stringWeight5);
			symbol5 = ComponentsService2.getWeightsToSymbols().get(stringWeight5);
			charge5 = ComponentsService2.getWeightsToCharges().get(stringWeight5);
			fMin = symbolsToRanges.get(symbol5).getMin();
    		fMax = symbolsToRanges.get(symbol5).getMax();
    		
			this.findCombinations6Weights();
			
		} else if (weights.size() == 7) {
			stringWeight0 = weights.get(0);
			weight0 = Double.parseDouble(stringWeight0);
			symbol0 = ComponentsService2.getWeightsToSymbols().get(stringWeight0);
			charge0 = ComponentsService2.getWeightsToCharges().get(stringWeight0);
			
			stringWeight1 = weights.get(1);
			weight1 = Double.parseDouble(stringWeight1);
			symbol1 = ComponentsService2.getWeightsToSymbols().get(stringWeight1);
			charge1 = ComponentsService2.getWeightsToCharges().get(stringWeight1);
			bMin = symbolsToRanges.get(symbol1).getMin();
    		bMax = symbolsToRanges.get(symbol1).getMax();
    		
			stringWeight2 = weights.get(2);
			weight2 = Double.parseDouble(stringWeight2);
			symbol2 = ComponentsService2.getWeightsToSymbols().get(stringWeight2);
			charge2 = ComponentsService2.getWeightsToCharges().get(stringWeight2);
			cMin = symbolsToRanges.get(symbol2).getMin();
    		cMax = symbolsToRanges.get(symbol2).getMax();
    		
			stringWeight3 = weights.get(3);
			weight3 = Double.parseDouble(stringWeight3);
			symbol3 = ComponentsService2.getWeightsToSymbols().get(stringWeight3);
			charge3 = ComponentsService2.getWeightsToCharges().get(stringWeight3);
			dMin = symbolsToRanges.get(symbol3).getMin();
    		dMax = symbolsToRanges.get(symbol3).getMax();
    		
			stringWeight4 = weights.get(4);
			weight4 = Double.parseDouble(stringWeight4);
			symbol4 = ComponentsService2.getWeightsToSymbols().get(stringWeight4);
			charge4 = ComponentsService2.getWeightsToCharges().get(stringWeight4);
			eMin = symbolsToRanges.get(symbol4).getMin();
    		eMax = symbolsToRanges.get(symbol4).getMax();
    		
			stringWeight5 = weights.get(5);
			weight5 = Double.parseDouble(stringWeight5);
			symbol5 = ComponentsService2.getWeightsToSymbols().get(stringWeight5);
			charge5 = ComponentsService2.getWeightsToCharges().get(stringWeight5);
			fMin = symbolsToRanges.get(symbol5).getMin();
    		fMax = symbolsToRanges.get(symbol5).getMax();
    		
			stringWeight6 = weights.get(6);
			weight6 = Double.parseDouble(stringWeight6);
			symbol6 = ComponentsService2.getWeightsToSymbols().get(stringWeight6);
			charge6 = ComponentsService2.getWeightsToCharges().get(stringWeight6);
			gMin = symbolsToRanges.get(symbol6).getMin();
    		gMax = symbolsToRanges.get(symbol6).getMax();
    		
			this.findCombinations7Weights();
			
		} else if (weights.size() == 8) {
			stringWeight0 = weights.get(0);
			weight0 = Double.parseDouble(stringWeight0);
			symbol0 = ComponentsService2.getWeightsToSymbols().get(stringWeight0);
			charge0 = ComponentsService2.getWeightsToCharges().get(stringWeight0);
			
			stringWeight1 = weights.get(1);
			weight1 = Double.parseDouble(stringWeight1);
			symbol1 = ComponentsService2.getWeightsToSymbols().get(stringWeight1);
			charge1 = ComponentsService2.getWeightsToCharges().get(stringWeight1);
			bMin = symbolsToRanges.get(symbol1).getMin();
    		bMax = symbolsToRanges.get(symbol1).getMax();
    		
			stringWeight2 = weights.get(2);
			weight2 = Double.parseDouble(stringWeight2);
			symbol2 = ComponentsService2.getWeightsToSymbols().get(stringWeight2);
			charge2 = ComponentsService2.getWeightsToCharges().get(stringWeight2);
			cMin = symbolsToRanges.get(symbol2).getMin();
    		cMax = symbolsToRanges.get(symbol2).getMax();
    		
			stringWeight3 = weights.get(3);
			weight3 = Double.parseDouble(stringWeight3);
			symbol3 = ComponentsService2.getWeightsToSymbols().get(stringWeight3);
			charge3 = ComponentsService2.getWeightsToCharges().get(stringWeight3);
			dMin = symbolsToRanges.get(symbol3).getMin();
    		dMax = symbolsToRanges.get(symbol3).getMax();
    		
			stringWeight4 = weights.get(4);
			weight4 = Double.parseDouble(stringWeight4);
			symbol4 = ComponentsService2.getWeightsToSymbols().get(stringWeight4);
			charge4 = ComponentsService2.getWeightsToCharges().get(stringWeight4);
			eMin = symbolsToRanges.get(symbol4).getMin();
    		eMax = symbolsToRanges.get(symbol4).getMax();
    		
			stringWeight5 = weights.get(5);
			weight5 = Double.parseDouble(stringWeight5);
			symbol5 = ComponentsService2.getWeightsToSymbols().get(stringWeight5);
			charge5 = ComponentsService2.getWeightsToCharges().get(stringWeight5);
			fMin = symbolsToRanges.get(symbol5).getMin();
    		fMax = symbolsToRanges.get(symbol5).getMax();
    		
			stringWeight6 = weights.get(6);
			weight6 = Double.parseDouble(stringWeight6);
			symbol6 = ComponentsService2.getWeightsToSymbols().get(stringWeight6);
			charge6 = ComponentsService2.getWeightsToCharges().get(stringWeight6);
			gMin = symbolsToRanges.get(symbol6).getMin();
    		gMax = symbolsToRanges.get(symbol6).getMax();
    		
			stringWeight7 = weights.get(7);
			weight7 = Double.parseDouble(stringWeight7);
			symbol7 = ComponentsService2.getWeightsToSymbols().get(stringWeight7);
			charge7 = ComponentsService2.getWeightsToCharges().get(stringWeight7);
			hMin = symbolsToRanges.get(symbol7).getMin();
    		hMax = symbolsToRanges.get(symbol7).getMax();
    		
			this.findCombinations8Weights();
			
		} else if (weights.size() == 9) {
			stringWeight0 = weights.get(0);
			weight0 = Double.parseDouble(stringWeight0);
			symbol0 = ComponentsService2.getWeightsToSymbols().get(stringWeight0);
			charge0 = ComponentsService2.getWeightsToCharges().get(stringWeight0);
			
			stringWeight1 = weights.get(1);
			weight1 = Double.parseDouble(stringWeight1);
			symbol1 = ComponentsService2.getWeightsToSymbols().get(stringWeight1);
			charge1 = ComponentsService2.getWeightsToCharges().get(stringWeight1);
			bMin = symbolsToRanges.get(symbol1).getMin();
    		bMax = symbolsToRanges.get(symbol1).getMax();
    		
			stringWeight2 = weights.get(2);
			weight2 = Double.parseDouble(stringWeight2);
			symbol2 = ComponentsService2.getWeightsToSymbols().get(stringWeight2);
			charge2 = ComponentsService2.getWeightsToCharges().get(stringWeight2);
			cMin = symbolsToRanges.get(symbol2).getMin();
    		cMax = symbolsToRanges.get(symbol2).getMax();
    		
			stringWeight3 = weights.get(3);
			weight3 = Double.parseDouble(stringWeight3);
			symbol3 = ComponentsService2.getWeightsToSymbols().get(stringWeight3);
			charge3 = ComponentsService2.getWeightsToCharges().get(stringWeight3);
			dMin = symbolsToRanges.get(symbol3).getMin();
    		dMax = symbolsToRanges.get(symbol3).getMax();
    		
			stringWeight4 = weights.get(4);
			weight4 = Double.parseDouble(stringWeight4);
			symbol4 = ComponentsService2.getWeightsToSymbols().get(stringWeight4);
			charge4 = ComponentsService2.getWeightsToCharges().get(stringWeight4);
			eMin = symbolsToRanges.get(symbol4).getMin();
    		eMax = symbolsToRanges.get(symbol4).getMax();
    		
			stringWeight5 = weights.get(5);
			weight5 = Double.parseDouble(stringWeight5);
			symbol5 = ComponentsService2.getWeightsToSymbols().get(stringWeight5);
			charge5 = ComponentsService2.getWeightsToCharges().get(stringWeight5);
			fMin = symbolsToRanges.get(symbol5).getMin();
    		fMax = symbolsToRanges.get(symbol5).getMax();
    		
			stringWeight6 = weights.get(6);
			weight6 = Double.parseDouble(stringWeight6);
			symbol6 = ComponentsService2.getWeightsToSymbols().get(stringWeight6);
			charge6 = ComponentsService2.getWeightsToCharges().get(stringWeight6);
			gMin = symbolsToRanges.get(symbol6).getMin();
    		gMax = symbolsToRanges.get(symbol6).getMax();
    		
			stringWeight7 = weights.get(7);
			weight7 = Double.parseDouble(stringWeight7);
			symbol7 = ComponentsService2.getWeightsToSymbols().get(stringWeight7);
			charge7 = ComponentsService2.getWeightsToCharges().get(stringWeight7);
			hMin = symbolsToRanges.get(symbol7).getMin();
    		hMax = symbolsToRanges.get(symbol7).getMax();
    		
			stringWeight8 = weights.get(8);
			weight8 = Double.parseDouble(stringWeight8);
			symbol8 = ComponentsService2.getWeightsToSymbols().get(stringWeight8);
			charge8 = ComponentsService2.getWeightsToCharges().get(stringWeight8);
			iMin = symbolsToRanges.get(symbol8).getMin();
    		iMax = symbolsToRanges.get(symbol8).getMax();
    		
			this.findCombinations9Weights();
			
		} else if (weights.size() == 10) {
			stringWeight0 = weights.get(0);
			weight0 = Double.parseDouble(stringWeight0);
			symbol0 = ComponentsService2.getWeightsToSymbols().get(stringWeight0);
			charge0 = ComponentsService2.getWeightsToCharges().get(stringWeight0);
			
			stringWeight1 = weights.get(1);
			weight1 = Double.parseDouble(stringWeight1);
			symbol1 = ComponentsService2.getWeightsToSymbols().get(stringWeight1);
			charge1 = ComponentsService2.getWeightsToCharges().get(stringWeight1);
			bMin = symbolsToRanges.get(symbol1).getMin();
    		bMax = symbolsToRanges.get(symbol1).getMax();
    		
			stringWeight2 = weights.get(2);
			weight2 = Double.parseDouble(stringWeight2);
			symbol2 = ComponentsService2.getWeightsToSymbols().get(stringWeight2);
			charge2 = ComponentsService2.getWeightsToCharges().get(stringWeight2);
			cMin = symbolsToRanges.get(symbol2).getMin();
    		cMax = symbolsToRanges.get(symbol2).getMax();
    		
			stringWeight3 = weights.get(3);
			weight3 = Double.parseDouble(stringWeight3);
			symbol3 = ComponentsService2.getWeightsToSymbols().get(stringWeight3);
			charge3 = ComponentsService2.getWeightsToCharges().get(stringWeight3);
			dMin = symbolsToRanges.get(symbol3).getMin();
    		dMax = symbolsToRanges.get(symbol3).getMax();
    		
			stringWeight4 = weights.get(4);
			weight4 = Double.parseDouble(stringWeight4);
			symbol4 = ComponentsService2.getWeightsToSymbols().get(stringWeight4);
			charge4 = ComponentsService2.getWeightsToCharges().get(stringWeight4);
			eMin = symbolsToRanges.get(symbol4).getMin();
    		eMax = symbolsToRanges.get(symbol4).getMax();
    		
			stringWeight5 = weights.get(5);
			weight5 = Double.parseDouble(stringWeight5);
			symbol5 = ComponentsService2.getWeightsToSymbols().get(stringWeight5);
			charge5 = ComponentsService2.getWeightsToCharges().get(stringWeight5);
			fMin = symbolsToRanges.get(symbol5).getMin();
    		fMax = symbolsToRanges.get(symbol5).getMax();
    		
			stringWeight6 = weights.get(6);
			weight6 = Double.parseDouble(stringWeight6);
			symbol6 = ComponentsService2.getWeightsToSymbols().get(stringWeight6);
			charge6 = ComponentsService2.getWeightsToCharges().get(stringWeight6);
			gMin = symbolsToRanges.get(symbol6).getMin();
    		gMax = symbolsToRanges.get(symbol6).getMax();
    		
			stringWeight7 = weights.get(7);
			weight7 = Double.parseDouble(stringWeight7);
			symbol7 = ComponentsService2.getWeightsToSymbols().get(stringWeight7);
			charge7 = ComponentsService2.getWeightsToCharges().get(stringWeight7);
			hMin = symbolsToRanges.get(symbol7).getMin();
    		hMax = symbolsToRanges.get(symbol7).getMax();
    		
			stringWeight8 = weights.get(8);
			weight8 = Double.parseDouble(stringWeight8);
			symbol8 = ComponentsService2.getWeightsToSymbols().get(stringWeight8);
			charge8 = ComponentsService2.getWeightsToCharges().get(stringWeight8);
			iMin = symbolsToRanges.get(symbol8).getMin();
    		iMax = symbolsToRanges.get(symbol8).getMax();
    		
			stringWeight9 = weights.get(9);
			weight9 = Double.parseDouble(stringWeight9);
			symbol9 = ComponentsService2.getWeightsToSymbols().get(stringWeight9);
			charge9 = ComponentsService2.getWeightsToCharges().get(stringWeight9);
			jMin = symbolsToRanges.get(symbol9).getMin();
    		jMax = symbolsToRanges.get(symbol9).getMax();
    		
			this.findCombinations10Weights();
			
		} else if (weights.size() == 11) {
			stringWeight0 = weights.get(0);
			weight0 = Double.parseDouble(stringWeight0);
			symbol0 = ComponentsService2.getWeightsToSymbols().get(stringWeight0);
			charge0 = ComponentsService2.getWeightsToCharges().get(stringWeight0);
			
			stringWeight1 = weights.get(1);
			weight1 = Double.parseDouble(stringWeight1);
			symbol1 = ComponentsService2.getWeightsToSymbols().get(stringWeight1);
			charge1 = ComponentsService2.getWeightsToCharges().get(stringWeight1);
			bMin = symbolsToRanges.get(symbol1).getMin();
    		bMax = symbolsToRanges.get(symbol1).getMax();
    		
			stringWeight2 = weights.get(2);
			weight2 = Double.parseDouble(stringWeight2);
			symbol2 = ComponentsService2.getWeightsToSymbols().get(stringWeight2);
			charge2 = ComponentsService2.getWeightsToCharges().get(stringWeight2);
			cMin = symbolsToRanges.get(symbol2).getMin();
    		cMax = symbolsToRanges.get(symbol2).getMax();
    		
			stringWeight3 = weights.get(3);
			weight3 = Double.parseDouble(stringWeight3);
			symbol3 = ComponentsService2.getWeightsToSymbols().get(stringWeight3);
			charge3 = ComponentsService2.getWeightsToCharges().get(stringWeight3);
			dMin = symbolsToRanges.get(symbol3).getMin();
    		dMax = symbolsToRanges.get(symbol3).getMax();
    		
			stringWeight4 = weights.get(4);
			weight4 = Double.parseDouble(stringWeight4);
			symbol4 = ComponentsService2.getWeightsToSymbols().get(stringWeight4);
			charge4 = ComponentsService2.getWeightsToCharges().get(stringWeight4);
			eMin = symbolsToRanges.get(symbol4).getMin();
    		eMax = symbolsToRanges.get(symbol4).getMax();
    		
			stringWeight5 = weights.get(5);
			weight5 = Double.parseDouble(stringWeight5);
			symbol5 = ComponentsService2.getWeightsToSymbols().get(stringWeight5);
			charge5 = ComponentsService2.getWeightsToCharges().get(stringWeight5);
			fMin = symbolsToRanges.get(symbol5).getMin();
    		fMax = symbolsToRanges.get(symbol5).getMax();
    		
			stringWeight6 = weights.get(6);
			weight6 = Double.parseDouble(stringWeight6);
			symbol6 = ComponentsService2.getWeightsToSymbols().get(stringWeight6);
			charge6 = ComponentsService2.getWeightsToCharges().get(stringWeight6);
			gMin = symbolsToRanges.get(symbol6).getMin();
    		gMax = symbolsToRanges.get(symbol6).getMax();
    		
			stringWeight7 = weights.get(7);
			weight7 = Double.parseDouble(stringWeight7);
			symbol7 = ComponentsService2.getWeightsToSymbols().get(stringWeight7);
			charge7 = ComponentsService2.getWeightsToCharges().get(stringWeight7);
			hMin = symbolsToRanges.get(symbol7).getMin();
    		hMax = symbolsToRanges.get(symbol7).getMax();
    		
			stringWeight8 = weights.get(8);
			weight8 = Double.parseDouble(stringWeight8);
			symbol8 = ComponentsService2.getWeightsToSymbols().get(stringWeight8);
			charge8 = ComponentsService2.getWeightsToCharges().get(stringWeight8);
			iMin = symbolsToRanges.get(symbol8).getMin();
    		iMax = symbolsToRanges.get(symbol8).getMax();
    		
			stringWeight9 = weights.get(9);
			weight9 = Double.parseDouble(stringWeight9);
			symbol9 = ComponentsService2.getWeightsToSymbols().get(stringWeight9);
			charge9 = ComponentsService2.getWeightsToCharges().get(stringWeight9);
			jMin = symbolsToRanges.get(symbol9).getMin();
    		jMax = symbolsToRanges.get(symbol9).getMax();
    		
			stringWeight10 = weights.get(10);
			weight10 = Double.parseDouble(stringWeight10);
			symbol10 = ComponentsService2.getWeightsToSymbols().get(stringWeight10);
			charge10 = ComponentsService2.getWeightsToCharges().get(stringWeight10);
			kMin = symbolsToRanges.get(symbol10).getMin();
    		kMax = symbolsToRanges.get(symbol10).getMax();
    		
			this.findCombinations11Weights();
			
		} else if (weights.size() == 12) {
			stringWeight0 = weights.get(0);
			weight0 = Double.parseDouble(stringWeight0);
			symbol0 = ComponentsService2.getWeightsToSymbols().get(stringWeight0);
			charge0 = ComponentsService2.getWeightsToCharges().get(stringWeight0);
			
			stringWeight1 = weights.get(1);
			weight1 = Double.parseDouble(stringWeight1);
			symbol1 = ComponentsService2.getWeightsToSymbols().get(stringWeight1);
			charge1 = ComponentsService2.getWeightsToCharges().get(stringWeight1);
			bMin = symbolsToRanges.get(symbol1).getMin();
    		bMax = symbolsToRanges.get(symbol1).getMax();
    		
			stringWeight2 = weights.get(2);
			weight2 = Double.parseDouble(stringWeight2);
			symbol2 = ComponentsService2.getWeightsToSymbols().get(stringWeight2);
			charge2 = ComponentsService2.getWeightsToCharges().get(stringWeight2);
			cMin = symbolsToRanges.get(symbol2).getMin();
    		cMax = symbolsToRanges.get(symbol2).getMax();
    		
			stringWeight3 = weights.get(3);
			weight3 = Double.parseDouble(stringWeight3);
			symbol3 = ComponentsService2.getWeightsToSymbols().get(stringWeight3);
			charge3 = ComponentsService2.getWeightsToCharges().get(stringWeight3);
			dMin = symbolsToRanges.get(symbol3).getMin();
    		dMax = symbolsToRanges.get(symbol3).getMax();
    		
			stringWeight4 = weights.get(4);
			weight4 = Double.parseDouble(stringWeight4);
			symbol4 = ComponentsService2.getWeightsToSymbols().get(stringWeight4);
			charge4 = ComponentsService2.getWeightsToCharges().get(stringWeight4);
			eMin = symbolsToRanges.get(symbol4).getMin();
    		eMax = symbolsToRanges.get(symbol4).getMax();
    		
			stringWeight5 = weights.get(5);
			weight5 = Double.parseDouble(stringWeight5);
			symbol5 = ComponentsService2.getWeightsToSymbols().get(stringWeight5);
			charge5 = ComponentsService2.getWeightsToCharges().get(stringWeight5);
			fMin = symbolsToRanges.get(symbol5).getMin();
    		fMax = symbolsToRanges.get(symbol5).getMax();
    		
			stringWeight6 = weights.get(6);
			weight6 = Double.parseDouble(stringWeight6);
			symbol6 = ComponentsService2.getWeightsToSymbols().get(stringWeight6);
			charge6 = ComponentsService2.getWeightsToCharges().get(stringWeight6);
			gMin = symbolsToRanges.get(symbol6).getMin();
    		gMax = symbolsToRanges.get(symbol6).getMax();
    		
			stringWeight7 = weights.get(7);
			weight7 = Double.parseDouble(stringWeight7);
			symbol7 = ComponentsService2.getWeightsToSymbols().get(stringWeight7);
			charge7 = ComponentsService2.getWeightsToCharges().get(stringWeight7);
			hMin = symbolsToRanges.get(symbol7).getMin();
    		hMax = symbolsToRanges.get(symbol7).getMax();
    		
			stringWeight8 = weights.get(8);
			weight8 = Double.parseDouble(stringWeight8);
			symbol8 = ComponentsService2.getWeightsToSymbols().get(stringWeight8);
			charge8 = ComponentsService2.getWeightsToCharges().get(stringWeight8);
			iMin = symbolsToRanges.get(symbol8).getMin();
    		iMax = symbolsToRanges.get(symbol8).getMax();
    		
			stringWeight9 = weights.get(9);
			weight9 = Double.parseDouble(stringWeight9);
			symbol9 = ComponentsService2.getWeightsToSymbols().get(stringWeight9);
			charge9 = ComponentsService2.getWeightsToCharges().get(stringWeight9);
			jMin = symbolsToRanges.get(symbol9).getMin();
    		jMax = symbolsToRanges.get(symbol9).getMax();
    		
			stringWeight10 = weights.get(10);
			weight10 = Double.parseDouble(stringWeight10);
			symbol10 = ComponentsService2.getWeightsToSymbols().get(stringWeight10);
			charge10 = ComponentsService2.getWeightsToCharges().get(stringWeight10);
			kMin = symbolsToRanges.get(symbol10).getMin();
    		kMax = symbolsToRanges.get(symbol10).getMax();
    		
    		stringWeight11 = weights.get(11);
			weight11 = Double.parseDouble(stringWeight11);
			symbol11 = ComponentsService2.getWeightsToSymbols().get(stringWeight11);
			charge11 = ComponentsService2.getWeightsToCharges().get(stringWeight11);
			lMin = symbolsToRanges.get(symbol11).getMin();
    		lMax = symbolsToRanges.get(symbol11).getMax();
    		
			this.findCombinations12Weights();
			
		} else if (weights.size() == 13) {
			stringWeight0 = weights.get(0);
			weight0 = Double.parseDouble(stringWeight0);
			symbol0 = ComponentsService2.getWeightsToSymbols().get(stringWeight0);
			charge0 = ComponentsService2.getWeightsToCharges().get(stringWeight0);
			
			stringWeight1 = weights.get(1);
			weight1 = Double.parseDouble(stringWeight1);
			symbol1 = ComponentsService2.getWeightsToSymbols().get(stringWeight1);
			charge1 = ComponentsService2.getWeightsToCharges().get(stringWeight1);
			bMin = symbolsToRanges.get(symbol1).getMin();
    		bMax = symbolsToRanges.get(symbol1).getMax();
    		
			stringWeight2 = weights.get(2);
			weight2 = Double.parseDouble(stringWeight2);
			symbol2 = ComponentsService2.getWeightsToSymbols().get(stringWeight2);
			charge2 = ComponentsService2.getWeightsToCharges().get(stringWeight2);
			cMin = symbolsToRanges.get(symbol2).getMin();
    		cMax = symbolsToRanges.get(symbol2).getMax();
    		
			stringWeight3 = weights.get(3);
			weight3 = Double.parseDouble(stringWeight3);
			symbol3 = ComponentsService2.getWeightsToSymbols().get(stringWeight3);
			charge3 = ComponentsService2.getWeightsToCharges().get(stringWeight3);
			dMin = symbolsToRanges.get(symbol3).getMin();
    		dMax = symbolsToRanges.get(symbol3).getMax();
    		
			stringWeight4 = weights.get(4);
			weight4 = Double.parseDouble(stringWeight4);
			symbol4 = ComponentsService2.getWeightsToSymbols().get(stringWeight4);
			charge4 = ComponentsService2.getWeightsToCharges().get(stringWeight4);
			eMin = symbolsToRanges.get(symbol4).getMin();
    		eMax = symbolsToRanges.get(symbol4).getMax();
    		
			stringWeight5 = weights.get(5);
			weight5 = Double.parseDouble(stringWeight5);
			symbol5 = ComponentsService2.getWeightsToSymbols().get(stringWeight5);
			charge5 = ComponentsService2.getWeightsToCharges().get(stringWeight5);
			fMin = symbolsToRanges.get(symbol5).getMin();
    		fMax = symbolsToRanges.get(symbol5).getMax();
    		
			stringWeight6 = weights.get(6);
			weight6 = Double.parseDouble(stringWeight6);
			symbol6 = ComponentsService2.getWeightsToSymbols().get(stringWeight6);
			charge6 = ComponentsService2.getWeightsToCharges().get(stringWeight6);
			gMin = symbolsToRanges.get(symbol6).getMin();
    		gMax = symbolsToRanges.get(symbol6).getMax();
    		
			stringWeight7 = weights.get(7);
			weight7 = Double.parseDouble(stringWeight7);
			symbol7 = ComponentsService2.getWeightsToSymbols().get(stringWeight7);
			charge7 = ComponentsService2.getWeightsToCharges().get(stringWeight7);
			hMin = symbolsToRanges.get(symbol7).getMin();
    		hMax = symbolsToRanges.get(symbol7).getMax();
    		
			stringWeight8 = weights.get(8);
			weight8 = Double.parseDouble(stringWeight8);
			symbol8 = ComponentsService2.getWeightsToSymbols().get(stringWeight8);
			charge8 = ComponentsService2.getWeightsToCharges().get(stringWeight8);
			iMin = symbolsToRanges.get(symbol8).getMin();
    		iMax = symbolsToRanges.get(symbol8).getMax();
    		
			stringWeight9 = weights.get(9);
			weight9 = Double.parseDouble(stringWeight9);
			symbol9 = ComponentsService2.getWeightsToSymbols().get(stringWeight9);
			charge9 = ComponentsService2.getWeightsToCharges().get(stringWeight9);
			jMin = symbolsToRanges.get(symbol9).getMin();
    		jMax = symbolsToRanges.get(symbol9).getMax();
    		
			stringWeight10 = weights.get(10);
			weight10 = Double.parseDouble(stringWeight10);
			symbol10 = ComponentsService2.getWeightsToSymbols().get(stringWeight10);
			charge10 = ComponentsService2.getWeightsToCharges().get(stringWeight10);
			kMin = symbolsToRanges.get(symbol10).getMin();
    		kMax = symbolsToRanges.get(symbol10).getMax();
    		
    		stringWeight11 = weights.get(11);
			weight11 = Double.parseDouble(stringWeight11);
			symbol11 = ComponentsService2.getWeightsToSymbols().get(stringWeight11);
			charge11 = ComponentsService2.getWeightsToCharges().get(stringWeight11);
			lMin = symbolsToRanges.get(symbol11).getMin();
    		lMax = symbolsToRanges.get(symbol11).getMax();
    		
    		stringWeight12 = weights.get(12);
			weight12 = Double.parseDouble(stringWeight12);
			symbol12 = ComponentsService2.getWeightsToSymbols().get(stringWeight12);
			charge12 = ComponentsService2.getWeightsToCharges().get(stringWeight12);
			mMin = symbolsToRanges.get(symbol12).getMin();
    		mMax = symbolsToRanges.get(symbol12).getMax();
		
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
		final double currentSum = a*weight0;
		final double totalCharge = a*charge0;

		if (totalCharge == charge 
				&& (currentSum >= targetSum - range 
				&& currentSum <= targetSum + range)) {
			
			final String solution = currentSum + "\n"
					+ totalCharge  + "\n"
					+ "(" + symbol0 + ")" + String.valueOf((int)a) + " + "
					+ "\n" 
					+ "_____________________________________________________________________________________________________________"
					+ "\n";
			
			solutionsList.add(solution);
			System.out.println(solution);
		}
	}
	
	private void findCombinations2Weights() {
		double s0 = a*weight0;

		double c0 = a*charge0;
		
		for (double b = bMin; b <= bMax; b++) {
			final double currentSum = s0 + b*weight1;
			final double totalCharge = c0 + b*charge1;

			if (totalCharge == charge 
					&& (currentSum >= targetSum - range 
					&& currentSum <= targetSum + range)) {
				
				final String solution = currentSum + "\n"
						+ totalCharge  + "\n"
						+ "(" + symbol0 + ")" + String.valueOf((int)a) + " + "
						+ "(" + symbol1 + ")" + String.valueOf((int)b)
						+ "\n" 
						+ "_____________________________________________________________________________________________________________"
						+ "\n";
				
				solutionsList.add(solution);
				System.out.println(solution);
			}
		}
	}
	
	private void findCombinations3Weights() {
		double s0 = a*weight0;
		double s1 = 0;

		double c0 = a*charge0;
		double c1 = 0;

		for (double b = bMin; b <= bMax; b++) {
			s1 = s0 + b*weight1;
			c1 = c0 + b*charge1;

			for (double c = cMin; c <= cMax; c++) {
				final double currentSum = s1 + c*weight2;
				final double totalCharge = c1 + c*charge2;

				if (totalCharge == charge 
						&& (currentSum >= targetSum - range 
						&& currentSum <= targetSum + range)) {
					
					final String solution = currentSum + "\n"
							+ totalCharge  + "\n"
							+ "(" + symbol0 + ")" + String.valueOf((int)a) + " + "
							+ "(" + symbol1 + ")" + String.valueOf((int)b) + " + "
							+ "(" + symbol2 + ")" + String.valueOf((int)c)
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
		double s0 = a*weight0;
		double s1 = 0;
		double s2 = 0;

		double c0 = a*charge0;
		double c1 = 0;
		double c2 = 0;

		for (double b = bMin; b <= bMax; b++) {
			s1 = s0 + b*weight1;
			c1 = c0 + b*charge1;

			for (double c = cMin; c <= cMax; c++) {
				s2 = s1 + c*weight2;
				c2 = c1 + c*charge2;
				
				for (double d = dMin; d <= dMax; d++) {
					final double currentSum = s2 + d*weight3;
					final double totalCharge = c2 + d*charge3;

					if (totalCharge == charge 
							&& (currentSum >= targetSum - range 
							&& currentSum <= targetSum + range)) {
						
						final String solution = currentSum + "\n"
								+ totalCharge  + "\n"
								+ "(" + symbol0 + ")" + String.valueOf((int)a) + " + "
								+ "(" + symbol1 + ")" + String.valueOf((int)b) + " + "
								+ "(" + symbol2 + ")" + String.valueOf((int)c) + " + "
								+ "(" + symbol3 + ")" + String.valueOf((int)d)
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
		double s0 = a*weight0;
		double s1 = 0;
		double s2 = 0;
		double s3 = 0;

		double c0 = a*charge0;
		double c1 = 0;
		double c2 = 0;
		double c3 = 0;

		for (double b = bMin; b <= bMax; b++) {
			s1 = s0 + b*weight1;
			c1 = c0 + b*charge1;

			for (double c = cMin; c <= cMax; c++) {
				s2 = s1 + c*weight2;
				c2 = c1 + c*charge2;
				
				for (double d = dMin; d <= dMax; d++) {
					s3 = s2 + d*weight3;
					c3 = c2 + d*charge3;
	
					for (double e = eMin; e <= eMax; e++) {
						final double currentSum = s3 + e*weight4;
						final double totalCharge = c3 + e*charge4;

						if (totalCharge == charge 
								&& (currentSum >= targetSum - range 
								&& currentSum <= targetSum + range)) {
							
							final String solution = currentSum + "\n"
									+ totalCharge  + "\n"
									+ "(" + symbol0 + ")" + String.valueOf((int)a) + " + "
									+ "(" + symbol1 + ")" + String.valueOf((int)b) + " + "
									+ "(" + symbol2 + ")" + String.valueOf((int)c) + " + "
									+ "(" + symbol3 + ")" + String.valueOf((int)d) + " + "
									+ "(" + symbol4 + ")" + String.valueOf((int)e)
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
		double s0 = a*weight0;
		double s1 = 0;
		double s2 = 0;
		double s3 = 0;
		double s4 = 0;

		double c0 = a*charge0;
		double c1 = 0;
		double c2 = 0;
		double c3 = 0;
		double c4 = 0;

		for (double b = bMin; b <= bMax; b++) {
			s1 = s0 + b*weight1;
			c1 = c0 + b*charge1;

			for (double c = cMin; c <= cMax; c++) {
				s2 = s1 + c*weight2;
				c2 = c1 + c*charge2;
				
				for (double d = dMin; d <= dMax; d++) {
					s3 = s2 + d*weight3;
					c3 = c2 + d*charge3;
	
					for (double e = eMin; e <= eMax; e++) {
						s4 = s3 + e*weight4;
						c4 = c3 + e*charge4;
			
						for (double f = fMin; f <= fMax; f++) {
							final double currentSum = s4 + f*weight5;
							final double totalCharge = c4 + f*charge5;

							if (totalCharge == charge 
									&& (currentSum >= targetSum - range 
									&& currentSum <= targetSum + range)) {
								
								final String solution = currentSum + "\n"
										+ totalCharge  + "\n"
										+ "(" + symbol0 + ")" + String.valueOf((int)a) + " + "
										+ "(" + symbol1 + ")" + String.valueOf((int)b) + " + "
										+ "(" + symbol2 + ")" + String.valueOf((int)c) + " + "
										+ "(" + symbol3 + ")" + String.valueOf((int)d) + " + "
										+ "(" + symbol4 + ")" + String.valueOf((int)e) + " + "
										+ "(" + symbol5 + ")" + String.valueOf((int)f)
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
		double s0 = a*weight0;
		double s1 = 0;
		double s2 = 0;
		double s3 = 0;
		double s4 = 0;
		double s5 = 0;
		
		double c0 = a*charge0;
		double c1 = 0;
		double c2 = 0;
		double c3 = 0;
		double c4 = 0;
		double c5 = 0;

		for (double b = bMin; b <= bMax; b++) {
			s1 = s0 + b*weight1;
			c1 = c0 + b*charge1;

			for (double c = cMin; c <= cMax; c++) {
				s2 = s1 + c*weight2;
				c2 = c1 + c*charge2;
				
				for (double d = dMin; d <= dMax; d++) {
					s3 = s2 + d*weight3;
					c3 = c2 + d*charge3;
	
					for (double e = eMin; e <= eMax; e++) {
						s4 = s3 + e*weight4;
						c4 = c3 + e*charge4;
			
						for (double f = fMin; f <= fMax; f++) {
							s5 = s4 + f*weight5;
							c5 = c4 + f*charge5;
			
							for (double g = gMin; g <= gMax; g++) {
								final double currentSum = s5 + g*weight6;
								final double totalCharge = c5 + g*charge6;

								if (totalCharge == charge 
										&& (currentSum >= targetSum - range 
										&& currentSum <= targetSum + range)) {
									
									final String solution = currentSum + "\n"
											+ totalCharge  + "\n"
											+ "(" + symbol0 + ")" + String.valueOf((int)a) + " + "
											+ "(" + symbol1 + ")" + String.valueOf((int)b) + " + "
											+ "(" + symbol2 + ")" + String.valueOf((int)c) + " + "
											+ "(" + symbol3 + ")" + String.valueOf((int)d) + " + "
											+ "(" + symbol4 + ")" + String.valueOf((int)e) + " + "
											+ "(" + symbol5 + ")" + String.valueOf((int)f) + " + "
											+ "(" + symbol6 + ")" + String.valueOf((int)g)
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
		double s0 = a*weight0;
		double s1 = 0;
		double s2 = 0;
		double s3 = 0;
		double s4 = 0;
		double s5 = 0;
		double s6 = 0;
		
		double c0 = a*charge0;
		double c1 = 0;
		double c2 = 0;
		double c3 = 0;
		double c4 = 0;
		double c5 = 0;
		double c6 = 0;

		for (double b = bMin; b <= bMax; b++) {
			s1 = s0 + b*weight1;
			c1 = c0 + b*charge1;

			for (double c = cMin; c <= cMax; c++) {
				s2 = s1 + c*weight2;
				c2 = c1 + c*charge2;
				
				for (double d = dMin; d <= dMax; d++) {
					s3 = s2 + d*weight3;
					c3 = c2 + d*charge3;
	
					for (double e = eMin; e <= eMax; e++) {
						s4 = s3 + e*weight4;
						c4 = c3 + e*charge4;
			
						for (double f = fMin; f <= fMax; f++) {
							s5 = s4 + f*weight5;
							c5 = c4 + f*charge5;
			
							for (double g = gMin; g <= gMax; g++) {
								s6 = s5 + g*weight6;
								c6 = c5 + g*charge6;
				
								for (double h = hMin; h <= hMax; h++) {
									final double currentSum = s6 + h*weight7;
									final double totalCharge = c6 + h*charge7;

									if (totalCharge == charge 
											&& (currentSum >= targetSum - range 
											&& currentSum <= targetSum + range)) {
										
										final String solution = currentSum + "\n"
												+ totalCharge  + "\n"
												+ "(" + symbol0 + ")" + String.valueOf((int)a) + " + "
												+ "(" + symbol1 + ")" + String.valueOf((int)b) + " + "
												+ "(" + symbol2 + ")" + String.valueOf((int)c) + " + "
												+ "(" + symbol3 + ")" + String.valueOf((int)d) + " + "
												+ "(" + symbol4 + ")" + String.valueOf((int)e) + " + "
												+ "(" + symbol5 + ")" + String.valueOf((int)f) + " + "
												+ "(" + symbol6 + ")" + String.valueOf((int)g) + " + "
												+ "(" + symbol7 + ")" + String.valueOf((int)h)
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
		double s0 = a*weight0;
		double s1 = 0;
		double s2 = 0;
		double s3 = 0;
		double s4 = 0;
		double s5 = 0;
		double s6 = 0;
		double s7 = 0;
		
		double c0 = a*charge0;
		double c1 = 0;
		double c2 = 0;
		double c3 = 0;
		double c4 = 0;
		double c5 = 0;
		double c6 = 0;
		double c7 = 0;

		for (double b = bMin; b <= bMax; b++) {
			s1 = s0 + b*weight1;
			c1 = c0 + b*charge1;

			for (double c = cMin; c <= cMax; c++) {
				s2 = s1 + c*weight2;
				c2 = c1 + c*charge2;
				
				for (double d = dMin; d <= dMax; d++) {
					s3 = s2 + d*weight3;
					c3 = c2 + d*charge3;
	
					for (double e = eMin; e <= eMax; e++) {
						s4 = s3 + e*weight4;
						c4 = c3 + e*charge4;
			
						for (double f = fMin; f <= fMax; f++) {
							s5 = s4 + f*weight5;
							c5 = c4 + f*charge5;
			
							for (double g = gMin; g <= gMax; g++) {
								s6 = s5 + g*weight6;
								c6 = c5 + g*charge6;
				
								for (double h = hMin; h <= hMax; h++) {
									s7 = s6 + h*weight7;
									c7 = c6 + h*charge7;
					
									for (double i = iMin; i <= iMax; i++) {
										final double currentSum = s7 + i*weight8;
										final double totalCharge = c7 + i*charge8;

										if (totalCharge == charge 
												&& (currentSum >= targetSum - range 
												&& currentSum <= targetSum + range)) {
											
											final String solution = currentSum + "\n"
													+ totalCharge  + "\n"
													+ "(" + symbol0 + ")" + String.valueOf((int)a) + " + "
													+ "(" + symbol1 + ")" + String.valueOf((int)b) + " + "
													+ "(" + symbol2 + ")" + String.valueOf((int)c) + " + "
													+ "(" + symbol3 + ")" + String.valueOf((int)d) + " + "
													+ "(" + symbol4 + ")" + String.valueOf((int)e) + " + "
													+ "(" + symbol5 + ")" + String.valueOf((int)f) + " + "
													+ "(" + symbol6 + ")" + String.valueOf((int)g) + " + "
													+ "(" + symbol7 + ")" + String.valueOf((int)h) + " + "
													+ "(" + symbol8 + ")" + String.valueOf((int)i)
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
		double s0 = a*weight0;
		double s1 = 0;
		double s2 = 0;
		double s3 = 0;
		double s4 = 0;
		double s5 = 0;
		double s6 = 0;
		double s7 = 0;
		double s8 = 0;
		
		double c0 = a*charge0;
		double c1 = 0;
		double c2 = 0;
		double c3 = 0;
		double c4 = 0;
		double c5 = 0;
		double c6 = 0;
		double c7 = 0;
		double c8 = 0;
		
		for (double b = bMin; b <= bMax; b++) {
			s1 = s0 + b*weight1;
			c1 = c0 + b*charge1;

			for (double c = cMin; c <= cMax; c++) {
				s2 = s1 + c*weight2;
				c2 = c1 + c*charge2;
				
				for (double d = dMin; d <= dMax; d++) {
					s3 = s2 + d*weight3;
					c3 = c2 + d*charge3;
	
					for (double e = eMin; e <= eMax; e++) {
						s4 = s3 + e*weight4;
						c4 = c3 + e*charge4;
			
						for (double f = fMin; f <= fMax; f++) {
							s5 = s4 + f*weight5;
							c5 = c4 + f*charge5;
			
							for (double g = gMin; g <= gMax; g++) {
								s6 = s5 + g*weight6;
								c6 = c5 + g*charge6;
				
								for (double h = hMin; h <= hMax; h++) {
									s7 = s6 + h*weight7;
									c7 = c6 + h*charge7;
					
									for (double i = iMin; i <= iMax; i++) {
										s8 = s7 + i*weight8;
										c8 = c7 + i*charge8;
						
										for (double j = jMin; j <= jMax; j++) {
											final double currentSum = s8 + j*weight9;
											final double totalCharge = c8 + j*charge9;

											if (totalCharge == charge 
													&& (currentSum >= targetSum - range 
													&& currentSum <= targetSum + range)) {
												
												final String solution = currentSum + "\n"
														+ totalCharge  + "\n"
														+ "(" + symbol0 + ")" + String.valueOf((int)a) + " + "
														+ "(" + symbol1 + ")" + String.valueOf((int)b) + " + "
														+ "(" + symbol2 + ")" + String.valueOf((int)c) + " + "
														+ "(" + symbol3 + ")" + String.valueOf((int)d) + " + "
														+ "(" + symbol4 + ")" + String.valueOf((int)e) + " + "
														+ "(" + symbol5 + ")" + String.valueOf((int)f) + " + "
														+ "(" + symbol6 + ")" + String.valueOf((int)g) + " + "
														+ "(" + symbol7 + ")" + String.valueOf((int)h) + " + "
														+ "(" + symbol8 + ")" + String.valueOf((int)i) + " + "
														+ "(" + symbol9 + ")" + String.valueOf((int)j)
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
		double s0 = a*weight0;
		double s1 = 0;
		double s2 = 0;
		double s3 = 0;
		double s4 = 0;
		double s5 = 0;
		double s6 = 0;
		double s7 = 0;
		double s8 = 0;
		double s9 = 0;
		
		double c0 = a*charge0;
		double c1 = 0;
		double c2 = 0;
		double c3 = 0;
		double c4 = 0;
		double c5 = 0;
		double c6 = 0;
		double c7 = 0;
		double c8 = 0;
		double c9 = 0;
		
		for (double b = bMin; b <= bMax; b++) {
			s1 = s0 + b*weight1;
			c1 = c0 + b*charge1;

			for (double c = cMin; c <= cMax; c++) {
				s2 = s1 + c*weight2;
				c2 = c1 + c*charge2;
				
				for (double d = dMin; d <= dMax; d++) {
					s3 = s2 + d*weight3;
					c3 = c2 + d*charge3;
	
					for (double e = eMin; e <= eMax; e++) {
						s4 = s3 + e*weight4;
						c4 = c3 + e*charge4;
			
						for (double f = fMin; f <= fMax; f++) {
							s5 = s4 + f*weight5;
							c5 = c4 + f*charge5;
			
							for (double g = gMin; g <= gMax; g++) {
								s6 = s5 + g*weight6;
								c6 = c5 + g*charge6;
				
								for (double h = hMin; h <= hMax; h++) {
									s7 = s6 + h*weight7;
									c7 = c6 + h*charge7;
					
									for (double i = iMin; i <= iMax; i++) {
										s8 = s7 + i*weight8;
										c8 = c7 + i*charge8;
						
										for (double j = jMin; j <= jMax; j++) {
											s9 = s8 + j*weight9;
											c9 = c8 + j*charge9;
							
											for (double k = kMin; k <= kMax; k++) {
												final double currentSum = s9 + k*weight10;
												final double totalCharge = c9 + k*charge10;

												if (totalCharge == charge 
														&& (currentSum >= targetSum - range 
														&& currentSum <= targetSum + range)) {
													
													final String solution = currentSum + "\n"
															+ totalCharge  + "\n"
															+ "(" + symbol0 + ")" + String.valueOf((int)a) + " + "
															+ "(" + symbol1 + ")" + String.valueOf((int)b) + " + "
															+ "(" + symbol2 + ")" + String.valueOf((int)c) + " + "
															+ "(" + symbol3 + ")" + String.valueOf((int)d) + " + "
															+ "(" + symbol4 + ")" + String.valueOf((int)e) + " + "
															+ "(" + symbol5 + ")" + String.valueOf((int)f) + " + "
															+ "(" + symbol6 + ")" + String.valueOf((int)g) + " + "
															+ "(" + symbol7 + ")" + String.valueOf((int)h) + " + "
															+ "(" + symbol8 + ")" + String.valueOf((int)i) + " + "
															+ "(" + symbol9 + ")" + String.valueOf((int)j) + " + " 
															+ "(" + symbol10 + ")" + String.valueOf((int)k)
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
		double s0 = a*weight0;
		double s1 = 0;
		double s2 = 0;
		double s3 = 0;
		double s4 = 0;
		double s5 = 0;
		double s6 = 0;
		double s7 = 0;
		double s8 = 0;
		double s9 = 0;
		double s10 = 0;
		
		double c0 = a*charge0;
		double c1 = 0;
		double c2 = 0;
		double c3 = 0;
		double c4 = 0;
		double c5 = 0;
		double c6 = 0;
		double c7 = 0;
		double c8 = 0;
		double c9 = 0;
		double c10 = 0;
		
		for (double b = bMin; b <= bMax; b++) {
			s1 = s0 + b*weight1;
			c1 = c0 + b*charge1;

			for (double c = cMin; c <= cMax; c++) {
				s2 = s1 + c*weight2;
				c2 = c1 + c*charge2;
				
				for (double d = dMin; d <= dMax; d++) {
					s3 = s2 + d*weight3;
					c3 = c2 + d*charge3;
	
					for (double e = eMin; e <= eMax; e++) {
						s4 = s3 + e*weight4;
						c4 = c3 + e*charge4;
			
						for (double f = fMin; f <= fMax; f++) {
							s5 = s4 + f*weight5;
							c5 = c4 + f*charge5;
			
							for (double g = gMin; g <= gMax; g++) {
								s6 = s5 + g*weight6;
								c6 = c5 + g*charge6;
				
								for (double h = hMin; h <= hMax; h++) {
									s7 = s6 + h*weight7;
									c7 = c6 + h*charge7;
					
									for (double i = iMin; i <= iMax; i++) {
										s8 = s7 + i*weight8;
										c8 = c7 + i*charge8;
						
										for (double j = jMin; j <= jMax; j++) {
											s9 = s8 + j*weight9;
											c9 = c8 + j*charge9;
							
											for (double k = kMin; k <= kMax; k++) {
												s10 = s9 + k*weight10;
												c10 = c9 + k*charge10;
												
												for (double l = lMin; l <= lMax; l++) {
													final double currentSum = s10 + l*weight11;
													final double totalCharge = c10 + l*charge11;

													if (totalCharge == charge 
															&& (currentSum >= targetSum - range 
															&& currentSum <= targetSum + range)) {
														
														final String solution = currentSum + "\n"
																+ totalCharge  + "\n"
																+ "(" + symbol0 + ")" + String.valueOf((int)a) + " + "
																+ "(" + symbol1 + ")" + String.valueOf((int)b) + " + "
																+ "(" + symbol2 + ")" + String.valueOf((int)c) + " + "
																+ "(" + symbol3 + ")" + String.valueOf((int)d) + " + "
																+ "(" + symbol4 + ")" + String.valueOf((int)e) + " + "
																+ "(" + symbol5 + ")" + String.valueOf((int)f) + " + "
																+ "(" + symbol6 + ")" + String.valueOf((int)g) + " + "
																+ "(" + symbol7 + ")" + String.valueOf((int)h) + " + "
																+ "(" + symbol8 + ")" + String.valueOf((int)i) + " + "
																+ "(" + symbol9 + ")" + String.valueOf((int)j) + " + " 
																+ "(" + symbol10 + ")" + String.valueOf((int)k)
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
		double s0 = a*weight0;
		double s1 = 0;
		double s2 = 0;
		double s3 = 0;
		double s4 = 0;
		double s5 = 0;
		double s6 = 0;
		double s7 = 0;
		double s8 = 0;
		double s9 = 0;
		double s10 = 0;
		double s11 = 0;
		
		double c0 = a*charge0;
		double c1 = 0;
		double c2 = 0;
		double c3 = 0;
		double c4 = 0;
		double c5 = 0;
		double c6 = 0;
		double c7 = 0;
		double c8 = 0;
		double c9 = 0;
		double c10 = 0;
		double c11 = 0;
		
		for (double b = bMin; b <= bMax; b++) {
			s1 = s0 + b*weight1;
			c1 = c0 + b*charge1;

			for (double c = cMin; c <= cMax; c++) {
				s2 = s1 + c*weight2;
				c2 = c1 + c*charge2;
				
				for (double d = dMin; d <= dMax; d++) {
					s3 = s2 + d*weight3;
					c3 = c2 + d*charge3;
	
					for (double e = eMin; e <= eMax; e++) {
						s4 = s3 + e*weight4;
						c4 = c3 + e*charge4;
			
						for (double f = fMin; f <= fMax; f++) {
							s5 = s4 + f*weight5;
							c5 = c4 + f*charge5;
			
							for (double g = gMin; g <= gMax; g++) {
								s6 = s5 + g*weight6;
								c6 = c5 + g*charge6;
				
								for (double h = hMin; h <= hMax; h++) {
									s7 = s6 + h*weight7;
									c7 = c6 + h*charge7;
					
									for (double i = iMin; i <= iMax; i++) {
										s8 = s7 + i*weight8;
										c8 = c7 + i*charge8;
						
										for (double j = jMin; j <= jMax; j++) {
											s9 = s8 + j*weight9;
											c9 = c8 + j*charge9;
							
											for (double k = kMin; k <= kMax; k++) {
												s10 = s9 + k*weight10;
												c10 = c9 + k*charge10;
												
												for (double l = lMin; l <= lMax; l++) {
													s11 = s10 + l*weight11;
													c11 = c10 + l*charge11;
													
													for (double m = mMin; m <= mMax; m++) {
														final double currentSum = s11 + m*weight12;
														final double totalCharge = c11 + m*charge12;

														if (totalCharge == charge 
																&& (currentSum >= targetSum - range 
																&& currentSum <= targetSum + range)) {
															
															final String solution = currentSum + "\n"
																	+ totalCharge  + "\n"
																	+ "(" + symbol0 + ")" + String.valueOf((int)a) + " + "
																	+ "(" + symbol1 + ")" + String.valueOf((int)b) + " + "
																	+ "(" + symbol2 + ")" + String.valueOf((int)c) + " + "
																	+ "(" + symbol3 + ")" + String.valueOf((int)d) + " + "
																	+ "(" + symbol4 + ")" + String.valueOf((int)e) + " + "
																	+ "(" + symbol5 + ")" + String.valueOf((int)f) + " + "
																	+ "(" + symbol6 + ")" + String.valueOf((int)g) + " + "
																	+ "(" + symbol7 + ")" + String.valueOf((int)h) + " + "
																	+ "(" + symbol8 + ")" + String.valueOf((int)i) + " + "
																	+ "(" + symbol9 + ")" + String.valueOf((int)j) + " + " 
																	+ "(" + symbol10 + ")" + String.valueOf((int)k)
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
