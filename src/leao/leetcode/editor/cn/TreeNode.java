package leao.leetcode.editor.cn;

public class TreeNode {
    int val;
    leao.leetcode.editor.cn.TreeNode left;
    leao.leetcode.editor.cn.TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, leao.leetcode.editor.cn.TreeNode left, leao.leetcode.editor.cn.TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}