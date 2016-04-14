import java.awt.*;
import javax.swing.*;
class CalFrame extends JFrame
{
    JButton num0Btn = new JButton("0");
    JButton num1Btn = new JButton("1");
    JButton num2Btn = new JButton("2");
    JButton num3Btn = new JButton("3");
    JButton num4Btn = new JButton("4");
    JButton num5Btn = new JButton("5");
    JButton num6Btn = new JButton("6");
    JButton num7Btn = new JButton("7");
    JButton num8Btn = new JButton("8");
    JButton num9Btn = new JButton("9");
    JButton num10Btn = new JButton("10");
    JButton numPtBtn = new JButton(".");

    JButton opAddBtn = new JButton("+");
    JButton opSubBtn = new JButton("-");
    JButton opMulBtn = new JButton("*");
    JButton opDivBtn = new JButton("/");

    JButton opSqrtBtn = new JButton("sqrt");
    JButton opModBtn = new JButton("%");
    JButton opInveBtn = new JButton("1/x");
    JButton opEqlBtn = new JButton("=");
    JButton opSignBtn = new JButton("+/-");
    
    JButton funMcBtn = new JButton("MC");
    JButton funMrBtn = new JButton("MR");
    JButton funMsBtn = new JButton("MS");
    JButton funMpBtn = new JButton("M+");

    JButton funBackBtn = new JButton("Back");
    JButton funCeBtn = new JButton("CE");
    JButton funCBtn = new JButton("C");

    JTextField screenFld = new JTextField(10);
    public void init()
    {
        JPanel otherBtnPanel = new JPanel(); 
        otherBtnPanel.setLayout(new GridLayout(4,5));
        otherBtnPanel.add(num7Btn); 
        otherBtnPanel.add(num8Btn); 
        otherBtnPanel.add(num9Btn); 
        otherBtnPanel.add(opDivBtn); 
        otherBtnPanel.add(opSqrtBtn); 
        otherBtnPanel.add(num4Btn); 
        otherBtnPanel.add(num5Btn); 
        otherBtnPanel.add(num6Btn); 
        otherBtnPanel.add(opMulBtn); 
        otherBtnPanel.add(opModBtn); 
        otherBtnPanel.add(num1Btn); 
        otherBtnPanel.add(num2Btn); 
        otherBtnPanel.add(num3Btn); 
        otherBtnPanel.add(opSubBtn); 
        otherBtnPanel.add(opInveBtn); 
        otherBtnPanel.add(num0Btn); 
        otherBtnPanel.add(opSignBtn); 
        otherBtnPanel.add(numPtBtn); 
        otherBtnPanel.add(opAddBtn); 
        otherBtnPanel.add(opEqlBtn); 

        JPanel resultBtnPanel = new JPanel();
        resultBtnPanel.setLayout(new GridLayout(1,3));
        resultBtnPanel.add(funBackBtn);
        resultBtnPanel.add(funCeBtn);
        resultBtnPanel.add(funCBtn);

        JPanel centrePanel = new JPanel();
        centrePanel.setLayout(new BorderLayout());
        centrePanel.add(resultBtnPanel, BorderLayout.NORTH);
        centrePanel.add(otherBtnPanel, BorderLayout.CENTER);

        JPanel westPanel = new JPanel();
        westPanel.setLayout(new GridLayout(4,1));
        westPanel.add(funMcBtn);
        westPanel.add(funMrBtn);
        westPanel.add(funMsBtn);
        westPanel.add(funMpBtn);

        setLayout(new BorderLayout());
        add(centrePanel, BorderLayout.CENTER);
        add(westPanel, BorderLayout.WEST);
        add(screenFld, BorderLayout.NORTH);
        screenFld.setEditable(false);//text field is uneditable
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
    }   

    public static void main(String[] args)
    {
        new CalFrame().init();
    }
}
