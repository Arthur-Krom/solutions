package solutions.mergetwosortedlists;

/**
 * ----
 * problem: 21 - Merge two sorted lists
 * status: completed, beats 100% runtime, beats 33% in memory
 * notes:
 * ----
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists into one sorted list. The list should be made by splicing
 * together the nodes of the first two lists.
 * Return the head of the merged linked list.
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = null;

        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        // list with lowest value on index 0 will be current 1, if values are the same list1 will be current1
        ListNode current1 = null;
        ListNode current2 = null;
        ListNode previous1 = null;

        if (list1.val <= list2.val) {
            head = list1;
            current2 = list2;
        } else {
            head = list2;
            current2 = list1;
        }

        while (current2 != null) {

            // the node to be inserted
            ListNode node = new ListNode(current2.val, null);

            // always start with searching from the head.
            current1 = head;

            while (current1.next != null && node.val > current1.next.val) {
                current1 = current1.next;
            }

            if (current1.next != null) {
                node.next = current1.next;
                current1.next = node;
            } else {
                current1.next = node;
            }

            current2 = current2.next;
        }
        return head;
    }
}