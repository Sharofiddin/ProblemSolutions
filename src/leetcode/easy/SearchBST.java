package leetcode.easy;

import java.util.Stack;

class TreeNode {
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

public class SearchBST {
    public static TreeNode searchBST(TreeNode root, int val) {
	Stack<TreeNode> nodes = new Stack<>();
	nodes.push(root);
	while (!nodes.isEmpty()) {
	    TreeNode node = nodes.pop();
	    if (node != null) {
		if (node.val == val) {
		    return node;
		} else {
		    nodes.push(node.right);
		    nodes.push(node.left);
		}
	    }
	}
	return null;
    }

    public static void main(String[] args) {

    }
}
