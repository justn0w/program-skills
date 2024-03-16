package com.justnow.skills.swardoffer.listnode;

import com.justnow.skills.datastruct.list.ListNode;

/**
 * 24 反转链表
 */
public class offer_24 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

//        while (node1 != null) {
//            System.out.println(node1.val);
//            node1 = node1.next;
//        }

        ListNode reverseNode = reverseListNode(node1);

        while (reverseNode != null) {
            System.out.println(reverseNode.val);
            reverseNode = reverseNode.next;
        }

    }
    /**
     * 思路一：
     * @param listNode
     * @return
     */
    public static ListNode reverseListNode(ListNode listNode) {
        ListNode pre = null;
        ListNode current = listNode;

        while (current != null) {
            ListNode temp = current.next; //temp暂存，current的下一个节点
            current.next = pre;
            pre = current;
            current = temp;
        }

        return pre;
    }
}
