package Fourth_Chapter;

import Helper.TreeNode;

/**
 * @author Mert Ozer
 * Tl and T2 are two very large binary trees, with Tl much bigger than T2. Create an
algorithm to determine if T2 is a subtree of Tl.
A tree T2 is a subtree of Tl if there exists a node n in Tl such that the subtree of n is identica I to T2.
That is, if you cut off the tree at node n, the two trees would be identical.
 */
public class Check_Subtree_4_10 {
    public boolean checkSubtree(TreeNode t1, TreeNode t2){
        if (t1 == null)
            return false;
        else if (helper(t1, t2))
            return true;
        else
            return checkSubtree(t1.left, t2) || checkSubtree(t1.right, t2);
    }
    public static boolean helper(TreeNode t1, TreeNode t2){
        if (t1 == null && t2 == null)
            return true;
        else if (t1 == null || t2 == null)
            return false;
        else if (t1.val != t2.val)
            return false;
        else return helper(t1.left, t2.left) && helper(t1.right, t2.right);
    }
}
