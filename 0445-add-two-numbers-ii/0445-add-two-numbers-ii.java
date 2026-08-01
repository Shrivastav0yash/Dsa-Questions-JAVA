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

    public ListNode reversell(ListNode head){

        if(head == null || head.next == null){
            return head;
        }

        ListNode last = reversell(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        l1 = reversell(l1);
        l2 = reversell(l2);

        int sum = 0;
        int carry = 0;

        ListNode answer = new ListNode();

        while(l1 != null || l2 != null){

            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }

            answer.val = sum % 10;
            carry = sum / 10;

            ListNode newNode = new ListNode(carry);
            newNode.next = answer;
            answer = newNode;
            sum = carry;
            
        }

        if(carry == 0) return answer.next;

        return answer;

    }
}