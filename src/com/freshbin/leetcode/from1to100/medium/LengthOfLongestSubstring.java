package com.freshbin.leetcode.from1to100.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3 
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 
 * @author freshbin
 * @date 2019年12月23日 上午9:21:49
 */
public class LengthOfLongestSubstring {

	public int lengthOfLongestSubstring0(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		HashMap<String, Integer> substringLengthMap = new HashMap<>();
		StringBuffer substringKey = new StringBuffer();
		Integer keyIndex = 0;
		char[] tempChar = s.toCharArray();
		for (int i = 0; i < tempChar.length; i++) {
			if (substringKey.toString().contains(String.valueOf(tempChar[i]))) {
				substringKey = new StringBuffer();
				i = ++keyIndex; // 如果有重复字符，则将遍历的游标移回初始下标的下一个
			}
			substringKey.append(String.valueOf(tempChar[i]));
			substringLengthMap.put(substringKey.toString(), substringKey.length());
		}

		Integer maxLength = 0;
		for (Map.Entry<String, Integer> entry : substringLengthMap.entrySet()) {
			if (entry.getValue() > maxLength) {
				maxLength = entry.getValue();
			}
		}

		return maxLength;
	}

	public static void main(String[] args) {
		String string = "abcabcdabfhua";
		LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
		System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring(string));
	}

	// 官方解法
	public int lengthOfLongestSubstring(String s) {
		int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;
	}
	
}
