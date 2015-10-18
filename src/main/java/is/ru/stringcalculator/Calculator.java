package is.ru.stringcalculator;
import java.io.*;

public class Calculator {

	public static int add(String text) {
		if (text == ("")) {
			return 0;
		}
		else if (text.startsWith("//") || text.contains(",") || text.contains("\n")) {
			return total(text);
		}
		else {
			return toInt(text);
		}
	}

	private static int total(String input){
		//Get deliminator
		String deliminator = setDeliminator(input);

		//remove delimter definition from string
		if (input.startsWith("//")) {
			input = input.substring(4);
		}

		//Change the string into a string array, based on the deliminator
		String [] allTheNumbers = input.split(deliminator);
	
		
		//Loop through the array and find the sum of all integers
		int sum = 0;
		boolean includeNegatives = false;
		String errorMsg = "Negatives not allowed: ";

		for (int x = 0; x < allTheNumbers.length; x++) {
			if (toInt(allTheNumbers[x]) < 0){
				if (includeNegatives) {
					errorMsg += "," + allTheNumbers[x];
				}
				else {
					includeNegatives = true;
					errorMsg += allTheNumbers[x];
				}
			}
			else if (toInt(allTheNumbers[x]) > 1000){
				continue;
			}
			else {
				sum += toInt(allTheNumbers[x]);
			}

		}
		if (includeNegatives){
			throw new IllegalArgumentException(errorMsg);
		}
		return sum;
	}

	//Change string into int
	private static int toInt(String input){
		return Integer.parseInt(input);
	} 

	//Creates a Deliminator, if there is a custom one it replaces the default "," and "\n" deliminators
	private static String setDeliminator(String input){
		String deliminator = ",|\\\n";
		if (input.startsWith("//")) {
			deliminator = input.substring(2, input.indexOf("\n"));
		}
		return deliminator;
	}
}


