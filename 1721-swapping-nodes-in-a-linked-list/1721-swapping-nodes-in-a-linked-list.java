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

    public int Length(ListNode head){
        int l = 0;
        while(head != null){
            head = head.next;
            l++;
        }
        return l;
    }


    public ListNode swapNodes(ListNode head, int k) {

        ListNode node1 = head;
        ListNode node2 = head;

        int length = Length(head);

        int k_1 = k;
        int k_2 = length - k + 1;

        while(k_1 > 1){
            node1 = node1.next;
            k_1--;
        }

        while(k_2 > 1){
            node2 = node2.next;
            k_2--;
        }

        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;

        return head;

    }
}