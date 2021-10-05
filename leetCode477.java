import java.util.ArrayList;
import java.util.List;

public class leetCode477 {
    public static void main(String[] args) {

    }


    static int totalHammingDistance(int[] nums) {
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1;j<nums.length;j++) {
                total += hammingDistance(nums[i],nums[j]);

            }
        }
        return total;

    }

    static int hammingDistance(int x,int y) {
        int dis = 0;
        String res = Integer.toBinaryString(x ^ y);
        for (char i : res.toCharArray()) {
            if (i == '1') {
                dis ++;
            }
        }
        return dis;
    }

    static void dos(int n) {
        String x = "X";
        int left = 0;
        int right = n - 1;
        List<String> res = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            char[] tmp = new char[n];
            for (int j = 0; j < n; j++) {
                if (j == left + i || j == right - i){
                    tmp[j] = 'X';
                } else {
                    tmp[j] = ' ';
                }

            }
            res.add(String.valueOf(tmp));

        }

    }

    static public int[] rotate(int[] nums, int k) {
        // Write your code here
        int [] res = new int[nums.length];
        int index = 0;
        if (nums.length > k) {
            index = nums.length - 1 - k;
        } else {
            index = nums.length - 1 - (k - nums.length);
        }
        int j = 0;
        for (int i = index+1; i < nums.length; i++) {
            res[j] = nums[i];
            j++;
        }
        for (int i = 0;i <= index;i++) {
            res[j] = nums[i];
            j++;
        }
        return res;

    }
}
