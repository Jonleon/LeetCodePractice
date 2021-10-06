/**
 * leetCode 402 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。 思路 单调栈
 *
 * @author liaoh
 */
public class lc402 {


    public static void main(String[] args) {
       String  num = "65526";
        System.out.println(removeKdigits(num,2));
    }
    public static String removeKdigits(String num, int k) {
        char[] c = num.toCharArray();
        int n = c.length;
        if (k == n) {
            return "0";
        }
        char[] ans = new char[n - k];
        int i = 0;
        for (char cur : c) {

            while (i > 0 && cur < ans[i - 1] && k > 0) {
                --i;
                --k;
            }
            if (i < ans.length) {
                ans[i] = cur;
                ++i;
            } else {
                --k;
            }

        }
        StringBuilder sb = new StringBuilder();
        i = 0;
        while (ans[i] == '0') {
            ++i;
            if (i == ans.length) {
                return "0";
            }
        }
        for (; i < ans.length; ++i) {
            sb.append(ans[i]);
        }
        return sb.toString();
    }

//    public String removeKdigits2(String num, int k) {
//        char [] nums = num.toCharArray();
//        int len = nums.length;
//        char [] stack = new char[len - k];
//        int index = 0;
//        for (char c : nums) {
//            while (index > 0 && c < stack[index-1] && k > 0) {
//                --index;
//                --k;
//            }
//            if (index < len) {
//                stack[index] = c;
//                index++;
//            } else {
//                k--;
//            }
//        }
//        String res = "";
//        index = 0;
//        for (;index<stack.length;index++) {
//
//        }
//    }

}
