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

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        Node tail = head;
        // Create a duplicate node and link each other
        while(tail!=null) {
            Node newNode = new Node(tail.val);
            Node temp = tail.next;
            tail.next = newNode;
            newNode.next = temp;
            tail = tail.next.next;
        }

        Node pointerNode = head;

        while(pointerNode != null) {
            if(pointerNode.random != null) {
                Node temp = pointerNode.random.next;
                pointerNode.next.random = temp;
            }
            pointerNode = pointerNode.next.next;
        }

        Node oldHead = head;
        Node newHead = oldHead.next;
        Node tempNewHead = newHead;

        while(oldHead != null) {
            oldHead.next = oldHead.next.next;
            oldHead = oldHead.next;
            if(tempNewHead.next != null) {
                tempNewHead.next = oldHead.next;
                tempNewHead = tempNewHead.next;
            }
            
        }

        return newHead;

    }
}