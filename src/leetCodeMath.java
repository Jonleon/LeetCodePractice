import java.util.HashMap;
import java.util.Map;

public class leetCodeMath {

    public static void main(String[] args) {
        divide(10,3);
    }

    static String numberToWords(int num) {

        Map<String, String> numberMap = new HashMap<>(10);
        String numbers = "0123456789";
        String words = "ZERO,ONE,TWO,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE";
        String couters = "Hundred,Thousand,Million,Billion";
        String[] tmp = words.split(",");
        String[] tmp2 = numbers.split("");
        for (int i = 0; i < tmp.length; i++) {
            numberMap.put(tmp2[i], tmp[i]);
        }
        return "";

    }

    /**
     *
     * @param dividend -2^31  ~ 2^31
     * @param divisor
     * @return
     */
    static int divide(int dividend, int divisor) {
        //防止overflow
        int res = 0;
        long tmpend = 0;
        long tmpsor = 0;
        if (dividend == Integer.MIN_VALUE) {
            tmpend = Integer.MAX_VALUE;
            tmpend = tmpend + 1;
        } else {
            tmpend = dividend;
        }

        if (divisor == Integer.MIN_VALUE) {
            tmpsor = Integer.MAX_VALUE;
            tmpsor = tmpsor + 1;
        } else {
            tmpsor = divisor;
        }

        boolean flag = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);

        tmpend = Math.abs(tmpend);
        tmpsor = Math.abs(tmpsor);

        long tmp1 = tmpend / tmpsor;
        if (flag) {
            if (tmp1 > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            return (int)tmp1;
        } else {
            return -1 * (int)tmp1;
        }


    }
}
