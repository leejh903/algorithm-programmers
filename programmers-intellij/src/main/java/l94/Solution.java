package l94;

import java.util.ArrayList;
import java.util.List;

class Solution {
	private List<Integer> answer = new ArrayList<>();

	public List<Integer> inorderTraversal(TreeNode root) {
		traverse(root);
		return answer;
	}

	public void traverse(TreeNode node) {
		if (node != null) {
			traverse(node.left);
			answer.add(node.val);
			traverse(node.right);
		}
	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {}

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
