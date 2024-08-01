package buoi4.mvc.command_processor;

import buoi4.mvc.CalculatorModel;

// lớp trừu tượng 
public abstract class Command {
    //field
    protected CalculatorModel calculatorModelRemote = null;

    //method

    public Command(CalculatorModel calculatorModelRemote){
        this.calculatorModelRemote = calculatorModelRemote;
    }
    //Phương thức trừu tượng không có thân hàm (body), chỉ định nghĩa (declaration) của phương thức mà các lớp con phải triển khai (implement).
    public abstract void execute();
    //Các lớp con của Command như C2FCommand và F2CCommand sẽ phải cung cấp triển khai cụ thể cho phương thức execute, để chỉ định hành động cụ thể mà lệnh đó thực hiện khi được gọi.
}
