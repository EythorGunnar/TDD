package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if (text == ("")) {
			return 0;
		}
		else if (text.contains(",")) {
			String [] allTheNumbers = text.split(",");
			int sum = 0;
			for (int x = 0; x < allTheNumbers.length; x++) {
				sum += Integer.parseInt(allTheNumbers[x]);
			}
			return sum;
		}
		else;
			return Integer.parseInt(text);
	}
}