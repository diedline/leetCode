package com.diedline.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class Test5 {
}
/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 */
class Solution5 {
    @Test
    public void test(){
//        Index index = new Index(0,1);
//        HashMap<Integer,Index> indexMap = new HashMap<>();
//        indexMap.put(0,index);
//        System.out.println(indexMap.get(0).getA() + indexMap.get(0).getB());
        System.out.println(longestPalindrome("babad"));
        System.out.println("111111111111");
    }
    //大佬写的真刘辟
    int std;        //起始
    int end;        //终止
    public String longestPalindrome(String s){
        int len = s.length();
        //先判断长度是否小于等于1
        if(len <= 1){
            return s;
        }
        //转成字符数组
        char[] chars = s.toCharArray();
        for (int i = 0; i <len ; i++) {
            help(chars, i, i);
            help(chars, i, i+1);
            //01 12 23 34
        }
        //成功返回回文子串  substring 返回子串的方法
        return s.substring(std, end +1);
    }
    public void help(char[] chars,int l,int r){
        //这里判断是否回文
        while (l >= 0 && r <chars.length && chars[l] == chars[r]){
            --l;
            ++r;
        }
        //向两边延伸
        if(end - std <r -l -2){
            std = l + 1;
            end = r - 1;
        }
    }

}