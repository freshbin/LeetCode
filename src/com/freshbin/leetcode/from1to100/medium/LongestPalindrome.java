package com.freshbin.leetcode.from1to100.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 *  
 * 穷举法，将所有的字串都判断是否回文，取出最长的字串
 * @author freshbin
 * @date 2019年12月26日 下午9:09:18
 */
public class LongestPalindrome {
	public boolean isPalindromic(String s) {
		for(int i = 0; i < s.length() / 2; i++) {
			if(s.charAt(i) != s.charAt(s.length() - i - 1)) {
				return false;
			}
		}
		
		return true;
	}
	
	public String longestPalindrome0(String s) {
		int maxLen = 0;
		HashMap<String, Integer> sMap = new HashMap<>();
		String returnString = "";
		for(int i = 0; i < s.length(); i++) {
			for(int j = i + 1; j <= s.length(); j++) {
				String tempString = s.substring(i, j);
				sMap.put(tempString, tempString.length());
			}
		}
		for(Map.Entry<String, Integer> entry : sMap.entrySet()) {
			if(isPalindromic(entry.getKey()) && entry.getValue() > maxLen) {
				returnString = entry.getKey();
				maxLen = entry.getKey().length();
			}
		}
        return returnString;
    }
	
	public static void main(String[] args) {
		String string = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
		LongestPalindrome longestPalindrome = new LongestPalindrome();
		System.out.println(longestPalindrome.longestPalindrome0(string));
	}
	
	// 马拉车算法 大神解法，来自https://leetcode.wang/leetCode-5-Longest-Palindromic-Substring.html#
	public String longestPalindrome2(String s) {
		String T = preProcess(s);
		int n = T.length();
		int[] P = new int[n];
		int C = 0, R = 0;
		for (int i = 1; i < n - 1; i++) {
			int i_mirror = 2 * C - i;
			if (R > i) {
				P[i] = Math.min(R - i, P[i_mirror]);// 防止超出 R
			} else {
				P[i] = 0;// 等于 R 的情况
			}

			// 碰到之前讲的三种情况时候，需要利用中心扩展法
			while (T.charAt(i + 1 + P[i]) == T.charAt(i - 1 - P[i])) {
				P[i]++;
			}

			// 判断是否需要更新 R
			if (i + P[i] > R) {
				C = i;
				R = i + P[i];
			}

		}

		// 找出 P 的最大值
		int maxLen = 0;
		int centerIndex = 0;
		for (int i = 1; i < n - 1; i++) {
			if (P[i] > maxLen) {
				maxLen = P[i];
				centerIndex = i;
			}
		}
		int start = (centerIndex - maxLen) / 2; // 最开始讲的求原字符串下标
		return s.substring(start, start + maxLen);
	}

	public String preProcess(String s) {
		int n = s.length();
		if (n == 0) {
			return "^$";
		}
		String ret = "^";
		for (int i = 0; i < n; i++)
			ret += "#" + s.charAt(i);
		ret += "#$";
		return ret;
	}
}
