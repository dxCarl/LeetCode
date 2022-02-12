package com.xiao.deng.leetcode.dynamic_programming;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * <p>
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * <p>
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 */
public class PascalTriangle {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>(numRows);
        List<Integer> line;

        for (int i = 0; i < numRows; i++) {
            line = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    line.add(1);
                } else {
                    line.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(line);
        }
        return res;
    }

        public static void main (String[]args){
            int numRows = 20;
            List<List<Integer>> generate = generate(numRows);
            generate.forEach(System.out::println);
        }

    }
