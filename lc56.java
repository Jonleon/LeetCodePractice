import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class lc56 {


    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 9}, {3, 8}, {11, 12}};
        int[] newIntervals = {2, 5};
        // int[][] res = insert(intervals, newIntervals);
        //System.out.println(res);

//        String S = "ababcbacadefegdehijhklij";
//        List<Integer> res3 = partitionLabels(S);


        int[] ci = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        int res = findKthLargest(ci, k);
        System.out.println(res);
    }

    /**
     * leetcode 56
     * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
     * 链接：https://leetcode-cn.com/problems/merge-intervals
     * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
     * 输出：[[1,6],[8,10],[15,18]]
     * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     *
     * @param intervals
     */
    private static int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparing(x -> x[0]));

        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            if (res.size() == 0 || res.get(res.size() - 1)[1] < left) {
                res.add(new int[]{left, right});
            } else {
                res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], right);
            }

        }

        return res.toArray(new int[res.size()][]);
        /**
         * 复杂度分析
         * 数组长度 nlogn
         *
         */
    }


    /**
     * leetcode 57
     * <p>
     * <p>
     * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
     * 输出：[[1,2],[3,10],[12,16]]
     * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
     *
     * @param intervals
     * @param newInterval
     * @return
     */

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        List<int[]> res = new ArrayList<>();
        boolean flag = false;
        for (int i = 0; i < intervals.length; i++) {

            int l = intervals[i][0], r = intervals[i][1];
            if (l > right) {
                if (!flag) {
                    flag = true;
                    res.add(new int[]{left, right});
                }
                res.add(intervals[i]);
            } else if (r < left) {
                res.add(intervals[i]);
            } else {
                left = Math.min(l, left);
                right = Math.max(r, right);
            }


        }
        if (!flag) {
            res.add(new int[]{left, right});
        }
        return res.toArray(new int[res.size()][]);

    }

    /**
     * 输入：S = "ababcbacadefegdehijhklij"
     * 输出：[9,7,8]
     * 解释：
     * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
     *
     * @param S
     * @return
     */

    public static List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        int[] last = new int[26];
        int length = S.length();
        for (int i = 0; i < length; i++) {
            last[S.charAt(i) - 'a'] = i;
        }
        int left = 0, right = 0;
        for (int i = 0; i < length; i++) {
            right = Math.max(right, last[S.charAt(i) - 'a']);
            if (i == right) {
                res.add(right - left + 1);
                left = right + 1;
            }

        }
        return res;
    }

    public static int hIndex(int[] citations) {
        // write your code here
        int length = citations.length;
        if (length == 0) {
            return 0;
        }
        // h 最大为 n，计算每个下标的引用次数，累加
        int[] array2 = new int[length + 1];
        for (int i = 0; i < length; i++) {

            if (citations[i] > length) {

                array2[length] += 1;

            } else {

                array2[citations[i]] += 1;
            }
        }
        int t = 0;
        for (int i = length; i >= 0; i--) {
            t = t + array2[i];
            if (t >= i) {
                return i;
            }
        }
        return 0;
    }

    public static int findKthLargest(int[] nums, int k) {
//        int heapSize = nums.length;
//        buildMaxHeap(nums, heapSize);
//        for (int i = nums.length - 1; i >= nums.length - k + 1; --i) {
//            swap(nums, 0, i);
//            --heapSize;
//            maxHeapify(nums, 0, heapSize);
//        }
//        return nums[0];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        for (int i = 0; i < k; i++) {
            minHeap.add(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (minHeap.size()!=0 && minHeap.peek() < nums[i]) {
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }
        if (minHeap.size()!=0) {
            return minHeap.peek();
        }
        return 0;

    }

    public static void buildMaxHeap(int[] a, int heapSize) {
        for (int i = heapSize / 2; i >= 0; --i) {
            maxHeapify(a, i, heapSize);
        }


    }

    public static void maxHeapify(int[] a, int i, int heapSize) {
        int left = i * 2 + 1, right = i * 2 + 2, largest = i;
        if (left < heapSize && a[left] > a[largest]) {
            largest = left;
        }
        if (right < heapSize && a[right] > a[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(a, i, largest);
            maxHeapify(a, largest, heapSize);
        }
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public int maxSubArray(int[] nums) {
        int res = 0;
        char x = 'a';

        for (int i = 0; i < nums.length; i++) {

        }

        return res;
    }

    public int[] productExceptSelf(int[] nums) {
        // write your code here
        int[] chengji = new int[nums.length];
        int len = nums.length;
        int pre = 1, tail = 1;
        for (int i = 0; i < len; i++) {
            chengji[i] = 1;
        }
        for (int i = 0; i < len; i++) {
            chengji[i] *= pre;
            pre *= nums[i];
        }
        for (int j = len - 1; j >= 0; j--) {
            chengji[j] *= tail;
            tail *= nums[j];
        }
        return chengji;

    }








}
