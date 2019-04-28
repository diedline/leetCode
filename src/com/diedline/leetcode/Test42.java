package com.diedline.leetcode;

import org.junit.jupiter.api.Test;

public class Test42 {
    /**
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     * <p>
     * <p>
     * <p>
     * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
     * <p>
     * 示例:
     * <p>
     * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
     * 输出: 6
     */
    @Test
    public void test() {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }


    /***
     *  思路：
     *        这道题好难呀
     *          溜了溜了
     *
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        // 至少三块方可积水
        if (height.length < 3) return 0;

        int i, result = 0, length = height.length;

        int[] L = new int[length], R = new int[length];

        // 记录每个挡板的左/右边的最高挡板高度
        for (i = 1; i < length; i++) {
            L[i] = Math.max(L[i - 1], height[i - 1]);
            R[length - 1 - i] = Math.max(R[length - i], height[length - i]);
        }

        // 计算积水
        for (i = 0; i < length; i++) {
            if (L[i] > height[i] && R[i] > height[i]) {
                result += Math.min(L[i], R[i]) - height[i];
            }
        }
        return result;
    }
//        public int trap(int[] height) {
//            for (int i = 0; i < height.length; i++) {
//                if(height[i]<height[i+1]){
//
//                }
//            }
//
//        }


}
