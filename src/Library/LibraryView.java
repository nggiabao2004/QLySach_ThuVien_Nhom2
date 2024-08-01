package Library;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Vector;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class LibraryView extends JFrame{
    private JPanel jPanelRemote;
    private JLabel jLabelInPutIDSach, jLabelInputNgayNhap, jLabelInputDonGia, jLabelInputSoLuong, jLabelInputNhaXuatBan, jLabelInputTinhTrang, jLabelInputThue;
    private JTextField jTextFieldIDSach, jTextFieldNgayNhap, jTextFieldDonGia, jTextFieldSoLuong, jTextFieldNhaXuatBan, jTextFieldTinhTrang, jTextFieldThue;
    DefaultTableModel dtm;
    JTable tb;
    private JButton btnAdd, btnUpdate, btnDelete, btnSearch, btnExit;
    private LibraryModel libraryModelRemote;
    private MenuController menuControllerRemote;

    LibraryView(){
        buildPanel();
        buildMenu();

        libraryModelRemote = new LibraryModel();
        

        add(jPanelRemote);
        setTitle("QUẢN LÍ SÁCH THƯ VIỆN");
        setSize(1000, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }


    public void buildPanel(){
        jPanelRemote = new JPanel();
       
        
        
        jLabelInPutIDSach = new JLabel("ID Sách");
        jTextFieldIDSach = new JTextField(20);
        jPanelRemote.add(jLabelInPutIDSach);
        jPanelRemote.add(jTextFieldIDSach);

        jLabelInputNgayNhap = new JLabel("Ngày Nhập");
        jTextFieldNgayNhap = new JTextField(20);
        jPanelRemote.add(jLabelInputNgayNhap);
        jPanelRemote.add(jTextFieldNgayNhap);

        jLabelInputDonGia = new JLabel("Đơn Giá");
        jTextFieldDonGia = new JTextField(20);
        jPanelRemote.add(jLabelInputDonGia);
        jPanelRemote.add(jTextFieldDonGia);

        jLabelInputSoLuong = new JLabel("Số Lượng");
        jTextFieldSoLuong = new JTextField(20);
        jPanelRemote.add(jLabelInputSoLuong);
        jPanelRemote.add(jTextFieldSoLuong);

        jLabelInputNhaXuatBan = new JLabel("Nhà Xuất Bản");
        jTextFieldNhaXuatBan = new JTextField(20);
        jPanelRemote.add(jLabelInputNhaXuatBan);
        jPanelRemote.add(jTextFieldNhaXuatBan);

        jLabelInputTinhTrang = new JLabel("Tình Trạng");
        jTextFieldTinhTrang = new JTextField(20);
        jPanelRemote.add(jLabelInputTinhTrang);
        jPanelRemote.add(jTextFieldTinhTrang);

        jLabelInputThue = new JLabel("Thuế");
        jTextFieldThue = new JTextField(20);
        jPanelRemote.add(jLabelInputThue);
        jPanelRemote.add(jTextFieldThue);

        jPanelRemote.setBounds(10,122,414,284);
        
        dtm = new DefaultTableModel();
        dtm.addColumn("ID Sách");
        dtm.addColumn("Ngày Nhập");
        dtm.addColumn("Đơn Giá");
        dtm.addColumn("Số Lượng");
        dtm.addColumn("Nhà Xuất Bản");
        dtm.addColumn("Tình Trạng");
        dtm.addColumn("Thuế");

        tb = new JTable(dtm);

        // Tạo thanh cuộn cho bảng
        JScrollPane sc = new JScrollPane(tb, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        sc.setBounds(10, 220, 960, 330);
        jPanelRemote.add(sc);

        btnAdd = new JButton("Thêm");
        btnAdd.setBounds(300, 10, 80, 25);
        jPanelRemote.add(btnAdd);

        btnUpdate = new JButton("Sửa");
        btnUpdate.setBounds(300, 40, 80, 25);
        jPanelRemote.add(btnUpdate);

        btnDelete = new JButton("Xóa");
        btnDelete.setBounds(300, 70, 80, 25);
        jPanelRemote.add(btnDelete);

        btnSearch = new JButton("Tìm Kiếm");
        btnSearch.setBounds(300, 100, 80, 25);
        jPanelRemote.add(btnSearch);

        btnExit = new JButton("Exit");
        btnSearch.setBounds(300, 100, 80, 25);
        jPanelRemote.add(btnExit);
        btnExit.addActionListener(menuControllerRemote);

    }

    public void buildMenu(){
        
    }

     class MenuController implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            //Command commandRemote = null;
            if(command.equals("Thêm")) {
                
                // commandRemote = new C2FCommand(calculatorModelRemote, num1);
                // commandProcessorRemote.execute(commandRemote);
    
            }else if (command.equals("Sửa")) {

                // commandRemote = new F2CCommand(calculatorModelRemote, num2);
                // commandProcessorRemote.execute(commandRemote);
               
            }else if (command.equals("Xóa")) {

                
               
            }else if (command.equals("Tìm Kiếm")) {

                
               
            }else if (command.equals("Exit")) {
                libraryModelRemote.exit();
            }
        }
    } 

    
}
