package 链表;

/**
 * Created with IntelliJ IDEA.
 * User: LJY
 * Date: 2022/3/7
 * Time: 15:30
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class 环形链表 {
    public boolean hasCycle(ListNode head) {
        ListNode fast,slow;
        if(head.next == null || head == null){
            return false;
        }

        fast = head.next;
        slow = head;
        while (slow != null && fast != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}
