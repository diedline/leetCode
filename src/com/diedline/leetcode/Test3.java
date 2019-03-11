package com.diedline.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Optional;



/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
class Solution1 {

    @Test
    public void test(){
        int a = lengthOfLongestSubstring("abbcd");
        System.out.println(a);
    }

    public int lengthOfLongestSubstring(String s) {
        //初始化
        int stIdx = 0, maxLen = 0;
        //定义一个int 数组来存取char字符
        int arr[] = new int[128];
        for(int i=0;i<s.length();i++){
            //迭代获取字符中出现重复的索引值
            stIdx = Math.max(arr[s.charAt(i)],stIdx);
            //迭代 获取字符串的最大长度
            maxLen = Math.max(maxLen, i-stIdx+1);
            //增加数组的索引值
            arr[s.charAt(i)] = i+1;
        }
        return maxLen;
    }
}


