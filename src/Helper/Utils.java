package Helper;

/**
 * @author Mert Ozer
 */
public class Utils {
    public static TreeNode createNonBinarySearchTree(){
        TreeNode head = new TreeNode(0);
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        TreeNode eight = new TreeNode(8);
        head.left = one;
        head.right = two;

        one.right = three;
        two.left = four;

        three.right = five;

        four.left = six;
        four.right = seven;

        five.left = eight;

        return head;
    }
}
