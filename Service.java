import java.math.BigDecimal;

class Service
{
    String callMethod(String cmd, String text)
    {
        switch(cmd)
        {
            case "1": case "2": case "3": case "4": case "5":
            case "6": case "7": case "8": case "9": case "0":
                      return append(cmd,text);

            case "C": return clear();

            case "+/-": return setSign(text);
            case "sqrt": return sqrt(text);
        }
        return text;
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
        if(text.length() > 1)
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

    String sqrt(String text)
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

    public static void main(String[] args)
    {
        Service s = new Service();
        String str1 = "14";
        String str2 = "";
        String str3 = "-14";
        System.out.println(s.setSign(str1));
        System.out.println(s.setSign(str2));
        System.out.println(s.setSign(str3));
    }
}
