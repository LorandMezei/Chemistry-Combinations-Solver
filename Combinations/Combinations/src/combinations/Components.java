package combinations;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Components {
	
	private static final HashMap<String, BigDecimal> symbolsToWeights = new HashMap<String, BigDecimal>();
	private static final HashMap<BigDecimal, String> weightsToSymbols = new HashMap<BigDecimal, String>();
	private static final HashMap<String, Integer> symbolsToCharges = new HashMap<String, Integer>();
	private static final HashMap<BigDecimal, Integer> weightsToCharges = new HashMap<BigDecimal, Integer>();
	
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
			    
			    if (values.size() == 3) {
			    	final String symbol = values.get(0);
			    	final BigDecimal weight = new BigDecimal(values.get(1));
			    	final Integer charge = Integer.parseInt(values.get(2));
			    	
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
									         final BigDecimal value) {
		if (symbolsToWeights != null) {
			symbolsToWeights.put(key, value);
		}
	}
	
	public static void addToWeightsToSymbols(final BigDecimal key,
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
	
	public static void addToWeightsToCharges(final BigDecimal key, 
		     						         final Integer value) {
		if (weightsToCharges != null) {
			weightsToCharges.put(key, value);
		}
	}
	
	public static List<String> getSymbols() {
		final List<String> symbols = new ArrayList<String>(); 
		for (final Map.Entry<String, BigDecimal> entry : Components.getSymbolsToWeights().entrySet()) {
			symbols.add(entry.getKey());
		}
		return symbols;
	}
	
	public static HashMap<String, BigDecimal> getSymbolsToWeights() {
		return symbolsToWeights;
	}
	
	public static HashMap<BigDecimal, String> getWeightsToSymbols() {
		return weightsToSymbols;
	}
	
	public static HashMap<String, Integer> getSymbolsToCharges() {
		return symbolsToCharges;
	}
	
	public static HashMap<BigDecimal, Integer> getWeightsToCharges() {
		return weightsToCharges;
	}

}
