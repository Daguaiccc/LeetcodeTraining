package HotTop100.子串;
import java.util.*;
/**
 * @author: 大怪
 * @email: 962527441@qq.com
 */


/**
 * 题目：
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * 子数组是数组中元素的连续非空序列。
 */
public class 和为K的子数组 {
    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            Integer ct = map.getOrDefault(sum, 0);
            if (map.containsKey(sum-k)){
                count += map.get(sum-k);
            }
            map.put(sum,++ct);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,1,1};
        System.out.println(subarraySum(a,2));
    }
}
