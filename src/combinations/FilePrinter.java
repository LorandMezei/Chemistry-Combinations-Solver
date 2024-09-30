package combinations;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FilePrinter {
	
	private static final String DEFAULT_FILE_SAVE_NAME = "combinations.txt";
	private static final String SORTED_FILE_APPEND_NAME = "_sorted.txt";
	
	public static void createFiles(final ArrayList<ArrayList<String>> listOfSolutionsList) throws IOException {
		if (Frame.getFileSaveTextField() != null 
				&& Frame.getFileSaveTextField().getText() != null) {
			
			final String fileSavePath = "".equals(Frame.getFileSaveTextField().getText()) 
					? DEFAULT_FILE_SAVE_NAME 
					: Frame.getFileSaveTextField().getText() + ".txt";
			
			final FileWriter fileWriter = new FileWriter(fileSavePath.trim());
				
			int numberOfSolutions = 0;
			for (final ArrayList<String> list : listOfSolutionsList) {
				numberOfSolutions += list.size();
				for (final String s : list) {
					try {
						fileWriter.append(s);
					} catch (IOException ex) { 
						ex.printStackTrace();
					}
				}
			}
			
			createSortFile(fileSavePath, listOfSolutionsList, DataPopulator.getWeights());
		
			System.out.println("Number of solutions: " + numberOfSolutions); 
			
			fileWriter.close();
		}	
	}
		
	private static void createSortFile(final String fileSavePath,
								 final ArrayList<ArrayList<String>> listOfSolutionsList,
								 final List<String> weights) throws IOException {
		final boolean isThereAComponentSelectedToSort = !"".equals(CombinationsCalculator.getCOMPONENT_TO_SORT());
		if (isThereAComponentSelectedToSort) {
			// combinations.txt
			String fileSavePath2 = fileSavePath.substring(0, fileSavePath.length() - 4);
			fileSavePath2 += SORTED_FILE_APPEND_NAME;
			final FileWriter fileWriter2 = new FileWriter(fileSavePath2);
			
			final ArrayList<String> allSolutions = new ArrayList<String>();
			for (ArrayList<String> solutionsList : listOfSolutionsList) {
				for (String solution : solutionsList) {
					allSolutions.add(solution);
				}
			}
			
			sortList(allSolutions);
			
			for (final String solution : allSolutions) {
				try {
					fileWriter2.append(solution);
				} catch (IOException ex) { 
					ex.printStackTrace();
				}
			}
			
			fileWriter2.close();
		}
}
	
	private static void sortList(final ArrayList<String> solutionsList) {
		Collections.sort(solutionsList, new Comparator<String>() {
		    @Override
		    public int compare(String s1, String s2) {
		    	
		    	boolean s1ContainsSortComponent = s1.contains(CombinationsCalculator.getCOMPONENT_TO_SORT());
		    	boolean s2ContainsSortComponent = s2.contains(CombinationsCalculator.getCOMPONENT_TO_SORT());	
		    	if (s1ContainsSortComponent 
		    			&& !s2ContainsSortComponent) {
		    		return -1; // sort largest to smallest. opposite would be return 1
		    		
		    	} else if (!s1ContainsSortComponent 
		    			&& s2ContainsSortComponent) {
		    		return 1; // sort largest to smallest. opposite would be return -1
		    		
		    	} else if (!s1ContainsSortComponent 
		    			&& !s2ContainsSortComponent) {
		    		return 0;
		    		
		    	} else {
	    			final Integer s1CountInt = getCount2(s1);
					final Integer s2CountInt = getCount2(s2);
					
					// largest to smallest. opposite would be s1CountInt.compareTo(s2CountInt)
			        return s2CountInt.compareTo(s1CountInt);
		    
		    	}
		    }
	
		    private Integer getCount2(final String solution) {		    	
		    	String count = "";
		    	final int componentIndex = solution.indexOf(CombinationsCalculator.getCOMPONENT_TO_SORT());
		    	
		    	int countIndex = componentIndex + CombinationsCalculator.getCOMPONENT_TO_SORT().length() + 1;
		    	while (countIndex < solution.length()) {
		    		char c = solution.charAt(countIndex);
		    		if (Character.isDigit(c)) {
		    			count += c;
		    		} else {
		    			break;
		    		}
		    		countIndex++;
		    	}
		     	
		    	return Integer.parseInt(count);
			}
		});
	}
}
