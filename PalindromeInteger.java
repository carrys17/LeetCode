package com.example.shang;

public class PalindromeInteger {
	public static void main(String[] args) {

		System.out.println(isPalindrome(40404));
	}

	
	private static boolean isPalindrome(int x) {
		if(x<0){
			return false;
		}
	
		int len = 10;
		while(x/len!=0){
			len = len * 10;
		}
		len = len/10;// x的位数，404时为100
		while(x!=0){
			int left = x / len;
			int right = x % 10;
			if(left!=right){
				return false;
			}else{
				// 主要就是这里，去头去尾，少了两个位数
				x = (x % len) / 10;
	            len = len/100;  
			}
		}
		
		return true;
		
	}
}
