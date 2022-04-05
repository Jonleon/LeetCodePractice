// 给你两个整数 left 和 right ，在闭区间 [left, right] 范围内，统计并返回 计算置位位数为质数 的整数个数。
//
// 计算置位位数 就是二进制表示中 1 的个数。
//
//
// 例如， 21 的二进制表示 10101 有 3 个计算置位。
//
//
//
//
// 示例 1：
//
//
// 输入：left = 6, right = 10
// 输出：4
// 解释：
// 6 -> 110 (2 个计算置位，2 是质数)
// 7 -> 111 (3 个计算置位，3 是质数)
// 9 -> 1001 (2 个计算置位，2 是质数)
// 10-> 1010 (2 个计算置位，2 是质数)
// 共计 4 个计算置位为质数的数字。
//
//
// 示例 2：
//
//
// 输入：left = 10, right = 15
// 输出：5
// 解释：
// 10 -> 1010 (2 个计算置位, 2 是质数)
// 11 -> 1011 (3 个计算置位, 3 是质数)
// 12 -> 1100 (2 个计算置位, 2 是质数)
// 13 -> 1101 (3 个计算置位, 3 是质数)
// 14 -> 1110 (3 个计算置位, 3 是质数)
// 15 -> 1111 (4 个计算置位, 4 不是质数)
// 共计 5 个计算置位为质数的数字。
//
//
//
//
// 提示：
//
//
// 1 <= left <= right <= 106
// 0 <= right - left <= 104
//
// Related Topics 位运算 数学
// 👍 86 👎 0

package leao.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumberOfSetBitsInBinaryRepresentation {
    public static void main(String[] args) {
        Solution solution = new PrimeNumberOfSetBitsInBinaryRepresentation().new Solution();
        solution.letterCombinations("23");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] keyb = new String[] {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        public int countPrimeSetBits(int left, int right) {
            int ans = 0;
            for (int x = left; x <= right; ++x) {
                if (((1 << Integer.bitCount(x)) & 665772) != 0) {
                    ++ans;
                }
            }
            return ans;

        }

        public List<String> letterCombinations(String digits) {
            List<String> results = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            backtracking(results, sb, 0, digits);
            return results;
        }

        public void backtracking(List<String> results, StringBuilder sb, int i, String digits) {
            //return condition
            if (i >= digits.length()) {
                results.add(sb.toString());
                return;
            }
            int index = digits.charAt(i) - '2';
            String keyboard = keyb[index];
            for (char c : keyboard.toCharArray()) {
                sb.append(c);
                backtracking(results, sb, i + 1, digits);
                sb.setLength(sb.length() - 1);
            }
        }

        // public int[] binArraPlus1(int [] arr) {
        // int countOne = arr[21];
        // int plusFactor = 1;
        // for (int i = 0; i < 20; i++) {
        // if (arr[i] == 0) {
        // if (plusFactor == 1) {
        // arr[i] = 1;
        // plusFactor--;
        // countOne++;
        // } else {
        // break;
        // }
        // } else {
        // if (plusFactor == 1) {
        // arr[i] = 0;
        // countOne--;
        // }
        // }
        // }
        // arr[21] = countOne;
        // return arr;
        // }
        // public int[] getBinArra(int x) {
        // int[] arra = new int[21];
        // int i = 0;
        // int oneCount = 0;
        // while (x != 0) {
        // int res = x % 2;
        // x = x / 2;
        // arra[i] = res;
        // i++;
        // if (res == 1) {
        // oneCount++;
        // }
        // }
        // arra[21] = oneCount;
        // return arra;
        // }
        //
        // public boolean isZ(int n) {
        // if (n < 2) {
        // return false;
        // }
        //
        // if (n == 2) {
        // return true;
        // }
        //
        // if (n % 2 == 0) {
        // return false;
        // }
        //
        // for (int i = 3; i * i <= n; i += 2) {
        // if (n % i == 0)
        // return false;
        // }
        //
        // return true;
        // }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}