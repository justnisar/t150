package src;

public class ReverseNodesInKGroup {

    private ListNode reverseList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode prev = null;
        ListNode current = head;
        while(current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        if(k == 1){
            return head;
        }

        int i = 0;
        ListNode prev = null;
        ListNode current = head;
        while(current != null && i < k){
            prev = current;
            current = current.next;
            i++;
        }

        if(i != k){
            return head;
        }

        prev.next = null;
        ListNode newHead = reverseList(head);
        head.next = reverseKGroup(current, k);
        return newHead;

    }

}
