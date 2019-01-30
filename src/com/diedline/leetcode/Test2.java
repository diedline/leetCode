package com.diedline.leetcode;

import org.junit.jupiter.api.Test;

import java.util.List;

public class Test2 {
}


/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储
 * 一位 数字。如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
class Solution {

    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val = x;}
    }

   //解法1：迭代每次计算个位数相加
    ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //先做判断l1,l2是否为空
        if(l1 == null){
            return l2;
        }if (l2 == null){
            return l1;
        }
        //初始化返回值节点和tmp
        ListNode head = new ListNode(0);
        ListNode p = head;
        int tmp = 0;
        //只要有一个非空循环就继续 将l1,l2中的值先加到tmp中
        while (l1 !=null||l2 !=null||tmp!=0){
            if(l1 !=null){
                tmp += l1.val;
                l1 = l1.next;
            }
            if(l2 !=null){
                tmp += l2.val;
                l2 = l2.next;
            }
            //每加一次 就添加一个p节点的值
            p.next = new ListNode(tmp%10);
            p = p.next;
            //进位
            tmp = tmp /10;
        }
        return head.next;
    }
    //解法二 递归
    ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if(l1 == null&&l2 == null){
            return null;
        }else if(l1 == null||l2 == null){
            return l1!=null?l1:l2;
        }else {
            ListNode l3;
            if(l1.val + l2.val<10){
                l3 = new ListNode(l1.val+l2.val);
                l3.next = addTwoNumbers(l1.next, l2.next);
            }else {
                l3 = new ListNode(l1.val+l2.val -10);
                l3.next = addTwoNumbers(l1.next,addTwoNumbers(l2.next,new ListNode(1)));
            }
            return l3;
        }
    }
}