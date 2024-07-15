package HotTop100.哈希;

/**
 * @author: 大怪
 * @email: 962527441@qq.com
 */


import java.nio.Buffer;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 题目：
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 *
 * 示例：
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 */
public class 字母异位词分组 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        return new ArrayList<>(Arrays.stream(strs).collect(Collectors.groupingBy(e -> {
            return e.chars().sorted().collect(StringBuffer::new,StringBuffer::appendCodePoint,StringBuffer::append).toString();
        })).values());
    }

    public static List<List<String>> groupAnagrams2(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = Arrays.toString(chars);
            List<String> value = map.getOrDefault(s, new ArrayList<>());
            value.add(str);
            map.put(s,value);
        }
        return new ArrayList<>(map.values());
    }
    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams2(strs));
    }
}
