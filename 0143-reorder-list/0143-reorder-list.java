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
 //Apprach 1 by Using reverse and slow fast appraoach
class Solution {
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;

        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;

    }
    public void reorderList(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode rev = reverse(slow);
        ListNode curr = head;

        while(rev.next != null){
            ListNode temp = curr.next;
            ListNode revTemp = rev.next;
            curr.next = rev;
            rev.next = temp;
            curr = temp;
            rev = revTemp;
        }
    }
}