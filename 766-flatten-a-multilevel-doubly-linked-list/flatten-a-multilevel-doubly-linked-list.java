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
    public Node flatten(Node head) {

        Node curr;
        Stack<Node> stk = new Stack<>();

        curr = head;

        while(curr != null) {
            if(curr.child != null) {
                if(curr.next != null)
                    stk.push(curr.next);
                Node temp = curr;
                curr.next = curr.child;
                curr.child = null;
                curr = curr.next;
                curr.prev = temp;
            } else if(curr.next == null && !stk.isEmpty()) {
                
                Node lastNode = curr;
                curr.next = stk.pop();
                curr = curr.next;
                curr.prev = lastNode;
                
            } else curr = curr.next;
        }

        return head;
        
    }
}