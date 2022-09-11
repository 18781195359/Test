package 链表;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: LJY
 * Date: 2022/3/7
 * Time: 15:03
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class 反转链表 {
    public ListNode reverseList(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }

        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }
}
