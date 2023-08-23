package cn.tyronecai.day0823.problem392;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cai.rong@yottabyte.cn
 * @date 2023-08-23 09:16
 * <p>
 * https://leetcode.cn/problems/is-subsequence/?envType=study-plan-v2&envId=leetcode-75
 * 392. 判断子序列
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * <p>
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * <p>
 * 进阶：
 * <p>
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 * <p>
 * 致谢：
 * <p>
 * 特别感谢 @pbrother 添加此问题并且创建所有测试用例。
 */
public class Solution01 {
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }

    /**
     * 0 <= s.length <= 100
     * 0 <= t.length <= 10^4
     * 两个字符串都只由小写字符组成。
     * */
    public static void main(String[] args) {
        String s = "axc";
        String t = "ahbgdc";
        boolean result = new Solution01().isSubsequence(s, t);
        System.out.println(result);
    }
}
