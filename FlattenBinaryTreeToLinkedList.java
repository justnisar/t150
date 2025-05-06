public class FlattenBinaryTreeToLinkedList {

    private TreeNode prev = null;

    private void recFun(TreeNode root){
        if(root == null){
            return;
        }
        TreeNode right = root.right;;
        if(prev != null){
            prev.right = root;
        }
        prev = root;
        recFun(root.left);
        recFun(right);
    }

    public void flatten(TreeNode root) {
        TreeNode Root = root;
        recFun(root);
        TreeNode current = Root;
        while(current != null){
            current.left = null;
            current = current.right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        two.left = new TreeNode(3);
        two.right = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        five.right = new TreeNode(6);
        root.left = two;
        root.right = five;
        new FlattenBinaryTreeToLinkedList().flatten(root);
    }
}
