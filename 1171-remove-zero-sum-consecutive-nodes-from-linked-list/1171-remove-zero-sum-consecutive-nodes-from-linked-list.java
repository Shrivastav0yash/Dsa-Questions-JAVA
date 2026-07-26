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
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        HashMap<Integer, ListNode> map = new HashMap<>();
        map.put(0,dummyNode);
        int prefixSum = 0;

        while(head != null){

            prefixSum += head.val;

            if(map.containsKey(prefixSum)){
                //Delete
                ListNode start = map.get(prefixSum);
                ListNode temp = start;
                int pSum = prefixSum;

                while(temp != head){
                    
                    temp = temp.next;
                    pSum += temp.val;

                    if(temp!=head) map.remove(pSum);

                }

                start.next = head.next;

            }
            else{
                map.put(prefixSum, head);
            }
            head = head.next;
        }

        return dummyNode.next;
    }
}