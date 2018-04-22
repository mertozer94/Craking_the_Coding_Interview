package Fourth_Chapter;

import Helper.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

import static Fourth_Chapter.Minimal_Tree_4_2.createBinarySearchTree;

/**
 * @author Mert Ozer
 * Given a binary tree, design a n algorithm which creates a linked list of all the nodes
at each depth (e.g., if you have a tree with depth D, you'll have D linked lists).
 */
public class List_of_Depths_4_3 {
    public static void main(String[] args){
        int[] array = {1,2,3,4,5,6,7,8,9};
        TreeNode root = createBinarySearchTree(array);
        ArrayList<LinkedList<TreeNode>> result = createLevelLinkedList(root);
    }
    public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<>();
        LinkedList<TreeNode> current = new LinkedList<>();
        if (root != null) {
            current.add(root);
        }
        while (!current.isEmpty()){
            result.add(current);
            LinkedList<TreeNode> parents = current;
            current = new LinkedList<>();
            for (TreeNode parent:parents){
                if (parent.left != null)
                    current.add(parent.left);

                if (parent.right != null)
                    current.add(parent.right);
            }
        }
        return result;
    }
}
