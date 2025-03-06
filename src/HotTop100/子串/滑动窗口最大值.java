package HotTop100.子串;

/**
 * @author: 大怪
 * @email: 962527441@qq.com
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Stack;

/**
 * 题目：
 *  给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。
 *  滑动窗口每次只向右移动一位。
 *  返回 滑动窗口中的最大值 。
 *
 *  示例 1：
 *
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 */
public class 滑动窗口最大值 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length-k+1];
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            if (i >= k){
                result[i-k] = deque.peek();
                rmFirst(deque,nums[i-k]);
            }
            addMax(deque,nums[i]);
        }
        result[result.length-1] = deque.peek();
        return result;
    }

    private static void addMax(ArrayDeque<Integer> deque, Integer k){
        while (!deque.isEmpty() && k > deque.getLast()){
            deque.removeLast();
        }
        deque.add(k);
    }

    private static void rmFirst(ArrayDeque deque, Integer k){
        if (k.equals(deque.getFirst())){
            deque.remove();
        }
    }

    public static void main(String[] args) {
        int[] ints = {1, 2, 8, -8,9,-2,-1 };
        maxSlidingWindow(ints,3);
    }
}
