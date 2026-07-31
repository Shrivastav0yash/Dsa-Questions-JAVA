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
 //Apprach III
class Solution {
    public int pairSum(ListNode head) {
        
        //Find Middle node
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode currNode = slow;

        //Reverse Linked List
        ListNode prevNode = null;
        ListNode nextNode = null;

        while(currNode != null){
            nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }

        currNode = head;
        int result = 0;

        while(prevNode != null){
            result = Math.max(result, (currNode.val + prevNode.val));
            prevNode = prevNode.next;
            currNode = currNode.next;
        }

        return result;

    }
}