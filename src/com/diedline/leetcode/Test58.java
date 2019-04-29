package com.diedline.leetcode;

import org.junit.jupiter.api.Test;

public class Test58 {
}

/**
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 *
 * 如果不存在最后一个单词，请返回 0 。
 *
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 *
 * 示例:
 *
 * 输入: "Hello World"
 * 输出: 5
 * */
class Solution58 {
    @Test
    public void test(){
        String s = "   a  ";
//        String[] arr = s.split(" ");
//        for (String a:arr
//             ) {
//            System.out.println(a);
//        }
        System.out.println(lengthOfLastWord(s));
    }


    public int lengthOfLastWord(String s) {
        if(s.trim().equals("") ){
            return 0;
        }
        String[] arr = s.split(" ");
        return arr[arr.length-1].length();
    }
}