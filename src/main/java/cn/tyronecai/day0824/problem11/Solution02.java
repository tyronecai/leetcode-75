package cn.tyronecai.day0824.problem11;

import com.google.common.io.Resources;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author cai.rong@yottabyte.cn
 * @date 2023-08-24 09:58
 */
public class Solution02 {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int result = 0;

        // 在每个状态下，无论长板或短板向中间收窄一格，都会导致水槽 底边宽度  变短：
        //
        //若向内 移动短板 ，水槽的短板 min(h[i],h[j])min(h[i], h[j])min(h[i],h[j]) 可能变大，因此下个水槽的面积 可能增大 。
        //若向内 移动长板 ，水槽的短板 min(h[i],h[j])min(h[i], h[j])min(h[i],h[j]) 不变或变小，因此下个水槽的面积 一定变小 。
        //因此，初始化双指针分列水槽左右两端，循环每轮将短板向内移动一格，并更新面积最大值，直到两指针相遇时跳出；即可获得最大面积。
        while (i < j) {
            int area = Math.min(height[i], height[j]) * (j - i);
            result = Math.max(result, area);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }


        System.out.printf("max area %s %n", result);
        return result;
    }

    public static void main(String[] args) throws IOException {
        String[] input = new String(Files.readAllBytes(Paths.get(Resources.getResource("day0824/problem11/input.txt").getPath()))).split(",");

        int[] height = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            height[i] = Integer.parseInt(input[i]);
        }
        System.out.println(height.length);

        int result = new Solution02().maxArea(height);
        System.out.println(result);
    }
}
