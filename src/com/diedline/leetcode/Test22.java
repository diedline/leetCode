package com.diedline.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Test22 {
}


class Solution22 {

    @Test
    public void test22(){
        List<String> list = generateParenthesis(3);
        for (String a:list
             ) {
            System.out.println(a);
        }

//        char[] arr = new char[3];
//        arr[0] = 1;
//        arr[1] = 2;
//        arr[2] = 3;
//
//
//        System.out.println(new String(arr));
    }

    /**
     * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
     *
     * 例如，给出 n = 3，生成结果为：
     *
     * [
     *   "((()))",
     *   "(()())",
     *   "(())()",
     *   "()(())",
     *   "()()()"
     * ]
     *
     *
     * 思路：
     *      这个括号规则是左右要匹配，就是说按照遍历添加时左边的括号必须大于等于右边的括号
     *
     *      直接采取暴力法 列出所有的组合 然后再进行校验  将成功的值添加到列表中
     * */
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generateAll(new char[2 * n], 0, list);
        return list;
    }

    /**
     * 使用递归来生成所有结果
     * ((((((
     * */
    public void generateAll(char[] current, int pos,List<String> result){
        if(pos == current.length){
            if(valid(current))
                result.add(new String(current));
        }else {
            current[pos] = '(';
            generateAll(current, pos + 1, result);
            current[pos] = ')';
            generateAll(current, pos + 1, result);
        }

    }

    /**
     *  通过括号的左右匹配来判断是否合法
     * */
    private boolean valid(char[] current) {

        int balance = 0;
        for(char c :current){
            if(c == '(') balance++;
            else balance --;
            if(balance <0) return false;
        }
        return (balance == 0);
    }
}