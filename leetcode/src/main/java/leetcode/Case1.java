package leetcode;

/**
 * @description: leetcode 第1题，给定数据和目标值，返回数据中两数之和等于目标值，返回两数的下标
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * @author: gb
 * @create: 2020/09/29
 */
public class Case1 {
    public int[] twoSum(int[] nums, int target) {

        if (nums == null || nums.length < 2) {
            return null;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            int a = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int b = nums[j];
                if (target == (a + b)) {
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }

    public static void main(String[] args) {

        int [] nums = {2,7,11,15};
        int [] result = new Case1().twoSum(nums,9);
        System.out.println(result);
    }
}
