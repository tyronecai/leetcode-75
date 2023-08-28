package cn.tyronecai.day0828.problem1456;

/**
 * @author cai.rong@yottabyte.cn
 * @date 2023-08-28 13:01
 *
 * https://leetcode.cn/problems/maximum-number-of-vowels-in-a-substring-of-given-length/?envType=study-plan-v2&envId=leetcode-75
 * 1456. 定长子串中元音的最大数目
 *
 * 给你字符串 s 和整数 k 。
 *
 * 请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。
 *
 * 英文中的 元音字母 为（a, e, i, o, u）。
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


    // 1 <= s.length <= 10^5
    //s 由小写英文字母组成
    //1 <= k <= s.length
    public int maxVowels(String s, int k) {
        char[] chars = s.toCharArray();

        int vowelCount = 0;
        int i = 0;
        for (; i < k; i++) {
            if (isVowel(chars[i])) {
                vowelCount++;
            }
        }

        int maxVowelCount = vowelCount;
        if (maxVowelCount == k) {
            return k;
        }
        for (; i < chars.length; i++) {
            if (isVowel(chars[i - k])) {
                vowelCount--;
            }
            if (isVowel(chars[i])) {
                vowelCount++;
            }

            if (vowelCount > maxVowelCount) {
                maxVowelCount = vowelCount;
                if (maxVowelCount == k) {
                    return k;
                }
            }
        }

        return maxVowelCount;
    }

    // 输入：s = "abciiidef", k = 3
    //输出：3
    //解释：子字符串 "iii" 包含 3 个元音字母。
    public static void main(String[] args) {
        String s = "leetcode";
        int k = 3;

        int result = new Solution01().maxVowels(s, k);
        System.out.println(result);

    }
}
