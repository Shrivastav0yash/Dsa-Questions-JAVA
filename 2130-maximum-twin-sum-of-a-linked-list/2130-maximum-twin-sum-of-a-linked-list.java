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
 //Approach II
class Solution {
    public int pairSum(ListNode head) {
        
        Stack<Integer> stack = new Stack<>();
        ListNode curr = head;

        while(curr != null){
            stack.push(curr.val);
            curr = curr.next;
        }

        int n = stack.size();
        int result = 0;

        int count = 1;

        curr = head;
        while( count <= n/2){

            result = Math.max(result, curr.val + stack.peek());
            curr = curr.next;
            stack.pop();
            count++;
        }

        return result;

    }
}