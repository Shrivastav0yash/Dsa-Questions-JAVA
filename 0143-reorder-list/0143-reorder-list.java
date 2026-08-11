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
 //By Recusrion
class Solution {

    ListNode curr ;

    public void solve(ListNode head){
        if(head == null) return;

        solve(head.next);

        ListNode temp = curr.next;

        if(curr.next == null) return;
        else if(curr == head) {
            curr.next = null;
            return;
        }

        curr.next = head;

        head.next = (temp == head) ? null : temp;

        curr = temp;
    }

    public void reorderList(ListNode head) {
        curr = head;
        solve(head);
    }
}