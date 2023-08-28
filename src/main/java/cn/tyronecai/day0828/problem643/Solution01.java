package cn.tyronecai.day0828.problem643;

/**
 * @author cai.rong@yottabyte.cn
 * @date 2023-08-28 12:45
 * <p>
 * 643. 子数组最大平均数 I
 * 给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。
 * <p>
 * https://leetcode.cn/problems/maximum-average-subarray-i/?envType=study-plan-v2&envId=leetcode-75
 * 请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。
 * <p>
 * 任何误差小于 10-5 的答案都将被视为正确答案。
 */
public class Solution01 {
    // n == nums.length
    //1 <= k <= n <= 105
    //-104 <= nums[i] <= 104
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int i = 0;
        for (; i < k; i++) {
            sum += nums[i];
        }

        int maxSum = sum;
        for (; i < nums.length; i++) {
            sum -= nums[i - k];
            sum += nums[i];

            if (sum > maxSum) {
                maxSum = sum;
            }
        }

        return 1.0D * maxSum / k;
    }

    // 输入：nums = [1,12,-5,-6,50,3], k = 4
    //输出：12.75
    //解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
    public static void main(String[] args) {
        int[] nums = new int[]{1, 12, -5, -6, 50, 3};
        int k = 4;

        double result = new Solution01().findMaxAverage(nums, k);
        System.out.println(result);
    }
}
