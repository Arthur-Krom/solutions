package solutions.reverselinkedlist;

/**
 * ----
 * problem: 206 - Reverse linked list
 * status: completed - iteratively, not recursive
 * notes:
 * ----
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 */
public class ReverseLinkedList {

    // iterative
    public ListNode reverseList(ListNode head) {
        ListNode result = head;

        if(result == null || result.next == null){
            return result;
        }

        ListNode a = new ListNode();

        while(result.next != null){
            ListNode c = new ListNode(result.val);

            if(a.next != null){
                c.next = a.next;
                a.next = c;
            }else{
                a.next = c;
            }

            result = result.next;
        }

        a.val = result.val;

        return a;
    }
}
