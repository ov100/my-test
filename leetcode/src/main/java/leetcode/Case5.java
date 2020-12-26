package leetcode;

/**
 * @description: 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案
 * @author: gb
 * @create: 2020/10/09
 */
public class Case5 {
    public String longestPalindrome(String s) {
        char[] array = s.toCharArray();
        int length = array.length;
        if (length == 1) {
            return s;
        }

        //是完整的回文串
        if (eq(array, 0, length - 1)) {
            return s;
        }

        int left =0;
        int maxLength=0;
        for (int i = 0; i < array.length-1; i++) {
            for (int j = i+1; j < array.length; j++) {
                int len = j-i;
                if(eq(array,i,j)&& len>maxLength){
                    left = i;
                    maxLength=len;
                }
            }
        }

        return s.substring(left,left+maxLength+1);
    }

    private boolean eq(char[] array, int left, int right) {
        while (left < right) {
            if (array[left++] != array[right--]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = new Case5().longestPalindrome("babad");
        System.out.println(s);
    }
}
