import java.util.Scanner;
import java.util.Stack;

public class paizaB087 {

    public static void main(String[] args) {
        solu();
    }


    public static void solu() {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int len = sc.nextInt();


        char[][] numbers = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            numbers[i] = sc.next().toCharArray();
        }

        getMax(numbers,rows,cols,len);


    }

    private static void getMax(char[][] nums,int row,int col,int len) {
        int ans = 0;
        int k=0;
        int cur=0;
        Stack<String> stack = new Stack<String>();
        // left -> right
        for (int i =0;i<row;i++) {
            char[] res = new char[len];
            String tmp="";
            k = col - len;
            cur=0;

            for (int x=0;x<col;x++) {
                while (k > 0 && cur > 0 && nums[i][x] > nums[i][x-1] ) {
                        --k;
                        --cur;
                }
                if (cur < col) {
                    res[cur] = nums[i][x];
                    cur++;

                }else {
                    k--;
                }

            }
            StringBuilder tm = new StringBuilder();
            for (char x : res) {
                tm.append(x);
            }
            if (ans < Integer.parseInt(tm.toString())) {
                ans = Integer.parseInt(tm.toString());
            }
        }

        for (int j=0;j<col;j++) {
            char []res = new char[len];
            k = row - len;
            cur = 0;
            for (int y=0;y < row;y++) {
                while (k >0 && cur >0 && nums[y][j] > nums[y-1][j]) {
                    --k;
                    --cur;
                }
                if (cur < row) {
                    res[cur] = nums[y][j];
                    cur++;
                } else {
                    k--;
                }
            }
            StringBuilder tm1 = new StringBuilder();
            for (char x : res) {
                tm1.append(x);
            }
            if (ans < Integer.parseInt(tm1.toString())) {
                ans = Integer.parseInt(tm1.toString());
            }
        }

        System.out.println(String.valueOf(ans));

    }
}
