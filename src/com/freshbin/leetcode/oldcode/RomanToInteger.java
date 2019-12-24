package com.freshbin.leetcode.oldcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, two is written as II in Roman numeral, just two one's added together. 
 * Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
 * Roman numerals are usually written largest to smallest from left to right. 
 * However, the numeral for four is not IIII. Instead, the number four is written as IV. 
 * Because the one is before the five we subtract it making four. 
 * The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 * I can be placed before V (5) and X (10) to make 4 and 9. 
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
 * 
 * @author freshbin
 * @date 2019年4月28日 上午11:26:24
 */
public class RomanToInteger {
	/**
	 * 写不下去了。。。。。
	 * 
	 * @param s
	 * @return
	 */
	public static int myTry01(String s) {
		if (s == null || s.length() <= 0) {
			return -1;
		}

		if (!(s.contains("I") || s.contains("V") || s.contains("X") || s.contains("L") || s.contains("C")
				|| s.contains("D") || s.contains("M"))) {
			return -1;
		}

		char[] sChar = s.toCharArray();
		int size = s.length();

		Integer targetNum = 0;
		String verifyS = s;
		// 判断字符串顺序是否合法
		for (int i = 0; i < size; i++) {
			if ("I".equals(String.valueOf(sChar[i]))) {
				verifyS = verifyS.substring(i + 1, size);
				if (verifyS.contains("X") || verifyS.contains("L") || verifyS.contains("C") || verifyS.contains("D")
						|| verifyS.contains("M")) {
					throw new IllegalAccessError();
				}

				if (i != size - 1) {
					if ("V".equals(String.valueOf(sChar[i + 1]))) {
						targetNum += 4;
					} else {

					}
				}
			}
		}

		List<String> onlyBeforeList = new ArrayList<String>();
		onlyBeforeList.add("I");// 1
		onlyBeforeList.add("X");// 10
		onlyBeforeList.add("C");// 100

		return 0;
	}

	public static int myTry02(String s) {
		if (s == null || s.length() <= 0) {
			System.out.println("参数为空");
			return -1;
		}
		int length = s.length();

		String pattern = "[I, V, X, L, C, D, M]+";
		boolean isMatch = Pattern.matches(pattern, s);
		if (!isMatch) {
			System.out.println("参数含有非法字符");
			return -1;
		}

		//想用正则判断是否有重复四个数字，发现不会写
		for (int j = length - 1; j >= 0; j--) {
			if(j > 2 && String.valueOf(s.charAt(j)).equals(String.valueOf(s.charAt(j - 1)))
					&& String.valueOf(s.charAt(j)).equals(String.valueOf(s.charAt(j - 2)))
							&& String.valueOf(s.charAt(j)).equals(String.valueOf(s.charAt(j - 3)))) {
				System.out.println("参数有连续四个重复的字符");
				return -1;
			}
		}
		
		Map<Character, Integer> romanValueMap = new HashMap<>(7);
		romanValueMap.put('I', 1);
		romanValueMap.put('V', 5);
		romanValueMap.put('X', 10);
		romanValueMap.put('L', 50);
		romanValueMap.put('C', 100);
		romanValueMap.put('D', 500);
		romanValueMap.put('M', 1000);

		int result = romanValueMap.get(s.charAt(length - 1));
		for (int i = length - 2; i >= 0; i--) {
			if (romanValueMap.get(s.charAt(i)) >= romanValueMap.get(s.charAt(i + 1))) {
				result += romanValueMap.get(s.charAt(i));
			} else {
				if (i > 1 && romanValueMap.get(s.charAt(i)) <= romanValueMap.get(s.charAt(i + 1))
						&& romanValueMap.get(s.charAt(i)) >= romanValueMap.get(s.charAt(i - 1))) {
					System.out.println("参数字符排列顺序违法");
					return -1;
				}
				
				result -= romanValueMap.get(s.charAt(i));
			}
		}

		if (result > 3999) {
			System.out.println("参数值过大");
			return -1;
		}
		
		return result;
	}

	public static void main(String[] args) {
		System.out.println(myTry02("MMMDDD"));
	}
}
	
