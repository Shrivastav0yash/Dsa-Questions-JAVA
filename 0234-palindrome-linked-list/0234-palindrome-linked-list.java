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

    ListNode curr ;

    public boolean recur(ListNode head){

        if(head == null) return true;

        boolean ans = recur(head.next);

        if(head.val != curr.val) return false;

        curr = curr.next;

        return ans;
    }

    public boolean isPalindrome(ListNode head) {
        curr = head;
        return recur(head);
    }
}