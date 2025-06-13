package sushanth.dac;

import java.util.regex.Pattern;

public class StringCalculator {
    public String input;
    public StringCalculator() {
        this.input = "";

    }
    public String parseInput(String input) {


         if(input == null || input.isEmpty()){
              return "0";
         }
         if(input.endsWith(",")){
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

             for (String number : numbers) {
                // Check for negative numbers
                 if(number.startsWith("-")) {
                     throw new NumberFormatException("Negative numbers are not allowed: " + number);
                 }
                 sum += Integer.parseInt(number);
             }


              return sum.toString();



    }
    public String getInput() {
        return input;
    }

    public String add(){

        if(input == ""){
            return "0";
        }
        else{
            return parseInput(input);
        }

    }
}
