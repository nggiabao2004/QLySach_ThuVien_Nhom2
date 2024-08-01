package buoi4.mvc;

import buoi4.mvc.command_processor.CommandProcessor;

public class CalculaltorWindowApp {

    public static void main(String[] args) {

        CalculatorModel calculatorModelRemote = new CalculatorModel();


        CommandProcessor commandProcessorRemote;
        commandProcessorRemote = CommandProcessor.makeCommandProcessor();


        CalcualtorView calcualtorViewRemote = new CalcualtorView(calculatorModelRemote);
       
        
        calcualtorViewRemote.setCommandProcessorRemote(commandProcessorRemote);
    } 

}