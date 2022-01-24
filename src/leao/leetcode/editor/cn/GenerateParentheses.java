// 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
//
//
// 示例 1：
//
//
// 输入：n = 3
// 输出：["((()))","(()())","(())()","()(())","()()()"]
//
//
// 示例 2：
//
//
// 输入：n = 1
// 输出：["()"]
//
//
//
//
// 提示：
//
//
// 1 <= n <= 8
//
// Related Topics 字符串 动态规划 回溯
// 👍 2302 👎 0

package leao.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GenerateParentheses {
    static List<String> res = new ArrayList<>();
    static LinkedList<LinkedList<String>> dp = new LinkedList<>();

    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
        System.out.println(solution.dpSolve(3));

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            dfs(n, 0, 0, "");
            return res;

        }

        private void dfs(int n, int left, int right, String cur) {
            if (left == n && right == n) {
                res.add(cur);
                return;
            }
            if (left < n) {
                dfs(n, left++, right, cur + "(");
            }
            if (right < n && left > right) {
                dfs(n, left, right++, cur + ")");
            }

        }

        private List<String> dpSolve(int n) {
            LinkedList<String> tmp1 = new LinkedList<>();
            LinkedList<String> tmp2 = new LinkedList<>();
            tmp1.add("()");
            tmp2.add("");
            dp.add(tmp2);
            dp.add(tmp1);
            for (int i = 2; i <= n; i++) {
                LinkedList<String> tmp = new LinkedList<>();
                // 这种dp的结果顺序不对
                for (String s : dp.get(i - 1)) {
                    tmp.add("(" + s + ")");
                    tmp.add(s + "()");
                    if (!(s + "()").equals("()" + s)) {
                        tmp.add("()" + s);
                    }
                }
                dp.add(tmp);
            }
            return dp.get(n);

        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}