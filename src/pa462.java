import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class pa462 {

    static Set<Integer> ableto = new HashSet<>();
    static int[] ways = new int[2];
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        sol();
    }

    static void sol() {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();
        ways[0] = A;
        ways[1] = B;
        walk(0,N);

        int abled = ableto.size() - 1;
        System.out.println(N - abled);

    }

    static void walk (int tempSteps,int end) {
        if (tempSteps <= end) {
            ableto.add(tempSteps);
        }
        if (tempSteps > end) {
            if (tempSteps - end <= Math.max(ways[0],ways[1])) {
                ableto.add(end);
            }
            return;
        }
        for (int i = 0; i < ways.length; i++) {
            list.add(ways[i]);
            tempSteps += ways[i];
            walk(tempSteps,end);

            tempSteps -= ways[i];
            list.remove(list.size()-1);
        }


    }


}
