package com.diedline.leetcode;

import org.junit.jupiter.api.Test;

public class Test9 {
}
/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 */
class Solution9 {
    @Test
    public void test(){
        System.out.println(isPalindrome(-121));
    }

    public boolean isPalindrome(int x) {
        String s = Integer.toString(x);
        char[] arr = s.toCharArray();
        for (int i = 0; i <arr.length ; i++) {
            while (arr[i] != arr[arr.length-1-i]){
                return false;
            }
        }
        return true;
    }
}