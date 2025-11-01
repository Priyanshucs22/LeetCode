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
    public ListNode modifiedList(int[] nums, ListNode head) {
        if (head == null) return null;
        Set<Integer> set = new HashSet<>();
        for (int e : nums) set.add(e);
        
        while (head != null && set.contains(head.val)) {
            head = head.next;
        }
        
        ListNode temp = head;
        ListNode prev = null;
        
        while (temp != null) {
            if (set.contains(temp.val)) {
                prev.next = temp.next;
            } else {
                prev = temp;
            }
            temp = temp.next;
        }
        return head;
    }
}
