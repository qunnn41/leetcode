package answer;

import auxiliary.TreeNode;

public class ConstructBinaryTreeFromPreInTraversal {
	/**
	 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
	 */
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        int length = preorder.length;
        if (length == 0)
            return null;
        if (length == 1)
            return new TreeNode(preorder[0]);
        int root = preorder[0], index = 0;
        TreeNode result = new TreeNode(root);
        while (index < length && inorder[index] != root)
            index ++;
        if (index == 0) {
            result.left = null;
            int[] pre = new int[length - 1];
            int[] in = new int[length - 1];
            for (int i = 0; i < length - 1; ++i) {
                pre[i] = preorder[i + 1];
                in[i] = inorder[i + 1];
            }
            result.right = buildTree(pre, in);
        } else if (index == length - 1) {
            result.right = null;
            int[] pre = new int[length - 1];
            int[] in = new int[length - 1];
            for (int i = 0; i < length - 1; ++i) {
                pre[i] = preorder[i + 1];
                in[i] = inorder[i];
            }
            result.left = buildTree(pre, in);
        } else {
            int[] pre_l = new int[index];
            int[] in_l = new int[index];
            int[] pre_r = new int[length - 1 - index];
            int[] in_r = new int[length - 1 - index];
            for (int i = 0; i < index; ++i) {
                pre_l[i] = preorder[i + 1];
                in_l[i] = inorder[i];
            }
            
            for (int i = index + 1; i < length; ++i) {
                pre_r[i - index - 1] = preorder[i];
                in_r[i - index - 1] = inorder[i];
            }
            
            result.left = buildTree(pre_l, in_l);
            result.right = buildTree(pre_r, in_r);
        }//end if
        return result;
    }
}
