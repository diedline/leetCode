package com.diedline.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BiFunction;

public class Test11 {
}
/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐
 * 标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得
 * 它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 */

class Solution11 {


    @Test
    public void test() {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    /**
     * 示例:
     * <p>
     * 输入: [1,8,6,2,5,4,8,3,7]
     * 输出: 49
     * 思路：获取数组索引* 数组值的最大的情况
     *       看来还需要找规律优化下了
     *
     * @param height
     * @return
     */
    //太真实了 o^2的就是垃圾
    public int maxArea(int[] height) {
        //直接将最大值变为temp试试
        int temp = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int c = compare(height[i], height[j], Integer::min) * Math.abs(j - i);
                if(c>temp){
                    temp = c;
                }
            }

        }
        return temp;
    }



    public Integer compare(Integer a, Integer b, BiFunction<Integer,Integer,Integer> bi){
        return bi.apply(a,b);
    }


    //第二种方式：动态规划  时间复杂度o（n）   空间复杂度 o(1)
    public int maxArea1(int[] height) {
        int maxarea = 0, l = 0;
        int r = height.length -1;
        while (l < r){
            maxarea = Math.max(maxarea,Math.min(height[l],height[r]) * ( r - l ));
            //假如 左边没右边的值大 就向左移动指针 否则就向右
            if(height[l] <height[r]){
                l++;
            }else r--;
        }
        return maxarea;
    }
}