package paiza;


import java.util.Scanner;

public class pA066 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int start=sc.nextInt(),end=sc.nextInt();
        int maxDay=0;
        for (int i = 1; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a < start) {
                start = a;
            }
            if (a <= end + 1) {
                end = Math.max(end,b);
             } else {
                maxDay = end + 1 -start;
                start = a;
                end = b;
                maxDay = Math.max(maxDay,(end + 1 - start));


            }
        }
        maxDay = Math.max(maxDay,(end+1-start));
        System.out.println(maxDay);

    }
}
