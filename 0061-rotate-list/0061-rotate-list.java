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
    public ListNode rotateRight(ListNode head, int k) {

        if(head == null || head.next == null || k == 0) return head;

        int len = 0;
        ListNode curr = head;

        while(curr != null){
            len++;
            curr = curr.next;
        }

        k = k % len;
        if(k == 0) return head;
        k = len - k;
        int move = 1;

        curr = head;
        ListNode prev = head;

        while(curr.next != null){

            if(move == k){
                prev = curr;
            }

            curr = curr.next;
            move++;
        }

        curr.next = head;
        head = prev.next;
        prev.next = null;

        return head;



    }
}