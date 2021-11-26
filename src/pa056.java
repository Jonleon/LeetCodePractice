import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class pa056 {
    static int bCount = 0;
    static int wCount = 0;
    static String B = "B";
    static String W = "W";
    static String E = ".";

    public static void main(String[] args) {
        sol();
    }

    static void sol() {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int Q = sc.nextInt();
        sc.nextLine();
        List<Chess> list = new ArrayList<>();
        for (int i = 1; i <= Q; i++) {
            String line = sc.nextLine();
            String[] tmp = line.split(" ");
            int x = Integer.parseInt(tmp[0]);
            int y = Integer.parseInt(tmp[1]);
            int val = Integer.parseInt(tmp[2]);
            Chess c = new Chess(x, y, val);

            list.add(c);
        }

        String[][] map = new String[N][N];

        // init map
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = E;
            }
        }
        int order = 0;
        for (Chess c : list) {
            int x = c.getX();
            int y = c.getY();
            int val = c.getVal();
            order++;

            String color = order % 2 == 0 ? W : B;
            map[x][y] = color;
            if (color.equals(B)) {
                bCount++;

            } else if (color.equals(W)) {
                wCount++;
            }

            // up
            while (y < c.getY() + val && y < N - 1) {
                y++;
                doMap(map, x, y, N, color);
            }
            x = c.getX();
            y = c.getY();
            // down
            while (y > c.getY() - val && y > 0) {
                y--;
                doMap(map, x, y, N, color);
            }
            x = c.getX();
            y = c.getY();
            // left
            while (x > c.getX() - val && x > 0) {
                x--;
                doMap(map, x, y, N, color);
            }
            x = c.getX();
            y = c.getY();
            // right
            while (x < c.getX() + val && x < N - 1) {
                x++;
                doMap(map, x, y, N, color);
            }
            // zuo shang
            switch (val) {
                case 1:
                    break;
                case 2:
                    doMap(map, c.getX() + 1, c.getY() + 1, N, color);
                    doMap(map, c.getX() - 1, c.getY() - 1, N, color);
                    doMap(map, c.getX() + 1, c.getY() - 1, N, color);
                    doMap(map, c.getX() - 1, c.getY() + 1, N, color);
                    break;
                case 3:
                    doMap(map, c.getX() + 1, c.getY() + 1, N, color);
                    doMap(map, c.getX() - 1, c.getY() - 1, N, color);
                    doMap(map, c.getX() + 1, c.getY() - 1, N, color);
                    doMap(map, c.getX() - 1, c.getY() + 1, N, color);

                    doMap(map, c.getX() + 3, c.getY(), N, color);
                    doMap(map, c.getX() - 3, c.getY(), N, color);
                    doMap(map, c.getX(), c.getY() - 3, N, color);
                    doMap(map, c.getX(), c.getY() + 3, N, color);

                    doMap(map, c.getX() + 1, c.getY() + 2, N, color);
                    doMap(map, c.getX() - 1, c.getY() + 2, N, color);
                    doMap(map, c.getX() + 2, c.getY() - 1, N, color);
                    doMap(map, c.getX() + 2, c.getY() + 1, N, color);

                    doMap(map, c.getX() + 1, c.getY() - 2, N, color);
                    doMap(map, c.getX() - 1, c.getY() - 2, N, color);
                    doMap(map, c.getX() - 2, c.getY() - 1, N, color);
                    doMap(map, c.getX() - 2, c.getY() + 1, N, color);
                    break;
                default:
                    break;
            }

        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(map[i][j]);
            }
            System.out.print("\n");
        }
        if (bCount > wCount) {
            System.out.println("B");
        } else if (bCount == wCount) {
            System.out.println("D");
        } else {
            System.out.println("W");
        }

    }

    static void doMap(String[][] map, int x, int y, int N, String color) {
        if (x < N && x >= 0 && y >= 0 && y < N) {
            if (!color.equals(map[x][y]) && !E.equals(map[x][y])) {
                map[x][y] = color;
                if (color.equals(B)) {
                    bCount++;
                    wCount--;

                } else if (color.equals(W)) {
                    wCount++;
                    bCount--;
                }
            }

        }

    }

    static class Chess {
        int x;
        int y;
        int val;

        Chess(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        int getX() {
            return x - 1;
        }

        public void setX(int x) {
            this.x = x;
        }

        int getY() {
            return y - 1;
        }

        public void setY(int y) {
            this.y = y;
        }

        int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }
    }
}
