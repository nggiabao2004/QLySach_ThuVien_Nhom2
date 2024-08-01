package buoi4.mvc;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Library.Sach;
import buoi4.mvc.command_processor.C2FCommand;
import buoi4.mvc.command_processor.Command;
import buoi4.mvc.command_processor.CommandProcessor;
import buoi4.mvc.command_processor.DelBookCommand;
import buoi4.mvc.command_processor.F2CCommand;
import buoi4.mvc.command_processor.SearchID;
import buoi4.mvc.command_processor.SearchPubl;
import buoi4.mvc.command_processor.TTienCommand;
import buoi4.mvc.command_processor.UpdateCommand;
import buoi4.mvc.observer.Subcriber;

public class CalcualtorView extends JFrame implements Subcriber
         {
    private JLabel jLabelInputRemote1, jLabelInputRemote2, jLabelOutputRemote, jLabelInputRemote3
    ,jLabelInputRemote4, jLabelInputRemote5, jLabelInputRemote6, jLabelInputRemote7;
    private JTextField jTextFieldInputRemote1, jTextFieldInputRemote2,  jTextFieldInputRemote3
    ,jTextFieldInputRemote4, jTextFieldInputRemote5, jTextFieldInputRemote6, jTextFieldInputRemote7;
    private JPanel jPanelRemote;
    private JButton addButtonRemote, subButtonRemote, delButtonRemote, upDButtonRemote,  searchBookButtonRemote,searchPubButtonRemote, TTButtonRemote ;
    private JMenuBar menuBarRemote = null;
    


    //private CalculatorController calculatorControlRemote;
    
    private MenuController menuControllerRemote = null;
    private EnterController enterControllerRemote = null;

    private CalculatorModel calculatorModelRemote;


    private CommandProcessor commandProcessorRemote = null;
    
    
    public void setCalculatorModelRemote(CalculatorModel calculatorModelRemote){
        this.calculatorModelRemote = calculatorModelRemote;
    }

    public void setCommandProcessorRemote(CommandProcessor commandProcessorRemote){
        this.commandProcessorRemote = commandProcessorRemote;
    }

    public JTextField setjTextFieldInputRemote1(){
        return jTextFieldInputRemote1;
    }

    CalcualtorView(CalculatorModel calculatorModelRemote) {
        this.calculatorModelRemote = calculatorModelRemote;
        //commandProcessorRemote = CommandProcessor.makeCommandProcessor();
        

        calculatorModelRemote.subcribe(this);

        //calculatorControlRemote = new CalculatorController();

        menuControllerRemote = new MenuController();

        
        enterControllerRemote = new EnterController();

        buildPanel();
        buildMenu();

        add(jPanelRemote);

        setTitle("Quản Lí Sách Thư Viện");
        setSize(950, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }

    public void buildPanel() {
        jPanelRemote = new JPanel();

        jLabelInputRemote1 = new JLabel("ID Sách");
        jTextFieldInputRemote1 = new JTextField(10);
        jTextFieldInputRemote1.addActionListener(enterControllerRemote);
        jPanelRemote.add(jLabelInputRemote1);
        jPanelRemote.add(jTextFieldInputRemote1);

        jLabelInputRemote2 = new JLabel("Ngày Nhập");
        jTextFieldInputRemote2 = new JTextField(10);
        jTextFieldInputRemote2.addActionListener(enterControllerRemote);
        jPanelRemote.add(jLabelInputRemote2);
        jPanelRemote.add(jTextFieldInputRemote2);

        jLabelInputRemote3 = new JLabel("Đơn Giá");
        jTextFieldInputRemote3 = new JTextField(10);
        jPanelRemote.add(jLabelInputRemote3);
        jPanelRemote.add(jTextFieldInputRemote3);

        jLabelInputRemote4 = new JLabel("Số Lượng");
        jTextFieldInputRemote4 = new JTextField(10);
        jPanelRemote.add(jLabelInputRemote4);
        jPanelRemote.add(jTextFieldInputRemote4);

        jLabelInputRemote5 = new JLabel("Nhà Xuất Bản");
        jTextFieldInputRemote5 = new JTextField(10);
        jPanelRemote.add(jLabelInputRemote5);
        jPanelRemote.add(jTextFieldInputRemote5);

        jLabelInputRemote6 = new JLabel("Tình Trạng");
        jTextFieldInputRemote6 = new JTextField(10);
        jPanelRemote.add(jLabelInputRemote6);
        jPanelRemote.add(jTextFieldInputRemote6);

        jLabelInputRemote7 = new JLabel("Thuế");
        jTextFieldInputRemote7 = new JTextField(10);
        jPanelRemote.add(jLabelInputRemote7);
        jPanelRemote.add(jTextFieldInputRemote7);

        jLabelOutputRemote = new JLabel("THÀNH TIỀN");
        jPanelRemote.add(jLabelOutputRemote);

        addButtonRemote = new JButton("Full List Book");
        addButtonRemote.addActionListener(menuControllerRemote);

        subButtonRemote = new JButton("Add New Book");
        subButtonRemote.addActionListener(menuControllerRemote);

        delButtonRemote = new JButton("Delete Book");
        delButtonRemote.addActionListener(menuControllerRemote);

        upDButtonRemote = new JButton("Update New Book");
        upDButtonRemote.addActionListener(menuControllerRemote);

        searchBookButtonRemote = new JButton("Search Book");
        searchBookButtonRemote.addActionListener(menuControllerRemote);

        searchPubButtonRemote = new JButton("Search Publisher");
        searchPubButtonRemote.addActionListener(menuControllerRemote);

        TTButtonRemote = new JButton("Thành Tiền");
        TTButtonRemote.addActionListener(menuControllerRemote);

        jPanelRemote.add(addButtonRemote);
        jPanelRemote.add(subButtonRemote);
        jPanelRemote.add(delButtonRemote);
        jPanelRemote.add(upDButtonRemote);
        jPanelRemote.add(searchBookButtonRemote);
        jPanelRemote.add(searchPubButtonRemote);
        jPanelRemote.add(TTButtonRemote);
    }

    public void buildMenu() {
        menuBarRemote = new JMenuBar();

        //đưa thanh Menu vào trong cửa sổ
        setJMenuBar(menuBarRemote);
        //Menu
        JMenu calcualtorMenuRemote = new JMenu("Menu");
        //đặt Menu vào trong Menu Bar
        menuBarRemote.add(calcualtorMenuRemote);
        //Menu Itm
        JMenuItem c2fMenuItemRemote = new JMenuItem("Full List Book");
        c2fMenuItemRemote.addActionListener(menuControllerRemote);
        //đặt item vào trong Menu
        calcualtorMenuRemote.add(c2fMenuItemRemote);

        JMenuItem f2cMenuItemRemote = new JMenuItem("Add New Book");
        f2cMenuItemRemote.addActionListener(menuControllerRemote);
        calcualtorMenuRemote.add(f2cMenuItemRemote);

        JMenuItem exitMenuItemRemote = new JMenuItem("EXIT");
        exitMenuItemRemote.addActionListener(menuControllerRemote);
        calcualtorMenuRemote.add(exitMenuItemRemote);
    }

    

    class MenuController implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            String IDSach = jTextFieldInputRemote1.getText();
            String NgayNhap = jTextFieldInputRemote2.getText(); 
            String DonGia= jTextFieldInputRemote3.getText();  
            String SoLuong= jTextFieldInputRemote4.getText(); 
            String NhaXuatBan= jTextFieldInputRemote5.getText();  
            String TinhTrang= jTextFieldInputRemote6.getText();  
            String Thue = jTextFieldInputRemote7.getText(); 
    
            Command commandRemote = null;


            if(command.equals("Full List Book")) {
                
                commandRemote = new C2FCommand(calculatorModelRemote, 2);
                commandProcessorRemote.execute(commandRemote);
    
            }else if (command.equals("Add New Book")) {

                
                commandRemote = new F2CCommand(calculatorModelRemote, IDSach,NgayNhap, DonGia, SoLuong, NhaXuatBan, TinhTrang, Thue);



                commandProcessorRemote.execute(commandRemote);
               
            }else if (command.equals("Delete Book")) {

                commandRemote = new DelBookCommand(calculatorModelRemote, IDSach);
                commandProcessorRemote.execute(commandRemote);
               
            }else if (command.equals("Update New Book")) {

                commandRemote = new UpdateCommand(calculatorModelRemote, IDSach,NgayNhap, DonGia, SoLuong, NhaXuatBan, TinhTrang, Thue);
                commandProcessorRemote.execute(commandRemote);
               
            }else if (command.equals("Search Book")) {

                commandRemote = new SearchID(calculatorModelRemote, IDSach);
                commandProcessorRemote.execute(commandRemote);
               
            }else if (command.equals("Search Publisher")) {

                commandRemote = new SearchPubl(calculatorModelRemote, NhaXuatBan);
                commandProcessorRemote.execute(commandRemote);
               
            }else if (command.equals("Thành Tiền")) {

                commandRemote = new TTienCommand(calculatorModelRemote, IDSach, TinhTrang,SoLuong, Thue);
                commandProcessorRemote.execute(commandRemote);
               
            }else if (command.equals("EXIT")) {
                calculatorModelRemote.exit();
            }
        }
    }

    class EnterController implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Command commandRemote = null;
            double f, c;
            String cmd = e.getActionCommand();
            String num = e.getActionCommand();

            if (num.equals(jTextFieldInputRemote2.getText())) {
                cmd = "f2c";
            } else if (num.equals(jTextFieldInputRemote1.getText())) {
                cmd = "c2f";
            }
            if (cmd.equals("f2c")) {
                f = Double.parseDouble(jTextFieldInputRemote2.getText());
                
                commandRemote = new F2CCommand(calculatorModelRemote, f);
                commandProcessorRemote.execute(commandRemote);

            } else if (cmd.equals("c2f")) {
                c = Double.parseDouble(jTextFieldInputRemote1.getText());
                commandRemote = new C2FCommand(calculatorModelRemote, c);
                commandProcessorRemote.execute(commandRemote);

            } else if (cmd.equals("exit")) {
                calculatorModelRemote.exit();
            }
        }
    }

    @Override
    public void update() {
        double result = calculatorModelRemote.getThanhTien();
        jLabelOutputRemote.setText("" + result);

    }
    
}
