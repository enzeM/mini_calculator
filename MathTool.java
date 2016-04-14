import java.math.BigDecimal;
import java.math.MathContext;
class MathTool
{
    public static double jia(double a, double b)
    {
        BigDecimal fst = new BigDecimal(String.valueOf(a)); 
        BigDecimal snd = new BigDecimal(String.valueOf(b));
        return fst.add(snd,MathContext.DECIMAL64).doubleValue();
    }

    public static double jian(double a, double b)
    {
        BigDecimal fst = new BigDecimal(String.valueOf(a));
        BigDecimal snd = new BigDecimal(String.valueOf(b));
        return fst.subtract(snd,MathContext.DECIMAL64).doubleValue();
    }

    public static double cheng(double a, double b)
    {
        BigDecimal fst = new BigDecimal(String.valueOf(a));
        BigDecimal snd = new BigDecimal(String.valueOf(b));
        return fst.multiply(snd,MathContext.DECIMAL64).doubleValue();
    }

    public static double chu(double a, double b)
    {
        BigDecimal fst = new BigDecimal(String.valueOf(a));
        BigDecimal snd = new BigDecimal(String.valueOf(b));
        return fst.divide(snd,MathContext.DECIMAL64).doubleValue();
    }
}
