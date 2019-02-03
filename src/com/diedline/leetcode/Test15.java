package com.diedline.leetcode;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.*;

public class Test15 {
}

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2] 
 * ]
 */
class Solution15 {

    @Test
    public void test(){
        int[] num = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum1(num));
    }

    //直接暴力算法超时 所以使用二分法试试
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <nums.length ; j++ ) {
                for (int k = 0; k < nums.length; k++) {
                    if(j != i && j!=k && i!=k && nums[i] + nums[j] == - nums[k]){
                        List<Integer> list = Arrays.asList(nums[i],nums[j],nums[k]);
                        list.sort(Integer::compareTo);
                        lists.add(list);
                    }
                }
            }
        }

        Set<List<Integer>> set = new HashSet<>();
        set.addAll(lists);
        List<List<Integer>> lists1 = new ArrayList<>();
        lists1.addAll(set);

        return lists1;
    }

    //使用二分法
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        int jNum;
        int iNum;
        int kNum;
        for (int i = 0; i < nums.length; i++) {
            int j = i+1;
            int k = nums.length-1;
            Arrays.sort(nums);
            while (j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum > 0){
                    k--;
                }else if(sum < 0){
                    j++;
                }else {
                    List<Integer> list = Arrays.asList(nums[i],nums[j],nums[k]);
                    list.sort(Integer::compareTo);
                    lists.add(list);

                    jNum = nums[j];
                    do {
                        j++;
                        if(j >= k){
                            break;
                        }
                    }while (nums[j] ==jNum);
                    kNum = nums[k];
                    do {
                        k--;
                        if (j >= k){
                            break;
                        }
                    }while (kNum == nums[k]);
                }
            }
        }
        Set<List<Integer>> set = new HashSet<>();
        set.addAll(lists);
        List<List<Integer>> lists1 = new ArrayList<>();
        lists1.addAll(set);
        return lists1;
    }
}