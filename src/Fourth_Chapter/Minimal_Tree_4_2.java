package Fourth_Chapter;

import Helper.TreeNode;

/**
 * @author Mert Ozer
 * Given a sorted (increasing order) array with unique integer elements, write an
algorithm to create a binary search tree with minimal height.
 */
public class Minimal_Tree_4_2 {
    public static void main(String[] args){
        int[] array = {1,2,3,4,5,6,7,8,9};
        TreeNode root = createBinarySearchTree(array);
    }
    public static TreeNode createBinarySearchTree(int[] sortedArray){
        if (sortedArray.length == 0)
            return null;
        return helperFunction(sortedArray, 0,sortedArray.length-1);
        }
    public static TreeNode helperFunction(int[] sortedArray, int begin, int end){

        if(end < begin)
            return null;

        int mid = (begin + end)/2;

        TreeNode root = new TreeNode(sortedArray[mid]);
        root.left = helperFunction(sortedArray, begin, mid-1);

        root.right = helperFunction(sortedArray, mid+1, end);

        return root;
    }
}
