package paiza;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class pS044 {
    public static void main(String[] args) {
        sol();
    }

    static void sol() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int[] dp = new int[n+1];
        Map<Integer, Integer> resMap = new HashMap<>(n);

        dp[0] = 1;
        Map<Integer,Integer> isShow = new HashMap<>(9);

        for (int i = 1; i <= n ; i++) {
            int currIndex = i -1;
            if (isShow.containsKey(nums[currIndex])) {

                dp[i] = dp[i-1] * 2 - dp[isShow.get(nums[currIndex])];
                isShow.put(nums[currIndex],Math.max(isShow.get(nums[currIndex]),currIndex));
                for (int k = 2; k <= i-1;k++) {
                    resMap.put(k,resMap.getOrDefault(k,0) + k);
                }
                resMap.put(i,resMap.getOrDefault(i,0)+1);
            } else {
                isShow.put(nums[currIndex],currIndex);
                dp[i] = dp[i - 1] * 2;
                for (int k = 1; k <= i-1;k++) {
                    resMap.put(k,resMap.getOrDefault(k,0) + k);
                }
                resMap.put(i,resMap.getOrDefault(i,0)+1);
            }
            int count = dp[i] - 1;



        }
        System.out.println(dp[n] - 1);


    }
}
