package src;

public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) {
            return list2;
        }
        if(list2 == null) {
            return list1;
        }
        if(list1.val <= list2.val) {
            ListNode head = new ListNode(list1.val);
            head.next = mergeTwoLists(list1.next, list2);
            return head;
        }
        ListNode head = new ListNode(list2.val);
        head.next = mergeTwoLists(list1, list2.next);
        return head;
    }
}
