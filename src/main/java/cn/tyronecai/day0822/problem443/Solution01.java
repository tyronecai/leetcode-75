package cn.tyronecai.day0822.problem443;

/**
 * @author cai.rong@yottabyte.cn
 * @date 2023-08-22 16:57
 * <p>
 * https://leetcode.cn/problems/string-compression/?envType=study-plan-v2&envId=leetcode-75
 * 443. 压缩字符串
 * 给你一个字符数组 chars ，请使用下述算法压缩：
 * <p>
 * 从一个空字符串 s 开始。对于 chars 中的每组 连续重复字符 ：
 * <p>
 * 如果这一组长度为 1 ，则将字符追加到 s 中。
 * 否则，需要向 s 追加字符，后跟这一组的长度。
 * 压缩后得到的字符串 s 不应该直接返回 ，需要转储到字符数组 chars 中。需要注意的是，如果组长度为 10 或 10 以上，则在 chars 数组中会被拆分为多个字符。
 * <p>
 * 请在 修改完输入数组后 ，返回该数组的新长度。
 * <p>
 * 你必须设计并实现一个只使用常量额外空间的算法来解决此问题。
 */
public class Solution01 {
    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        char lastChar = chars[0];
        int lastCount = 1;
        for (int i = 1; i < chars.length; i++) {
            char c = chars[i];
            if (c == lastChar) {
                lastCount += 1;
            } else {
                sb.append(lastChar);
                if (lastCount > 1) {
                    sb.append(lastCount);
                }
                lastChar = c;
                lastCount = 1;
            }
        }

        sb.append(lastChar);
        if (lastCount > 1) {
            sb.append(lastCount);
        }

        // 要将结果写回原 chars
        String result = sb.toString();
        for (int i = 0; i < sb.length(); i++) {
            chars[i] = result.charAt(i);
        }
        return result.length();
    }

    public static void main(String[] args) {
        char[] chars = new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'c', 'c', 'c'};
        int result = new Solution01().compress(chars);
        System.out.println(result);
    }
}
