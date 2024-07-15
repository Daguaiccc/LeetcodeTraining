package HotTop100.哈希;

/**
 * @author: 大怪
 * @email: 962527441@qq.com
 */

import java.util.HashMap;

/**
 * 题目：
 * 给定一个整数数组 nums 和一个整数目标值 target
 * 请你在该数组中找出和为目标值target的那两个整数，并返回它们的数组下标。
 *
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 *
 */
public class 两数之和 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }
}
