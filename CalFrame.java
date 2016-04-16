import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
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

    private Service calService = new Service();
    public void init()
    {
        JPanel otherBtnPanel = new JPanel(); 
        otherBtnPanel.setLayout(new GridLayout(4,5));
        otherBtnPanel.add(num7Btn);    num7Btn.addActionListener(new CalListener());
        otherBtnPanel.add(num8Btn);    num8Btn.addActionListener(new CalListener());
        otherBtnPanel.add(num9Btn);    num9Btn.addActionListener(new CalListener()); 
        otherBtnPanel.add(opDivBtn);   opDivBtn.addActionListener(new CalListener());
        otherBtnPanel.add(opSqrtBtn);  opSqrtBtn.addActionListener(new CalListener());
        otherBtnPanel.add(num4Btn);    num4Btn.addActionListener(new CalListener());
        otherBtnPanel.add(num5Btn);    num5Btn.addActionListener(new CalListener());
        otherBtnPanel.add(num6Btn);    num6Btn.addActionListener(new CalListener());
        otherBtnPanel.add(opMulBtn);   opMulBtn.addActionListener(new CalListener());
        otherBtnPanel.add(opModBtn);   opModBtn.addActionListener(new CalListener());
        otherBtnPanel.add(num1Btn);    num1Btn.addActionListener(new CalListener());
        otherBtnPanel.add(num2Btn);    num2Btn.addActionListener(new CalListener());
        otherBtnPanel.add(num3Btn);    num3Btn.addActionListener(new CalListener());
        otherBtnPanel.add(opSubBtn);   opSubBtn.addActionListener(new CalListener());
        otherBtnPanel.add(opInveBtn);  opInveBtn.addActionListener(new CalListener());
        otherBtnPanel.add(num0Btn);    num0Btn.addActionListener(new CalListener());
        otherBtnPanel.add(opSignBtn);  opSignBtn.addActionListener(new CalListener());
        otherBtnPanel.add(numPtBtn);   numPtBtn.addActionListener(new CalListener());
        otherBtnPanel.add(opAddBtn);   opAddBtn.addActionListener(new CalListener());
        otherBtnPanel.add(opEqlBtn);   opEqlBtn.addActionListener(new CalListener());

        JPanel resultBtnPanel = new JPanel();
        resultBtnPanel.setLayout(new GridLayout(1,3));
        resultBtnPanel.add(funBackBtn); funBackBtn.addActionListener(new CalListener());
        resultBtnPanel.add(funCeBtn);   funCeBtn.addActionListener(new CalListener());
        resultBtnPanel.add(funCBtn);    funCBtn.addActionListener(new CalListener());

        JPanel centrePanel = new JPanel();
        centrePanel.setLayout(new BorderLayout());
        centrePanel.add(resultBtnPanel, BorderLayout.NORTH);
        centrePanel.add(otherBtnPanel, BorderLayout.CENTER);

        JPanel westPanel = new JPanel();
        westPanel.setLayout(new GridLayout(4,1));
        westPanel.add(funMcBtn);  funMcBtn.addActionListener(new CalListener());
        westPanel.add(funMrBtn);  funMrBtn.addActionListener(new CalListener());
        westPanel.add(funMsBtn);  funMsBtn.addActionListener(new CalListener());
        westPanel.add(funMpBtn);  funMpBtn.addActionListener(new CalListener());

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
    
    //inner class
    class CalListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            //clear error cmd before next operation
            if(screenFld.getText().equals("cmd not found") ||
                screenFld.getText().equals("math error"))
            {
                screenFld.setText("");
            }

            String command = ((JButton)e.getSource()).getActionCommand();
            String text = screenFld.getText();
            String result = calService.callMethod(command, text);
            screenFld.setText(result);
            System.out.println("Active button: "+command);
        }
    }

    public static void main(String[] args)
    {
        new CalFrame().init();
    }
}
