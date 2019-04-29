package com.diedline.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Test66 {
}

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 * */
class Solution66 {
    @Test
    public void test(){
        int[] digits = {9};
        int[] arr = plusOne(digits);
        for (Integer num:arr
             ) {
            System.out.println(num);
        }
    }

    /**
     *
     *
     * */
    public int[] plusOne(int[] digits) {

        int carry = 0;
        digits[digits.length-1]+=1;

        for(int i=digits.length-1; i>=0;i--){
            int number = carry + digits[i];
            digits[i] = number % 10;
            carry = number /10;
            if(i==0&&carry>0){
                int[] result = new int[digits.length+1];
                for(int j=1;j<result.length;j++){
                    result[j] = digits[j-1];
                }
                result [0] = carry;
                return result;
            }
        }

        return digits;
    }
}
