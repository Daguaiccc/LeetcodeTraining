package HotTop100.双指针;

/**
 * @author: 大怪
 * @email: 962527441@qq.com
 */

/**
 * 题目:
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 示例：
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 */
public class 接雨水 {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length -1;
        int maxS = 0;
        int leftH =0;
        int rightH =0;
        while (left <= right){
            leftH = Math.max(leftH,height[left]);
            rightH = Math.max(rightH,height[right]);
            if (leftH<rightH){
                maxS += leftH-height[left++];
            }else {
                maxS += rightH-height[right--];
            }
        }
        return maxS;
    }
}
