// 给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。
//
// 形式上，斐波那契式序列是一个非负整数列表 F，且满足：
//
//
// 0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）；
// F.length >= 3；
// 对于所有的0 <= i < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成立。
//
//
// 另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。
//
// 返回从 S 拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回 []。
//
//
//
// 示例 1：
//
// 输入："123456579"
// 输出：[123,456,579]
//
//
// 示例 2：
//
// 输入: "11235813"
// 输出: [1,1,2,3,5,8,13]
//
//
// 示例 3：
//
// 输入: "112358130"
// 输出: []
// 解释: 这项任务无法完成。
//
//
// 示例 4：
//
// 输入："0123"
// 输出：[]
// 解释：每个块的数字不能以零开头，因此 "01"，"2"，"3" 不是有效答案。
//
//
// 示例 5：
//
// 输入: "1101111"
// 输出: [110, 1, 111]
// 解释: 输出 [11,0,11,11] 也同样被接受。
//
//
//
//
// 提示：
//
//
// 1 <= S.length <= 200
// 字符串 S 中只含有数字。
//
// Related Topics 字符串 回溯
// 👍 248 👎 0

package leao.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SplitArrayIntoFibonacciSequence {

    public static void main(String[] args) {
        //Solution solution = new SplitArrayIntoFibonacciSequence().new Solution();
        //System.out.println(solution.splitIntoFibonacci("1101111"));
        String x = null;
        String y = "124";
        List<String> tmp = new ArrayList<>();
        System.out.println(x+y);


    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> splitIntoFibonacci(String num) {
            List<Integer> res = new ArrayList<>();
            return dfs(0, num, res);
        }

        public List<Integer> dfs(int start, String num, List<Integer> path) {
            // 剪枝
            if (path.size() > 2) {
                if (path.get(path.size() - 1) != path.get(path.size() - 2) + path.get(path.size() - 3)) {
                    return new ArrayList<>();
                }
            }
            if (start >= num.length()) {
                if (path.size() > 2) {
                    return path;
                } else {
                    return new ArrayList<>();
                }
            }
            int cur = 0;
            List<Integer> ans = new ArrayList<>();
            for (int i = start; i < num.length(); i++) {
                // cut
                if (i > start && num.charAt(start) == '0') {
                    return new ArrayList<>();
                }
                cur = cur * 10 + num.charAt(i) - '0';
                if (cur < 0) {
                    return new ArrayList<>();
                }
                path.add(cur);
                ans = dfs(i + 1, num, path);
                if (ans.size() > 2) {
                    return ans;
                }
                path.remove(path.size() - 1);

            }
            return ans;
        }

    }
    // leetcode submit region end(Prohibit modification and deletion)

}