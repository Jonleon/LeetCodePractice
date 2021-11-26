import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class pa459 {

    public static void main(String[] args) {

    }


    static void sol() {
        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        int cols = sc.nextInt();

        int [][] map = new int[rows][cols];
        int [][] res = new int[rows][cols];


        for (int i = 0; i < rows - 1; i++) {
            String [] tmp = sc.next().split(" ");
            int [] tmp2 = new int[cols];
            for (int j = 0;j < tmp.length; j++) {
                tmp2[j] = Integer.parseInt(tmp[j]);
            }

            map[i] = tmp2;
        }


        int maxCount = 0;

        for (int i = 0; i < rows; i++) {
            int tmpRes = map[1][0];
            for (int j = 0; j < cols; j++) {


            }
        }




    }

    static void getMaxRes(int [][] map,int i,int j,int cols,int rows) {

    }
}
