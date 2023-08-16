package cn.tyronecai.day0816.problems1431;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author cai.rong@yottabyte.cn
 * @date 2023-08-16 09:23
 * <p>
 * https://leetcode.cn/problems/kids-with-the-greatest-number-of-candies/?envType=study-plan-v2&envId=leetcode-75
 * 1431. 拥有最多糖果的孩子
 * 给你一个数组 candies 和一个整数 extraCandies ，其中 candies[i] 代表第 i 个孩子拥有的糖果数目。
 * <p>
 * 对每一个孩子，检查是否存在一种方案，将额外的 extraCandies 个糖果分配给孩子们之后，此孩子有 最多 的糖果。注意，允许有多个孩子同时拥有 最多 的糖果数目。
 */
public class Solution01 {
    // 2 <= candies.length <= 100
    // 1 <= candies[i] <= 100
    // 1 <= extraCandies <= 50
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        // 先找到最多的糖果是几颗，然后判断加上extraCandies是否能超过最大值
        int max = 0;
        for (int i : candies) {
            if (i > max) {
                max = i;
            }
        }

        List<Boolean> result = new ArrayList<>(candies.length);
        for (int i = 0; i < candies.length; ++i) {
            result.add(candies[i] + extraCandies >= max);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] candies = new int[]{2, 3, 5, 1, 3};
        int extraCandies = 3;
        List<Boolean> result = new Solution01().kidsWithCandies(candies, extraCandies);
        System.out.println(result);
    }
}
