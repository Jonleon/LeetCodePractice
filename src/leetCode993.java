public class leetCode993 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        boolean res = isCousins(root, 3, 4);
        System.out.println(res);

    }

    public static boolean isCousins(TreeNode root, int x, int y) {
        if (root.val == x || root.val == y) {
            return false;
        }

        TreeNode px = null;
        px = getParent(root, x, px);
        TreeNode py = null;
        py = getParent(root, y, py);
        if (px.equals(root) || py.equals(root)) {
            return false;
        }
        if (!px.equals(py)) {
            return getParent(root, px.val, px).equals(getParent(root, py.val, py));
        } else {
            return false;
        }


    }

    static TreeNode getParent(TreeNode node, int target, TreeNode t) {
        if (node.left != null) {
            if (node.left.val == target) {
                t = node;
            } else {
                t = getParent(node.left, target, t);
            }

        }
        if (node.right != null) {
            if (node.right.val == target) {
                t = node;
            } else {
                t = getParent(node.right, target, t);
            }

        }


        return t;
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
