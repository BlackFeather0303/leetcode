//Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.

//You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.
// a recursive method but not very fast and efficient.
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null&&t2==null) {
        	return null;
        }
        else if(t1==null) {
        	return t2;
        }
        else if (t2==null) {
        	return t1;
        }
        else{
        	TreeNode res = new TreeNode(t1.val+t2.val);
        	judge(res,t1,t2);
        	return res;
        }
    }
    public void judge(TreeNode res,TreeNode t1,TreeNode t2){
        if (t1.right!=null&&t2.right!=null) {
    		res.right = new TreeNode(0);
    		recursiveMerge(res.right,t1.right,t2.right);
    	}
    	if (t1.left!=null&&t2.left!=null) {
    		res.left = new TreeNode(0);
    		recursiveMerge(res.left,t1.left,t2.left);
    	}
    	if (t1.right==null&&t2.right!=null) {
    		res.right = t2.right;
    	}
    	if (t1.right!=null&t2.right == null) {
    		res.right = t1.right;
    	}
    	if (t1.left!=null&&t2.left==null) {
    		res.left = t1.left;
    	}
    	if (t1.left==null&&t2.left!=null) {
    		res.left = t2.left;
    	}
    }
    public void recursiveMerge(TreeNode res,TreeNode t1,TreeNode t2){
    	res.val = t1.val+t2.val;
    	judge(res,t1,t2);
    }
