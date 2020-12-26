package leetcode;

import java.util.*;

/**
 * @description: 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3
 * 思路：滑动窗口
 * @author: gb
 * @create: 2020/09/29
 */
public class Case3 {
    public int lengthOfLongestSubstring(String s) {
        char[] array = s.toCharArray();
        if(s.length()==1){
            return  1;
        }

        int max=0,left=0;

        Map<Character,Integer> map = new HashMap<>(array.length);
        for (int i = 0; i < array.length; i++) {

            char curr = array[i];
            if(map.containsKey(curr)){
                left = Math.max(map.get(curr),left);
            }

            max = Math.max(i-left+1,max);

            map.put(curr,i+1);
        }

        return max;
    }


    public static void main(String[] args) {
        int i = new Case3().lengthOfLongestSubstring("au");
        System.out.println(i);
    }
}
