package HotTop100.滑动窗口;

/**
 * @author: 大怪
 * @email: 962527441@qq.com
 */

import java.net.BindException;
import java.util.*;

/**
 * 题目：
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 *
 * 示例 1:
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 */
public class 找到字符串中所有字母异位词 {
    public static List<Integer> findAnagrams(String s, String p) {
        int[] counts = new int[26];
        int[] sums = new int[26];
        char[] chars = p.toCharArray();
        ArrayList<Integer> list = new ArrayList<>();
        for (char c : chars) {
            counts[c-'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            sums[s.charAt(i)-'a']++;
            if (i>=p.length()){
                sums[s.charAt(i-p.length())-'a']--;
            }
            if (Arrays.equals(counts, sums)){
                list.add(i-p.length()+1);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        findAnagrams("cbaebabacd","abc");
    }
}
