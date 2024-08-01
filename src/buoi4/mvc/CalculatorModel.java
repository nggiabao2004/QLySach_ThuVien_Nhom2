package buoi4.mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import buoi4.mvc.observer.Publisher;

public class CalculatorModel extends Publisher  {
    private double result;
    double thanhTien = 0;

    public void upDatebook(String IDSach,String NgayNhap, String DonGia, String SoLuong, String NhaXuatBan, String TinhTrang, String Thue) throws ClassNotFoundException, SQLException{
        //1. kết nối CSDL
         String user = "root";
         String url = "jdbc:mysql://localhost:3306/SachThuVien";
         String password = "khoa1601";
         Connection connection = null;
         Statement statementRemote = null;
         //1. KẾT NỐI ĐẾN MYSQL - db221407
         //nạp driver vào chương trình
         Class.forName("com.mysql.cj.jdbc.Driver");
 
         //tạo kết nối đến db221407
         connection = DriverManager.getConnection(url, user, password);
 
         //2. truy vấn
         String sql = "UPDATE SACH SET NgayNhap ='"+NgayNhap+"', DonGia = '"+DonGia+"', SoLuong = '"+SoLuong+"', NhaXuatBan = N'"+NhaXuatBan+"', TinhTrang = N'"+TinhTrang+"', Thue = '"+Thue+"' WHERE IDSach = N'"+IDSach+"'";
         statementRemote = connection.createStatement();
         //thực thi
         int rowCount = statementRemote.executeUpdate(sql);
 
         System.out.println("Row count affected is: " + rowCount);
 
         connection.close();
     }

    public void delbook(String IDSach) throws ClassNotFoundException, SQLException{
        //1. kết nối CSDL
         String user = "root";
         String url = "jdbc:mysql://localhost:3306/SachThuVien";
         String password = "khoa1601";
         Connection connection = null;
         Statement statementRemote = null;
         //1. KẾT NỐI ĐẾN MYSQL - db221407
         //nạp driver vào chương trình
         Class.forName("com.mysql.cj.jdbc.Driver");
 
         //tạo kết nối đến db221407
         connection = DriverManager.getConnection(url, user, password);
 
         //2. truy vấn
         String sql = "DELETE FROM SACH WHERE IDSach = N'"+IDSach+"'";
         statementRemote = connection.createStatement();
         //thực thi
         int rowCount = statementRemote.executeUpdate(sql);
 
         System.out.println("Row count affected is: " + rowCount);
 
         connection.close();
     }

    public void addbook(String IDSach,String NgayNhap, String DonGia, String SoLuong, String NhaXuatBan, String TinhTrang, String Thue) throws ClassNotFoundException, SQLException{
       //1. kết nối CSDL
        String user = "root";
        String url = "jdbc:mysql://localhost:3306/SachThuVien";
        String password = "khoa1601";
        Connection connection = null;
        Statement statementRemote = null;
        //1. KẾT NỐI ĐẾN MYSQL - db221407
        //nạp driver vào chương trình
        Class.forName("com.mysql.cj.jdbc.Driver");

        //tạo kết nối đến db221407
        connection = DriverManager.getConnection(url, user, password);

        //2. truy vấn
        String sql = "INSERT INTO SACH VALUES(N'"+IDSach+"', '"+NgayNhap+"', '"+DonGia+"','"+SoLuong+"',N'"+NhaXuatBan+"', N'"+TinhTrang+"', '"+Thue+"')";
        statementRemote = connection.createStatement();
        //thực thi
        int rowCount = statementRemote.executeUpdate(sql);

        System.out.println("Row count affected is: " + rowCount);

        connection.close();
    }

