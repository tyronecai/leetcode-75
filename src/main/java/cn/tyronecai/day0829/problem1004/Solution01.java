package cn.tyronecai.day0829.problem1004;

/**
 * @author cai.rong@yottabyte.cn
 * @date 2023-08-29 08:41
 *
 * https://leetcode.cn/problems/max-consecutive-ones-iii/?envType=study-plan-v2&envId=leetcode-75
 * 1004. 最大连续1的个数 III
 * 给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
 * 示例 1：
 *
 * 输入：nums = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：[1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 * 示例 2：
 *
 * 输入：nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * 输出：10
 * 解释：[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * nums[i] 不是 0 就是 1
 * 0 <= k <= nums.length
 */
public class Solution01 {

    public int longestOnes(int[] nums, int k) {
        int maxCount = 0;

        // 连续的一段数长度
        int numCount = 0;
        // 连续的一段数中的0个数
        int zeroCount = 0;
        // 这一段数中的第一个0的位置
        int firstZeroIndex = -1;

        // 找连续的一段数，里面最多只有K个0
        // 如果发现超过K个0，则从这一段数里面第一个0的后一个位置开始重新统计
        // 比如 1,1,1,0,0,0,1,1,1,1,0
        // 从第一个1开始，统计到第二个0，就达到最长
        // 再往后一位，则会导致长度变短
        // 因为要求连续的一段数，里面最多只有K个0。所以要从第二个0开始重新统计
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == 1) {
                numCount++;
                i++;
                continue;
            }

            if (nums[i] == 0) {
                if (firstZeroIndex == -1) {
                    firstZeroIndex = i;
                }

                zeroCount++;
                if (zeroCount <= k) {
                    numCount++;
                    i++;
                } else {
                    if (numCount > maxCount) {
                        maxCount = numCount;
                    }

                    // 移动i
                    i = firstZeroIndex + 1;

                    // 重新统计
                    numCount = 0;
                    zeroCount = 0;
                    firstZeroIndex = -1;
                }
            }
        }

        // 这里
        if (numCount > maxCount) {
            maxCount = numCount;
        }

        return maxCount;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1 };
        int k = 3;

        nums = new int[] {1,1,1,0,0,0,1,1,1,1,0};
        k = 2;

        nums = new int[] {0,0,0,1};
        k = 4;

        int result = new Solution01().longestOnes(nums, k);
        System.out.println(result);
    }
}
