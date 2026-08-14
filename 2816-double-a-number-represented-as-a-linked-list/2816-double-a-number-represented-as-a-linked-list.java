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
 //By Recursion
class Solution {

    public int solve(ListNode head){
        if(head == null) return 0;

        int carry = solve(head.next);

        int newValue = (head.val * 2) + carry;
        head.val = newValue % 10;

        return newValue >= 10 ? 1 : 0;
    }

    public ListNode doubleIt(ListNode head) {
        int last_carry = solve(head);
        
        if(last_carry > 0){
            ListNode newHead = new ListNode(last_carry);
            newHead.next = head;
            return newHead;
        }

        return head;

    }
}