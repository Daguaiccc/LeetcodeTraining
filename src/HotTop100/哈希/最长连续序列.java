package HotTop100.哈希;

/**
 * @author: 大怪
 * @email: 962527441@qq.com
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 题目：
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 * 示例 1：
 *
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 */
public class 最长连续序列 {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums);
        int max = 0;
        for (int num : nums) {
            if (map.containsKey(num - 1)) {
                map.put(num, map.get(num - 1) + 1);
            }  else {
                map.put(num, map.getOrDefault(num, 1));
            }
            max = Math.max(max, map.get(num));
        }
        return max;
    }


    public int longestConsecutive2(int[] nums) {
        if (nums.length == 0) {return 0;}
        Arrays.sort(nums);
        int longest = 0;
        int curr = 1;
        for (int i = 1; i < nums.length; i ++) {
            if (nums[i] == nums[i-1] + 1) {
                curr ++;
            } else if (nums[i] != nums[i-1]) {
                longest = Math.max(longest, curr);
                curr = 1;
            }
        }
        return Math.max(longest, curr);
    }
}
