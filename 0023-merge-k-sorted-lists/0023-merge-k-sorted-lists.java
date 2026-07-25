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

    public ListNode mergeTwoLists(ListNode L1, ListNode L2){
        if(L1 == null) return L2;

        if(L2 == null) return L1;

        if(L1.val <= L2.val){
            L1.next = mergeTwoLists(L1.next, L2);
            return L1;
        }
        else{
            L2.next = mergeTwoLists(L1, L2.next);
            return L2;
        }
    }

    public ListNode partition(int start, int end, ListNode[] lists){
        if(start > end) return null;

        if(start == end) return lists[start];

        int mid = start + (end -  start)/2;

        ListNode L1 = partition(start, mid,  lists);
        ListNode L2 = partition(mid+1, end, lists);
        return mergeTwoLists(L1, L2);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        if(k == 0) return null;

        return partition(0, k-1, lists);

    }
}