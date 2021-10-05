import java.util.Scanner;

public class lc724 {

    public static void main(String[] args) {
//        int[] nums = {-1,-1,-1,0,1,1};
//        pivotIndex(nums);
        sol();
    }

    public static int pivotIndex(int[] nums) {
        int left,right=0;
        for (int i=0; i< nums.length; i++) {
            if (i >= 1) {
                left = add(nums,0,i);
                right = add(nums,i+1,nums.length);
                if (left == right) {

                    return i;
                }
            }
        }

        return -1;
    }

    private static int add(int[]nums,int from,int end) {
        int res=0;
        for (;from<end;from++) {
            res = res + nums[from];
        }
        return res;
    }


    public static void sol() {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        String flower = "#";
        String [][] flowers = new String[rows+2][cols+2];

        for (int i=1;i<=rows;i++) {
            flowers[i] = ("." + sc.next() +  ".").split("");
        }
        String temp = "";
        for (int i=0;i<=cols+1;i++) {
            temp += ".";
        }
        flowers[0] = temp.split("");
        flowers[rows+1] =temp.split("");

        int res = 0;
        for (int i=1;i<rows;i++) {
            for (int j=1;j<cols;j++) {
                if (flowers[i][j].equals(flower)) {

                    if (!flowers[i][j-1].equals(flower)) {
                        res++;
                    }
                    if (!flowers[i-1][j].equals(flower)) {
                        res++;
                    }
                    if (!flowers[i][j+1].equals(flower)) {
                        res++;
                    }
                    if (!flowers[i-1][j].equals(flower)) {
                        res++;
                    }

                }
            }
        }


        System.out.println(res);
    }

}
