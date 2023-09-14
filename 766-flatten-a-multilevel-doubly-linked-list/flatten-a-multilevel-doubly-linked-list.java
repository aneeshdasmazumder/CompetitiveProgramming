/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node reachTail(Node tail) {
        while(tail.next != null) {
            tail = tail.next;
        }

        return tail;
    }
    public Node flatten(Node head) {

        Node curr;
        // Stack<Node> stk = new Stack<>();

        curr = head;

        while(curr!= null) {
            if(curr.child != null) {
                Node tail = reachTail(curr.child);
                tail.next = curr.next;
                if(tail.next != null)
                    tail.next.prev = tail;
                tail = tail.next;
                curr.next = curr.child;
                curr.next.prev = curr;
                curr.child = null;
            } 
            curr = curr.next;
        }

        

        // while(curr != null) {
        //     if(curr.child != null) {
        //         if(curr.next != null)
        //             stk.push(curr.next);
        //         Node temp = curr;
        //         curr.next = curr.child;
        //         curr.child = null;
        //         curr = curr.next;
        //         curr.prev = temp;
        //     } else if(curr.next == null && !stk.isEmpty()) {
                
        //         Node lastNode = curr;
        //         curr.next = stk.pop();
        //         curr = curr.next;
        //         curr.prev = lastNode;
                
        //     } else curr = curr.next;
        // }

        return head;
        
    }
}