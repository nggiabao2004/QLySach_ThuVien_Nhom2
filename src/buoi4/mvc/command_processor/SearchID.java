package buoi4.mvc.command_processor;

import java.sql.SQLException;

import buoi4.mvc.CalculatorModel;

public class SearchID extends Command{
    String IDSach ; 
    public SearchID(CalculatorModel calculatorModelRemote, String IDSach)
    {
        super(calculatorModelRemote);
        this.IDSach = IDSach;
    }

    @Override
    public void execute() {
        try {
            calculatorModelRemote.searchIDBook(IDSach);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
