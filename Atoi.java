package com.example.shang;

public class Atoi {
	
	public static void main(String[] args) {
		String s = "  -  4541s784";
		System.out.println(solution(s));
	}

	private static int solution(String s) {
		// 如果为null，直接返回
		if (s == null) {
			return 0;
		}
		s = s.trim();
		// 长度为0，直接返回
		if (s.length() == 0) {
			return 0;
		}
		// 先用double类型处理，用于后面的上下限比较
		double res = 0.0f;
		// 标识位，判断正负
		char flag = '+'; 
		int i = 0;
		char ch = '0';
		while(i < s.length()){
			ch = s.charAt(i);
			// 判断是否为正负符合
			if (ch == '-' || ch == '+') {
				// 如果符合不在首位，直接返回
				if (i!=0) {
					return 0;
				}
				// 如果为负，将标识位记录为'-'
				if (ch == '-') {
					flag = '-';
				}
			}else if(ch>='0'&& ch<='9'){
				res = res * 10 + (s.charAt(i)-'0');
			}else if(ch!=' '){ // 遇到除了数字和空格的，直接返回前面的结果
				break;
			}	
			i++;
		}
		if (flag=='-') {
			res = -1 * res;
		}
		if (res>Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		}
		if (res<Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}
		return (int)res;
	}

}
