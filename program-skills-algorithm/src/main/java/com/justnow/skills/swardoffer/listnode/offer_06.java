package com.justnow.skills.swardoffer.listnode;

import com.justnow.skills.datastruct.list.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 6 从尾到头打印链表
 * https://www.nowcoder.com/practice/d0267f7f55b3412ba93bd35cfa8e8035?tpId=13&tqId=11156&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking&from=cyc_github
 */
public class offer_06 {


    public static void main(String[] args) {

    }

    //思路一：栈先进后出的思想
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> s = new Stack<Integer>();
        ArrayList<Integer> lists = new ArrayList<>();

        while (listNode != null) {
            s.push(listNode.val);
            listNode = listNode.next;
        }

        while (!s.isEmpty()) {
            lists.add(s.pop());
        }

        return lists;
    }

    //思路二：递归思想
    ArrayList<Integer> lists = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead02(ListNode listNode) {
        if (listNode != null) {
            printListFromTailToHead(listNode.next);
            lists.add(listNode.val);
        }
        return lists;
    }
}
