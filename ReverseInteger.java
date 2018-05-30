package com.example.shang;

//The input is assumed to be a 32-bit signed integer. 
// Your function should return 0 when the reversed integer overflows.
public class ReverseInteger {
	
	
	public static void main(String[] args) {
		int i = -1234565655;
		long res = solution(i);
		System.out.println("转换后的结果 ： "+res);
	}

	private static long solution(int i) {
//		boolean flag = false;
//		if (i<0) {
//			flag = false;
//		}else{
//			flag = true;
//		}
//		
//		if (!flag) {
//			i = i * (-1);
//		}
		
		long res = 0;
		
		do{
			int j = i % 10;
			i = i / 10;
			res = res * 10 + j;
			
		}while(i!=0); // 改进，正负一起处理，不用再去管正负数了
		
		if (res >= Integer.MAX_VALUE || res <= Integer.MIN_VALUE) {
			res = 0;
		}
		
//		if (!flag) {
//			res = res * (-1);
//		}
		
		
		return res;
	}
}
