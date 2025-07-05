package src;

public class BinaryTreeaximumPathSum {

    private int recFun(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = recFun(root.left);
        int right = recFun(root.right);

        if(root.val > sum){
            sum = root.val;
        }
        if(root.val + left > sum){
            sum = root.val + left;
        }
        if(root.val + right > sum){
            sum = root.val + right;
        }
        if(root.val + left + right > sum){
            sum = root.val + left + right;
        }
        return Math.max(root.val, Math.max(root.val + left, root.val + right));
    }

    int sum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        recFun(root);
        return sum;
    }
}
