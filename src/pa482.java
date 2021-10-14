import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class pa482 {
    static String player = "S";
    static String road = ".", wall = "#";
    static String walked = "?";
    static List<List<String>> map = new ArrayList<>();
    static Stack<int[]> stack = new Stack<>();

    public static void main(String[] args) {
        if (sol()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }

    static boolean sol() {
        Scanner sc = new Scanner(System.in);

        int row = sc.nextInt();
        int col = sc.nextInt();

        int x = 0, y = 0;

        List<Integer> xRes = new ArrayList<>();
        xRes.add(0);
        xRes.add(col - 1);

        List<Integer> yRes = new ArrayList<>();
        yRes.add(0);
        yRes.add(row - 1);
        for (int i = 0; i < row; i++) {
            List<String> tmp = new ArrayList<>();
            Collections.addAll(tmp, sc.next().split(""));
            if (tmp.contains(player)) {
                x = tmp.indexOf(player);
                y = i;
            }
            map.add(tmp);

        }
        if (xRes.contains(x) || yRes.contains(y)) {
            return true;
        }
        // x = 0 or col - 1 y = 0 or row - 1
        // dfs → ↑ ← ↓
        stack.add(new int[] {x, y});
        while (!stack.isEmpty()) {
            x = stack.peek()[0];
            y = stack.peek()[1];
            while (trace(x, y)) {
                int[] tmp = stack.peek();
                if (xRes.contains(tmp[0]) || yRes.contains(tmp[1])) {
                    return true;
                } else {
                    map.get(tmp[1]).set(tmp[0], walked);
                    x = stack.peek()[0];
                    y = stack.peek()[1];
                }
            }
            stack.pop();
        }
        return false;
    }

    static boolean trace(int x,int y) {
        // right
        if (map.get(y).get(x+1).equals(road)) {
            stack.add(new int[]{x+1,y});
            return true;
        }
        if (map.get(y).get(x-1).equals(road)) {
            stack.add(new int[]{x-1,y});
            return true;
        }
        if (map.get(y+1).get(x).equals(road)) {
            stack.add(new int[]{x,y+1});
            return true;
        }

        if (map.get(y-1).get(x).equals(road)) {
            stack.add(new int[]{x,y-1});
            return true;
        }
        return false;
    }

}
