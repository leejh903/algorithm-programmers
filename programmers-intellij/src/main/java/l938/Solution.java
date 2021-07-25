package l938;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private int sum = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        traverse(root, low, high);
        return sum;
    }

    public void traverse(TreeNode node, int low, int high) {
        if(node != null) {
            if (node.val >= low && node.val <= high) sum += node.val;
            traverse(node.left, low, high);
            traverse(node.right, low, high);
        }
    }
}

 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
