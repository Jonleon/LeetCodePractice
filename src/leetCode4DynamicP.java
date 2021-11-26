import java.util.HashMap;
import java.util.Map;

public class leetCode4DynamicP {

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();

        int res = climbStairs(10, map);
        System.out.println(res);

    }

    /**
     * no.64 minimum path sum
     *
     * @param grid
     * @return
     */
    static int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // rigth j + 1
        // down x + 1

        return 0;
    }

    static int climbStairs(int n, Map<Integer, Integer> map) {
        if (n == 1 || n == 2) {
            return n;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int tmp = climbStairs(n - 1, map) + climbStairs(n - 2, map);
        map.put(n, tmp);
        return tmp;
    }

    /**
     *  0-1 dp
     *
     */
}
