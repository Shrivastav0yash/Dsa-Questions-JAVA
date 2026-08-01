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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while(l1 != null){
            s1.push(l1.val);
            l1 = l1.next;
        }

        while(l2 != null){
            s2.push(l2.val);
            l2 = l2.next;
        }

        int sum = 0;
        int carry = 0;

        ListNode answer = new ListNode();

        while( !s1.empty() || !s2.empty()){

            if(!s1.empty()){
                sum += s1.peek();
                s1.pop();
            }
            if(!s2.empty()){
                sum += s2.peek();
                s2.pop();
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