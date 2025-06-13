package sushanth.dac;

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

             // Initialize sum to 0
        Integer sum = 0;

             String[] numbers = input.split("[,\n]");

             for (String number : numbers) {
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
