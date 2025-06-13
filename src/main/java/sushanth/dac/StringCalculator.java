package sushanth.dac;

public class StringCalculator {
    public String input;
    public StringCalculator() {
        this.input = "";

    }
    public String parseInput(String input) {


       Integer num = 0;
       num =Integer.parseInt(input);
       return num.toString();


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
