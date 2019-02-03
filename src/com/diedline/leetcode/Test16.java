package com.diedline.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Test16 {
}
/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中
 * 的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */
class Solution16 {
    @Test
    public void test(){
        int[] nums = {-1,2,1,-4};
        int target = 1;
        System.out.println(threeSumClosest(nums,target));
    }

    //使用二分法 先对数组进行排序  然后再获取最大值
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int temp = 0;
        int sum1 = nums[0] + nums[1]+ nums[2];
        if(nums.length == 3){
            return sum1;
        }
        for (int i = 0; i < nums.length-1; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            //定义返回最接近的值



            while (j < k){
                int sum = nums[i] + nums[j] +nums[k];
                if(sum < target){
                    j++;
                    //找出最接近的值
                    if(Math.abs(sum- target) <= Math.abs(sum1 - target)){
                        temp = sum;
                        sum1 = sum;
                    }

                }else if (sum > target){
                    k--;
                    if(Math.abs(sum- target) <= Math.abs(sum1 - target)){
                        temp = sum;
                        sum1 = sum;
                    }
                }else {
                    //这里只有返回那个值
                    return sum;
                }
            }
        }
      return temp;
    }
}