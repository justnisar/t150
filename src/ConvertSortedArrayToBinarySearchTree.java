package src;

import com.sun.source.tree.Tree;

public class ConvertSortedArrayToBinarySearchTree {

    private TreeNode recFun(int[] nums, int start, int end){
        if(start < end){
            return null;
        }
        else if(start == end){
            return new TreeNode(nums[start]);
        }
        int mid = start + (end - start)/2;
        TreeNode result = new TreeNode(mid);
        result.left = recFun(nums,start, mid - 1);
        result.right = recFun(nums,mid + 1,end);
        return result;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return recFun(nums, 0, nums.length - 1);
    }
}
