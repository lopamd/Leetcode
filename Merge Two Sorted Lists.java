/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        if(l1 == null && l2 == null)
            return null;
        if(l1 != null && l2 == null)
            return l1;
        if(l1 == null && l2 != null)
            return l2;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                prev.next = l1;
                prev = prev.next;
                l1 = l1.next;
            }else{
                prev.next = l2;
                prev = prev.next;
                l2 = l2.next;
            }
        }
        if(l1 != null)
            prev.next = l1;
        else
            prev.next = l2;
        return dummy.next;
            
    }
}