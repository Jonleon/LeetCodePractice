import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class paizaA202 {
    public static void main(String[] args) {
        sol();
    }



    static int sol() {
        Scanner sc = new Scanner(System.in);


        int N = sc.nextInt();

        List<Integer> indexs = new ArrayList<>();

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < N; i++) {

            numbers.add(sc.nextInt());
            if (numbers.get(i) == 0) {
                indexs.add(i);
            }
        }
        if (indexs.size() < 2) {
            return 0;
        }

        int left = 0,right = 0;
        int zeroCount;
        int res = 0;
        for (int i = 0; i < numbers.size(); i++) {
            zeroCount = 0;
            for (int index : indexs) {
                if (index >= i && index <= (i+6)) {
                    zeroCount++;
                }
            }
            if (zeroCount >= 2) {
                if (i < right) {
                    left = Math.min(left,i);
                } else {
                    left = i;
                }

                right = Math.max(right,i + 6);

            }
            if (zeroCount < 2) {

                continue;
            }

            res = Math.max(res,right - left + 1);
            if (i + 6 >= numbers.size() - 1) {
                break;
            }

        }

        System.out.println(res);

        return res;

    }
}
