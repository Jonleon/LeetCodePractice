import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class leetCode872 {
    static Pattern p = Pattern.compile("[^a-zA-Z0-9]");
    public static void main(String[] args) {
//        leafSimilar(null,null);
        String source = "咔咔090test=one   __+*sdf";

        Matcher matcher = p.matcher(source);
        // 把其他字符替换成 *
        String source_new = matcher.replaceAll("");
        System.out.println(source_new);

    }

    static boolean leafSimilar(TreeNode root1, TreeNode root2) {

        List<Integer> ar1 = new ArrayList<>();
        List<Integer> ar2 = new ArrayList<>();
        bianli(root1,ar1);
        bianli(root2,ar2);
        boolean res = false;
        if (ar1.size() != ar2.size()) {
            return false;
        }
        for (int i = 0; i <= ar1.size()-1; i++) {
            res = ar1.get(i).equals(ar2.get(i));
            if (res == false) {
                return res;
            }
        }
        return res;
    }

    static void bianli(TreeNode root,List<Integer> ar) {
        if (root.left == null && root.right == null) {
            ar.add(root.val);
        } else {
            if (root.left != null) {
                bianli(root.left,ar);
            }
            if (root.right != null) {
                bianli(root.right,ar);
            }
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
