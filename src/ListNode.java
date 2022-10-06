public class ListNode {
    int val = -1;

    ListNode next;
    ListNode() {};
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(-1);
        ListNode currentNode = result;
        int carry = 0;

        while (l1 != null || l2 != null || carry == 1) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            sum += carry;
            carry = sum / 10;
            ListNode node = new ListNode(sum % 10);
            currentNode.next = node;
            currentNode = currentNode.next;

        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode i3 = new ListNode(3);
        ListNode i2 = new ListNode(4, i3);
        ListNode i1 = new ListNode(2, i2);

        ListNode l3 = new ListNode(4);
        ListNode l2 = new ListNode(6, l3);
        ListNode l1 = new ListNode(5, l2);

        ListNode answer = addTwoNumbers(i1, l1);

        while(answer != null) {
            System.out.println(answer.val);
            answer = answer.next;
        }
    }
}
