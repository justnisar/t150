import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree {

    public List<Double> averageOfLevels(TreeNode root) {

        List<Double> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        int nodeCount = 0;
        double totalSum = 0;
        while(!queue.isEmpty()) {


            TreeNode current = queue.remove();
            if(current == null) {
                if(!queue.isEmpty()){
                    queue.add(null);
                }
                result.add(totalSum/nodeCount);
                totalSum = 0;
                nodeCount = 0;
                continue;
            }
            totalSum += current.val;
            nodeCount++;
            if(current.left != null) {
                queue.add(current.left);
            }
            if(current.right != null){
                queue.add(current.right);
            }

        }

        return result;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        new AverageOfLevelsInBinaryTree().averageOfLevels(root);
    }

}
