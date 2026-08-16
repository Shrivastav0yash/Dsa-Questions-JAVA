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
        int[] ans = new int[2];
        Arrays.fill(ans, -1);
        ListNode curr = head.next;
        ListNode prev = head;
        int count = 1;
        int cp1 = 0;
        int cp2 = 0;
        int cp3 = 0;

        if(curr.next == null) return ans;

        while(curr.next != null){

            if( (prev.val < curr.val && curr.val > curr.next.val) || 
               (prev.val > curr.val && curr.val < curr.next.val)  ){
                    if(cp1 == 0){
                        cp1 = count;
                        cp2 = cp1;
                    }
                    else{
                        cp3 = count;
                        minD = Math.min(minD, (cp3-cp2));
                        cp2 = cp3;

                    } 
               }

            count++;
            prev = curr;
            curr = curr.next;

        }

        if (cp1 == 0 || cp1 == cp2) return ans;
        
        maxD = cp2 - cp1;
        ans[0] = minD;
        ans[1] = maxD;
        
        return ans;
    }
}