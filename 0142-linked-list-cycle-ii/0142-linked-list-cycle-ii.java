/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 //Optimal
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode startPoint = head;

        if(head == null || head.next == null) return null;

        boolean flag = false;
        while(fast != null && fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                flag = true;
                break;
            }
        }

        if(flag == true){
            while(slow != startPoint){
                slow = slow.next;
                startPoint = startPoint.next;
            }
            return startPoint;
        }

        return null;

    }
}