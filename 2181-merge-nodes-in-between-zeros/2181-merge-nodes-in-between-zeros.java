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
    public ListNode mergeNodes(ListNode head) {
        ListNode curr = head.next;
        ListNode present = head.next;
        int val = 0;

        while(curr != null){

            if(curr.val != 0){
                val += curr.val;
            }
            else{
                present.val = val;
                present.next = curr.next;
                present = present.next;
                val = 0;
            }

            curr = curr.next;

        }

        return head.next;

    }
}