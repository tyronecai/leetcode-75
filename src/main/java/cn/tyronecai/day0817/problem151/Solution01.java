package cn.tyronecai.day0817.problem151;

import org.junit.Assert;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author cai.rong@yottabyte.cn
 * @date 2023-08-17 09:29
 *
 * https://leetcode.cn/problems/reverse-words-in-a-string/?envType=study-plan-v2&envId=leetcode-75
 * 151. 反转字符串中的单词
 * 中等
 * 962
 * 相关企业
 * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 *
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 *
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 *
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 */
public class Solution01 {

    public String reverseWords(String s) {
        // 先将整个句子拆解成单词
        List<String> words = new ArrayList<>();
        for (String token : s.split(" ")) {
            token = token.trim();
            if (token.length() > 0) {
                words.add(token);
            }
        }

        // 现在来做反转
        int i = 0;
        int j = words.size() - 1;
        while (i < j) {
            String tmp = words.get(i);
            words.set(i, words.get(j));
            words.set(j, tmp);
            ++i;
            --j;
        }

        // 最终用空格连接单词
        return String.join(" ", words);
    }


    public static void main(String[] args) {
        String input = "  hello world  ";
        String result = new Solution01().reverseWords(input);
        Assert.assertTrue(result, result.equals("world hello"));

        input = "a good   example";
        result = new Solution01().reverseWords(input);
        Assert.assertTrue(result, result.equals("example good a"));
    }
}
