package buoi4.mvc.command_processor;

import java.sql.SQLException;

import buoi4.mvc.CalculatorModel;

public class F2CCommand extends Command{
    private double f;
    String IDSach, NgayNhap,  DonGia,  SoLuong,  NhaXuatBan,  TinhTrang,  Thue;
    public F2CCommand(CalculatorModel calculatorModelRemote, String IDSach,String NgayNhap, String DonGia, String SoLuong, String NhaXuatBan, String TinhTrang, String Thue) {
        //gọi đến constructor của lớp cha (Command)
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
            calculatorModelRemote.addbook(IDSach,NgayNhap, DonGia, SoLuong, NhaXuatBan, TinhTrang, Thue );
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        };
    }
}
