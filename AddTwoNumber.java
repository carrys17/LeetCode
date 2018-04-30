package com.example.shang;
/**
 * 有两个链表，它们表示逆序的两个非负数。计算出两个数的和之后，同样逆序输出作为一个链表。
 * 需要注意一点：有进位
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) 
 * Output: 7 -> 0 -> 8
 */
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}


public class AddTwoNumber {
	public static void main(String[] args) {
		ListNode node11 = new ListNode(2);
		ListNode node12 = new ListNode(4);
		ListNode node13 = new ListNode(3);
		node12.next = node13;
		node11.next = node12;
		
		ListNode node21 = new ListNode(5);
		ListNode node22 = new ListNode(6);
		ListNode node23 = new ListNode(4);
		node22.next = node23;
		node21.next = node22;
		
		ListNode resListNode = addTwoNumber2(node11, node21);
		
		while(resListNode.next!=null){
			System.out.print(resListNode.val+"  ");
			resListNode = resListNode.next;
		}
		System.out.print(resListNode.val+"  ");
		
	}
	
	// 方式1，每一位相加
	public static ListNode addTwoNumber(ListNode l1,ListNode l2) {
		if(l1==null || l2 == null) return null;
		ListNode temp = new ListNode(0);
		ListNode res = temp;
		
		int value1 = 0; // 进位值
		int value2 = 0; // 当前位数相加的结果
		while (l1!=null && l2!=null){
			value2 = (l1.val +l2.val+value1)%10;
			value1 = (l1.val +l2.val+value1)/10;
			
			temp.next = new ListNode(value2);
			l1 = l1.next;
			l2 = l2.next;
			temp = temp.next;
			if (l1 == null && l2 == null) {
                break;
            }
            if (l1 == null) {
                l1 = new ListNode(0);
            }
            if (l2 == null) {
                l2 = new ListNode(0);
            }
		} 
		//如果有进位，最后再补上一位
		if (value1 != 0) {
            temp.next = new ListNode(value1);
        }
        return res.next;
	}
	
	// 方式2 递归的方式来实现
	public static ListNode addTwoNumber2(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        int value = l1.val + l2.val;
        ListNode result = new ListNode(value % 10);
        result.next = addTwoNumber2(l1.next, l2.next);
        if (value >= 10) { // 如果有进位，就取进位值跟当前值相加
            result.next = addTwoNumber2(new ListNode(value / 10), result.next);
        }
        return result;
    }
	
	// 方式3   将过程分为三种情况。现将两个链表等长度对应的数字之和计算出来，然后两个链表有一个为空了。
	// 此时分两种情况（类似情况）。如果l1不为空，则将l1链表的值与“进位”相加再取余做为下一个结果元素的值。
	public static ListNode addTwoNumber3(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        ListNode head = new ListNode(0);
        ListNode point = head;
        int carry = 0;
        while (l1 != null && l2 != null) {
            int sum = carry + l1.val + l2.val;
            point.next = new ListNode(sum % 10);
            carry = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
            point = point.next;
        }

        while (l1 != null) {
            int sum = carry + l1.val;
            point.next = new ListNode(sum % 10);
            carry = sum / 10;
            l1 = l1.next;
            point = point.next;
        }

        while (l2 != null) {
            int sum = carry + l2.val;
            point.next = new ListNode(sum % 10);
            carry = sum / 10;
            l2 = l2.next;
            point = point.next;
        }

        if (carry != 0) {
            point.next = new ListNode(carry);
        }
        return head.next;
    }
}	

