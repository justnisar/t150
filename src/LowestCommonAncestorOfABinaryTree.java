package src;

public class LowestCommonAncestorOfABinaryTree {

    /*public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         if(root == null){
             return null;
         }

         if(root == p || root == q ){
             return root;
         }

         TreeNode left = lowestCommonAncestor(root.left, p, q);
         TreeNode right = lowestCommonAncestor(root.right, p, q);

         if(left != null && right != null){
             return root;
         }

         if(left != null){
             return left;
         }

         if(right != null){
             return right;
         }

         return null;
    }*/

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        if(root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null){
            return root;
        }
        if(left != null){
            return left;
        }
        return right;

    }
}
