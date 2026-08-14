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
 //Approach 1 - reverse Linked List
class Solution {

    public ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;

        ListNode last = reverse(head.next);

        head.next.next = head;
        head.next = null;
        return last;
    }

    public ListNode doubleIt(ListNode head) {
        
        head = reverse(head);
        int carry = 0;
        ListNode curr = head;
        ListNode lastNode = null;

        while(curr != null){
            int val = (2 * curr.val) % 10 + carry;
            carry = (2 * curr.val ) / 10;
            curr.val = val;
            lastNode = curr;
            curr = curr.next;
        }

        if(carry > 0){
            ListNode newnode = new ListNode(carry);
            lastNode.next = newnode;
            newnode.next = null;
        }

        return reverse(head);

    }
}