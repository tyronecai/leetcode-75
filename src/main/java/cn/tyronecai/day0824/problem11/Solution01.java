package cn.tyronecai.day0824.problem11;

import com.google.common.io.Resources;

import javax.annotation.Resource;
import java.io.IOException;
import java.lang.reflect.Parameter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author cai.rong@yottabyte.cn
 * @date 2023-08-24 09:12
 *
 * https://leetcode.cn/problems/container-with-most-water/?envType=study-plan-v2&envId=leetcode-75
 * 11. 盛最多水的容器
 * 提示
 * 中等
 * 4.5K
 * 相关企业
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 *
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 *
 * 说明：你不能倾斜容器。
 */
public class Solution01 {

    public int maxArea(int[] height) {
        int result = 0;
        int startIndex = 0;
        int endIndex = 0;

        // 暴力硬算
        for (int i = 0; i < height.length; i++) {
            int num = height[i];
            for (int j = i+1; j < height.length; j++) {
                int newArea = Math.min(num, height[j]) * (j - i);
                if (newArea > result) {
                    result = newArea;
                    startIndex = i;
                    endIndex = j;
                }
            }
        }
        System.out.printf("start %s, end %s, area %s %n", startIndex, endIndex, result);
        return result;
    }

    public static void main(String[] args) throws IOException {
        String[] input = new String(Files.readAllBytes(Paths.get(Resources.getResource("day0824/problem11/input.txt").getPath()))).split(",");

        int[] height = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            height[i] = Integer.parseInt(input[i]);
        }
        System.out.println(height.length);

        int result = new Solution01().maxArea(height);
        System.out.println(result);
    }
}
