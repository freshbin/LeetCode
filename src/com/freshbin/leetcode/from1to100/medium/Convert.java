package com.freshbin.leetcode.from1to100.medium;

import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.bcel.internal.generic.LLOAD;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * 请你实现这个将字符串进行指定行数变换的函数：
 * string convert(string s, int numRows);
 * 示例 1:
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 
 * 示例 2:
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 
 * @author freshbin
 * @date 2019年12月28日 上午9:15:55
 */
public class Convert {
	public String convert(String s, int numRows) {
		if(numRows == 1) {
			return s;
		}
		String[][] tempArr = new String[numRows][s.length()];
		int count = 0;
		int j = 0;
		int i = 0;
		boolean downToUp = false;
		while (count < s.length()) {
			tempArr[i][j] = String.valueOf(s.charAt(count));
			count++;
			if(i == numRows-1) {
				downToUp = true;
			}
			if(i == 0) {
				downToUp = false;
			}
			if(downToUp) {
				j++;
				i--;
			} else {
				i++;
			}
		}
		
		StringBuffer sb = new StringBuffer();
		for(int y = 0; y < numRows; y++) {
			for(int x = 0; x < s.length(); x++) {
				if(tempArr[y][x] != null) {
					sb.append(tempArr[y][x]);
				}
			}
		}
		
        return sb.toString();
    }
	
	public static void main(String[] args) {
		String s = "ABC";
		int row = 2;
		Convert convert = new Convert();
		System.out.println(convert.convert(s, row));
	}
	
	// 官方解法
    public String convert0(String s, int numRows) {

        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }

    public String convert1(String s, int numRows) {

        if (numRows == 1) return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }
}
