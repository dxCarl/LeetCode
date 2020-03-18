package com.xiao.deng.leetcode.diameter_of_binary_tree;

/**
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
 * 示例 :
 * 给定二叉树
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diameter-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    int ans;

    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        maxDepth(root);
        return ans - 1;
    }

    private int maxDepth(TreeNode node) {
        if (null == node) {
            return 0;
        }
        TreeNode left = node.left;
        TreeNode right = node.right;
        int leftDep = maxDepth(left);
        int rightDep = maxDepth(right);
        ans = Math.max(ans, leftDep + rightDep + 1);
        return Math.max(leftDep, rightDep)  + 1 ;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;

        int ans = new Solution().diameterOfBinaryTree(null);
        System.out.println(ans);


    }
}
