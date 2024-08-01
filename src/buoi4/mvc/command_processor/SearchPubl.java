package buoi4.mvc.command_processor;

import java.sql.SQLException;

import buoi4.mvc.CalculatorModel;

public class SearchPubl extends Command{
    String NhaXuatBan;
    public SearchPubl(CalculatorModel calculatorModelRemote, String NhaXuatBan){
        super(calculatorModelRemote);
        this.NhaXuatBan = NhaXuatBan;

    }

    @Override
    public void execute() {
        try {
            calculatorModelRemote.searchPublisher(NhaXuatBan);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
