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
 //Apprach 2 -  Stack
class Solution {
    public ListNode doubleIt(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode curr = head;

        while(curr != null){
            stack.push(curr);
            curr = curr.next;
        }

        int carry = 0;
        curr = stack.peek();
        int val = (2 * curr.val) % 10 + carry;
        carry = (2 * curr.val) / 10;
        curr.val = val;
        curr.next = null;
        stack.pop();


        while(!stack.empty()){

            ListNode temp = stack.peek();
            val = (2 * temp.val) % 10 + carry;
            carry = (2 * temp.val) / 10;

            temp.val = val;

            temp.next = curr;
            curr = temp;
            stack.pop();
        }

        if(carry > 0){
            ListNode headNode = new ListNode(carry);
            headNode.next = curr;
            return headNode;
        }
            
        return curr;
    }
}