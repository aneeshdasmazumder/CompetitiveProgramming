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
    public boolean isPalindrome(ListNode head) {
        if(head.next == null) return true;
        // find the mid
        ListNode mid = head;
        ListNode last = head;
        ListNode prevNodes = head;
        while(last.next != null) {
            if(last.next.next != null) {
                last = last.next.next;
                mid = mid.next;
            } else {
                last = last.next;
            }
        }
        System.out.println(mid.val);
        // Reverse the linked list after the mid
        ListNode reverseNode = reverseNode(mid.next, mid.next.next);
        mid.next.next = null;
        mid.next = reverseNode;
        // ListNode t = head;
        // while(t != null) {
        //     System.out.println(t.val);
        //     t = t.next;
        // }
        ListNode nextNodes = mid.next;
        // Compare
        while(nextNodes!=null) {
            if(prevNodes.val != nextNodes.val) return false;
            nextNodes = nextNodes.next;
            prevNodes = prevNodes.next;
        }

        return true;
    }

    public ListNode reverseNode(ListNode prev, ListNode newNext) {
        if (newNext == null) return prev;
        ListNode tempPrev = newNext;
        ListNode temp = newNext.next;
        newNext.next = prev;
        return reverseNode(tempPrev, temp);
    }
}