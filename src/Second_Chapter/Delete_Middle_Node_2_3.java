package Second_Chapter;

import Helper.ListNode;

/**
 * @author Mert Ozer
 *
 * Implement an algorithm to delete a node in the middle (i.e., any node but
the first and last node, not necessarily the exact middle) of a singly linked list, given only access to
that node.
EXAMPLE
Input: the nodec from the linked list a->b->c->d->e->f
Result: nothing is returned, but the new linked list looks like a - >b- >d- >e- >f
 */
public class Delete_Middle_Node_2_3 {
    public void deleteMiddleNode(ListNode head){
        if (head == null || head.next == null)
            return;

        head.val = head.next.val;
        head.next = head.next.next;
        return;

    }
}
