// 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
////
//// 子数组 是数组中的一个连续部分。
////
////
//
// 示例 1：
//
//
// 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
// 输出：6
// 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
//
//
// 示例 2：
//
//
// 输入：nums = [1]
// 输出：1
//
//
// 示例 3：
//
//
// 输入：nums = [5,4,-1,7,8]
// 输出：23
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 105
// -104 <= nums[i] <= 104
//
//
//
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
// Related Topics 数组 分治 动态规划
// 👍 4128 👎 0

package leao.leetcode.editor.cn;

import java.lang.ref.Reference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MaximumSubarray {
    public static void main(String[] args) throws Exception{
        Solution solution = new MaximumSubarray().new Solution();
        TestClass test = new TestClass();
        test.x.add(new TreeNode(1));
        test.y.add(new TreeNode(2));
        Field field = test.getClass().getDeclaredField("x");

        System.out.println(1);

    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            List<Integer> res = new ArrayList<>(nums.length);
            for (int i = 0; i < nums.length; i++) {

            }

            List<String> t = new ArrayList<>();
            t.size();
            String x = "sdaf";
            x.length();

            return 1;
        }
    }

    public static class TestClass {
        List<TreeNode> x = new ArrayList<>();
        List<TreeNode> y = new ArrayList<>();

    }
    // leetcode submit region end(Prohibit modification and deletion)

}