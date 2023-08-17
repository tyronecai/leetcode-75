package cn.tyronecai.day0817.problem345;

import org.junit.Assert;

/**
 * @author cai.rong@yottabyte.cn
 * @date 2023-08-17 09:05
 *
 * https://leetcode.cn/problems/reverse-vowels-of-a-string/?envType=study-plan-v2&envId=leetcode-75
 * 345. 反转字符串中的元音字母
 * 简单
 * 319
 * 相关企业
 * 给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
 *
 * 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现不止一次。
 */
public class Solution01 {

    private boolean isVowel(char c) {
        switch (c) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
                return true;
            default:
                return false;
        }
    }

    public String reverseVowels(String s) {
        // 反转 的意思就是：字符串的第一个元音字母 和 字符串的最后一个元音字母 调换位置
        int n = s.length();
        char[] chars = s.toCharArray();
        int i = 0;
        int j = n - 1;
        while (i < j) {
            while (i < n && !isVowel(chars[i])) {
                ++i;
            }
            while (j > 0 && !isVowel(chars[j])) {
                --j;
            }
            if (i < j) {
                char tmp = chars[i];
                chars[i] = chars[j];
                chars[j] = tmp;

                ++i;
                --j;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String input = "leotcudi";
        String result = new Solution01().reverseVowels(input);
        Assert.assertTrue(result, result.equals("loutcide"));
    }
}
