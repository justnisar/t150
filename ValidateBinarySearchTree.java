import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree {

    private void recFun(TreeNode root, List<TreeNode> list){
        if(root != null){
            recFun(root.left, list);
            list.add(root);
            recFun(root.right, list);
        }
    }

    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        List<TreeNode> list = new ArrayList<>();
        recFun(root, list);
        for(int i = 1; i < list.size(); i++){
            if(list.get(i).val < list.get(i-1).val){
                return false;
            }
        }
        return false;
    }
}
