package com.diedline.leetcode.stack;

import org.junit.jupiter.api.Test;

import java.util.Stack;

public class Test20 {
    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     *
     * 示例 1:
     *
     * 输入: "()"
     * 输出: true
     * 示例 2:
     *
     * 输入: "()[]{}"
     * 输出: true
     * 示例 3:
     *
     * 输入: "(]"
     * 输出: false
     * 示例 4:
     *
     * 输入: "([)]"
     * 输出: false
     * 示例 5:
     *
     * 输入: "{[]}"
     * 输出: true
     */


    /***
     * 思路   使用堆栈
     * 先判断堆栈的size是否等于0
     * 将arr字符入栈
     * 然后根据isSym方法来判断是否是匹配的符号 判断的是数组最开始的符号和结束的符号
     * 如果成功，那么删除栈中的符号栈就重新变成0，失败的话栈就会不停的增加
     * 如果最后栈的大小为0，那么就代表匹配成功了
     */
    @Test
    public void test() {

    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] arrs = s.toCharArray();
        for (char arr : arrs) {
            if (stack.size() == 0) {
                stack.push(arr);
            } else if (isSym(stack.peek(), arr)) {
                stack.pop();
            } else {
                stack.push(arr);
            }
        }
        return stack.size() == 0;
    }

    /**
     * 判断两个char是否是对应的符号
     *
     * @param c1
     * @param c2
     * @return
     */
    public Boolean isSym(char c1, char c2) {
        return (c1 == '(' && c2 == ')' || c1 == '[' && c2 == ']' || c1 == '{' && c2 == '}');
    }

}
