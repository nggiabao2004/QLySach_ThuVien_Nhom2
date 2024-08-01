import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TestTable {
     public void searchAllList() throws ClassNotFoundException, SQLException {
        String user = "root";
        String url = "jdbc:mysql://localhost:3306/SachThuVien";
        String password = "khoa1601";
        Connection connection = null;
        Statement statementRemote = null;
        ResultSet rsRemote = null;

        // KẾT NỐI ĐẾN MYSQL - db221407
        // nạp driver vào chương trình
        Class.forName("com.mysql.cj.jdbc.Driver");

        // tạo kết nối đến db221407
        connection = DriverManager.getConnection(url, user, password);

        System.out.println(connection.toString());

        // TRUY VẤN
        String sql = "SELECT SACH.IDSach, SACH.NgayNhap, SACH.DonGia, SACH.SoLuong FROM SACH";

        // statement
        statementRemote = connection.createStatement();

        // thực thi câu query
        rsRemote = statementRemote.executeQuery(sql);

        // Tạo mô hình bảng
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Mã Sách");
        model.addColumn("Ngày Nhập");
        model.addColumn("Đơn Giá");
        model.addColumn("Số Lượng");

        // Đọc dữ liệu từ ResultSet và thêm vào mô hình bảng
        while (rsRemote.next()) {
            String idSach = rsRemote.getString(1);
            String ngayNhap = rsRemote.getString(2);
            String donGia = rsRemote.getString(3);
            String soLuong = rsRemote.getString(4);
            model.addRow(new Object[]{idSach, ngayNhap, donGia, soLuong});
        }

        // Đóng kết nối
        connection.close();

        // Tạo JTable và thiết lập mô hình bảng
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        // Tạo JFrame và thêm JScrollPane chứa JTable vào JFrame
        JFrame frame = new JFrame("Danh sách sách");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(scrollPane);
        frame.setSize(800, 400);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        try {
            new TestTable().searchAllList();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
