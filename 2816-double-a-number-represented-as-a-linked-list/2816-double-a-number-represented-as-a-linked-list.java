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
 //Apprach 4 - from left to right
class Solution {
    public ListNode doubleIt(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            int val = curr.val * 2 ;

            if(val < 10){
                curr.val = val;
            }
            else if(prev != null){
                curr.val = val % 10;
                prev.val+= 1;
            }
            else {
                ListNode newHead = new ListNode(1);
                newHead.next = curr;
                curr.val = val % 10;
                head = newHead;
            }
            prev = curr;
            curr = curr.next;

        }

        return head;
    }
}