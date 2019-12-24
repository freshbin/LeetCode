package com.freshbin.leetcode.from1to100.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素 
 * 示例： 
 * 给定 nums = [2, 7, 11, 15], target = 9 
 * 因为 nums[0] + nums[1] = 2 + 7 = 9 
 * 所以 返回 [0, 1] 
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 
 * 个人解题思路：两个for循环，每两个元素相加，等于目标数即可
 * 
 * @author freshbin
 * @date 2019年12月20日 下午3:20:03
 */
public class TwoSum {

	public int[] twoSum(int[] nums, int target) {
		int[] targetIndex = new int[2];
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					targetIndex[0] = i;
					targetIndex[1] = j;
					return targetIndex;
				}
			}
		}
		return targetIndex;
	}

	public static void main(String[] args) {
		TwoSum twoSum = new TwoSum();
		int[] nums = {3, 2, 3};
		int target = 6;
		int[] targetArr = twoSum.twoSum(nums, target);
		System.out.println(targetArr[0] + "," + targetArr[1]);
	}
	
	// 官方解法1
    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    
    // 官方解法2
    public int[] twoSum2(int[] nums, int target) {
    	Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    
    // 官方解法3
    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
	
}
