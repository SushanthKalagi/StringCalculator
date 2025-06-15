package sushanth.dac;

import java.util.regex.Pattern;

public class StringCalculator {
    public String input;

    public StringCalculator() {
        this.input = "";

    }

    public int[] parseInput(String input) {


        if (input == null || input.isEmpty()) {
            int[] emptyArray = new int[1];
            emptyArray[0] = 0;
            return emptyArray;
        }
        if (input.endsWith(",")) {
            throw new NumberFormatException("Number expected but EOF found");
        }
        if (input.contains(",\n")) {
            throw new NumberFormatException("Number expected but '\\n' found");
        }
        String delimiter = "[,\n]";
        if (input.startsWith("//")) {
            int delimiterEnd = input.indexOf('\n');
            if (delimiterEnd == -1) {
                throw new NumberFormatException("Invalid custom delimiter format");
            }
            delimiter = Pattern.quote(input.substring(2, delimiterEnd));
            input = input.substring(delimiterEnd + 1);
        }

        // Initialize sum to 0
        Integer sum = 0;

        String[] numbers = input.split(delimiter);
        int[] result = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            // Check for negative numbers
            String number = numbers[i];
            if (number.startsWith("-")) {
                throw new NumberFormatException("Negative numbers are not allowed: " + number);
            }
            result[i] = Integer.parseInt(number);
        }


        return result;


    }

    public String getInput() {
        return input;
    }

    public String add() {

        if (input == "") {
            return "0";
        }
        int[] numbers = parseInput(input);
        int sum = 0;
        for (int n : numbers) {
            sum += n;
        }
        return String.valueOf(sum);

    }
    public String sub() {

        if (input == "") {
            return "0";
        }
        int[] numbers = parseInput(input);
        int sub = numbers[0];
        for (int i =1; i< numbers.length; i++) {
            sub -= numbers[i];
        }
        return String.valueOf(sub);

    }
}
