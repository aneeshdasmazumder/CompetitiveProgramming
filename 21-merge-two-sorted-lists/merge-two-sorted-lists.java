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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null) return null;
        ListNode f1 = list1;
        ListNode f2 = list2;
        ListNode root = null;
        ListNode temp1 = root;
        while(f1 != null && f2 != null) {
            if(f1.val <= f2.val) {
                ListNode node = new ListNode(f1.val, null);
                if(root == null) {
                    root = node;
                    temp1 = root;
                } else {
                    temp1.next = node;
                    temp1 = temp1.next;
                }
                f1 = f1.next;
            } else {
                ListNode node = new ListNode(f2.val, null);
                if(root == null) {
                    root = node;
                    temp1 = root;
                } else {
                    temp1.next = node;
                    temp1 = temp1.next;
                }
                f2 = f2.next;
            }
            // System.out.println(temp1.val);
        }
        // System.out.println(temp1.val);
        while(f1 != null) {
            ListNode node = new ListNode(f1.val, null);
            if(root == null) {
                root = node;
                temp1 = root;
            } else {
                temp1.next = node;
                temp1 = temp1.next;
            }
            
            f1 = f1.next;
        }

        // if(temp1 == null) System.out.println("Fail");

        while(f2 != null) {
            ListNode node = new ListNode(f2.val, null);
            if(root == null) {
                root = node;
                temp1 = root;
            } else {
                temp1.next = node;
                temp1 = temp1.next;
            }
            
            f2 = f2.next;
        }

        return root;
    }
}