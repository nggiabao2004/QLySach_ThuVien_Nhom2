package buoi4.mvc.command_processor;

import java.sql.SQLException;

import buoi4.mvc.CalculatorModel;

public class DelBookCommand extends Command{
    String IDSach;
    public DelBookCommand(CalculatorModel calculatorModelRemote, String IDSach){
        super(calculatorModelRemote);
        this.IDSach = IDSach;
    }
    
    
    @Override
    public void execute() {
        // TODO Auto-generated method stub
        try {
            calculatorModelRemote.delbook(IDSach);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
