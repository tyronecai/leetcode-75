package cn.tyronecai.day0829.problem742;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author cai.rong@yottabyte.cn
 * @date 2023-08-29 16:45
 * <p>
 * 724. 寻找数组的中心下标
 * 给你一个整数数组 nums ，请计算数组的 中心下标 。
 * <p>
 * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
 * <p>
 * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
 * <p>
 * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1, 7, 3, 6, 5, 6]
 * 输出：3
 * 解释：
 * 中心下标是 3 。
 * 左侧数之和 sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11 ，
 * 右侧数之和 sum = nums[4] + nums[5] = 5 + 6 = 11 ，二者相等。
 * 示例 2：
 * <p>
 * 输入：nums = [1, 2, 3]
 * 输出：-1
 * 解释：
 * 数组中不存在满足此条件的中心下标。
 * 示例 3：
 * <p>
 * 输入：nums = [2, 1, -1]
 * 输出：0
 * 解释：
 * 中心下标是 0 。
 * 左侧数之和 sum = 0 ，（下标 0 左侧不存在元素），
 * 右侧数之和 sum = nums[1] + nums[2] = 1 + -1 = 0 。
 */
public class Solution01 {

    public int pivotIndex(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }

        // 如果只有一个数字，因为它的左边是空的，所有左边数字之和为0.
        // 右边也是空的，所以它右边数字之和也是0
        // 所以此时就是特殊情况
        if (nums.length == 1) {
            return 0;
        }

        int[] leftSum = new int[nums.length];
        leftSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            leftSum[i] = leftSum[i - 1] + nums[i];
        }

        int[] rightSum = new int[nums.length];
        rightSum[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            rightSum[i] = rightSum[i + 1] + nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            // 最左边的数字，它左边数字之和是0
            if (i == 0) {
                if (rightSum[1] == 0) {
                    return i;
                } else {
                    continue;
                }
            }

            // 最右边的数字，它右边的数字之和是0
            if (i == nums.length - 1) {
                if (leftSum[nums.length - 2] == 0) {
                    return i;
                } else {
                    continue;
                }
            }

            if (leftSum[i - 1] == rightSum[i + 1]) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, -1};

        int result = new Solution01().pivotIndex(nums);
        System.out.println(result);
    }
}
