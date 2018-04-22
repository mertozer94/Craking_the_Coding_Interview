package Fourth_Chapter;

import Helper.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

import static Fourth_Chapter.Minimal_Tree_4_2.createBinarySearchTree;

/**
 * @author Mert Ozer
 * Implement a function to check if a binary tree is balanced. For the purposes of
this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any
node never differ by more than one.
 */
public class Check_Balanced_4_4 {
    public static void main(String[] args){
        int[] array = {1,2,3,4,5,6,7,8,9};
        TreeNode root = createBinarySearchTree(array);
        System.out.println(isBalanced(root));

    }
    public static boolean isBalanced(TreeNode head){
        if (head == null)
            return true;

        if (Math.abs(countDepth(head.left)-countDepth(head.right)) > 1)
            return false;

        else
            return isBalanced(head.left) && isBalanced(head.right);
    }
    public static int countDepth(TreeNode head){
        if (head == null)
            return 0;

        int countLeft = countDepth(head.left) + 1;
        int countRight = countDepth(head.right) + 1;

        return Math.max(countLeft, countRight);
    }
}
