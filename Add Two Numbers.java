/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Solution {
    public void printList(ListNode list){
        ListNode temp = list;
        while(temp != null) {
            System.out.print(temp.val);
            temp = temp.next;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;
        ListNode res = new ListNode(0);
        ListNode r = res;
        while(l1 != null || l2 != null){
            sum /= 10;
            if(l1 != null ){
                sum = sum + l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum = sum + l2.val;
                l2 = l2.next;
            }
            int data = sum % 10;
            ListNode newnode = new ListNode(data);
            r.next = newnode;
            r = r.next;
        }
        if(sum/10 == 1){    
            ListNode newnode = new ListNode(1);
            r.next = newnode;
            
        }
        return res.next;
        
    }
}