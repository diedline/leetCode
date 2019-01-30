package com.diedline.java8;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;

public class leetCode {


    //LeetCode
    class Solution {

        @Test
        public void test(){
            int[] nums = {-1,-2,-3,-4,-5};
            int[] ints = twoSum(nums,-8);
            for (Integer a:ints
                 ) {
                System.out.println(a);
            }
        }

        public int[] twoSum(int[] nums, int target) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            ArrayList<Integer> arrayList1 = new ArrayList<>();
            for (int i = 0; i <nums.length ; i++) {
                for (int j = 1; j<nums.length ; j++){
                    if (nums[i] +nums[j] == target){
                        arrayList.add(i);
                        arrayList.add(j);
                        break;
                    }
                }
            }
            //ШЅжи
            Iterator<Integer> it = arrayList.iterator();
            while (it.hasNext()){
                Object object = it.next();
                if(!arrayList1.contains(object)){
                    arrayList1.add((Integer) object);
                }
            }
            int[] num2 = new int[arrayList1.size()];
            for (int i = 0; i <arrayList1.size() ; i++) {
                num2[i] = arrayList1.get(i);
            }
            return num2;
        }
    }
}
