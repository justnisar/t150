import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        queue.add(null);
        List<Integer> temp = new ArrayList<>();
        while(!queue.isEmpty()){

            TreeNode node = queue.remove();
            if(node == null){
                result.add(temp);
               if(queue.isEmpty()){

                   break;
               }

               temp = new ArrayList<>();
               queue.add(null);
               continue;
            }

            temp.add(node.val);

            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }

        }


        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        TreeNode x = new TreeNode(20);
        x.left = new TreeNode(15);
        x.right = new TreeNode(7);
        root.right = x;
        new BinaryTreeLevelOrderTraversal().levelOrder(root);
    }
}
