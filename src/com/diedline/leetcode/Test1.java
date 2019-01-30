package com.diedline.leetcode;

import java.util.ArrayList;

public class Test1 {
    //leetcode µÚÒ»Ìâ
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            int flag =0;
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i = 0; i <nums.length ; i++) {
                for (int j = i+1; j<nums.length ; j++){
                    if (nums[i] +nums[j] == target && flag==0){
                        arrayList.add(i);
                        arrayList.add(j);
                        flag = 1;
                    }
                }
            }
            int[] num2 = new int[arrayList.size()];
            for (int i = 0; i <arrayList.size() ; i++) {
                num2[i] = arrayList.get(i);
            }
            return num2;
        }
    }
}