    public void searchAllList()throws ClassNotFoundException, SQLException{
        String user = "root";
        String url = "jdbc:mysql://localhost:3306/SachThuVien";
        String password = "khoa1601";
        Connection connection = null;
        Statement statementRemote = null;
        ResultSet rsRemote = null;
        //1. KẾT NỐI ĐẾN MYSQL - db221407
        //nạp driver vào chương trình
        Class.forName("com.mysql.cj.jdbc.Driver");

        //tạo kết nối đến db221407
        connection = DriverManager.getConnection(url, user, password);

        System.out.println(connection.toString());

        //TRUY VẤN
        String sql = " select * from SACH";

        //statement
        statementRemote = connection.createStatement();

        //thực thi câu query
        rsRemote = statementRemote.executeQuery(sql);

        // //in danh sách nhân viên ra màn hình
        // while (rsRemote.next()) {
        //     // int empId = rsRemote.getInt(1);
        //     // String empNo = rsRemote.getString(2);
        //     // String empName = rsRemote.getString("Emp_Name");
        //     // System.out.println("--------------------");
        //     // System.out.println("EmpId:" + empId);
        //     // System.out.println("EmpNo:" + empNo);
        //     // System.out.println("EmpName:" + empName);

        //     String idSach = rsRemote.getString(1);
        //     String ngayNhap = rsRemote.getString(2);
        //     String donGia = rsRemote.getString(3);
        //     String soLuong = rsRemote.getString(4);

        //     System.out.println("--------------------");
        //     System.out.println("Mã Sách" + idSach);
        //     System.out.println("Ngày Nhập" + ngayNhap);
        //     System.err.println("Đơn Giá" + donGia);
        //     System.out.println("Số Lượng" + soLuong);

        // }
        // connection.close();

        // Tạo mô hình bảng
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Mã Sách");
        model.addColumn("Ngày Nhập");
        model.addColumn("Đơn Giá");
        model.addColumn("Số Lượng");
        model.addColumn("Nhà Xuất Bản");
        model.addColumn("Tình Trạng");
        model.addColumn("Thuế");


        // Đọc dữ liệu từ ResultSet và thêm vào mô hình bảng
        while (rsRemote.next()) {
            String idSach = rsRemote.getString(1);
            String ngayNhap = rsRemote.getString(2);
            String donGia = rsRemote.getString(3);
            String soLuong = rsRemote.getString(4);
            String NhaXuatBan = rsRemote.getString(5);
            String TinhTrang = rsRemote.getString(6);
            String Thue = rsRemote.getString(7);
            model.addRow(new Object[]{idSach, ngayNhap, donGia, soLuong, NhaXuatBan, TinhTrang,Thue});
        }

        // Đóng kết nối
        connection.close();

        // Tạo JTable và thiết lập mô hình bảng
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        // Tạo JFrame và thêm JScrollPane chứa JTable vào JFrame
        JFrame frame = new JFrame("Danh Sách Sách Hiện Có");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(scrollPane);
        frame.setSize(800, 400);
        frame.setVisible(true);
    }

    public void searchIDBook(String IDSach)throws ClassNotFoundException, SQLException{
        String user = "root";
        String url = "jdbc:mysql://localhost:3306/SachThuVien";
        String password = "khoa1601";
        Connection connection = null;
        Statement statementRemote = null;
        ResultSet rsRemote = null;
        //1. KẾT NỐI ĐẾN MYSQL - db221407
        //nạp driver vào chương trình
        Class.forName("com.mysql.cj.jdbc.Driver");

        //tạo kết nối đến db221407
        connection = DriverManager.getConnection(url, user, password);

        System.out.println(connection.toString());

        //TRUY VẤN
        String sql = " select * from SACH WHERE IDSach = '"+IDSach+"'";

        //statement
        statementRemote = connection.createStatement();

        //thực thi câu query
        rsRemote = statementRemote.executeQuery(sql);

        // Tạo mô hình bảng
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Mã Sách");
        model.addColumn("Ngày Nhập");
        model.addColumn("Đơn Giá");
        model.addColumn("Số Lượng");
        model.addColumn("Nhà Xuất Bản");
        model.addColumn("Tình Trạng");
        model.addColumn("Thuế");


        // Đọc dữ liệu từ ResultSet và thêm vào mô hình bảng
        while (rsRemote.next()) {
            String idSach = rsRemote.getString(1);
            String ngayNhap = rsRemote.getString(2);
            String donGia = rsRemote.getString(3);
            String soLuong = rsRemote.getString(4);
            String NhaXuatBan = rsRemote.getString(5);
            String TinhTrang = rsRemote.getString(6);
            String Thue = rsRemote.getString(7);
            model.addRow(new Object[]{idSach, ngayNhap, donGia, soLuong, NhaXuatBan, TinhTrang,Thue});
        }

        // Đóng kết nối
        connection.close();

        // Tạo JTable và thiết lập mô hình bảng
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        // Tạo JFrame và thêm JScrollPane chứa JTable vào JFrame
        JFrame frame = new JFrame("Danh Sách Sách Hiện Có");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(scrollPane);
        frame.setSize(800, 400);
        frame.setVisible(true);
    }

