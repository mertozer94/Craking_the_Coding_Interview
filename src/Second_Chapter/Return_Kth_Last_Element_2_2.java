package Second_Chapter;

import Helper.ListNode;
import sun.text.IntHashtable;

import java.util.List;

/**
 * @author Mert Ozer
 * Implement an algorithm to find the kth to last element of a singly linked list.
 */
public class Return_Kth_Last_Element_2_2 {
    public ListNode returnKthLastElement(ListNode head, Integer k){
        ListNode wrongK = new ListNode(-1);
        ListNode runner = head;
        int countNodes = 0;
        while (runner != null){
            countNodes++;
            runner = runner.next;
        }
        if (k > countNodes)
            return wrongK;

        for (int i = 0; i < countNodes - k+1; i++){
            head = head.next;
        }
        return head;
    }
    public int recursiveKthLastElement(ListNode head, Integer k){
        if (head == null)
            return -1;

        int elNo = recursiveKthLastElement(head.next,k)+1;
        if (elNo == k)
            return head.val;

        return -1;
    }

}
