// 给出两个整数 n 和 k，找出所有包含从 1 到 n 的数字，且恰好拥有 k 个逆序对的不同的数组的个数。
//
// 逆序对的定义如下：对于数组的第i个和第 j个元素，如果满i < j且 a[i] > a[j]，则其为一个逆序对；否则不是。
//
// 由于答案可能很大，只需要返回 答案 mod 109 + 7 的值。
//
// 示例 1:
//
//
// 输入: n = 3, k = 0
// 输出: 1
// 解释:
// 只有数组 [1,2,3] 包含了从1到3的整数并且正好拥有 0 个逆序对。
//
//
// 示例 2:
//
//
// 输入: n = 3, k = 1
// 输出: 2
// 解释:
// 数组 [1,3,2] 和 [2,1,3] 都有 1 个逆序对。
//
//
// 说明:
//
//
// n 的范围是 [1, 1000] 并且 k 的范围是 [0, 1000]。
//
// Related Topics 动态规划
// 👍 149 👎 0

package leao.leetcode.editor.cn;

public class KInversePairsArray {
    public static void main(String[] args) {
        Solution solution = new KInversePairsArray().new Solution();
        System.out.println(solution.kInversePairs(10,11));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 转移方程
        //   f (n,k) = f(n-1,k)  f(4,1) = f(3,1) + 1 ? 132 213   2 1 3 4 , 1 3 2 4, 1 2 4 3
        public int kInversePairs(int n, int k) {
            int[][] dp = new int[n+1][n+1];
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= k; j++) {
                    if (j ==0) {
                        dp[i][j] = 1;
                    } else {
                        for (int p = 0; p <= Math.min(j,i-1); p++) {
                            dp[i][j] = (dp[i][j] + dp[i-1][j-p]); // % 1000000007 ???;
                        }
                    }
                }
            }
            return dp[n][k];
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}