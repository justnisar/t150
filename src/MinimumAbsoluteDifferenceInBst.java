package src;

public class MinimumAbsoluteDifferenceInBst {

    private int miniumumAbsoluteDifference = 0;
    private int prev = -1;
    private void inOrder(TreeNode root){
        if(root != null){
            inOrder(root.left);
            if(prev != -1){
                miniumumAbsoluteDifference = Math.min(Math.abs(root.val - prev), miniumumAbsoluteDifference);
            }
            prev = root.val;
            inOrder(root.right);
        }
    }

    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return miniumumAbsoluteDifference;
    }

}
