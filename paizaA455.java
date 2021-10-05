import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class paizaA455 {
    static private int rCount = 0;
    static private int gCount = 0;
    static private int bCount = 0;
    static List<List<String>> qipan = new ArrayList<>();
    // R G B
    static private List<String> stones = new ArrayList<>();

    public static void main(String[] args) {
        sol1();
    }


    static void sol() {
        Scanner sc = new Scanner(System.in);


        int N = sc.nextInt();
        List<List<Integer>> builds = new ArrayList<>(N);

        //input data
        for (int i = 0; i < N; i++) {
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                tmp.add(sc.nextInt());
            }
            builds.add(tmp);
        }


        int pre, back, left, right;
        pre = sc.nextInt();
        back = sc.nextInt();
        left = sc.nextInt();
        right = sc.nextInt();
        String res = "";
        int preMax = 0;
        int backMax = 0;
        int leftMax = 0;
        int rightMax = 0;
        List<Integer> cols = new ArrayList<>();
        // calculate
        // use left and right to confirm col
        for (int i = 1; i <= N - 2; i++) {
            if (left != right) {
                if (builds.get(i).contains(left) && builds.get(i).contains(right)) {
                    cols.add(i);
                }
            }
            if (left == right && builds.get(i).indexOf(left) != builds.get(i).lastIndexOf(right)) {
                cols.add(i);
            }

        }
        //use pre and back to confirm row
        for (int j = 1; j < N - 1; j++) {
            for (Integer col : cols) {
                preMax = 0;
                backMax = 0;
                leftMax = 0;
                rightMax = 0;
                for (int i = 0; i < col; i++) {
                    preMax = Math.max(preMax, builds.get(i).get(j));
                }
                if (preMax != pre) {
                    continue;
                }
                for (int i = col + 1; i < N; i++) {
                    backMax = Math.max(backMax, builds.get(i).get(j));
                }
                if (backMax != back) {
                    continue;
                }
                for (Integer row : builds.get(col).subList(0, j)) {
                    leftMax = Math.max(row, leftMax);
                }
                if (left != leftMax) {
                    continue;
                }
                for (Integer row : builds.get(col).subList(j + 1, N)) {
                    rightMax = Math.max(row, rightMax);
                }
                if (right != rightMax) {
                    continue;
                }

                res = res + (col + 1) + " " + (j + 1) + ",";

            }

        }


        String[] allres = res.split(",");
        for (String t : allres) {
            System.out.println(t);
        }


    }


    static void sol1() {
        Scanner sc = new Scanner(System.in);


        int N = sc.nextInt();
        int M = sc.nextInt();

        //input data
        for (int i = 0; i < N; i++) {

            List<String> tmp = new ArrayList<>();
            String t = sc.next();
            for (String x : t.split("")) {
                add(x);
                tmp.add(x);
            }
            qipan.add(tmp);
        }

        stones.add("R");
        stones.add("G");
        stones.add("B");

        for (int i = 0; i < M; i++) {
            String t = stones.get(i % 3);
            add(t);
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;

            //set
            qipan.get(y).set(x,t);

            int tmpY = y;
            int tmpX = x;
            // up down
            while (tmpY != 0) {
                tmpY--;
                if (qipan.get(tmpY).get(x).equals(t) && y - tmpY > 1) {
                    replace(x,y,x,tmpY,t);
                    break;
                }

            }
            tmpY = y;
            while (tmpY != N-1) {
                tmpY++;
                if (qipan.get(tmpY).get(x).equals(t) && tmpY - y > 1) {
                    replace(x,y,x,tmpY,t);
                    break;
                }

            }

            // right left
            while (tmpX != 0) {
                tmpX--;
                if (qipan.get(y).get(tmpX).equals(t) && x - tmpX > 1) {
                    replace(x,y,tmpX,y,t);
                }

            }
            tmpX = x;
            while (tmpX != N-1) {
                tmpX++;
                if (qipan.get(y).get(tmpX).equals(t) && tmpX - x > 1) {
                    replace(x,y,tmpX,y,t);
                }

            }

            // Right slash  left slash
            tmpX = x;tmpY=y;
            while (tmpX != 0 && tmpY != 0) {
                tmpX--;
                tmpY--;
                if (qipan.get(tmpY).get(tmpX).equals(t) && x - tmpX > 1 && y - tmpY > 1) {
                    replace(x,y,tmpX,tmpY,t);
                }
            }
            tmpX = x;tmpY=y;
            while (tmpX != 0 && tmpY != N-1) {
                tmpX--;
                tmpY++;
                if (qipan.get(tmpY).get(tmpX).equals(t) && x - tmpX > 1 && tmpY - y > 1) {
                    replace(x,y,tmpX,tmpY,t);
                }
            }
            tmpX = x;tmpY=y;
            while (tmpX != N-1 && tmpY != N-1) {
                tmpX++;
                tmpY++;
                if (qipan.get(tmpY).get(tmpX).equals(t) && tmpX - x > 1 && tmpY - y > 1) {
                    replace(x,y,tmpX,tmpY,t);
                }
            }
            tmpX = x;tmpY=y;
            while (tmpX != N-1 && tmpY != 0) {
                tmpX++;
                tmpY--;
                if (qipan.get(tmpY).get(tmpX).equals(t) && tmpX - x > 1 && y - tmpY > 1) {
                    replace(x,y,tmpX,tmpY,t);
                }
            }




        }
        for (List<String> row : qipan) {
            for (String t : row) {
                System.out.print(t);
            }
            System.out.println();
        }

        if (rCount > bCount && rCount > gCount) {
            System.out.println("R");
        }
        if (bCount > rCount && bCount > gCount) {
            System.out.println("B");
        }
        if (gCount > rCount && gCount > bCount) {
            System.out.println("G");
        }
        if (rCount == gCount && gCount > bCount) {
            if (stones.get((M-1) % 3).equals("R")) {
                System.out.println("R");
            } else {
                System.out.println("G");
            }
        }
        if (bCount == gCount && gCount > rCount) {
            if (stones.get((M-1) % 3).equals("G")) {
                System.out.println("G");
            } else {
                System.out.println("B");
            }
        }
        if (rCount == bCount && bCount > gCount) {
            if (stones.get((M-1) % 3).equals("R")) {
                System.out.println("R");
            } else {
                System.out.println("B");
            }
        }




    }

    static private void add(String t) {
        if ("R".equals(t)) {
            rCount++;
        } else if ("G".equals(t)) {
            gCount++;
        } else if ("B".equals(t)) {
            bCount++;
        }
    }

    static private void sub(String t) {
        if ("R".equals(t)) {
            rCount--;
        } else if ("G".equals(t)) {
            gCount--;
        } else if ("B".equals(t)) {
            bCount--;
        }
    }

    static private void replace(int x,int y,int newX,int newY, String newS) {
        if (newX > x && y == newY) {
            for (int i = x+1; i < newX; i++) {
                doReplace(i,y,newS);
            }
        }
        if (newX > x && newY > y) {
            int tmpx = x,tmpy = y;
            while (tmpx != newX && tmpy != newY) {
                tmpx++;
                tmpy++;
                doReplace(tmpx,tmpy,newS);

            }
        }
        if (newX > x && newY < y) {
            int tmpx = x,tmpy = y;
            while (tmpx != newX && tmpy != newY) {
                tmpx++;
                tmpy--;
                doReplace(tmpx,tmpy,newS);

            }
        }
        if (newX == x) {
           if (newY < y) {
               for (int i = y-1; i > newY; i--) {
                   doReplace(x,i,newS);
               }
           } else {
               for (int i = y+1; i < newY; i++) {
                   doReplace(x,i,newS);
               }
           }
        }
        if (newX < x) {
            if (newY == y) {
                for (int i = newX + 1; i < x; i++) {
                    doReplace(i,y,newS);
                }
            }

            if (newY < y) {
                int tmpx = x,tmpy = y;
                while (tmpx != newX && tmpy != newY) {
                    tmpx--;
                    tmpy--;
                    doReplace(tmpx,tmpy,newS);

                }
            }

            if (newY > y) {
                int tmpx = x,tmpy = y;
                while (tmpx != newX && tmpy != newY) {
                    tmpx--;
                    tmpy++;
                    doReplace(tmpx,tmpy,newS);

                }
            }

        }

    }

    static private void doReplace(int x,int y,String newS) {
        String old = qipan.get(y).get(x);
        if (stones.contains(old)) {
            sub(old);
            qipan.get(y).set(x,newS);
            add(newS);
        }
    }
}
