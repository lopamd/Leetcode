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
        if(head == null || head.next == null)
            return null;
        ListNode slowptr = head;
        ListNode fastptr = head;
        while(fastptr != null && fastptr.next != null){
            slowptr = slowptr.next;
            fastptr = fastptr.next.next;
            if(slowptr == fastptr){
                slowptr = head;
                while(slowptr != fastptr){
                    slowptr = slowptr.next;
                    fastptr = fastptr.next;
                }
                return fastptr;
            }
        }
      return null;
    }
}