package com.example.shang;
/**
 * �������������Ǳ�ʾ����������Ǹ�����������������ĺ�֮��ͬ�����������Ϊһ������
 * ��Ҫע��һ�㣺�н�λ
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
	
	// ��ʽ1��ÿһλ���
	public static ListNode addTwoNumber(ListNode l1,ListNode l2) {
		if(l1==null || l2 == null) return null;
		ListNode temp = new ListNode(0);
		ListNode res = temp;
		
		int value1 = 0; // ��λֵ
		int value2 = 0; // ��ǰλ����ӵĽ��
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
		//����н�λ������ٲ���һλ
		if (value1 != 0) {
            temp.next = new ListNode(value1);
        }
        return res.next;
	}
	
	// ��ʽ2 �ݹ�ķ�ʽ��ʵ��
	public static ListNode addTwoNumber2(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        int value = l1.val + l2.val;
        ListNode result = new ListNode(value % 10);
        result.next = addTwoNumber2(l1.next, l2.next);
        if (value >= 10) { // ����н�λ����ȡ��λֵ����ǰֵ���
            result.next = addTwoNumber2(new ListNode(value / 10), result.next);
        }
        return result;
    }
	
	// ��ʽ3   �����̷�Ϊ����������ֽ���������ȳ��ȶ�Ӧ������֮�ͼ��������Ȼ������������һ��Ϊ���ˡ�
	// ��ʱ�������������������������l1��Ϊ�գ���l1�����ֵ�롰��λ�������ȡ����Ϊ��һ�����Ԫ�ص�ֵ��
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

