package cn.tyronecai.day0822.problem443;

/**
 * @author cai.rong@yottabyte.cn
 * @date 2023-08-22 17:08
 */
public class Solution02 {
    public int compress(char[] chars) {
        char lastChar = chars[0];
        int lastCount = 1;
        int j = 0;
        for (int i = 1; i < chars.length; i++) {
            char c = chars[i];
            if (c == lastChar) {
                lastCount += 1;
            } else {
                chars[j++] = lastChar;
                if (lastCount > 1) {
                    for (char x : String.valueOf(lastCount).toCharArray()) {
                        chars[j++] = x;
                    }
                }

                lastChar = c;
                lastCount = 1;
            }
        }

        chars[j++] = lastChar;
        if (lastCount > 1) {
            for (char x : String.valueOf(lastCount).toCharArray()) {
                chars[j++] = x;
            }
        }

        return j;
    }

    public static void main(String[] args) {
        char[] chars = new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'c', 'c', 'c'};
        int result = new Solution02().compress(chars);
        System.out.println(result);
    }
}
