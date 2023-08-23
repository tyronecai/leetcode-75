package cn.tyronecai.day0822.problem283;

import java.util.SortedSet;

/**
 * @author cai.rong@yottabyte.cn
 * @date 2023-08-22 17:17
 *
 * https://leetcode.cn/problems/move-zeroes/?envType=study-plan-v2&envId=leetcode-75
 * 283. 移动零
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 */
public class Solution01 {

    // 将0和近邻的非0数字进行调换
    public void moveZeroes(int[] nums) {
        int firstZeroIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == 0) {
                if (firstZeroIndex == -1) {
                    firstZeroIndex = i;
                }
            } else {
                if (firstZeroIndex != -1) {
                    nums[firstZeroIndex] = num;
                    nums[i] = 0;
                    firstZeroIndex += 1;
                }
            }
        }
    }

    /**
     * 示例 1:
     *
     * 输入: nums = [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * 示例 2:
     *
     * 输入: nums = [0]
     * 输出: [0]
     *
     *
     * 提示:
     *
     * 1 <= nums.length <= 104
     * -231 <= nums[i] <= 231 - 1
     * */
    public static void main(String[] args) {
        int[] nums = new int[] {1,3,5, 12};
        new Solution01().moveZeroes(nums);
        for (int i : nums) {
            System.out.println(i);
        }

    }
}
