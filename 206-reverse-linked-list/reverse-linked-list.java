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
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        // ListNode reversed = reverse(curr, prev);
        while( curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;

        }

        return prev;
    }

    // public ListNode reverse(ListNode curr, ListNode prev) {
    //     if(curr == null) return prev;
    //     ListNode temp = curr.next;
    //     curr.next = prev;
    //     prev = curr;
    //     curr = temp;

    //     return reverse(curr, prev);
    // }
}