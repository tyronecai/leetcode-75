package cn.tyronecai.day0830.problem2215;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author cai.rong@yottabyte.cn
 * @date 2023-08-30 11:04
 * <p>
 * 2215. 找出两数组的不同
 * 给你两个下标从 0 开始的整数数组 nums1 和 nums2 ，请你返回一个长度为 2 的列表 answer ，其中：
 * <p>
 * answer[0] 是 nums1 中所有 不 存在于 nums2 中的 不同 整数组成的列表。
 * answer[1] 是 nums2 中所有 不 存在于 nums1 中的 不同 整数组成的列表。
 * 注意：列表中的整数可以按 任意 顺序返回。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,3], nums2 = [2,4,6]
 * 输出：[[1,3],[4,6]]
 * 解释：
 * 对于 nums1 ，nums1[1] = 2 出现在 nums2 中下标 0 处，然而 nums1[0] = 1 和 nums1[2] = 3 没有出现在 nums2 中。因此，answer[0] = [1,3]。
 * 对于 nums2 ，nums2[0] = 2 出现在 nums1 中下标 1 处，然而 nums2[1] = 4 和 nums2[2] = 6 没有出现在 nums2 中。因此，answer[1] = [4,6]。
 * 示例 2：
 * <p>
 * 输入：nums1 = [1,2,3,3], nums2 = [1,1,2,2]
 * 输出：[[3],[]]
 * 解释：
 * 对于 nums1 ，nums1[2] 和 nums1[3] 没有出现在 nums2 中。由于 nums1[2] == nums1[3] ，二者的值只需要在 answer[0] 中出现一次，故 answer[0] = [3]。
 * nums2 中的每个整数都在 nums1 中出现，因此，answer[1] = [] 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums1.length, nums2.length <= 1000
 * -1000 <= nums1[i], nums2[i] <= 1000
 */
public class Solution01 {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> result = new ArrayList<>(2);
        // 要点是先排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        // nums1 中所有 不 存在于 nums2 中的 不同 整数组成的列表。
        List<Integer> left = new ArrayList<>();
        // nums2 中所有 不 存在于 nums1 中的 不同 整数组成的列表。
        List<Integer> right = new ArrayList<>();
        result.add(left);
        result.add(right);

        // 注意 由于 nums1[2] == nums1[3] ，二者的值只需要在 answer[0] 中出现一次，故 answer[0] = [3]。
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            int x = nums1[i];
            int y = nums2[j];
            if (x < y) {
                left.add(x);

                i++;
                // 跳过重复的数字
                while (i < nums1.length && nums1[i] == x) {
                    i++;
                }
            } else if (nums1[i] > nums2[j]) {
                right.add(y);

                j++;
                // 跳过重复的数字
                while (j < nums2.length && nums2[j] == y) {
                    j++;
                }
            } else {
                i++;
                while (i < nums1.length && nums1[i] == x) {
                    i++;
                }

                j++;
                while (j < nums2.length && nums2[j] == y) {
                    j++;
                }
            }
        }

        while (i < nums1.length) {
            // 跳过重复的数字
            if (left.size() == 0 || left.get(left.size() - 1) != nums1[i]) {
                left.add(nums1[i]);
            }

            i++;
        }

        while (j < nums2.length) {
            // 跳过重复的数字
            if (right.size() == 0 || right.get(right.size() - 1) != nums2[j]) {
                right.add(nums2[j]);
            }
            j++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 3};
        int[] nums2 = new int[]{1, 1, 2, 2};

        List<List<Integer>> result = new Solution01().findDifference(nums1, nums2);
        System.out.println(result);
    }
}
