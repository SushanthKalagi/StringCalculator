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
        Integer sum = 0;
         if(input.contains(",")) {
             String[] numbers = input.split(",");

             for (String number : numbers) {
                 sum += Integer.parseInt(number);
             }

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
