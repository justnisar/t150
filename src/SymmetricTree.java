package src;

public class SymmetricTree {

    private boolean recFun(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) {
            return true;
        }
        if(root1 == null && root2 != null){
            return false;
        }
        if(root1 != null && root2 == null) {
            return false;
        }
        if(root1 != null && root2 != null && root1.val != root2.val) {
            return false;
        }
        return recFun(root1.left,root2.right) && recFun(root1.right,root2.left);
    }

    public boolean isSymmetric(TreeNode root) {
        return recFun(root,root);
    }
}
