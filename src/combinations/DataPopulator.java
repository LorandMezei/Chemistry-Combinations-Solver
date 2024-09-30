package combinations;

import java.awt.Color;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import setupHelpers.ComponentsService2;

public class DataPopulator {
	
	public static final List<String> WEIGHTS = new ArrayList<>();
	
	private static DefaultTableModel TABLE_MODEL = null;
	private static final Object[] TABLE_COLUMN_NAMES = new Object[]{"Component", "Weight", "Charge", "Use", "Sort", "Force", "Min", "Max"};
	private static final int SYMBOL_TABLE_INDEX = 0;
	private static final int USE_TABLE_INDEX = 3;
	private static final int SORT_TABLE_INDEX = 4;
	private static final int FORCE_TABLE_INDEX = 5;
	private static final int MIN_TABLE_INDEX = 6;
	private static final int MAX_TABLE_INDEX = 7;
	
	public static void populate() {
		if (Frame.getFileLoadTextField() != null 
				&& Frame.getFileLoadTextField().getText() != null) {
			
			final String fileLoadPath = "".equals(Frame.getFileLoadTextField().getText()) 
					? "components.txt" 
							: Frame.getFileLoadTextField().getText();
			
			ComponentsService2.populateData(fileLoadPath.trim());
			
			final List<String> symbols = ComponentsService2.getSymbols();
			Collections.sort(symbols, String.CASE_INSENSITIVE_ORDER);
		
			final List<Integer> charges = new ArrayList<>();
			for (final String s : symbols) {
				WEIGHTS.add(ComponentsService2.getSymbolsToWeights().get(s));
				charges.add(ComponentsService2.getSymbolsToCharges().get(s));
			}
			
			loadTable(createTableModel(symbols, charges));
		}
	}
	
	public static void saveTableModel() throws IOException {
		if (TABLE_MODEL == null) {
			return;
		}
		
		final String profileFileName;
    	if (Frame.getProfile1Button().isSelected()) {
    		profileFileName = "profile1.txt";
    	} else if (Frame.getProfile2Button().isSelected()) {
    		profileFileName = "profile2.txt";
    	} else if (Frame.getProfile3Button().isSelected()) {
    		profileFileName = "profile3.txt";
    	} else if (Frame.getProfile4Button().isSelected()) {
    		profileFileName = "profile4.txt";
    	} else if (Frame.getProfile5Button().isSelected()) {
    		profileFileName = "profile5.txt";
    	} else {
    		profileFileName = "defaultProfile.txt";
    	}
	    	
		try (final FileWriter fileWriter = new FileWriter(profileFileName)) {
			fileWriter.append(
					Frame.getTargetTextField().getText()
					+ ","
					+ Frame.getRangeTextField().getText()
					+ ","
				    + Frame.getChargeTextField().getText()
				    + "\n");
				    
			for (int i = 0; i < TABLE_MODEL.getRowCount(); i++) {
				final String symbol = Frame.getComponentsTable().getValueAt(i, SYMBOL_TABLE_INDEX).toString();
				final String weight = ComponentsService2.getSymbolsToWeights().get(symbol).toString();
				final String charge = ComponentsService2.getSymbolsToCharges().get(symbol).toString();
				final Boolean useSelected = Boolean.valueOf(Frame.getComponentsTable().getValueAt(i, USE_TABLE_INDEX).toString());
				final Boolean sortSelected = Boolean.valueOf(Frame.getComponentsTable().getValueAt(i, SORT_TABLE_INDEX).toString());
				final Boolean forceSelected = Boolean.valueOf(Frame.getComponentsTable().getValueAt(i, FORCE_TABLE_INDEX).toString());
				final int min = Integer.parseInt(Frame.getComponentsTable().getValueAt(i, MIN_TABLE_INDEX).toString().trim());
				final int max = Integer.parseInt(Frame.getComponentsTable().getValueAt(i, MAX_TABLE_INDEX).toString().trim());
				
				try {
					fileWriter.append(
							symbol 
							+ ","
							+ weight
							+ ","
							+ charge
							+ ","
							+ useSelected
							+ ","
							+ sortSelected
							+ ","
							+ forceSelected
							+ ","
							+ min
							+ ","
							+ max
							+ "\n");
					
				} catch (IOException ex) { 
					ex.printStackTrace();
				}
			}
			
		} catch (IOException ex) { 
			ex.printStackTrace();
		} 
	}

