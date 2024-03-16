package com.justnow.skills.swardoffer.listnode;

import com.justnow.skills.datastruct.list.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 23 链表中的环的节点
 */
public class offer_23 {

    /**
     * 思路一：hashset方法
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> viewed = new HashSet<>();

        while (head != null) {
            if (!viewed.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 思路二：快慢指针
     * https://leetcode.cn/problems/linked-list-cycle/solutions/440042/huan-xing-lian-biao-by-leetcode-solution/?envType=study-plan-v2&envId=top-100-liked
     *
     * @param head
     * @return
     */
    public boolean hasCycle02(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }
}
