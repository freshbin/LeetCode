package com.freshbin.leetcode.oldcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Determine whether an integer is a palindrome. An integer is a palindrome when
 * it reads the same backward as forward. Input: 121 Output: true Input: -121
 * Output: false
 * 
 * @author freshbin
 * @date 2019年4月24日 下午5:55:46
 */
public class PalindromeNumber {
	public static boolean myTry01(int x) {
		if (x < 0 || (x != 0 && x % 10 == 0)) {
			return false;
		}

		String targetString = new Integer(x).toString();
		char[] targetChar = targetString.toCharArray();

		StringBuffer reverseStringBuffer = new StringBuffer();
		for (int i = targetChar.length - 1; i >= 0; i--) {
			reverseStringBuffer.append(targetChar[i]);
		}

		if (String.valueOf(x).equals(reverseStringBuffer.toString())) {
			return true;
		}

		return false;
	}

	public static boolean myTry02(int x) {
		if(x < 0 || (x != 0 && x % 10 == 0)) {
			return false;
		}
		
		int reverseNum = 0;
		int target = x;
		
		while(x != 0) {
			reverseNum = reverseNum * 10 + x % 10;
			x = x / 10;
		}
		
		return reverseNum == target;
	}
	
	public boolean otherTry01(int x) {
		int palindromeX = 0;
		int inputX = x;
		while (x > 0) {
			palindromeX = palindromeX * 10 + (x % 10);
			x = x / 10;
		}
		return palindromeX == inputX;
	}

	public static void main(String[] args) {
		int x = 7447;
		System.out.println(myTry02(x));
	}
}