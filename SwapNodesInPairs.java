/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode first=head,second=head.next;
        while(first!=null){
            if(second==null) first=first.next;
            else{
                int temp=first.val;
                first.val=second.val;
                second.val=temp;
                first=second.next;
                if(first==null) continue;
                second=first.next;
            }
        }
        return head;
    }
}