	private static DefaultTableModel createTableModel(final List<String> symbols,
											          final List<Integer> charges) {
		final DefaultTableModel model = new DefaultTableModel(TABLE_COLUMN_NAMES, 0) {
			@Override
	        public Class getColumnClass(int columnIndex) {
				if (columnIndex == USE_TABLE_INDEX 
						|| columnIndex == SORT_TABLE_INDEX
						|| columnIndex == FORCE_TABLE_INDEX) {
	        		return Boolean.class;
	        	} else {
	        		return String.class;
	        	}
	            
	         }
	    };
	    
	    if (Frame.getClearTableValuesCheckbox().isSelected()) {
	    	Frame.getTargetTextField().setText("");
			Frame.getRangeTextField().setText("");
			Frame.getChargeTextField().setText("");
			Frame.getFileSaveTextField().setText("");
			
	    	for (int i = 0; i < symbols.size(); i++) {
		    	model.addRow(new Object[] {symbols.get(i), WEIGHTS.get(i), charges.get(i), false, false, false, "0", "10"});
		    }
	    	
	    } else {
	    	final String profileFileName;
	    	if (Frame.getProfile1Button().isSelected()) {
	    		profileFileName = "profile1.txt";
	    	} else if (Frame.getProfile2Button().isSelected()) {
	    		profileFileName = "profile2.txt";
	    	} else if (Frame.getProfile3Button().isSelected()) {
	    		profileFileName = "profile3.txt";
	    	} else if (Frame.getProfile4Button().isSelected()) {
	    		profileFileName = "profile4.txt";
	    	} else if (Frame.getProfile5Button().isSelected()) {
	    		profileFileName = "profile5.txt";
	    	} else {
	    		profileFileName = "defaultProfile.txt";
	    	}
	    	
	    	boolean doesProfileExist = true;
	    	
	    	final File file;
	    	final BufferedReader reader;
	    	final BufferedReader reader2;
			try {
				file = new File(profileFileName);
				file.createNewFile();
				reader = new BufferedReader(new FileReader(file));
				reader2 = new BufferedReader(new FileReader(file));
				String line = reader.readLine();
				String secondLine = reader2.readLine();
				secondLine = reader2.readLine();
				
				if (line == null || "".equals(line) || secondLine == null || "".equals(secondLine)) {
					doesProfileExist = false;
					
				} else {
					int lineCounter = 0;
					while (line != null) {
						final List<String> values = new ArrayList<>();
						final StringTokenizer tokenizer = new StringTokenizer(line, ",");
					    while (tokenizer.hasMoreElements()) {
					        values.add(tokenizer.nextToken());
					    }
					    
					    if (lineCounter == 0 && values.size() == 3) {
					    	Frame.getTargetTextField().setText(values.get(0));
							Frame.getRangeTextField().setText(values.get(1));
							Frame.getChargeTextField().setText(values.get(2));
							
					    } else if (values.size() == 8) {
					    	model.addRow(new Object[] {
						    		values.get(0), values.get(1), values.get(2), // Strings
						    		Boolean.parseBoolean(values.get(3)), Boolean.parseBoolean(values.get(4)), Boolean.parseBoolean(values.get(5)), // Booleans
						    		values.get(6), values.get(7)}); // Strings
					    }
					    
					    line = reader.readLine();
					    lineCounter++;
					}
				}

				reader.close();
				reader2.close();
				
			} catch (IOException e) {
				doesProfileExist = false;
				e.printStackTrace();
			}
			
			if (!doesProfileExist) {
			    Frame.getTargetTextField().setText("");
				Frame.getRangeTextField().setText("");
			    Frame.getChargeTextField().setText("");
				Frame.getFileSaveTextField().setText("");
				
				for (int i = 0; i < symbols.size(); i++) {
			    	model.addRow(new Object[] {symbols.get(i), WEIGHTS.get(i), charges.get(i), false, false, false, "0", "10"});
			    }
			}
	    }
	    
	    TABLE_MODEL = model;
	    
	    return model;
	}
	
	private static void loadTable(final DefaultTableModel model) {
		final JTable table = new JTable(model) // add striping to table
		{
		    public Component prepareRenderer(TableCellRenderer renderer, int row, int column)
		    {
		        final Component c = super.prepareRenderer(renderer, row, column);

		        //  Alternate row color 
		        if (!isRowSelected(row))
		            c.setBackground(row % 2 == 0 ? getBackground() :  new Color(240,240,240));

		        return c;
		    }
		};
		Frame.setCOMPONENTS_TABLE(table);
		Frame.getComponentsTableScrollPane().getViewport().add(Frame.getComponentsTable());
	}
	
	public static List<String> getWeights() {
		return WEIGHTS;
	}
}
