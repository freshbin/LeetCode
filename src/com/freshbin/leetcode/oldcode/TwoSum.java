package com.freshbin.leetcode.oldcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组，返回两个数字的索引，使它们相加到特定目标。 您可以假设每个输入只有一个解决方案，并且您可能不会两次使用相同的元素。 
 * 例： 给定nums= [2,7,11,15]，target = 9， 因为nums [ 0 ] + nums [ 1 ] = 2 + 7 = 9， 返回[ 0，1 ]。
 * 
 * @author freshbin
 * @date 2019年4月9日 下午5:02:22
 */
public class TwoSum {
	public static int[] myTry1(int[] nums, int target) throws Exception {
		long startTime = System.currentTimeMillis();
		int[] targetArr = new int[2];
		int size = nums.length;
		for (int i = 1; i < size; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] + nums[j] == target) {
					targetArr[0] = j;
					targetArr[1] = i;
					System.out.println("myTry1方法结果：[" + targetArr[0] + ", " + targetArr[1] + "]====耗时："
							+ (System.currentTimeMillis() - startTime));
					return targetArr;
				}
			}
		}
		return null;
	}

	public static int[] otherTry1(int[] numbers, int target) {
		long startTime = System.currentTimeMillis();
		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>(16);
		for (int i = 0; i < numbers.length; i++) {
			if (map.containsKey(target - numbers[i])) {
				result[1] = i;
				result[0] = map.get(target - numbers[i]);
				System.out.println("otherTry1方法结果：[" + result[0] + ", " + result[1] + "]====耗时："
						+ (System.currentTimeMillis() - startTime));
				return result;
			}
			map.put(numbers[i], i);
		}
		return result;
	}

	public static int[] otherTry2(int[] nums, int target) {
		long startTime = System.currentTimeMillis();

		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] == target - nums[i]) {
					System.out.println(
							"otherTry2方法结果：[" + i + ", " + j + "]====耗时：" + (System.currentTimeMillis() - startTime));
					return new int[] { i, j };
				}
			}
		}
		throw new IllegalArgumentException("No two sum solution");

	}

	public static int[] otherTry3(int[] nums, int target) {
		long startTime = System.currentTimeMillis();

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement) && map.get(complement) != i) {
				System.out.println("otherTry3方法结果：[" + i + ", " + map.get(complement) + "]====耗时："
						+ (System.currentTimeMillis() - startTime));
				return new int[] { i, map.get(complement) };
			}
		}
		throw new IllegalArgumentException("No two sum solution");

	}

	public static int[] otherTry4(int[] nums, int target) {
		long startTime = System.currentTimeMillis();
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement)) {
				System.out.println("otherTry4方法结果：[" + map.get(complement) + ", " + i + "]====耗时："
						+ (System.currentTimeMillis() - startTime));
				return new int[] { map.get(complement), i };
			}
			map.put(nums[i], i);
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	public static void main(String[] args) throws Exception {
		int size = 100000000;
		int[] nums = new int[size];
		for (int i = 0; i < size; i++) {
			nums[i] = (int) (Math.random() * 10000);
		}

		int firstIndex = (int) (Math.random() * size);
		int secondIndex = (int) (Math.random() * size);
		int target = nums[firstIndex] + nums[secondIndex];

		myTry1(nums, target);
		otherTry1(nums, target);
		otherTry2(nums, target);
		otherTry3(nums, target);
		otherTry4(nums, target);
	}

}
