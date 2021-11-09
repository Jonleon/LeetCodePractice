// Dota2 的世界里有两个阵营：Radiant(天辉)和 Dire(夜魇)
//
// Dota2 参议院由来自两派的参议员组成。现在参议院希望对一个 Dota2 游戏里的改变作出决定。他们以一个基于轮为过程的投票进行。在每一轮中，每一位参议
// 员都可以行使两项权利中的一项：
//
//
//
// 禁止一名参议员的权利：
//
// 参议员可以让另一位参议员在这一轮和随后的几轮中丧失所有的权利。
//
//
// 宣布胜利：
//
//
//
// 如果参议员发现有权利投票的参议员都是同一个阵营的，他可以宣布胜利并决定在游戏中的有关变化。
//
//
//
// 给定一个字符串代表每个参议员的阵营。字母 “R” 和 “D” 分别代表了 Radiant（天辉）和 Dire（夜魇）。然后，如果有 n 个参议员，给定字符
// 串的大小将是 n。
//
// 以轮为基础的过程从给定顺序的第一个参议员开始到最后一个参议员结束。这一过程将持续到投票结束。所有失去权利的参议员将在过程中被跳过。
//
// 假设每一位参议员都足够聪明，会为自己的政党做出最好的策略，你需要预测哪一方最终会宣布胜利并在 Dota2 游戏中决定改变。输出应该是 Radiant 或
// Dire。
//
//
//
// 示例 1：
//
//
// 输入："RD"
// 输出："Radiant"
// 解释：第一个参议员来自 Radiant 阵营并且他可以使用第一项权利让第二个参议员失去权力，因此第二个参议员将被跳过因为他没有任何权利。然后在第二轮的时候，
// 第一个参议员可以宣布胜利，因为他是唯一一个有投票权的人
//
//
// 示例 2：
//
//
// 输入："RDD"
// 输出："Dire"
// 解释：
// 第一轮中,第一个来自 Radiant 阵营的参议员可以使用第一项权利禁止第二个参议员的权利
// 第二个来自 Dire 阵营的参议员会被跳过因为他的权利被禁止
// 第三个来自 Dire 阵营的参议员可以使用他的第一项权利禁止第一个参议员的权利
// 因此在第二轮只剩下第三个参议员拥有投票的权利,于是他可以宣布胜利
//
//
//
//
// 提示：
//
//
// 给定字符串的长度在 [1, 10,000] 之间.
//
//
//
// Related Topics 贪心 队列 字符串
// 👍 220 👎 0

package leao.leetcode.editor.cn;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class Dota2Senate {
    public static void main(String[] args) {
        Solution solution = new Dota2Senate().new Solution();
        solution.func2("DRRDRDRDRDDRDRDR");
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String predictPartyVictory(String senate) {
            // RDD RRDDDD DDDRRRR RDDR RDRDRDD
            int countR = 0;
            int countD = 0;
            String res = "";

            for (int i = 0; i < senate.length(); i++) {

                if (senate.charAt(i) == 'R') {
                    if (countD > 0) {
                        countD--;
                    } else {
                        countR++;
                        res += 'R';
                    }

                } else {
                    if (countR > 0) {
                        countR--;
                    } else {
                        countD++;
                        res += 'D';
                    }
                }
                if (i == senate.length() - 1 && (countD != 0 || countR != 0)) {
                    int restart = res.length() - Math.max(countD,countR);
                    senate = res.substring(restart,(res.length())) + res.substring(0, restart);
                    res = "";
                    i = -1;
                    countD = 0;
                    countR = 0;
                    if (!senate.contains("D") || !senate.contains("R")) {
                        res = senate;
                        break;
                    }
                } else if (i == senate.length() - 1 && senate.contains("D") && senate.contains("R")) {
                    senate = res;
                    res = "";
                    i = -1;
                    countD = 0;
                    countR = 0;
                }

            }
            if (res.charAt(0) == 'R') {
                return "Radiant";
            } else {
                return "Dire";
            }

        }

        public String test(String senate) {
            List<String> se = Arrays.stream(senate.split("")).collect(Collectors.toCollection(ArrayList::new));
            if (!senate.contains("D") || !senate.contains("R")) {

            } else {
                int index = 0;
                while (se.contains("D") && se.contains("R")) {
                    func(se,index,se.get(index));
                    index++;
                    if (index > se.size() - 1) {
                        index = 0;

                    }
                }
            }
            String res = "";
            for (int i = 0; i < se.size(); i++) {
                if (!se.get(i).equals(" ")) {
                    res = se.get(i);
                }
            }
            if (res.equals("R")) {
                return "Radiant";
            } else {
                return "Dire";
            }
        }

        public void func(List<String> s, int index, String x) {
            if (!s.get(index).equals(" ")) {
                int len = s.size();
                int tmpIndex = index;
                while (tmpIndex != index - 1 && tmpIndex != -1) {
                    tmpIndex++;
                    if (tmpIndex > len - 1) {
                        tmpIndex = 0;
                    }
                    if (!s.get(tmpIndex).equals(x) && !s.get(tmpIndex).equals(" ")) {
                        s.set(tmpIndex," ");
                        break;
                    }
                }
            }

        }


        public String func2(String senate) {
            Queue<Integer> r = new LinkedList<>();
            Queue<Integer> d = new LinkedList<>();
            for (int i = 0; i < senate.length(); i++) {
                if (senate.charAt(i) == 'R') {
                    r.offer(i);
                } else {
                    d.offer(i);
                }
            }
            int len = senate.length();
            while (!r.isEmpty() && !d.isEmpty()) {
                int rIndex = r.poll();
                int dIndex = d.poll();
                if (rIndex < dIndex) {
                    r.offer(rIndex + len);
                } else {
                    d.offer(dIndex + len);
                }
            }
            if (r.isEmpty()) {
                return "Dire";
            }else {
                return "Radiant";
            }
        }
    }
    // leetcode submit region end(Prohibit modification and deletion)

}