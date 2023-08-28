package cn.tyronecai.day0828.problem1679;

/**
 * @author cai.rong@yottabyte.cn
 * @date 2023-08-28 09:03
 * <p>
 * https://leetcode.cn/problems/max-number-of-k-sum-pairs/?envType=study-plan-v2&envId=leetcode-75
 * 1679. K 和数对的最大数目
 * 提示
 * 中等
 * 58
 * 相关企业
 * 给你一个整数数组 nums 和一个整数 k 。
 * <p>
 * 每一步操作中，你需要从数组中选出和为 k 的两个整数，并将它们移出数组。
 * <p>
 * 返回你可以对数组执行的最大操作数。
 */
public class Solution01 {
    // 1 <= nums.length <= 10^5
    //1 <= nums[i] <= 10^9
    //1 <= k <= 10^9
    public int maxOperations(int[] nums, int k) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == -1 || nums[i] >= k) {
                continue;
            }

            int remain = k - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == -1) {
                    continue;
                }
                if (nums[j] == remain) {
                    count++;
                    nums[i] = -1;
                    nums[j] = -1;
                    break;
                }
            }
        }

        return count;
    }

    // 输入：nums = [1,2,3,4], k = 5
    //输出：2
    //解释：开始时 nums = [1,2,3,4]：
    //- 移出 1 和 4 ，之后 nums = [2,3]
    //- 移出 2 和 3 ，之后 nums = []
    //不再有和为 5 的数对，因此最多执行 2 次操作。
    public static void main(String[] args) {
        int[] nums = new int[]{3,1,3,4,3};
        int k = 6;

        int result = new Solution01().maxOperations(nums, k);
        System.out.println(result);
    }
}
