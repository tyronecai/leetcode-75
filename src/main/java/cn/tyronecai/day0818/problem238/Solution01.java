package cn.tyronecai.day0818.problem238;

/**
 * @author cai.rong@yottabyte.cn
 * @date 2023-08-18 11:06
 * <p>
 * https://leetcode.cn/problems/product-of-array-except-self/?envType=study-plan-v2&envId=leetcode-75
 * 238. 除自身以外数组的乘积
 * <p>
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * <p>
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * <p>
 * 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 */
public class Solution01 {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        // 第一次遍历获取每个位置前向所有数字的乘积
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = nums[i - 1] * result[i - 1];
        }

        // 再来一次遍历，算出来右侧所有数字的乘积
        int tmp = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = tmp * result[i];
            tmp *= nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 1, 0, -3, 3};
        int[] result = new Solution01().productExceptSelf(nums);
        for (int i : result) {
            System.out.println(i);
        }
    }


}
