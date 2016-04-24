package answer;

import auxiliary.TreeNode;

public class ConstructBinaryTreeFromInPostTraversal {
	/**
	 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
	 */
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        int length = inorder.length;
        if (length == 0)
        	return null;
        if (length == 1)
        	return new TreeNode(inorder[0]);
        int root = postorder[length - 1], index = 0;
        TreeNode result = new TreeNode(root);
        while (index < length && inorder[index] != root)
        	index ++;
        if (index == 0) {
        	result.left = null;
        	int[] in = new int[length - 1];
        	int[] post = new int[length - 1];
        	
        	for (int i = 0; i < length - 1; ++i) {
        		in[i] = inorder[i + 1];
        		post[i] = postorder[i];
        	}
        	
        	result.right = buildTree(in, post);
        } else if (index == length - 1) {
        	result.right = null;
        	int[] in = new int[length - 1];
        	int[] post = new int[length - 1];
        	
        	for (int i = 0; i < length - 1; ++i) {
        		in[i] = inorder[i];
        		post[i] = postorder[i];
        	}
        	
        	result.left = buildTree(in, post);
        } else {
        	int[] in_l = new int[index];
        	int[] in_r = new int[length - 1 - index];
        	int[] post_l = new int[index];
        	int[] post_r = new int[length - 1 - index];
        	
        	for (int i = 0; i < index; ++i) {
        		in_l[i] = inorder[i];
        		post_l[i] = postorder[i];
        	}
        	
        	for (int i = index + 1; i < length; ++i) {
        		in_r[i - index - 1] = inorder[i];
        		post_r[i - index - 1] = postorder[i - 1];
        	}
        	
        	result.left = buildTree(in_l, post_l);
        	result.right = buildTree(in_r, post_r);
        }
        
        return result;
    }
}
