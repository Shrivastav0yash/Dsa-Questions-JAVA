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
 //Approach 1 by Using stack
class Solution {
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        
        while(temp != null){
            stack.push(temp);
            temp = temp.next;
        }

        temp = stack.peek();
        stack.pop();
        int maxValue = temp.val;

        ListNode result = new ListNode(temp.val);

        while(!stack.empty()){
            temp = stack.peek();
            stack.pop();

            if(temp.val < maxValue){
                continue;//skip this node
            }
            else{
                ListNode curr = new ListNode(temp.val);
                curr.next = result;
                result = curr;
                maxValue = curr.val;
            }
        }

        return result;
    }
}