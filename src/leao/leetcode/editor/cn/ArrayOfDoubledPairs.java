// 给定一个长度为偶数的整数数组 arr，只有对 arr 进行重组后可以满足 “对于每个 0 <= i < len(arr) / 2，都有 arr[2 * i
// + 1] = 2 * arr[2 * i]” 时，返回 true；否则，返回 false。
//
//
//
// 示例 1：
//
//
// 输入：arr = [3,1,3,6]
// 输出：false
//
//
// 示例 2：
//
//
// 输入：arr = [2,1,2,6]
// 输出：false
//
//
// 示例 3：
//
//
// 输入：arr = [4,-2,2,-4]
// 输出：true
// 解释：可以用 [-2,-4] 和 [2,4] 这两组组成 [-2,-4,2,4] 或是 [2,4,-2,-4]
//
//
//
//
// 提示：
//
//
// 0 <= arr.length <= 3 * 104
// arr.length 是偶数
// -105 <= arr[i] <= 105
//
// Related Topics 贪心 数组 哈希表 排序
// 👍 121 👎 0

package leao.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class ArrayOfDoubledPairs {
    static Random random = new Random();

    public static void main(String[] args) {
        Solution solution = new ArrayOfDoubledPairs().new Solution();
        HashSet<Integer> lot7 = new HashSet<>(7);
        while (lot7.size() < 7) {
            int i = random.nextInt(38);
            lot7.add(i);
        }
        System.out.println(lot7);
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canReorderDoubled(int[] arr) {
            Map<Integer, Integer> count = new HashMap<>();
            for (int x : arr) {
                count.put(x, count.getOrDefault(x, 0) + 1);
            }
            if (count.getOrDefault(0, 0) % 2 != 0) {
                return false;
            }

            count.remove(0);

            List<Integer> vals = new ArrayList<>();
            for (int x : count.keySet()) {
                vals.add(x);
            }
            Collections.sort(vals, (a, b) -> Math.abs(a) - Math.abs(b));
            for (int x : vals) {
                if (count.getOrDefault(2 * x, 0) < count.get(x)) {
                    return false;
                }
                count.put(2 * x, count.getOrDefault(x * 2, 0) - count.get(x));
            }

            return true;
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}