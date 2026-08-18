/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public int gcd(int a, int b) {
        while (b != 0) {
            int rem = a % b;
            a = b;
            b = rem;
        }
        return a;
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {

        ListNode curr = head.next;
        ListNode prev = head;

        while(curr != null){

            int val = gcd(prev.val, curr.val);
            ListNode temp = new ListNode(val);

            prev.next = temp;
            temp.next = curr;

            prev = curr;
            curr = curr.next;
        }

        return head;
    }
}