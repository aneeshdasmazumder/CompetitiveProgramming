/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null) return head;
        ListNode fast = head;
        ListNode slow = head;
        ListNode nullNode = null;
        if(fast.next == null) return nullNode;

        if(fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        } else return nullNode;

        while(fast != slow) {
            if(fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            } else return nullNode;
        }

        ListNode tempBeg = head;
        while(fast != tempBeg) {
            fast = fast.next;
            tempBeg = tempBeg.next;
        }

        return fast;
    }
}