public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
 
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
 
            if(slow == fast)
                fast = fast.next;

                /* added to find the length of cycle */
                int currentlength = 1;
                while(slow == fast){
                    fast = fast.next;
                    currentlength += 1;
                    System.out.println(currentlength);
                }
                /* end for finding length of cycle */

                /* start -- find start point of cycle */
                // find the length, move one node by length
                // than move both nodes at same speed until they meet
                for (int i =0; i <= currentlength - 1; i++){
                    fast =  fast.next;
                }
                while(fast == slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                /* end --  find start point of cycle */
                return true;
        }
        return false;
    }
}