import java.math.BigDecimal;
import static java.lang.System.out;
class Service
{
    //basic format: firstOperand + secondOperand = result 
    private boolean isSecond = false; //check whether we are filling the secondOperand
    private String fstOp;
    private String opSign; //operational sign
    private String lastOp; //lastOperation excuted in the system

    String callMethod(String cmd, String text)
    {
        switch(cmd)
        {
            case "1": case "2": case "3": case "4": case "5":
            case "6": case "7": case "8": case "9": case "0":
                if(lastOp == "=" || 
                    lastOp == "+" || 
                    lastOp == "-" || 
                    lastOp == "*" || 
                    lastOp == "/" )
                {
                    out.println("enter clear");
                    text = clear();
                }
                System.out.println("last cmd "+lastOp);
                setLastOp(cmd);
                return append(cmd,text);

            case "C": 
                setLastOp(cmd);
                return clear();

            case "+/-": 
                setLastOp(cmd);
                return setSign(text);

            case "sqrt": 
                setLastOp(cmd);
                if(isSecond == false)
                {
                    return getSqrt(text);
                }
                else return "math error";

            case "+": case "-": case "*": case "/":
                    setLastOp(cmd);
                    if(isSecond == false)
                    {
                        isSecond = true;
                        setOpSign(cmd);
                        setFstOp(text);
                        return fstOp; 
                    }
                    if(fstOp != null) //accumulate calculation
                    {
                        setFstOp(basicCal(opSign, fstOp, text));
                        return fstOp;
                    }
                    else return "enter a number before: "+text;

            case "%": 
                    setLastOp(cmd);
                    return getPercent(text);
                    
            case "=": 
                    setLastOp(cmd);
                    if(isSecond == true)
                      {
                          isSecond = false;
                          String result = basicCal(opSign, fstOp, text);
                          setFstOp("");
                          setOpSign("");
                          return result;
                      }
                      else
                          return "math error";

            case "Back": 
                    setLastOp(cmd);
                    return backSpace(text);

            case "CE":
                    setLastOp(cmd);
                    setFstOp("");
                    setSign("");
                    isSecond = false;
                    return clear();
        }
        return "cmd not found";
    }

    String basicCal(String cmd, String strFst, String strSnd)
    {
        double fst = Double.parseDouble(strFst);
        double snd = Double.parseDouble(strSnd);
        double result = 0;
        switch(cmd)
        {
            case "+" : result = MathTool.jia(fst, snd);
                       return Double.toString(result);

            case "-" : result = MathTool.jian(fst, snd);
                       return Double.toString(result);
                       
            case "*" : result = MathTool.cheng(fst, snd);
                       return Double.toString(result);
            case "/" : 
                       if(snd != 0)
                       {
                           result = MathTool.chu(fst, snd);
                           return Double.toString(result);
                       }
                       else return "math error";

            default: return "math error";
        }
    }

    String backSpace(String text)
    {
        if(text.length() > 1)
        {
            return text.substring(0, text.length()-1);
        }
        else 
        {
            return "";
        }
    }

    String clear()
    {
        return "";
    }

    String append(String cmd, String text)
    {
        return text + cmd;
    }

    String setSign(String text)
    {
        if(text.length() > 0)
        {
            if(text.charAt(0) != '-')
            {
                return "-"+text;
            }

            else
            {
                return text.substring(1);
            }
        }
        return "";
    }

    String getSqrt(String text)
    {
        if(text.length() > 0)
        {
            Double num = Double.parseDouble(text);
            if(num > 1)
            {
                Double result = Math.sqrt(num);
                return result.toString();
            }
            else return "math error";
        }

        else return "";
    }

    String getPercent(String text)
    {
        if(text.length() > 0)
        {
            Double num = Double.parseDouble(text);
            Double result = num/100;
            return result.toString();
        }
        else return "math error";
    }

    public void setFstOp(String operand)
    {
        this.fstOp = operand;
    }

    public void setOpSign(String sign)
    {
        this.opSign = sign;
    }

    public void setLastOp(String operand)
    {
        this.lastOp = operand;
    }

    public static void main(String[] args)
    {
        Service s = new Service();
        String str1 = "14";
        String strjia = "+";
        String str3 = "14";
        String streql = "=";
        System.out.println(s.callMethod(strjia, str3));
        System.out.println(s.callMethod(streql,str1));
    }
}
