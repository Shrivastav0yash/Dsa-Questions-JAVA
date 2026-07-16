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
    public ListNode deleteMiddle(ListNode head) {

        if(head == null || head.next == null) return null;

        int middle = 0;
        int totalNodes = 0;
        ListNode temp = head;
        while(temp != null){
            totalNodes++;
            temp = temp.next;
        }

        middle = totalNodes / 2;

        int i = 1;
        temp = head;
        while(i<middle){
            temp = temp.next;
            i++;
        }

        temp.next = temp.next.next;
        return head;
    }
}