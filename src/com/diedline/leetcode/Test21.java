package com.diedline.leetcode;

import org.junit.jupiter.api.Test;

import java.util.List;

public class Test21 {
}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution21 {
    @Test
    public void test(){
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1 = l1.next;
        l1.next = new ListNode(4);

        System.out.println(l1.val);
        System.out.println(l1.next.val);
        System.out.println(l1.next.val);
    }



    public  class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }

    /**
     * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     *
     * 示例：
     *
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     * 思路：
     *      按照顺序取出两个有序列表的值进行比较
     *      将较小值添加入新的列表
     *      如果一个链表为空就将另一个链表直接使用Next和你要创建的链表连接
     * */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode cur = new ListNode(0);
        ListNode listNode = cur;
        while (l1 != null && l2 != null){
            if(l1.val > l2.val){
                listNode.next = l2;
                listNode = listNode.next;
                l2 = l2.next;
            }else {
                listNode.next = l1;
                listNode = listNode.next;
                l1 = l1.next;
            }
        }

        //如果其中一条链表为空 直接相互连接
        if(l1 == null){
            listNode.next = l2;
        }
        if(l2 == null){
            listNode.next = l1;
        }

        return cur.next;
    }
}