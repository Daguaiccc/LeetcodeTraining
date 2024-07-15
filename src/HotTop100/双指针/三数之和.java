package HotTop100.双指针;

/**
 * @author: 大怪
 * @email: 962527441@qq.com
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 题目：
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]]
 * 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。
 * 请你返回所有和为 0 且不重复的三元组。
 *
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 */

/**
 * 并没有使用双指针的解法，而是使用了两数之和的变种
 */
public class 三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int target = nums[i];
            if (i>0 && Integer.compare(nums[i],nums[i-1]) == 0){
                continue;
            }
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = i+1; j < nums.length; j++) {
                if (map.containsKey(-(target+nums[j]))){
                    list.add(Arrays.asList(nums[i],-(target+nums[j]),nums[j]));
                    while (j+1<nums.length && Integer.compare(nums[j],nums[j+1]) == 0){
                        j++;
                    }
                }else {
                    map.put(nums[j],j);
                }
            }
        }
        return list;
    }
}
