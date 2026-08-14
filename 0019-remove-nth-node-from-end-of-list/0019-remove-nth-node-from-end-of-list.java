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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Dummy node to handle edge cases cleanly (e.g., removing the head node)
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode fast = dummy;
        ListNode slow = dummy;
        
        // Advance fast pointer so there is an n-node gap between fast and slow
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        
        // Move fast to the end, maintaining the n-node gap
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        // slow is at the (n + 1)-th node from the end; skip the nth node
        slow.next = slow.next.next;
        
        return dummy.next;
    }
}