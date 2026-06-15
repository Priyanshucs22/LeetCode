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
    public ListNode deleteMiddle(ListNode head) {
        ListNode temp = head;
        int size = 0;
        while(temp!=null){
            size++;
            temp = temp.next;
        }
        temp = head;
        ListNode d = new ListNode(-1);
        int mid = size/2;
        ListNode l = d;
        for(int i=0;i<mid;i++){
            l.next = temp;
            temp = temp.next;
            l = l.next;
        }
        temp = temp.next;
        l.next = temp;
        return d.next;
    }
}
