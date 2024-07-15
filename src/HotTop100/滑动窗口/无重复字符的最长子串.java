package HotTop100.滑动窗口;

/**
 * @author: 大怪
 * @email: 962527441@qq.com
 */

import java.util.HashMap;

/**
 * 题目：
 * 给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度。
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */

public class 无重复字符的最长子串 {
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int max = 0;
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])){
                index = Math.max(index,map.get(chars[i])+1);
            }
            max = Math.max(max,i-index+1);
            map.put(chars[i],i);
        }
        return max;
    }

    public static void main(String[] args) {
        lengthOfLongestSubstring("pwwkew");
    }
}