    public void searchPublisher(String NhaXuatban)throws ClassNotFoundException, SQLException{
        String user = "root";
        String url = "jdbc:mysql://localhost:3306/SachThuVien";
        String password = "khoa1601";
        Connection connection = null;
        Statement statementRemote = null;
        ResultSet rsRemote = null;
        //1. KẾT NỐI ĐẾN MYSQL - db221407
        //nạp driver vào chương trình
        Class.forName("com.mysql.cj.jdbc.Driver");

        //tạo kết nối đến db221407
        connection = DriverManager.getConnection(url, user, password);

        System.out.println(connection.toString());

        //TRUY VẤN
        String sql = "Select * from SACH WHERE NhaXuatBan = N'"+NhaXuatban+"'";

        //statement
        statementRemote = connection.createStatement();

        //thực thi câu query
        rsRemote = statementRemote.executeQuery(sql);

        // Tạo mô hình bảng
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Mã Sách");
        model.addColumn("Ngày Nhập");
        model.addColumn("Đơn Giá");
        model.addColumn("Số Lượng");
        model.addColumn("Nhà Xuất Bản");
        model.addColumn("Tình Trạng");
        model.addColumn("Thuế");


        // Đọc dữ liệu từ ResultSet và thêm vào mô hình bảng
        while (rsRemote.next()) {
            String idSach = rsRemote.getString(1);
            String ngayNhap = rsRemote.getString(2);
            String donGia = rsRemote.getString(3);
            String soLuong = rsRemote.getString(4);
            String NhaXuatBan = rsRemote.getString(5);
            String TinhTrang = rsRemote.getString(6);
            String Thue = rsRemote.getString(7);
            model.addRow(new Object[]{idSach, ngayNhap, donGia, soLuong, NhaXuatBan, TinhTrang,Thue});
        }

        // Đóng kết nối
        connection.close();

        // Tạo JTable và thiết lập mô hình bảng
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        // Tạo JFrame và thêm JScrollPane chứa JTable vào JFrame
        JFrame frame = new JFrame("Danh Sách Sách Hiện Có");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(scrollPane);
        frame.setSize(800, 400);
        frame.setVisible(true);
    }

    public double tinhThanhTien(String IDSach, String tinhTrang, String SoLuong,  String Thue) throws ClassNotFoundException, SQLException{
        String Gia = null;
        int soLuong = Integer.parseInt(SoLuong) ;
        int thue = Integer.parseInt(Thue);
        
        String user = "root";
        String url = "jdbc:mysql://localhost:3306/SachThuVien";
        String password = "khoa1601";
        Connection connection = null;
        Statement statementRemote = null;
        ResultSet rsRemote = null;
        //1. KẾT NỐI ĐẾN MYSQL - db221407
        //nạp driver vào chương trình
        Class.forName("com.mysql.cj.jdbc.Driver");

        //tạo kết nối đến db221407
        connection = DriverManager.getConnection(url, user, password);

        System.out.println(connection.toString());

        //TRUY VẤN
        String sql = "SELECT SACH.DonGia FROM SACH WHERE IDSach = N'"+IDSach+"'";

        //statement
        statementRemote = connection.createStatement();

        //thực thi câu query
        rsRemote = statementRemote.executeQuery(sql);
        if (rsRemote.next()) {
            Gia = rsRemote.getString("DonGia");
        }
        int donGia = Integer.parseInt(Gia);

        if ("Sách Mới".equalsIgnoreCase(tinhTrang)) {
                thanhTien = soLuong * donGia;
        } else if ("Sách Cũ".equalsIgnoreCase(tinhTrang)) {
                thanhTien = soLuong * donGia * 0.5;
            }
        else if ("Sách Tham Khảo".equalsIgnoreCase(tinhTrang)) {
            thanhTien = soLuong * donGia + thue;
        }
        
        changeState();
        return thanhTien;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void c2f(double c) {
        this.result = (9.0/5 * (c)) + 32;
        changeState();
    }

    public void f2c(double f) {
        this.result = 5.0/9 * (f - 32);
        changeState();
    }

    public double getResult() {
        return result;
    }

    public void exit() {
        System.exit(0);
    }

    private void changeState() {
        notifySubcribers();//thừa kế từ cha tao
    }

}
