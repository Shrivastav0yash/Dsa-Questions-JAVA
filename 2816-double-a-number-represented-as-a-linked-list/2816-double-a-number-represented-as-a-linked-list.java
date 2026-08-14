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
 //Approach 5
class Solution {
    public ListNode doubleIt(ListNode head) {
        
        if(head.val >= 5){
            ListNode newHead = new ListNode(0);
            newHead.next = head;
            head = newHead;
        }

        ListNode curr = head;

        while(curr != null){
            
            curr.val  = (curr.val * 2) % 10;

            if(curr.next != null && curr.next.val >= 5){
                curr.val += 1;
            }
            curr = curr.next;
            
        }

        return head;

    }
}