package com.diedline.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class Test14 {
}

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *["aac","acab","aa","abba","aa"]
 * 所有输入只包含小写字母 a-z 。
 */

class Solution14 {
    @Test
    public void test() {
        String[] strs = {"ac", "ac", "a", "ac"};
        System.out.println(longestCommonPrefix(strs));
        System.out.println("------------------------");
    }


    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        StringBuilder sb = new StringBuilder();
        if (strs.length > 1) {
            int len = strs[0].length();
            for (int i = 0; i < len; i++) {
                char curr = strs[0].charAt(i);
                //先取出第一个字符 然后用它跟后面的值比较
                for (int j = 1; j < strs.length; j++) {
                    //假如后面的字符串的长度比第一个字符串的长度小 或者是不匹配了就返回String aaa aa这种情况
                    if (strs[j].length() <= i || strs[j].charAt(i) != curr) {
                        return sb.toString();
                    }
                    //假如字符串的值和curr取出的值相同并且循环到最后都满足
                    if (strs[j].charAt(i) == curr && j == strs.length - 1) {
                        sb.append(curr);
                    }
                }
            }
        }
        return sb.toString();
    }
}