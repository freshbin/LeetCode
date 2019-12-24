package com.freshbin.leetcode.from1to100.medium;

import java.math.BigDecimal;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 
 * 个人解题思路：
 * 循环两个链表，组装成表示的整数之后，把两个整数相加，再把这个整数一位一位的存入链表
 * 
 * @author freshbin
 * @date 2019年12月20日 下午4:33:57
 */
public class AddTwoNumbers {
	/**
	 * 提交的时候总发现答案不对
	 * 调来调去总算是搞定了，但是真粗糙
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode addTwoNumbers0(ListNode l1, ListNode l2) {
		String realNum1 = String.valueOf(l1.val);
		while (l1.next != null) {
			realNum1 = l1.next.val+ "" + realNum1;
			l1 = l1.next;
		}
		
		String realNum2 = String.valueOf(l2.val);
		while (l2.next != null) {
			realNum2 =  l2.next.val + "" + realNum2;
			l2 = l2.next;
		}
		
		BigDecimal targetNum = new BigDecimal(realNum1).add(new BigDecimal(realNum2));
		String tempString = String.valueOf(targetNum);
		int[] returnArr = new int[tempString.length()];
		int index = 0;
		for(int i = tempString.length() - 1; i >= 0; i--) {
			char tempC = tempString.charAt(i);
			returnArr[index] = Integer.valueOf(String.valueOf(tempC));
			index++;
		}
		
		ListNode returnListNode = new ListNode(returnArr[0]);
		ListNode tempListNode = returnListNode;
		for(int i = 1; i < returnArr.length; i++) {
			tempListNode.next = new ListNode(returnArr[i]);
			tempListNode = tempListNode.next;
		}
		
		return returnListNode;
    }
	
	public ListNode transToListNode(int[] sourceArr) {
		if(sourceArr.length == 0) {
			return new ListNode(0);
		}
		ListNode returnListNode = new ListNode(sourceArr[0]);
		ListNode tempListNode = returnListNode;
		for(int i = 1; i < sourceArr.length; i++) {
			tempListNode.next = new ListNode(sourceArr[i]);
			tempListNode = tempListNode.next;
		}
		return returnListNode;
	}
	
	public static void main(String[] args) {
		AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
		int[] arr1 = {};
		int[] arr2 = {0, 1};
		ListNode l10 = addTwoNumbers.transToListNode(arr1);
		ListNode l20 = addTwoNumbers.transToListNode(arr2);
		
//		ListNode returNode = addTwoNumbers.addTwoNumbers0(l10, l20);
		ListNode returNode = addTwoNumbers.addTwoNumbers2(l10, l20);
		System.out.println(returNode.val);
		while (returNode.next != null) {
			returNode = returNode.next;
			System.out.println(returNode.val);
		}
	}
	
	// 看完官方解法理解之后，算是背写的吧
	public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
		ListNode returNode = new ListNode(0);
		ListNode p = l1, q = l2, currNode = returNode;
		int carry = 0;
		while (p != null || q != null) {
			int x = p != null ? p.val : 0;
			int y = q != null ? q.val : 0;
			int sum = x + y + carry;
			carry = sum / 10;
			currNode.next = new ListNode(sum%10);
			currNode = currNode.next;
			
			if(p != null) {				
				p = p.next;
			}
			if(q != null) {
				q = q.next;
			}
		}
		
		if(carry > 0) {
			currNode.next = new ListNode(carry);
		}
		
		return returNode.next;
	}
	
	// 官方解法
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	    ListNode dummyHead = new ListNode(0);
	    ListNode p = l1, q = l2, curr = dummyHead;
	    int carry = 0;
	    while (p != null || q != null) {
	        int x = (p != null) ? p.val : 0;
	        int y = (q != null) ? q.val : 0;
	        int sum = carry + x + y; // 这里处理得真巧妙
	        carry = sum / 10;
	        curr.next = new ListNode(sum % 10);
	        curr = curr.next;
	        if (p != null) p = p.next;
	        if (q != null) q = q.next;
	    }
	    if (carry > 0) {
	        curr.next = new ListNode(carry);
	    }
	    return dummyHead.next;
	}
	
}
