package Second_Chapter;

import Helper.ListNode;

import java.util.ArrayList;

/**
 * @author Mert Ozer
 * Write code to remove duplicates from an unsorted linked list.
FOLLOW UP
How would you solve this problem if a temporary buffer is not allowed?
 */
public class Remove_Duplicates_2_1 {
    public static void main(String[] args){

    }
    public ListNode removeDuplicates(ListNode head){
        ListNode n = head;
        ListNode pre = head;
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null){
            if (!list.contains(head.val)){
                list.add(head.val);
                pre = head;
            }
            else {
                pre.next = head.next;
            }
            head = head.next;
        }
        return n;
    }
}
