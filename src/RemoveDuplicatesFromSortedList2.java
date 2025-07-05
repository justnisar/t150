package src;

public class RemoveDuplicatesFromSortedList2 {

    public ListNode deleteDuplicates(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }
        ListNode current = head;

        if(current.val == current.next.val){
            while(current != null && current.next != null && current.val == current.next.val){
                current = current.next;
            }
            return deleteDuplicates(current.next);
        }
        else{
            head.next = deleteDuplicates(head.next);
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);
        new RemoveDuplicatesFromSortedList2().deleteDuplicates(head);
    }

}
