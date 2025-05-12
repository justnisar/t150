package src;

import java.util.ArrayList;
import java.util.List;

public class SumRootToLeafNumbers {

    private int sum = 0;

    private void recFun(TreeNode root, List<TreeNode> list){

        if(root == null){
            return;
        }

        // Leaf node
        if(root.left == null && root.right == null){
            list.add(root);
            int temp = 0;
            int j = 0;
            for(int i = list.size() - 1; i >= 0; i--){
                temp = temp + list.get(i).val * (int)Math.pow(10,j);
                j++;
            }
            sum += temp;
            return;
        }

        list.add(root);
        if(root.left != null){
            recFun(root.left, list);
            list.remove(list.size()-1);
        }
        if(root.right != null){
            recFun(root.right, list);
            list.remove(list.size()-1);
        }
    }

    public int sumNumbers(TreeNode root) {
        recFun(root, new ArrayList<TreeNode>());
        return sum;
    }

    public static void main(String[] args) {
        //1,2,3
        TreeNode root = new TreeNode(1);
        //root.left = new src.TreeNode(1);
        root.right = new TreeNode(5);
        new SumRootToLeafNumbers().sumNumbers(root);
    }

}
