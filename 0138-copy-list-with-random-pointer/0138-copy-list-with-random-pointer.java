/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
//Approach II
class Solution {
    public Node copyRandomList(Node head) {
        
        if(head == null) return head;

        //New Node insert in original node

        Node curr = head;

        while(curr != null){
            Node temp = curr.next;
            curr.next = new Node(curr.val);
            curr.next.next = temp;
            curr = temp;
        }

        //Deep Copy of random pointer
        curr = head;
        while(curr != null && curr.next != null){

            if(curr.random == null){
                curr.next.random = null;
            }
            else{
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        //Seperate List
        Node newHead = head.next;
        Node newCurr = newHead;
        curr = head;

        while(curr != null && newCurr != null){
            
            curr.next = curr.next == null ? null : curr.next.next;
            newCurr.next = newCurr.next == null ? null : newCurr.next.next;

            curr = curr.next;
            newCurr = newCurr.next;

        }

        return newHead;

    }
}