import java.math.BigDecimal;

class Service
{
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
        return cmd + text;
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
            Double result = Math.sqrt(num);
            return result.toString();
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
