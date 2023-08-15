package cn.tyronecai.day0815.problem1768;

import org.junit.Assert;

/**
 * @author cai.rong@yottabyte.cn
 * @date 2023-08-15 09:03
 *
 * 1768. 交替合并字符串
 * https://leetcode.cn/problems/merge-strings-alternately/?envType=study-plan-v2&envId=leetcode-75
 * 给你两个字符串 word1 和 word2 。请你从 word1 开始，通过交替添加字母来合并字符串。如果一个字符串比另一个字符串长，就将多出来的字母追加到合并后字符串的末尾。
 * 返回 合并后的字符串 。
 */
class Solution01 {

    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();

        int i = 0;
        for (i = 0; i < Math.min(word1.length(), word2.length()); i++) {
            result.append(word1.charAt(i));
            result.append(word2.charAt(i));
        }

        if (i < word1.length()) {
            result.append(word1.substring(i));
        }
        if (i < word2.length()) {
            result.append(word2.substring(i));
        }

        return result.toString();
    }

    /**
     * 输入：word1 = "abc", word2 = "pqr"
     * 输出："apbqcr"
     * 解释：字符串合并情况如下所示：
     * word1：  a   b   c
     * word2：    p   q   r
     * 合并后：  a p b q c r
     * */
    public static void main(String[] args) {
        String word1 = "abcde";
        String word2 = "pqr";

        String result = "apbqcrde";
        Assert.assertTrue(result.equals(new Solution01().mergeAlternately(word1, word2)));
    }
}
