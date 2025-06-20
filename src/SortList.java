package src;

public class SortList {

    private ListNode getMid(ListNode head){
        ListNode prev = null;
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        return slow;
    }

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode mid = getMid(head);
        head = sortList(head);
        mid = sortList(mid);
        return merge(head, mid);
    }

    private ListNode merge(ListNode head1, ListNode head2){
        ListNode result = null, current1 = head1, current2 = head2, current = null;
        while(current1 != null && current2 != null){
            if(current1.val <= current2.val){
                if(result == null){
                    result = current = current1;
                }
                else{
                    current.next = current1;
                    current = current1;
                }
                current1 = current1.next;
            }
            else{
                if(result == null){
                    result = current = current2;
                }
                else{
                    current.next = current2;
                    current = current2;
                }
                current2 = current2.next;
            }

        }
        if(current1 != null){
            current.next = current1;
        }
        if(current2 != null){
            current.next = current2;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        new SortList().sortList(head);
    }

}
