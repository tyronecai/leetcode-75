package cn.tyronecai.day0829.problem1493;

/**
 * @author cai.rong@yottabyte.cn
 * @date 2023-08-29 16:22
 * <p>
 * 1493. 删掉一个元素以后全为 1 的最长子数组
 * 提示
 * 中等
 * 99
 * 相关企业
 * 给你一个二进制数组 nums ，你需要从中删掉一个元素。
 * <p>
 * 请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。
 * <p>
 * 如果不存在这样的子数组，请返回 0 。
 * <p>
 * <p>
 * <p>
 * 提示 1：
 * <p>
 * 输入：nums = [1,1,0,1]
 * 输出：3
 * 解释：删掉位置 2 的数后，[1,1,1] 包含 3 个 1 。
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,1,1,0,1,1,0,1]
 * 输出：5
 * 解释：删掉位置 4 的数字后，[0,1,1,1,1,1,0,1] 的最长全 1 子数组为 [1,1,1,1,1] 。
 * 示例 3：
 * <p>
 * 输入：nums = [1,1,1]
 * 输出：2
 * 解释：你必须要删除一个元素。
 */
public class Solution01 {
    // 和1004题 是一样的，只是这里k固定是1
    public int longestSubarray(int[] nums) {
        final int k = 1;

        int maxCount = 0;

        // 连续的一段数中的0个数
        int zeroCount = 0;

        // 找连续的一段数，里面最多只有K个0
        // 如果发现超过K个0，则从这一段数里面第一个0的后一个位置开始重新统计
        // 比如 1,1,1,0,0,0,1,1,1,1,0
        // 从第一个1开始，统计到第二个0，就达到最长
        // 再往后一位，则会导致长度变短
        // 因为要求连续的一段数，里面最多只有K个0。所以要从第二个0开始重新统计
        int left = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;

                if (zeroCount > k) {
                    // 移动left到 从left之前位置开始的第一个0的下一个位置
                    // 这样才能将zeroCount降下来
                    while (zeroCount > k) {
                        if (nums[left++] == 0) {
                            zeroCount--;
                        }
                    }
                }
            }

            maxCount = Math.max(maxCount, i - left + 1);
        }

        return maxCount - 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1};

        int result = new Solution01().longestSubarray(nums);
        System.out.println(result);
    }
}
