package cn.tyronecai.day0829.problem742;

import org.junit.Assert;

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
public class Solution02 {

    public int pivotIndex(int[] nums) {
        // 提前算出来右边数字累计和，补上一位数字是因为最右边数字它没有右边了，所以它右边数字之和为0
        int[] rightSumNums = new int[nums.length + 1];
        rightSumNums[nums.length] = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            rightSumNums[i] = rightSumNums[i + 1] + nums[i];
        }

        // 记录左边所有数之和
        int leftSum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (leftSum == rightSumNums[i + 1]) {
                return i;
            }

            leftSum += nums[i];
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums;
        int result;

        nums = new int[] {1, 7, 3, 6, 5, 6};
        result = new Solution02().pivotIndex(nums);
        Assert.assertTrue(result == 3);

        nums = new int[]{1, 2, 3};
        result = new Solution02().pivotIndex(nums);
        Assert.assertTrue(result == -1);


        nums = new int[] {2, 1, -1};
        result = new Solution02().pivotIndex(nums);
        Assert.assertTrue(result == 0);

        nums = new int[] {2};
        result = new Solution02().pivotIndex(nums);
        Assert.assertTrue(result == 0);
    }
}
