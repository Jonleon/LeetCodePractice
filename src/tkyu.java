import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class tkyu {
    public static void main(String[] args) {
        init();
        String test = "HBC#";
        String res = "";
        for (String i : test.split("")) {
            res += converToBinary(convertToInt(i));
            if (res.length() > 320) {
                break;
            }
        }

        System.out.println(res.substring(9,20));
    }
    static List<String> args = new ArrayList<>(64);

    static void init() {
        String tmps = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        tmps += tmps.toLowerCase();
        tmps += "0123456789";
        tmps += "@#";
        Collections.addAll(args,tmps.split(""));
        System.out.println(2);
    }

    static int convertToInt(String target) {
        return args.indexOf(target);
    }

    static String converToBinary(int target) {
        String tmp = Integer.toBinaryString(target);
        String res = "";
        if (tmp.length() < 6) {
            for (int i = 0; i < 6-tmp.length(); i++) {
                res += "0";
            }
        }
        return res + tmp;
    }
}
