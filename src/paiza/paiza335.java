package paiza;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class paiza335 {
    public static void main(String[] args) {
        sol3();
    }

    static void sol() {
        Scanner sc = new Scanner(System.in);

        int frame = sc.nextInt();
        int balls = sc.nextInt();
        int times = sc.nextInt();

        int[] prices = new int[times];

        for (int i = 0; i < times; i++) {
            String tmp = sc.next();
            if (tmp.equals("G")) {
                prices[i] = 0;
            } else {
                prices[i] = Integer.parseInt(tmp);
            }

        }
        int score = 0;
        int left = 0;
        for (int i = 0; i < frame; i++) {
            if (i == frame - 1) {
                if (prices[left] == balls) {
                    if (prices[left + 1] == balls) {
                        score += balls + prices[left + 1] * 2 + prices[left + 2] * 3;
                    } else {
                        score = score + balls + prices[left + 1] * 2 + prices[left + 2] * 2;
                    }
                } else if (prices[left] + prices[left + 1] == balls) {
                    score = score + balls + prices[left + 2] * 2;
                } else {
                    score = prices[left] + prices[left + 1];
                }

            } else {
                if (prices[left] == balls) {
                    score = score + balls + prices[left + 1] + prices[left + 2];
                    left++;
                } else if (prices[left] + prices[left + 1] == balls) {
                    score = score + balls + prices[left + 2];
                    left += 2;
                } else {
                    score += prices[left] + prices[left + 1];
                    left += 2;
                }
            }

        }

        System.out.println(score);

    }


    static void sol2() {
        Scanner sc = new Scanner(System.in);
        Map<String,List<Integer>> map = new HashMap<>(26);
        int n = sc.nextInt();
        List<String> keyboards = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            keyboards.add(sc.next());
        }
        String[] target = sc.next().split("");
        for (int i = 0; i < 26; i++) {
           String tmp = String.valueOf((char) (i + 'a'));
           List<Integer> indexs =  new ArrayList<>();
           for (int j = 0; j < keyboards.size();j++) {
               if (keyboards.get(j).contains(tmp)) {
                   indexs.add(j);
               }
           }
           map.put(tmp,indexs);
        }
        int count = 0;
        int left = 0;
        int right = 1;
        List<Integer> a = map.get(target[left]);
        List<Integer> b = map.get(target[right]);
        while (right <= target.length - 1) {
            List<Integer> res  = isContains(a,b);
            if (res.size() > 0) {
                a = res;
                right++;
                if (right == target.length) {
                    count++;
                    break;
                }
                b = map.get(target[right]);
            } else {
                count++;
                left = right;
                right++;
                if (right == target.length) {
                    count++;
                    break;
                }
                a = map.get(target[left]);
                b = map.get(target[right]);
            }
        }
        System.out.println(count);

    }

    static List<Integer> isContains (List<Integer> i1,List<Integer>i2) {
        List<Integer> res = new ArrayList<>();
        for (int t : i1) {
            if (i2.contains(t)) {
                res.add(t);
            }
        }
        return res;
    }



    static void sol3() {

        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        int s = sc.nextInt();
        int t = sc.nextInt();
        String [] result = new String[k];
        result[0] = "ABC";

        String res = build(k,result);
        System.out.println(res.substring(s-1,t));


    }
    static String build(int k,String [] result) {

        for (int i = 1; i <= k-1; i++) {
            result[i] = "A" + result[i-1] + "B" + result[i-1] + "C";
            if (i >= 4) {
                result[i - 4] = "";
                result[i - 3] = "";
                result[i - 2] = "";
            }
        }
        return result[k-1];
    }
}
