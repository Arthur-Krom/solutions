package solutions.reverselinkedlist;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void printNodeWithText(String text){
        if(this.next != null){
            System.out.println(text + " node: " + this.val + " next: " + next.val);
        }else{
            System.out.println(text + " node: " + this.val + " next is empty");
        }
    }

    public static void printList(ListNode listNode) {
        System.out.println("------");
        do {
            System.out.println("val: " + listNode.val);
            listNode = listNode.next;
        } while (listNode != null);
    }
}
