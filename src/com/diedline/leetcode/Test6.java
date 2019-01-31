package com.diedline.leetcode;

import org.junit.jupiter.api.Test;

public class Test6 {
}
/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R    4    1  5  9 .....          规律  4n -3
 * E T O E S I I G  8    2 4 6 8 ......               2n
 * E   D   H   N    4    3,7 ,11                      4n -1
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R            3
 * E   O E   I I            5
 * E C   I H   N            5
 * T     S     G            3
 *
 * 3+1+3+1+3 ....
 * 4+2+4+2 ......
 * n+n-2+n+n-2 .....
 */
class Solution6{

    @Test
    public void test() {
        System.out.println(convert("LEETCODEISHIRING",4));
    }
    /** 思路 ：
     * 创建一个与 当前字符串相同大小的char数组和 一个 int[]数组
     * int[]数组存取重新排列后的 字符顺序
     * char数组依次填充 int[]数组分配的编号
     * 最后 直接返回string的构造就Ok
     *
     */


    public String convert(String s, int numRows) {
        int n = 0;
        int length = s.length();
        int[] indx = new int[numRows];
        char[] chars = new char[length];
        if(numRows ==1){
            return  s;
        }
        // 4*2 -2 6     16 % 6   2 3     3
        int size = numRows * 2 -2;
        int num =length / size;
        int rem =length % size;
        for (int i = 1; i < numRows; i++) {
            int flag = i == 1 ? 1:2;
            // 理解不了···
            n = flag * num + (rem >= i ? (1 + (size - rem + 1 <i ? 1:0)):0);
            indx[i] = indx[i-1] + n;
        }
        int flag = -1;
        int curRow = 0;
        for(char c : s.toCharArray()){
            chars[indx[curRow]] = c;
            indx[curRow] = indx[curRow] + 1;
            if (curRow == 0 || curRow == numRows - 1) flag = -flag;
            curRow += flag;
        }
        return new String(chars);
    }
}
