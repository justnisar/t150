public class ReverseLinkedList2 {

    private ListNode reverseList(ListNode head){

        ListNode prev = null;
        ListNode current = head;
        ListNode next;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        /*
        Three parts
        left
        middle
        right
         */

        int i = 1;
        ListNode current = head;
        ListNode middle = null;
        ListNode prev = null;
        ListNode next = null;

        while(current != null){

            if(i == left - 1){
                prev = current;
            }
            else if(i == left){
                middle = current;
            }
            else if(i == right){
                next = current.next;
                current.next = null;
            }
            i++;
            current = current.next;
        }

        // reverse of middle part
        middle = reverseList(middle);

        // connect last part
        current = middle;
        while(current.next != null){
            current = current.next;
        }
        current.next = next;

        if(prev == null){
            return middle;
        }
        prev.next = middle;
        return head;
    }
}
