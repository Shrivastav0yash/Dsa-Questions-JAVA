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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int maxD = 0;
        int minD = Integer.MAX_VALUE;
        ListNode curr = head.next;
        ListNode prev = head;
        int count = 1;
        int cp1 = 0;
        int cp2 = 0;

        while(curr.next != null){

            if( (prev.val < curr.val && curr.val > curr.next.val) || 
               (prev.val > curr.val && curr.val < curr.next.val)  ){
                    if(cp1 == 0){
                        cp1 = count;
                        cp2 = cp1;
                    }
                    else{
                        minD = Math.min(minD, (count-cp2));
                        cp2 = count;

                    } 
               }

            count++;
            prev = curr;
            curr = curr.next;

        }

        if (minD == Integer.MAX_VALUE) {
            return new int[]{-1, -1};
        }

        return new int[]{minD, cp2 - cp1};
    }
}