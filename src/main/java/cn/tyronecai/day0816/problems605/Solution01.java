package cn.tyronecai.day0816.problems605;

/**
 * @author cai.rong@yottabyte.cn
 * @date 2023-08-16 10:42
 * <p>
 * https://leetcode.cn/problems/can-place-flowers/?envType=study-plan-v2&envId=leetcode-75
 * 605. 种花问题
 * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * <p>
 * 给你一个整数数组 flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数 n ，能否在不打破种植规则的情况下种入 n 朵花？能则返回 true ，不能则返回 false 。
 */
public class Solution01 {

    private boolean checkSlot(int[] flowerbed, int i) {
        if (i < 0 || i >= flowerbed.length) {
            return true;
        }
        return flowerbed[i] == 0;
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // 0 <= n <= flowerbed.length
        // 要小心n可能为0
        if (n == 0) {
            return true;
        }

        int x = n;
        for (int i = 0; i < flowerbed.length; i++) {
            if (checkSlot(flowerbed, i - 1) && checkSlot(flowerbed, i) && checkSlot(flowerbed, i + 1)) {
                flowerbed[i] = 1;
                x -= 1;
                if (x == 0) {
                    return true;
                }
            }
        }

        return false;
    }

    // 示例 1：
    //
    //输入：flowerbed = [1,0,0,0,1], n = 1
    //输出：true
    //示例 2：
    //
    //输入：flowerbed = [1,0,0,0,1], n = 2
    //输出：false
    //
    //
    //提示：
    //
    //1 <= flowerbed.length <= 2 * 104
    //flowerbed[i] 为 0 或 1
    //flowerbed 中不存在相邻的两朵花
    //0 <= n <= flowerbed.length
    public static void main(String[] args) {
        int[] flowerbed = new int[]{0, 0, 1, 0, 1};
        int n = 2;
        boolean result = new Solution01().canPlaceFlowers(flowerbed, n);
        System.out.println(result);

        for (int i = 0; i < flowerbed.length; i++) {
            System.out.println("#" + i + ", " + flowerbed[i]);
        }
    }
}
