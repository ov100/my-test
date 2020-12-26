package leetcode;

import java.util.Arrays;

/**
 * @description: 寻找两个正序数组的中位数
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
 * <p>
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * @author: gb
 * @create: 2020/10/09
 */
public class Case4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merge = new int[nums1.length + nums2.length];

        for (int i = 0; i < nums1.length; i++) {
            merge[i] = nums1[i];
        }

        for (int i = 0; i < nums2.length; i++) {
            merge[i + nums1.length] = nums2[i];
        }

        if (merge.length == 1) {
            return merge[0];
        }

        Arrays.sort(merge);

        boolean odd = merge.length % 2 != 0;
        int mid = merge.length / 2;
        if (odd) {
            return merge[mid];
        }

        return (merge[mid - 1] + merge[mid]) * 1D / 2D;
    }

    public static void main(String[] args) {
        int[] n1 = {1};
        int[] n2 = {};
        double d = new Case4().findMedianSortedArrays(n1, n2);
        System.out.println(d);
    }
}
