import java.math.BigDecimal;
import java.text.DecimalFormat;

public class FomatDecimal {
    public static void main(String[] s){
        BigDecimal a = new BigDecimal("997.22");

        String formatted = new DecimalFormat("#.0000000000").format(a);
        System.out.println(formatted);
    }
}
