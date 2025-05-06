import java.util.Stack;

public class AddTwoNumbers {

    private ListNode recFun(ListNode l1, ListNode l2, int carry){

        if(l1 == null && l2 == null){
            if(carry == 1){
                return new ListNode(1);
            }
            return null;
        }

        int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
        int digit = sum % 10;
        ListNode result = new ListNode(digit);
        carry = sum / 10;
        result.next = recFun(l1 != null ? l1.next : null, l2 != null ? l2.next : null, carry);
        return result;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        return recFun(l1, l2, 0);


    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);

        ListNode l2 = new ListNode(3);
        new AddTwoNumbers().addTwoNumbers(l1, l2);
    }
}
