package com.freshbin.leetcode.oldcode;

import java.math.BigDecimal;

/**
 * 给定32位有符号整数，整数的反向数字 
 * Example 1: 
 * Input: 123 
 * Output: 321 
 * 
 * Example 2: 
 * Input: -123
 * Output: -321 
 * 
 * Example 3: 
 * Input: 120 
 * Output: 21
 * 
 * @author freshbin
 * @date 2019年4月11日 下午5:02:48
 */
public class ReverseInteger {
	public static int my01(int x) {
		long start = System.nanoTime();
		System.out.println("入参为：" + x);
		if(-9 < x && x < 9) {
			System.out.println("返回值为：" + x + "===耗时:" + (System.nanoTime() - start));
			return x;
		}
		
		String tempX = String.valueOf(x);
		String[] arr = new String[32];
		int length = tempX.length();
		for (int i = 0; i < length; i++) {
			String element = tempX.substring(i, i+1);
			if(i == 0 && x < 0) {
				continue;
			}
			arr[i] = element;
		}

		StringBuffer sb = new StringBuffer();
		if(x < 0) {
			sb.append("-");
		}
		for (int j = length - 1; j >= 0; j--) {
			if(j == 0 && x < 0) {
				break;
			}
			
			if(j == length - 1 && "0".equals(arr[length - 1])) {
				continue;
			}
			
			sb.append(arr[j]);
		}
		
		Long returnNum = Long.valueOf(sb.toString());
		
		if(returnNum > Integer.MAX_VALUE || returnNum < Integer.MIN_VALUE){
			System.out.println("值过大：" + returnNum + "===耗时:" + (System.nanoTime() - start));
	        return 0;
	    }
		x = Integer.valueOf(sb.toString());
		System.out.println("返回值为：" + x + "===耗时:" + (System.nanoTime() - start));
		return x;
	}
	
	public static int my02(int x) {
		long start = System.nanoTime();
		System.out.println("入参为：" + x);
		long resultNum = 0;
		
		while(x != 0) {
			resultNum = resultNum * 10 + x % 10;
			x = x / 10;
		}
		
		if(resultNum > Integer.MAX_VALUE || resultNum < Integer.MIN_VALUE){
			System.out.println("值过大：" + resultNum + "===耗时:" + (System.nanoTime() - start));
	        return 0;
	    }
		
		x = Integer.valueOf(String.valueOf(resultNum));
		
		System.out.println("返回值为：" + x + "===耗时:" + (System.nanoTime() - start));
		return x;
	}
	
	public static int other01(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
	
	public static void main(String[] args) {
		int x = (int)(Math.random()*2147483647);
		int flag = (int)Math.round(Math.random());
		if(flag == 1) {
			x = -x;
		}
		my02(x);
	}
}
