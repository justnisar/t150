
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {

    private List<Integer> getReverse(List<Integer> list){
        List<Integer> result = new ArrayList<>();
        for(int i = list.size() - 1; i >= 0; i--){
            result.add(list.get(i));
        }
        return result;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        queue.add(null);
        List<Integer> temp = new ArrayList<>();
        boolean zigZag = true;
        while(!queue.isEmpty()){

            TreeNode node = queue.remove();
            if(node == null){

                if(zigZag){
                    result.add(temp);
                }
                else{
                    result.add(getReverse(temp));
                }
                zigZag = !zigZag;
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

}
