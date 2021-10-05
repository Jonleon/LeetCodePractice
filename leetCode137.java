import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetCode137 {
    public static void main(String[] args) {
        int[] nums = new int[]{9, 9, 9};
        //System.out.println(singleNumber(nums));

        //plusOne(nums);

        xorOperation(4,3);

    }

    /**
     * 输入：nums = [2,2,3,2]
     * 输出：3
     * O (n) O (1)
     *
     * @param nums
     * @return
     */

    static int singleNumber(int[] nums) {
        int res = nums[0];

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> etry : map.entrySet()) {
            if (etry.getValue() == 1) {
                res = etry.getKey();
            }
        }
        return res;
    }

    static int romanToInt(String s) {
        Map<String, Integer> dic = new HashMap<>();
        dic.put("I", 1);
        dic.put("V", 5);
        dic.put("X", 10);
        dic.put("L", 50);
        dic.put("C", 100);
        dic.put("D", 500);
        dic.put("M", 1000);
        dic.put("IV", 4);
        dic.put("IX", 9);
        dic.put("XL", 40);
        dic.put("XC", 90);
        dic.put("CD", 400);
        dic.put("CM", 900);
        String realS = "";
        char[] as = s.toCharArray();
        for (int i = 0; i < as.length; i++) {
            if (i != as.length - 1 && dic.get(String.valueOf(as[i])) < dic.get(String.valueOf(as[i + 1]))) {
                realS += String.valueOf(as[i]) + String.valueOf(as[i + 1]) + " ";
                i++;
            } else {
                realS += String.valueOf(as[i]) + " ";
            }
        }
        int res = 0;
        for (String tmp : realS.split(" ")) {
            res += dic.get(tmp);
        }
        return res;
    }

    static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        int strlen = strs.length;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strlen; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) == c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];

    }


    //双指针
    static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int f = 1;
        int s = 1;
        while (f < nums.length) {
            if (nums[f] != nums[f - 1]) {
                nums[s] = nums[f];
                s++;
            }
            f++;
        }
        int[] res = new int[2];
        res[0] = 1;
        res[1] = 2;
        return s;


    }

    static int[] plusOne(int[] digits) {
        boolean add = false;
        boolean over = false;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (i == digits.length - 1) {
                if (digits[i] + 1 == 10) {
                    digits[i] = 0;
                    add = true;
                    if (i == 0) {
                        over = true;
                    }
                } else {
                    digits[i] = digits[i] + 1;
                }
            } else {
                if (add) {
                    if (digits[i] + 1 == 10) {
                        digits[i] = 0;
                        add = true;
                        if (i == 0) {
                            over = true;
                        }
                    } else {
                        digits[i] = digits[i] + 1;
                        add = false;
                    }

                }
            }


        }
        if (over) {
            int[] res = new int[digits.length];
            res[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                res[i + 1] = digits[i];
            }
            return res;
        } else {
            return digits;
        }


    }


    static int xorOperation(int n, int start) {
        int res = 0;
        int curr = 0;
        for(int i = 0;i<n-1;i++) {
            curr = start + i*2;
            res = res ^ curr;

        }
        return res;
    }

//    static List<List<Integer>> threeSum(int[] nums) {
//        nums = Arrays.sort(nums,Comparator.comparing());
//    }
}
