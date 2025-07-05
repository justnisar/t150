package src;

public class RotateList {

    private int getLength(ListNode head){
        int count = 0;
        ListNode current = head;
        while(current != null){
            count++;
            current = current.next;
        }
        return count;
    }

    private ListNode getBreakingNode(ListNode prev, ListNode head, int breakPoint, int n){
        if(n == breakPoint){
            prev.next = null;
            return head;
        }
        return getBreakingNode(head, head.next, breakPoint, n-1);
    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        int length = getLength(head);
        k = k % length;
        if(k == 0){
            return head;
        }
        ListNode newHead = getBreakingNode(null, head, k, length);
        ListNode current = newHead;
        while(current.next != null){
            current = current.next;
        }
        current.next = head;
        return newHead;
    }
}
