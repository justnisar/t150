package src;

public class RemoveNthNodeFromEndOfList {

    private int recFun(ListNode prev, ListNode head, int n){

        if(head == null){
            return 1;
        }

        int pos = recFun(head, head.next, n);

        if(pos == n){
            if(prev == null){
                return -1;
            }
            prev.next = head.next;
        }
        return pos + 1;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        int result = recFun(null, head, n);
        return result == -1 ? head.next : head;
    }


}
