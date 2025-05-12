package src;

class ListNode {
    int val;
    ListNode next;
    ListNode prev;

    ListNode(int x) {
        val = x;
        next = null;
        prev = null;
    }
}

public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}
