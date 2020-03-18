package com.xiao.deng.leetcode.overlap;

/**
 * 矩形以列表 [x1, y1, x2, y2] 的形式表示，其中 (x1, y1) 为左下角的坐标，(x2, y2) 是右上角的坐标。
 * 如果相交的面积为正，则称两矩形重叠。需要明确的是，只在角或边接触的两个矩形不构成重叠
 * 给出两个矩形，判断它们是否重叠并返回结果
 * <p>
 * 输入：rec1 = [0,0,2,2], rec2 = [1,1,3,3]
 * 输出：true
 * <p>
 * 输入：rec1 = [0,0,1,1], rec2 = [1,0,2,1]
 * 输出：false
 * <p>
 * 提示：
 * <p>
 * 两个矩形 rec1 和 rec2 都以含有四个整数的列表的形式给出。
 * 矩形中的所有坐标都处于 -10^9 和 10^9 之间。
 * x 轴默认指向右，y 轴默认指向上。
 * 你可以仅考虑矩形是正放的情况。
 */
public class Solution {

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        boolean eq = true;
        for (int i = 0; i < 4; i++) {
            if (rec1[i] != rec2[i]) {
                eq = false;
            }
        }
        if (eq) {
            return true;
        }

        int r1_x1 = rec1[0];
        int r1_y1 = rec1[1];
        int r1_x2 = rec1[2];
        int r1_y2 = rec1[3];

        int r2_x1 = rec2[0];
        int r2_y1 = rec2[1];
        int r2_x2 = rec2[2];
        int r2_y2 = rec2[3];

        //rec2在rec1的左侧
        boolean left = r2_x2 <= r1_x1;
        //rec2在rec1的右侧
        boolean right = r2_x1 >= r1_x2;
        //rec2在rec1的上侧
        boolean up = r2_y1 >= r1_y2;
        //rec2在rec1的下侧
        boolean down = r2_y2 <= r1_y1;
        return !(left || right || up || down);
    }

    public static void main(String[] args) {
        int[] rec1 = new int[]{0,0,1,1};
        int[] rec2 = new int[]{1,0,-2,-2};
        boolean overlap = new Solution().isRectangleOverlap(rec1, rec2);
        System.out.println(overlap);
    }
}
