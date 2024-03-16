package com.justnow.skills.swardoffer.listnode;

import com.justnow.skills.datastruct.list.ListNode;

/**
 * 52 两个链表中的第一个公共结点
 * https://leetcode.cn/problems/intersection-of-two-linked-lists/solutions/12624/intersection-of-two-linked-lists-shuang-zhi-zhen-l/?envType=study-plan-v2&envId=top-100-liked
 */
public class offer_52 {

    public ListNode findFirstCommonNode(ListNode headNodeA, ListNode headNodeB) {
        ListNode nodeA = headNodeA;
        ListNode nodeB = headNodeB;
        while (nodeA != nodeB) {
            nodeA = nodeA != null ? nodeA.next : headNodeB;
            nodeB = nodeB != null ? nodeB.next : headNodeA;
        }

        return nodeA;
    }
}
