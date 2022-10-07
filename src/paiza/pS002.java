package paiza;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class pS002 {
    private static int startX = -1;
    private static int startY = -1;
    private static int endX = -1;
    private static int endY = -1;

    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    private static String goal = "g";
    private static String road = "0";
    private static String walked = "9";

    public static void main(String[] args) {
        sol();
    }

    static public void sol() {
        Scanner sc = new Scanner(System.in);

        int cols = sc.nextInt();
        int rows = sc.nextInt();
        String[][] map = new String[rows][cols];
        sc.nextLine();
        for (int i = 0; i < rows; i++) {
            String[] tmp = sc.nextLine().split(" ");
            for (int j = 0; j < cols; j++) {
                if (tmp[j].equals("s")) {
                    startX = i;
                    startY = j;
                } else if (tmp[j].equals("g")) {
                    endX = i;
                    endY = j;
                }
            }
            map[i] = tmp;

        }
        if (startX < 0 || startY < 0 || endX < 0 || endY < 0) {
            System.out.println("Fail");
            return;
        }

        Deque<Node> nodeDeque = new LinkedList<>();

        nodeDeque.offer(new Node(startX, startY));
        // String [][] walkedMap = new String[rows][cols];
        map[startX][startY] = walked;
        Node tmp;
        int res = 0;
        while (!nodeDeque.isEmpty()) {
            tmp = nodeDeque.peek();

            if (tmp.x == endX && tmp.y == endY) {
                System.out.println(tmp.steps);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int tx = tmp.x + dx[i];
                int ty = tmp.y + dy[i];
                if (tx >= 0 && ty >= 0 && tx <= rows - 1 && ty <= cols - 1) {
                    if (map[tx][ty].equals(road)) {
                        map[tx][ty] = walked;
                        nodeDeque.offer(new Node(tx, ty, tmp.steps + 1));
                    }
                    if (map[tx][ty].equals(goal)) {
                        System.out.println(tmp.steps + 1);
                        return;
                    }
                }

            }
            nodeDeque.poll();
        }

        System.out.println("Fail");

    }

    public static class Node {
        int x;
        int y;
        int steps = 0;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Node(int x, int y, int steps) {
            this.x = x;
            this.y = y;
            this.steps = steps;
        }
    }
}
