package buoi4.mvc.command_processor;

import java.sql.SQLException;

import buoi4.mvc.CalculatorModel;

public class C2FCommand extends Command {
    private double c;
    public C2FCommand(CalculatorModel calculatorModelRemote,
    double c) {
        super(calculatorModelRemote);
        this.c = c;
       
    }

    @Override
    public void execute() {
        try {
            calculatorModelRemote.searchAllList() ;
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
