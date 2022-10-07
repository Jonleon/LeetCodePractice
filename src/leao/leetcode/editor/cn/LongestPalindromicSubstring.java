// 给你一个字符串 s，找到 s 中最长的回文子串。
//
//
//
// 示例 1：
//
//
// 输入：s = "babad"
// 输出："bab"
// 解释："aba" 同样是符合题意的答案。
//
//
// 示例 2：
//
//
// 输入：s = "cbbd"
// 输出："bb"
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 1000
// s 仅由数字和英文字母组成
//
// Related Topics 字符串 动态规划
// 👍 5228 👎 0

package leao.leetcode.editor.cn;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        String s = "babad";
        solution.longestPalindrome(s);

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            // dp [i][j] = dp[i+1][j-1] && s[i] == s[j]
            //
            int n = s.length();
            if (n < 2) {
                return s;
            }
            boolean[][] dp = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                dp[i][i] = true;
            }
            int maxLen = 1;
            int index = 0;
            String res = "";
            for (int j = 1; j < n; j++) {
                for (int i= 0; i <j; i++) {
                    if (s.charAt(i) != s.charAt(j)) {
                        dp[i][j] = false;
                    } else {
                        if (j - i <= 2) {
                            dp[i][j] = true;
                        } else {
                            dp[i][j] = dp[i+1][j-1];
                        }
                    }

                    if (dp[i][j] && (j - i + 1) > maxLen) {
                        index = i;
                        maxLen = j - i + 1;
                    }
                }

            }

            return s.substring(index,index+maxLen);
        }


    }
    // leetcode submit region end(Prohibit modification and deletion)

}