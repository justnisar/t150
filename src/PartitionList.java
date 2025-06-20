package src;

public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        ListNode leftHead = null, leftTail = null;
        ListNode rightHead = null, rightTail = null;
        ListNode current = head;
        while(current != null){
            if(current.val < x){
               if(leftHead == null){
                   leftHead = leftTail = current;
               }
               else{
                   leftTail.next = current;
                   leftTail = current;
               }
            }
            else{
                if(rightHead == null){
                    rightHead = rightTail = current;
                }
                else{
                    rightTail.next = current;
                    rightTail = current;
                }
            }
            current = current.next;
        }

        if(leftTail != null){
            leftTail.next = null;
        }

        if(rightTail != null){
            rightTail.next = null;
        }

        if(leftTail != null){
            leftTail.next = rightHead;
        }

        return leftHead != null ? leftHead : rightHead;
    }

    private void printList(ListNode head){
        ListNode current = head;
        while(current != null){
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        new PartitionList().printList(head);
        ListNode result = new PartitionList().partition(head, 3);
        //new PartitionList().printList(result);
    }
}
