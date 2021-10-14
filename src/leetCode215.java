import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class leetCode215 {

    static Random random = new Random();

    public static void main(String[] args) {
        int[] nums = new int[] {3, 2, 1, 5, 6, 4};
        int k = 2;
        // int res = findKthLargest1(nums, k);
        int res = bottomK(nums, k);
        System.out.println(res);
    }

    static int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    static int quickSelect(int[] a, int l, int r, int index) {
        int target = randomPartition(a, l, r);
        if (target == index) {
            return a[target];
        } else {
            return target > index ? quickSelect(a, l, target - 1, index) : quickSelect(a, target + 1, r, index);
        }
    }

    static int randomPartition(int[] a, int l, int r) {
        int i = random.nextInt(r - 1 + l) + l;
        // 这一步是随机选一个pivot，防止最坏情况 On2
        swap(a, i, r);
        return partition(a, l, r);

    }

    static int partition(int[] a, int l, int r) {
        int x = a[r], i = l - 1;
        for (int j = l; j < r; j++) {
            if (a[j] > x) {
                swap(a, j, i++);
            }
        }
        swap(a, i + 1, r);
        return i + 1;
    }

    static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;

    }

    public static int findKthLargest1(int[] nums, int k) {
        int len = nums.length;
        int l = 0, r = len - 1, target = k - 1;
        while (true) {
            int t = partition1(nums, l, r);
            if (t == target) {
                return nums[target];
            } else if (t < target) {
                l = t + 1;
            } else {
                r = t - 1;
            }
        }
    }

    public static int partition1(int[] a, int l, int r) {

        // add random
        if (r > l) {
            int randomIndex = l + random.nextInt(r - l);
            swap(a, l, randomIndex);
        }

        int pivot = a[l];
        int index = l;
        for (int i = l + 1; i <= r; i++) {
            if (a[i] > pivot) {
                index++;
                swap(a, index, i);
            }
        }
        swap(a, index, l);
        return index;
    }

    static int topK(int[] a, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        int len = a.length;
        for (int i = 0; i < k; i++) {
            minHeap.add(a[i]);
        }
        for (int i = k; i < len; i++) {
            if (a[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(a[i]);
            }
        }
        if (minHeap.size() > 0) {
            return minHeap.peek();
        } else {
            return -1;
        }

    }

    static int bottomK(int[] a, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, ((o1, o2) -> o2 - o1));

        int len = a.length;
        for (int i = 0; i < k; i++) {
            minHeap.add(a[i]);
        }
        for (int i = k; i < len; i++) {
            if (a[i] < minHeap.peek()) {
                minHeap.poll();
                minHeap.add(a[i]);
            }
        }
        if (minHeap.size() > 0) {
            return minHeap.peek();
        } else {
            return -1;
        }

    }

}
