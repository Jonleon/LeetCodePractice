import com.sun.javafx.binding.StringFormatter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class pizza255 {

    public static void main(String[] args) {
        solu();
    }


    public static void solu() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();



        int[][] numbers = new int[n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0;j < 4;j++) {
                numbers[i][j] = sc.nextInt();
            }

        }

        List<Integer> res = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            int[] thisRow = numbers[i];

            int sPrice = thisRow[1];
            int sDis = thisRow[0];
            int addDis = thisRow[2];
            int addPrice = thisRow[3];

            int totalPrice = sPrice;
            if (x >= sDis) {
                totalPrice = totalPrice + addPrice + getAddPrice(x,sDis,addDis,addPrice);
            }
            res.add(totalPrice);
        }

        res.sort(Comparator.naturalOrder());

        System.out.println(String.format("%d %d",res.get(0),res.get(n-1)));


    }

    private static int getAddPrice(int targetDis,int sDis,int addDis,int addPrice) {
        int res=0;

        int times = ((targetDis - sDis) / addDis);
        for (int i = 0; i < times; i++) {
            res += addPrice;
        }

        return res;
    }
}
