import java.math.BigDecimal;
import static java.lang.System.out;
class Service
{
    /* basic format : firstOperand + secondOperand = result
     * isSecond     : check whether we are filling the secondOperand
     * fstOp        : operational sign
     * memoOp       : operand in the memory
     * lastOper     : lastOperation excuted in the system
     */
    private boolean isSecond = false;
    private String fstOp = ""; 
    private String memoOp = "0";
    private String opSign = "";
    private String lastOper = "";

    String callMethod(String cmd, String text)
    {
        switch(cmd)
        {
            case "1": case "2": case "3": case "4": case "5":
            case "6": case "7": case "8": case "9": case "0":
            case ".":
                    if(lastOper == "=" || 
                        lastOper == "+" || 
                        lastOper == "-" || 
                        lastOper == "*" || 
                        lastOper == "/" )
                    {
                        out.println("enter clear");
                        text = clear();
                    }
                    System.out.println("last cmd "+lastOper);
                    setLastOper(cmd);
                    return append(cmd,text);

            case "+": case "-": case "*": case "/":
                    setLastOper(cmd);
                    if(isSecond == false)
                    {
                        isSecond = true;
                        setOpSign(cmd);
                        setFstOp(text);
                        return fstOp; 
                    }
                    if(fstOp != null) //accumulate calculation
                    {
                        setFstOp(calBasic(opSign, fstOp, text));
                        return fstOp;
                    }
                    else return "enter a number before: "+text;

            case "+/-": 
                    setLastOper(cmd);
                    return setSign(text);

            case "sqrt": 
                    setLastOper(cmd);
                    if(isSecond == false)
                    {
                        return calSqrt(text);
                    }
                    else return "math error";

            case "%": 
                    setLastOper(cmd);
                    return calPercent(text);

            case "1/x":
                    if(isNumber(text))
                    {
                        setLastOper(cmd);
                        String result = calBasic("/", "1", text);
                        return result;
                    }
                    else return "math error";
                    
            case "=": 
                    setLastOper(cmd);
                    if(isSecond == true)
                      {
                          isSecond = false;
                          String result = calBasic(opSign, fstOp, text);
                          setFstOp("");
                          setOpSign("");
                          return result;
                      }
                      else
                          return "math error";

            case "Back": 
                    setLastOper(cmd);
                    return backSpace(text);

            case "CE":
                    setLastOper(cmd);
                    return clearAll();

            case "C": 
                    setLastOper(cmd);
                    return clear();

            case "M+":
                    return callMemoMethod(cmd, text);

            case "M-":
                    return callMemoMethod(cmd, text);

            case "MR":
                    return callMemoMethod(cmd, text);

            case "MS":
                    return callMemoMethod(cmd, text);

            case "MC":
                    return callMemoMethod(cmd, text);
        }
        return "cmd not found";
    }

    String callMemoMethod(String cmd, String text)
    {
        setLastOper(cmd);
        switch(cmd)
        {
            case "MS": if(isNumber(text))
                       {
                           memoOp = text;
                           return text;
                       }
                       else return text;

            case "MR": return memoOp;

            case "MC": memoOp = "0";
                       return text;

            case "M+": if(isNumber(text))
                       {
                           memoOp = callMethod("+", text);
                           return text;
                       }
                       else return text;

            case "M-": memoOp = callMethod("-", text);
                       return text;
        }
        return "math error";
    }
                    
    
    boolean isNumber(String text)
    {
        try
        {
            double d = Double.parseDouble(text);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }

    String calBasic(String cmd, String strFst, String strSnd)
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

            case "/" : if(snd != 0)
                       {
                           result = MathTool.chu(fst, snd);
                           return Double.toString(result);
                       }
                       else return "math error";

            default  : return "math error";
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

    String clearAll()
    {
        setFstOp("");
        setSign("");
        isSecond = false;
        return clear();
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
        else return "";
    }

    String calSqrt(String text)
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

    String calPercent(String text)
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

    //set last operation iff the operation is excuted succfully
    public void setLastOper(String operand)
    {
        this.lastOper = operand;
    }

    public String getLastOper()
    {
        return this.lastOper;
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
