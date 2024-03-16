package com.justnow.skills.swardoffer.listnode;

import com.justnow.skills.datastruct.list.ListNode;
import com.sun.org.apache.xerces.internal.impl.dtd.XMLSimpleType;

/**
 * 25 合并两个有序的链表
 */
public class offer_25 {

    /**
     *
     * @param node1
     * @param node2
     * @return
     */
    public ListNode merge(ListNode node1, ListNode node2) {
        ListNode dump = new ListNode(-1);
        ListNode cur = dump;
        while (node1 != null && node2 != null) {
            if (node1.val > node2.val) {
                cur.next = new ListNode(node2.val);
                node2 = node2.next;
            } else {
                cur.next = new ListNode(node1.val);
                node1 = node1.next;
            }
            cur = cur.next;
        }

        if (node1 == null) {
            cur.next = node2;
        }

        if (node2 == null) {
            cur.next = node1;
        }

        return dump.next;
    }
}
