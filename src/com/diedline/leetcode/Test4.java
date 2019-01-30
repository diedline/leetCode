package com.diedline.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test4 {
}
/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 */
class Solution2 {
    @Test
    public void test(){
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        System.out.println(findMedianSortedArrays(nums1,nums2));

    }
    //通过
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //如果使用Int会丢失精度
        double d1 = 0,d2 = 0;
        //对数组先进行堆排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        //首先先判断当其中一个为空的情况
        if(nums1 == null ||nums2 == null){
            if (nums1!=null){
                d1 = (double) (nums1[nums1.length /2]+nums1[nums1.length/2-1])/2;
            }else {
                d2 = (double)(nums2[nums2.length /2]+nums2[nums2.length/2-1])/2;
            }
            return nums1!=null?d1:d2;
        }
        //使用IntStream将两个Int数组相连
        IntStream stream = Arrays.stream(nums1);
        IntStream stream1 = Arrays.stream(nums2);
        IntStream stream2 =  IntStream.concat(stream,stream1);
        //直接将流再转换成数组并排序
        int[] arr3 = stream2.toArray();
        Arrays.sort(arr3);
        //这里有两种情况 当arr3.length的长度为奇数时 直接返回arr3.length+1/2
        //为偶数时才返回下面这种情况
        if(arr3.length%2 ==0){
            d1 = (double) (arr3[arr3.length/2]+arr3[arr3.length/2-1])/2;
            return d1;
        }else {
            d1 = (double) arr3[(arr3.length-1)/2];
            return d1;
        }
    }

}