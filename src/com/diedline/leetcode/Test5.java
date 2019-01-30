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
        HashMap hashMap = contain(s);
        return "a";
    }
    //再写一个判断是否回文的方法
    public boolean isPalindrome(String s,HashMap<Character,Index> hs){
        char[] arr = s.toCharArray();
        //先获取hashMap的索引值
        Set<Character> set = hs.keySet();
        ArrayList<Index> arrayList = new ArrayList<>();
        //根据key值获取索引组 并存入arrayList中
        for (Character c:set
             ) {
            arrayList.add(hs.get(c));
        }
        //对于arrayList的每一个值都判断一遍是否是回文
        for (Index x:arrayList
             ) {
            int start = x.getA();
            int end = x.getB();
            //今天先到这里睡觉了88
            return true;
        }
        return true;
    }

    //直接就得到了一个HashMap里面有需要的所有信息 不过比较浪费时间复杂度
    public HashMap<Character,Index> contain(String s){
        char[] arr = s.toCharArray();
        HashMap<Character,Index> hashMap = new HashMap<>();
        Index index = new Index();
        for (int i = 0; i <arr.length ; i++) {
            for (int j = i+1; j<arr.length; j++){
                if(arr[i] == arr[j]){
                    index.setA(i);
                    index.setB(j);
                    hashMap.put(arr[i],index);
                }
            }
        }
       return hashMap;
    }
}