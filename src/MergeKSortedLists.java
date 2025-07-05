package src;


import java.util.PriorityQueue;

public class MergeKSortedLists {

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(
                (a, b) -> a.val - b.val
        );
        for(ListNode list : lists){
            if(list != null){
                priorityQueue.add(list);
            }
        }
        ListNode head = null, tail = null;
        while(!priorityQueue.isEmpty()){
            ListNode current = priorityQueue.remove();
            if(head == null){
                head = tail = current;
            }
            else{
                tail.next = current;
                tail = current;
            }
            if(current.next != null){
                priorityQueue.add(current.next);
            }
        }

        return head;
    }

}
