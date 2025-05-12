package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Pair{
    TreeNode node;
    int level;
    public Pair(TreeNode node, int level){
        this.node = node;
        this.level = level;
    }
}

public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 0));

        int levelLookingFor = 0;

        while(!stack.isEmpty()){

            Pair top = stack.pop();
            if(top.level == levelLookingFor){
                result.add(top.node.val);
                levelLookingFor++;
            }
            if(top.node.left != null){
                stack.push(new Pair(top.node.left, top.level + 1));
            }
            if(top.node.right != null){
                stack.push(new Pair(top.node.right, top.level + 1));
            }

        }

        return result;
    }
}
