package com.justnow.skills.swardoffer.listnode;


import com.justnow.skills.datastruct.list.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/linked-list-cycle-ii/description/?envType=study-plan-v2&envId=top-100-liked
 * 142 lc，返回环形链表的第一个节点
 */
public class offer_23_02 {

    /**
     * 快慢指针：https://blog.nowcoder.net/n/b117b5636329454d8a868f8226475c1b
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> viewed = new HashSet<>();
        while (head != null) {
            if (viewed.contains(head)) {
                return head;
            }

            viewed.add(head);
            head = head.next;
        }
        return null;
    }

    /**
     * 思路二：hashSet的内容
     * @param head
     * @return
     */
    public ListNode detectCycle02(ListNode head) {
        return null;
    }
}
