package cn.tyronecai.day0829.problem1732;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author cai.rong@yottabyte.cn
 * @date 2023-08-29 16:32
 * <p>
 * 1732. 找到最高海拔
 * 提示
 * 简单
 * 86
 * 相关企业
 * 有一个自行车手打算进行一场公路骑行，这条路线总共由 n + 1 个不同海拔的点组成。自行车手从海拔为 0 的点 0 开始骑行。
 * <p>
 * 给你一个长度为 n 的整数数组 gain ，其中 gain[i] 是点 i 和点 i + 1 的 净海拔高度差（0 <= i < n）。请你返回 最高点的海拔 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：gain = [-5,1,5,0,-7]
 * 输出：1
 * 解释：海拔高度依次为 [0,-5,-4,1,1,-6] 。最高海拔为 1 。
 * 示例 2：
 * <p>
 * 输入：gain = [-4,-3,-2,-1,4,3,2]
 * 输出：0
 * 解释：海拔高度依次为 [0,-4,-7,-9,-10,-6,-3,-1] 。最高海拔为 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == gain.length
 * 1 <= n <= 100
 * -100 <= gain[i] <= 100
 */
public class Solution01 {

    public int largestAltitude(int[] gain) {
        int[] altitude = new int[gain.length + 1];
        // 自行车手从海拔为 0 的点 0 开始骑行
        altitude[0] = 0;
        int maxAltitude = altitude[0];

        for (int i = 0; i < gain.length; i++) {
            altitude[i + 1] = altitude[i] + gain[i];
            if (altitude[i + 1] > maxAltitude) {
                maxAltitude = altitude[i + 1];
            }
        }
        //System.out.println(Arrays.stream(gain).mapToObj(String::valueOf).collect(Collectors.toList()));
        //System.out.println(Arrays.stream(altitude).mapToObj(String::valueOf).collect(Collectors.toList()));

        return maxAltitude;
    }

    public static void main(String[] args) {
        int[] gain = new int[]{-4, -3, -2, -1, 4, 3, 2};
        int result = new Solution01().largestAltitude(gain);
        System.out.println(result);
    }
}
