package com.diedline.leetcode;

import org.junit.jupiter.api.Test;

public class Test10 {
}





/**
 * 给定一个字符串 (s) 和一个字符模式 (p)。实现支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符。
 * '*' 匹配零个或多个前面的元素。
 * 匹配应该覆盖整个字符串 (s) ，而不是部分字符串。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 示例 1:
 *
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 */


class Solution10 {
    @Test
    public void test(){
        System.out.println(isMatch("","."));
    }


    public boolean isMatch(String s, String p) {
//        if (s.isEmpty()){
//            return false;
//        }
//        if (p.isEmpty() ){
//            return false;
//        }
        if(s.matches(p)){
            return true;
        }else {
            return false;
        }
    }
}
