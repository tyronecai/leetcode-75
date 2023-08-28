package cn.tyronecai.day0828.problem1679;

import java.util.*;

/**
 * @author cai.rong@yottabyte.cn
 * @date 2023-08-28 15:08
 */
public class Solution03 {
    // 1 <= nums.length <= 10^5
    //1 <= nums[i] <= 10^9
    //1 <= k <= 10^9

    // 因为数字取值范围有10^9，所以也不能用数组
    //
    public int maxOperations(int[] nums, int k) {
        int count = 0;

        // 记录每个数字的位置，一个数可能出现多次
        Map<Integer, List<Integer>> dataMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= k) {
                nums[i] = -1;
            } else {
                // 通过 Java 454 ms 53.1 MB
                //dataMap.computeIfAbsent(nums[i], x -> new ArrayList<>()).add(i);
                // 通过 Java 31 ms 54.3 MB。用ArrayList会因为remove操作导致慢一个数量级
                dataMap.computeIfAbsent(nums[i], x -> new LinkedList<>()).add(i);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == -1) {
                continue;
            }

            List<Integer> tmpList = dataMap.get(k - nums[i]);
            if (tmpList == null || tmpList.isEmpty()) {
                continue;
            }

            if (false) {
                // 找到自己了，比如k=6，当前num是3，那么按上面的会找到自己
                for (int x : tmpList) {
                    // 因为是顺序找，所以x一定要大于i，否则在处理x时就处理过了
                    // 这里有太多重复计算，所以必须用下面的方法，做remove
                    if (x > i && nums[x] != -1) {
                        count++;

                        nums[i] = -1;
                        nums[x] = -1;

                        break;
                    }
                }
            } else {
                // 需要把用过的remove掉，减少计算，否则会超时
                // 但还是不如先对nums排序
                Iterator<Integer> iterator = tmpList.iterator();
                while (iterator.hasNext()) {
                    int x = iterator.next();
                    iterator.remove();
                    if (x > i) {
                        nums[i] = -1;
                        nums[x] = -1;
                        count++;
                        break;
                    }
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
        int[] nums = new int[]{63, 10, 28, 31, 90, 53, 75, 77, 72, 47, 45, 6, 49, 13, 77, 61, 68, 43, 33, 1, 14, 62, 55, 55, 38, 54, 8, 79, 89, 14, 50, 68, 85, 12, 42, 57, 4, 67, 75, 6, 71, 8, 61, 26, 11, 20, 22, 3, 70, 52, 82, 70, 67, 18, 66, 79, 84, 51, 78, 23, 19, 84, 46, 61, 63, 73, 80, 61, 15, 12, 58, 3, 21, 66, 42, 55, 7, 58, 85, 60, 23, 69, 41, 61, 35, 64, 58, 84, 61, 77, 45, 14, 1, 38, 4, 8, 42, 16, 79, 60, 80, 39, 67, 10, 24, 15, 6, 37, 68, 76, 30, 53, 63, 87, 11, 71, 86, 82, 77, 76, 37, 21, 85, 7, 75, 83, 80, 8, 19, 25, 11, 10, 41, 66, 70, 14, 23, 74, 33, 76, 35, 89, 68, 85, 83, 57, 6, 72, 34, 21, 57, 72, 79, 29, 65, 3, 67, 8, 24, 24, 18, 26, 27, 68, 78, 64, 57, 55, 68, 28, 9, 11, 38, 45, 61, 37, 81, 89, 38, 43, 45, 26, 84, 62, 22, 37, 51, 15, 30, 67, 75, 24, 66, 40, 81, 74, 48, 43, 78, 14, 33, 19, 73, 5, 1, 2, 53, 29, 49, 73, 23, 5};
        int k = 59;

        int result = new Solution03().maxOperations(nums, k);
        System.out.println(result);
    }
}
