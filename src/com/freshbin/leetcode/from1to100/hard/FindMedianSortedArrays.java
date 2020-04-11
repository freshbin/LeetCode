package com.freshbin.leetcode.from1to100.hard;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * 
 * 示例 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * 则中位数是 2.0
 * 
 * 示例 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 则中位数是 (2 + 3)/2 = 2.5
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 
 * 解题思路：没什么想法，这个时间复杂度我达不到了，只能通过把两个数组装到一个新数组，
 * 然后排序新数组，找出中位数了
 * @author freshbin
 * @date 2019年12月25日 上午9:23:27
 */
public class FindMedianSortedArrays {
	public double findMedianSortedArrays0(int[] nums1, int[] nums2) {
		int[] newArr = new int[nums1.length + nums2.length];
		for(int i = 0; i < nums1.length; i++) {
			newArr[i] = nums1[i];
		}
		for(int i = 0; i < nums2.length; i++) {
			newArr[nums1.length + i] = nums2[i];
		}
		
		// Arrays.sort(newArr);
		for(int i = 0; i < newArr.length - 1; i++) {
			for(int j = i + 1; j < newArr.length; j++) {
				if(newArr[i] > newArr[j]) {
					int temp = newArr[i];
					newArr[i] = newArr[j];
					newArr[j] = temp;
				}
			}
		}
		
		if(newArr.length % 2 == 0) {
			return Double.valueOf(newArr[newArr.length / 2 - 1] + newArr[newArr.length / 2]) / 2;
		} else {
			return Double.valueOf(newArr[newArr.length / 2]);
		}
    }

	public static void main(String[] args) {
//		FindMedianSortedArrays findMedianSortedArrays = new FindMedianSortedArrays();
//		int[] nums1 = {1, 3, 5, 7, 9};
//		int[] nums2 = {2, 4, 6, 7, 8, 9};
//		System.out.println(findMedianSortedArrays.findMedianSortedArrays0(nums1, nums2));
		
		System.out.println(Math.round(Float.valueOf("2700.00")));
	}
	
	// 官方解法
	public double findMedianSortedArrays(int[] A, int[] B) {
		int m = A.length;
		int n = B.length;
		if (m > n) { // to ensure m<=n
			int[] temp = A;
			A = B;
			B = temp;
			int tmp = m;
			m = n;
			n = tmp;
		}
		int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
		while (iMin <= iMax) {
			int i = (iMin + iMax) / 2;
			int j = halfLen - i;
			if (i < iMax && B[j - 1] > A[i]) {
				iMin = i + 1; // i is too small
			} else if (i > iMin && A[i - 1] > B[j]) {
				iMax = i - 1; // i is too big
			} else { // i is perfect
				int maxLeft = 0;
				if (i == 0) {
					maxLeft = B[j - 1];
				} else if (j == 0) {
					maxLeft = A[i - 1];
				} else {
					maxLeft = Math.max(A[i - 1], B[j - 1]);
				}
				if ((m + n) % 2 == 1) {
					return maxLeft;
				}

				int minRight = 0;
				if (i == m) {
					minRight = B[j];
				} else if (j == n) {
					minRight = A[i];
				} else {
					minRight = Math.min(B[j], A[i]);
				}

				return (maxLeft + minRight) / 2.0;
			}
		}
		return 0.0;
    }
}
