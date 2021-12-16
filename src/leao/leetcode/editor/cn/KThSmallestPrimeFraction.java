// 给你一个按递增顺序排序的数组 arr 和一个整数 k 。数组 arr 由 1 和若干 素数 组成，且其中所有整数互不相同。
//
// 对于每对满足 0 < i < j < arr.length 的 i 和 j ，可以得到分数 arr[i] / arr[j] 。
//
// 那么第 k 个最小的分数是多少呢? 以长度为 2 的整数数组返回你的答案, 这里 answer[0] == arr[i] 且 answer[1] == a
// rr[j] 。
//
//
// 示例 1：
//
//
// 输入：arr = [1,2,3,5], k = 3
// 输出：[2,5]
// 解释：已构造好的分数,排序后如下所示:
// 1/5, 1/3, 2/5, 1/2, 3/5, 2/3
// 很明显第三个最小的分数是 2/5
//
//
// 示例 2：
//
//
// 输入：arr = [1,7], k = 1
// 输出：[1,7]
//
//
//
//
// 提示：
//
//
// 2 <= arr.length <= 1000
// 1 <= arr[i] <= 3 * 104
// arr[0] == 1
// arr[i] 是一个 素数 ，i > 0
// arr 中的所有数字 互不相同 ，且按 严格递增 排序
// 1 <= k <= arr.length * (arr.length - 1) / 2
//
// Related Topics 数组 二分查找 堆（优先队列）
// 👍 153 👎 0

package leao.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class KThSmallestPrimeFraction {
    public static void main(String[] args) {
        Solution solution = new KThSmallestPrimeFraction().new Solution();
        //solution.kthSmallestPrimeFraction(new int[]{1,2,3,5},3);
        List<Integer> tmp = new ArrayList<>();

        tmp.add(1);
        tmp.add(2);
        Iterator<Integer> it = tmp.iterator();
        while (it.hasNext()) {
            int i = it.next();
            it.remove();
        }


    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] kthSmallestPrimeFraction(int[] arr, int k) {
            PriorityQueue<int[]> minHeap = new PriorityQueue<>(k, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] * o2[1] > o2[0] * o1[1] ) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            });

            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = i+1; j < arr.length; j++) {
                    int[] tmp = new int[]{ arr[i] , arr[j]};
                    minHeap.add(tmp);
                }
            }

            for (int i = 0; i < k - 1; i++) {
                minHeap.poll();
            }
            return minHeap.poll();
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}