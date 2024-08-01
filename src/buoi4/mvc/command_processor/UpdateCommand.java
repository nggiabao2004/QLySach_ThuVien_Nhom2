package buoi4.mvc.command_processor;

import java.sql.SQLException;

import buoi4.mvc.CalculatorModel;

public class UpdateCommand extends Command{
    String IDSach, NgayNhap,  DonGia,  SoLuong,  NhaXuatBan,  TinhTrang,  Thue;
    public UpdateCommand(CalculatorModel calculatorModelRemote, String IDSach,String NgayNhap, String DonGia, String SoLuong, String NhaXuatBan, String TinhTrang, String Thue){
        super(calculatorModelRemote);
        this.IDSach = IDSach;
        this.NgayNhap = NgayNhap;
        this.DonGia = DonGia;
        this.SoLuong = SoLuong;
        this.NhaXuatBan = NhaXuatBan;
        this.TinhTrang = TinhTrang;
        this.Thue = Thue;         
    }

    @Override
    public void execute() {
        try {
            calculatorModelRemote.upDatebook(IDSach, NgayNhap, DonGia, SoLuong, NhaXuatBan, TinhTrang, Thue);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
