// 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。
//
// 判断你是否能够到达最后一个下标。
//
//
//
// 示例 1：
//
//
// 输入：nums = [2,3,1,1,4]
// 输出：true
// 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
//
//
// 示例 2：
//
//
// 输入：nums = [3,2,1,0,4]
// 输出：false
// 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 3 * 104
// 0 <= nums[i] <= 105
//
// Related Topics 贪心 数组 动态规划
// 👍 1573 👎 0

package leao.leetcode.editor.cn;

public class JumpGame {
    public static void main(String[] args) {
        Solution solution = new JumpGame().new Solution();
        int[] nums = {2, 3, 0, 1, 4};

        System.out.println(solution.jump2(nums));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canJump(int[] nums) {
            int n = nums.length;
            boolean[] dp = new boolean[n];
            dp[0] = true;

            for (int i = 1; i < n; i++) {
                boolean flag = false;
                for (int j = i - 1; j >= 0; j--) {
                    flag = dp[j] && (nums[j] + j >= i);
                    if (flag) {
                        break;
                    }
                }
                dp[i] = flag;
            }
            return dp[n - 1];
        }

        public int jump(int[] nums) {
            int steps = 0;
            int n = nums.length;
            int[] dp = new int[n];
            dp[0] = 0;

            for (int i = 0; i < n; i++) {
                steps = dp[i] + 1;
                int right = i + nums[i] >= (n - 1) ? (n - 1) : i + nums[i];
                for (int j = i + 1; j <= right; j++) {

                    if (dp[j] == 0) {
                        dp[j] = steps;
                    } else {
                        dp[j] = Math.min(dp[j], steps);
                    }

                }
            }
            return dp[n - 1];
        }

        public int jump2(int[] nums) {
            int n = nums.length;
            int end = 0;
            int maxPosition = 0;
            int steps = 0;
            for (int i = 0; i < n - 1; i++) {
                maxPosition = Math.max(maxPosition,i + nums[i]);
                if (i == end) {
                    end = maxPosition;
                    steps++;
                }
            }
            return steps;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}