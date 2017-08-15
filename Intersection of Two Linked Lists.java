/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        ListNode h1 = headA;
        ListNode h2 = headB;
        int length1 = 0;
        int length2 = 0;
        int diff = 0;
        while(h1 != null){
            h1 = h1.next;
            length1++;
        }
        while(h2 != null){
            h2 = h2.next;
            length2++;
        }
        h1 = headA;
        h2 = headB;
        int i = 0;
        if(length1 > length2){
            diff = length1 - length2;
            while(i < diff){
                h1 = h1.next;
                i++;
            }
        }else{
            diff = length2 - length1;
            while(i < diff){
                h2 = h2.next;
                i++;
            }
        }
        while(h1 != null && h2 != null){
            if(h1.val == h2.val)
                return h1;
            h1 = h1.next;
            h2 = h2.next;
        }
        return null;
    }
}