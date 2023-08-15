package cn.tyronecai.day0815.problem1071;

import org.junit.Assert;

/**
 * @author cai.rong@yottabyte.cn
 * @date 2023-08-15 09:20
 * <p>
 * 1071. 字符串的最大公因子
 * https://leetcode.cn/problems/greatest-common-divisor-of-strings/?envType=study-plan-v2&envId=leetcode-75
 * 对于字符串 s 和 t，只有在 s = t + ... + t（t 自身连接 1 次或多次）时，我们才认定 “t 能除尽 s”。
 * <p>
 * 给定两个字符串 str1 和 str2 。返回 最长字符串 x，要求满足 x 能除尽 str1 且 x 能除尽 str2 。
 */
public class Solution01 {

    // 检查left是否是right的重复
    public boolean checkGcd(String left, String right) {
        if (left.length() % right.length() == 0) {
            int n = left.length() / right.length();
            for (int i = 0; i < n; i++) {
                int base = i * right.length();
                for (int j = 0; j < right.length(); j++) {
                    if (left.charAt(base + j) != right.charAt(j)) {
                        return false;
                    }
                }
            }
            return true;
        }

        return false;
    }

    public int gcd(int a, int b) {
        int remainder = a % b;
        while (remainder != 0) {
            a = b;
            b = remainder;
            remainder = a % b;
        }
        return b;
    }

    public String gcdOfStrings(String str1, String str2) {
        // 实际就是求 left 和 right 长度的公因数
        int n = gcd(str1.length(), str2.length());
        String result = str1.substring(0, n);
        if (checkGcd(str1, result) && checkGcd(str2, result)) {
            return result;
        }

        return "";
    }

    // 输入：str1 = "ABABAB", str2 = "ABAB"
    // 输出："AB"
    public static void main(String[] args) {
        String str1 = "TAUXXTAUXXTAUXXTAUXXTAUXX";
        String str2 = "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX";

        String result = new Solution01().gcdOfStrings(str1, str2);
        System.out.println(result);
        Assert.assertTrue("TAUXX".equals(result));
    }
}
