import java.util.Random;

public class leetCode4Array {

    static Random random = new Random();

    public static void main(String[] args) {
//        int[] ints = {4, 0, 0, 0, 0, 0};
//        int[] ints2 = {1, 2, 3, 4, 5};
//        merge(ints, 1, ints2, 5);
        //System.out.println(maximumElementAfterDecrementingAndRearranging(ints));
        countPrimes(10);
    }

    static void moveZeroes(int[] nums) {
        //统计前面0的个数
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            //如果当前数字是0就不操作
            if (nums[j] == 0) {
                i++;
            } else if (i != 0) {
                //否则，把当前数字放到最前面那个0的位置，然后再把
                //当前位置设为0
                nums[j - i] = nums[j];
                nums[j] = 0;
            }
        }
    }


    //快慢指针
    static void removeDuplicate(int[] nums) {
        int i = 0, j = 1;
        for (; j < nums.length; j++) {
            if (nums[i] == nums[j]) {

            } else {
                i++;
                nums[i] = nums[j];
            }
        }
    }

    //快慢指针2
    static void removeDuplicate2(int[] nums) {
        int i = 0, j = 1;
        boolean two = false;
        for (; j < nums.length; j++) {
            if (nums[i] == nums[j]) {
                if (!two) {
                    i++;
                    nums[i] = nums[j];
                    two = true;
                }
            } else {
                i++;
                nums[i] = nums[j];
                two = false;
            }
        }
    }

    //0, 2, 1, 0, 1, 1, 2

    static void sortColors(int[] nums) {
        int countZero = 0;
        int countTwo = 0;
        for (int i = 0; i < nums.length - countTwo; i++) {
            if (nums[i] == 0) {
                swap(countZero, i, nums);
                countZero++;
            }
            if (nums[i] == 2) {
                swap(i, nums.length - 1 - countTwo, nums);
                countTwo++;
                i--;
            }
        }
    }

    static void swap(int i, int j, int[] nums) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    static int findKth(int[] nums, int k) {
        int len = nums.length;
        int left = 0, right = len - 1;
        while (true) {
            int index = partition(nums, left, right);
            if (index == k - 1) {

                return nums[k - 1];
            }
            if (index > k - 1) {
                right = index - 1;
            } else {
                left = index + 1;
            }
        }

    }

    static int partition(int[] nums, int left, int right) {

        int index = random.nextInt(right) % (right - left + 1) + left;

        swap(index, left, nums);
        int pivot = nums[left];
        index = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] >= pivot) {
                index++;
                swap(i, index, nums);
            }
        }
        swap(index, left, nums);
        return index;
    }

    static int maximumElementAfterDecrementingAndRearranging(int[] arr) {

        int n = arr.length;
        int[] cnt = new int[n + 1];
        for (int v : arr) {
            ++cnt[Math.min(v, n)];
        }
        int miss = 0;
        for (int i = 1; i <= n; ++i) {
            if (cnt[i] == 0) {
                ++miss;
            } else {
                miss -= Math.min(cnt[i] - 1, miss);
            }
        }
        return n - miss;

    }

    /**
     * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     * 输出：[1,2,2,3,5,6]
     * 倒序的双指针罢了
     *
     * @param a
     * @param m
     * @param b
     * @param n
     */
    static void merge(int[] a, int m, int[] b, int n) {
        int targeti = a.length - 1;
        int ia = m - 1, ib = n - 1;
        while (ia >= 0 && ib >= 0) {
            if (a[ia] > b[ib]) {
                swap(ia, targeti, a);
                ia--;
            } else {
                a[targeti] = b[ib];
                ib--;
            }
            targeti--;
        }
        if (ia < 0 && ib >= 0) {
            for (int i = 0; i <= ib; i++) {
                a[i] = b[i];
            }
        }
    }

    /**
     * 输入：numbers = [2,7,11,15], target = 9
     * 输出：[1,2]
     * 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
     *
     * @param numbers
     * @param target
     * @return
     */
    static int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i != j) {
            if (numbers[i] + numbers[j] < target) {
                i++;
            } else if (numbers[i] + numbers[j] > target) {
                j--;
            }
            if (numbers[i] + numbers[j] == target) {
                break;
            }
        }
        return new int[]{i + 1, j + 1};
    }

    static int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
           count += isP(i) ? 1:0;
        }
        return count;
    }
    static boolean isP(int n) {
        for (int i = 2; i*i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return  true;
    }
}
