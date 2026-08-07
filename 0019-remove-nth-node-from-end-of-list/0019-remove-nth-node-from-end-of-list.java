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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int L = 0;
        ListNode curr = head;

        while(curr != null){
            L++;
            curr = curr.next;
        }

        if(L==1) return null;

        // Remove head
        if (L == n) {
            return head.next;
        }

        curr = head;
        ListNode prev = null;
        int i = 1;
        while(i != (L-n+1) ){
            prev = curr;
            curr = curr.next;
            i++;
        }

        prev.next = curr.next;
        curr.next = null;

        return head;
    }
}