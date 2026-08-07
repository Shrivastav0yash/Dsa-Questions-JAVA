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

        //find length
        while(curr != null){
            L++;
            curr = curr.next;
        }

        //egde case 1
        if(L==1) return null;

        // Remove head edge case 2
        if (L == n) {
            return head.next;
        }

        //move pointer till we reach the delete node
        curr = head;
        ListNode prev = null;
        int i = 1;
        while(i != (L-n+1) ){
            prev = curr;
            curr = curr.next;
            i++;
        }

        //delete it
        prev.next = curr.next;
        curr.next = null;

        return head;
    }
}