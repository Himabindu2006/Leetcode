/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    int diameter = 0; // stores the maximum diameter found

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return diameter;
    }

    private int depth(TreeNode node) {
        if (node == null)
            return 0;

        // Recursively get left and right subtree heights
        int left = depth(node.left);
        int right = depth(node.right);

        // Update the diameter (longest path through current node)
        diameter = Math.max(diameter, left + right);

        // Return height of this subtree
        return 1 + Math.max(left, right);
    }
}
