package Fourth_Chapter;

import Helper.TreeNode;
import Helper.Utils;

import static Fourth_Chapter.Minimal_Tree_4_2.createBinarySearchTree;

/**
 * @author Mert Ozer
 * Implement a function to check if a binary tree is a binary search tree.
 */
public class Validate_BST_4_5 {
    public static void main(String[] args){
        int[] array = {1,2,3,4,5,6,7,8,9};
        TreeNode root = createBinarySearchTree(array);
        System.out.println(validateBST(root));

        TreeNode root2 = Utils.createNonBinarySearchTree();
        System.out.println(validateBST(root2));


    }
    public static boolean validateBST(TreeNode head){
        if (head == null)
            return false;

        return validateBST(head,Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public static boolean validateBST(TreeNode head,int min, int max){
        if (head == null)
            return true;

        if (head.val < min || head.val > max)
            return false;

        return validateBST(head.left, min, head.val) && validateBST(head.right,head.val,max);
    }
}
