package cn.tyronecai.day0829.problem1004;

/**
 * @author cai.rong@yottabyte.cn
 * @date 2023-08-29 08:41
 * <p>
 * https://leetcode.cn/problems/max-consecutive-ones-iii/?envType=study-plan-v2&envId=leetcode-75
 * 1004. 最大连续1的个数 III
 * 给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：[1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 * 示例 2：
 * <p>
 * 输入：nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * 输出：10
 * 解释：[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * nums[i] 不是 0 就是 1
 * 0 <= k <= nums.length
 */
public class Solution02 {

    public int longestOnes(int[] nums, int k) {
        // 当前统计的这一段连续的数长度
        int maxCount = 0;
        // 当前统计的这一段连续的数中的0个数
        int zeroCount = 0;

        // https://leetcode.cn/problems/max-consecutive-ones-iii/solutions/609055/fen-xiang-hua-dong-chuang-kou-mo-ban-mia-f76z/
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            }

            // 当zeroCount > k 时，要移动left到第一个0
            while (zeroCount > k) {
                if (nums[left++] == 0) {
                    zeroCount--;
                }
            }

            maxCount = Math.max(maxCount, i - left + 1);
        }

        return maxCount;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        int k = 3;

        //nums = new int[] {1,1,1,0,0,0,1,1,1,1,0};
        //k = 2;

        //nums = new int[] {0,0,0,1};
        //k = 4;

        int result = new Solution02().longestOnes(nums, k);
        System.out.println(result);
    }
}
