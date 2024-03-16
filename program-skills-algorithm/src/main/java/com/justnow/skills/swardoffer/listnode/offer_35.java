package com.justnow.skills.swardoffer.listnode;

import com.justnow.skills.datastruct.list.ListNode;

/**
 * 34 随机链表的复制
 */
public class offer_35 extends BaseListNode{

    public static void main(String[] args) {

        offer_35 offer_35 = new offer_35();
        ListNode listNode = offer_35.buildListNode();

        System.out.println("begin:" + listNode.val);

        ListNode copyCommonListNode = copyCommonListNode(listNode);

        offer_35.printListNodeVal(copyCommonListNode);

        System.out.println("begin:" + listNode.val);

    }

    public static ListNode copyCommonListNode(ListNode head) {
        ListNode dump = new ListNode(-1);
        ListNode pre = dump;

        while (head != null) {
            ListNode node = new ListNode(head.val);
            pre.next = node;
            pre = node;
            head = head.next;
        }

        return dump.next;
    }
}
