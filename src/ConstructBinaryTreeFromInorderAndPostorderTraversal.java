package src;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    private int index = 0;

    private int findIndex(int start, int end, int number, int[] inorder) {
        int i = 0;
        for(i = start ; i <= end; i++){
            if(inorder[i] == number){
                break;
            }
        }
        return i;
    }

    private TreeNode recFun(int start, int end, int[] inorder, int[] postorder){
        if(start > end){
            return null;
        }

        TreeNode root = new TreeNode(postorder[index]);
        int rootPosInInorder = findIndex(start, end, postorder[index], inorder);
        index--;
        root.right = recFun(rootPosInInorder + 1, end,  inorder, postorder);
        root.left = recFun(start, rootPosInInorder - 1, inorder, postorder);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index = inorder.length - 1;
        return recFun(0, inorder.length - 1, inorder, postorder);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        int[] postorder = {9,15,7,20,3};
        int[] inorder = {9, 3, 15, 20, 7};
        new ConstructBinaryTreeFromInorderAndPostorderTraversal().buildTree(inorder, postorder);
    }
}
