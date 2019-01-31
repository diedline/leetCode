package com.diedline.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Test5 {
}
/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 *
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 *
 * 输入: "cbbd"
 * 输出: "bb"
 */
class Solution5 {
    @Test
    public void test(){
//        Index index = new Index(0,1);
//        HashMap<Integer,Index> indexMap = new HashMap<>();
//        indexMap.put(0,index);
//        System.out.println(indexMap.get(0).getA() + indexMap.get(0).getB());
        longestPalindrome("abbae");
    }

    /**
     * 思路：
     *  先判断是否存在两个相同的字符如果存在两个相同的字符就将该字符串提出进行回文检测判断成功后将
     *  这个字符串的索引值之差相减得到的数就是最长回文子串的长度 所以可以创建一个 HashMap将这个长度存取然后在排序
     * @param
     * @return
     */
    class Index{
        int a;      //起始索引
        int b;      //结束索引

        public Index() {
        }

        public Index(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        public int getB() {
            return b;
        }

        public void setB(int b) {
            this.b = b;
        }
    }
    public String longestPalindrome(String s) {
        HashMap<Index,Character> hashMap = contain(s);
        Set<Integer> set = null;

        HashMap<Integer,Integer> hs = isPalindrome(s,hashMap);
        //先遍历测试下
        set = hs.keySet();
        for (Integer i:set
             ) {
            System.out.println(i+" "+hs.get(i));
        }
        return "a";
    }
    //再写一个判断是否回文的方法
    public HashMap<Integer,Integer> isPalindrome(String s,HashMap<Index,Character> hs){
        HashMap<Integer,Integer> hs1 = new HashMap<>();
        char[] arr = s.toCharArray();
        //先获取hashMap的索引值
        Set<Index> set = hs.keySet();
        //根据key值获取索引组 并存入arrayList中
        ArrayList<Index> arrayList = new ArrayList<>();
        //对于arrayList的每一个值都判断一遍是否是回文
        for (Index x:set
             ) {
            int start = x.getA();
            int end = x.getB();
            for(int i = (start + end)/2 ; i >= start; i--){
                for (int j = (start + end)/2; j <= end; j++) {
                    if (arr[i] != arr[j]){
                        return null;
                    }else {
                        hs1.put(start,end);
                    }
                }
            }
        }

        return hs1;
    }

    //直接就得到了一个HashMap里面有需要的所有信息 不过比较浪费时间复杂度
    public HashMap<Index,Character> contain(String s){
        char[] arr = s.toCharArray();
        HashMap<Index,Character> hashMap = new HashMap<>();

        for (int i = 0; i <arr.length ; i++) {
            for (int j = i+1; j<arr.length; j++){
                //i0 和 i3
                if(arr[i] == arr[j]){
                    //发现你如果在外面初始化index因为相同的地址空间会将不同值的index认为是同一个
                    Index index = new Index();
                    index.setA(i);
                    index.setB(j);
                    hashMap.put(index,arr[i]);
                }
            }
        }
       return hashMap;
    }
}