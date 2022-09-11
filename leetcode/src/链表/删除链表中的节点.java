package 链表;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: LJY
 * Date: 2022/3/7
 * Time: 13:57
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class 删除链表中的节点 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode pNode = head;
        while (pNode != null && pNode.val != val){
            pNode = pNode.next;
        }

        if(pNode.next == null){

        }else {
            pNode.val = pNode.next.val;
            pNode.next = pNode.next.next;
        }
        return head;
    }

    @Test
    public void test_01(){
        ListNode listNode = new ListNode(5);
        ListNode listNode1 = new ListNode(7);
        ListNode listNode2 = new ListNode(99);

        listNode.next = listNode1;
        listNode1.next = listNode2;

        ListNode listNode3 = deleteNode(listNode,99);
    }


}
