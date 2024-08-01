package buoi4.mvc.command_processor;

import java.sql.SQLException;

import buoi4.mvc.CalculatorModel;

public class TTienCommand extends Command {

    String IDSach, tinhTrang, SoLuong, Thue;
    public TTienCommand(CalculatorModel calculatorModelRemote, String IDSach, String tinhTrang, String SoLuong,  String Thue){
        super(calculatorModelRemote);
        this.IDSach = IDSach;
        this.tinhTrang = tinhTrang;
        this.SoLuong = SoLuong;
        this.Thue = Thue;
    }

    @Override
    public void execute() {
        try {
            calculatorModelRemote.tinhThanhTien(IDSach, tinhTrang, SoLuong, Thue);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
}
