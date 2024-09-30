package setupHelpers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class ComponentsService2 {
	
	public static final int NUM_FILE_ARGUMENTS = 3;
	public static final int SYMBOL_FILE_INDEX = 0;
	public static final int WEIGHT_FILE_INDEX = 1;
	public static final int CHARGE_FILE_INDEX = 2;
	
	private static final HashMap<String, String> symbolsToWeights = new HashMap<String, String>();
	private static final HashMap<String, String> weightsToSymbols = new HashMap<String, String>();
	private static final HashMap<String, Integer> symbolsToCharges = new HashMap<String, Integer>();
	private static final HashMap<String, Integer> weightsToCharges = new HashMap<String, Integer>();
	
	public static void populateData(final String filePath) {
		final BufferedReader reader;

		try {
			reader = new BufferedReader(new FileReader(filePath));
			String line = reader.readLine();

			while (line != null) {
				final List<String> values = new ArrayList<>();
				final StringTokenizer tokenizer = new StringTokenizer(line, ",");
			    while (tokenizer.hasMoreElements()) {
			        values.add(tokenizer.nextToken());
			    }
			    
			    if (values.size() == NUM_FILE_ARGUMENTS) {
			    	final String symbol = values.get(SYMBOL_FILE_INDEX);
			    	String weight;
			    	
			    	final String stringWeight = values.get(WEIGHT_FILE_INDEX);
			    	final List<String> values2 = new ArrayList<>();
			    	final StringTokenizer tokenizer2 = new StringTokenizer(stringWeight, ".");
			    	while (tokenizer2.hasMoreElements()) {
				        values2.add(tokenizer2.nextToken());
				    }
			    	
			    	if (values2.get(1).length() == 4) {
			    		weight = values.get(WEIGHT_FILE_INDEX);
			    	} else {
			    		weight = values.get(WEIGHT_FILE_INDEX);
			    	}
			    	
			    	final Integer charge = Integer.parseInt(values.get(CHARGE_FILE_INDEX));
			    	
			    	symbolsToWeights.put(symbol, weight);
			    	weightsToSymbols.put(weight, symbol);
			    	symbolsToCharges.put(symbol, charge);
			    	weightsToCharges.put(weight, charge);
			    	
			    }
			    
			    line = reader.readLine();
			}

			reader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void addToSymbolsToWeights(final String key,
									         final String value) {
		if (symbolsToWeights != null) {
			symbolsToWeights.put(key, value);
		}
	}
	
	public static void addToWeightsToSymbols(final String key,
										     final String value) {
		if (weightsToSymbols != null) {
			weightsToSymbols.put(key, value);
		}
	}
	
	public static void addToSymbolsToCharges(final String key, 
										     final Integer value) {
		if (symbolsToCharges != null) {
			symbolsToCharges.put(key, value);
		}
	}
	
	public static void addToWeightsToCharges(final String key, 
		     						         final Integer value) {
		if (weightsToCharges != null) {
			weightsToCharges.put(key, value);
		}
	}
	
	public static List<String> getSymbols() {
		final List<String> symbols = new ArrayList<String>(); 
		for (final Map.Entry<String, String> entry : ComponentsService2.getSymbolsToWeights().entrySet()) {
			symbols.add(entry.getKey());
		}
		return symbols;
	}
	
	public static HashMap<String, String> getSymbolsToWeights() {
		return symbolsToWeights;
	}
	
	public static HashMap<String, String> getWeightsToSymbols() {
		return weightsToSymbols;
	}
	
	public static HashMap<String, Integer> getSymbolsToCharges() {
		return symbolsToCharges;
	}
	
	public static HashMap<String, Integer> getWeightsToCharges() {
		return weightsToCharges;
	}

}
