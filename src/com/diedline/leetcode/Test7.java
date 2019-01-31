package com.diedline.leetcode;

import org.junit.jupiter.api.Test;

public class Test7 {
}


/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 *     4294967295
 *     1534236469
 *     1234
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [?231,  231 ? 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
class Solution7 {
    @Test
    public void test() {
//        System.out.println(Integer.reverse(123));
        System.out.println(reverse(-123));
    }

    public int reverse(int x) {
        //先对数字进行分离 先转成字符串好分离
        if (x <0){
            x = -x;
            return handle2(x);
        }else {
            return handle(x);
        }

    }

    private int handle(int x) {
        String s = Integer.toString(x);
        char[] arr = s.toCharArray();
        char temp;
        //在将char的索引交换
        if(arr.length%2 ==1){
            // 0+3+1/2
                for (int i = 0; i < arr.length/2+1 ; i++){
                    temp = arr[i];
                    arr[i] = arr[arr.length-1-i];
                    arr[arr.length-1-i] = temp;
                }
        }else {
            for (int i = 0; i < arr.length/2; i++) {
                temp = arr[i];
                arr[i] = arr[arr.length - 1 - i];
                arr[arr.length - 1 - i] = temp;
            }
        }
        String s2 = new String(arr);
        try{
            Integer.valueOf(s2);
        }catch (NumberFormatException e1){
            return 0;
        }

        return Integer.valueOf(s2);
    }
    private int handle2(int x) {
        String s = Integer.toString(x);
        char[] arr = s.toCharArray();
        char temp;
        //在将char的索引交换
        if(arr.length%2 ==1){
            // 0+3+1/2
            for (int i = 0; i < arr.length/2+1 ; i++){
                temp = arr[i];
                arr[i] = arr[arr.length-1-i];
                arr[arr.length-1-i] = temp;
            }
        }else {
            for (int i = 0; i < arr.length/2; i++) {
                temp = arr[i];
                arr[i] = arr[arr.length - 1 - i];
                arr[arr.length - 1 - i] = temp;
            }
        }
        String s2 = new String(arr);
        try{
            Integer.valueOf(s2);
        }catch (NumberFormatException e1){
            return 0;
        }
        return -Integer.valueOf(s2);
    }
}
