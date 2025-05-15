package src;

public class KthSmallestElementInBst {

    private int current = 0;
    private int result = -1;
    private void inOrder(TreeNode root, int k){
        if(root != null){
            inOrder(root.left, k);
            current++;
            if(current == k){
                result = root.val;
                return;
            }
            inOrder(root.right, k);
        }
    }

    public int kthSmallest(TreeNode root, int k) {
        inOrder(root , k);
        return result;
    }
}
