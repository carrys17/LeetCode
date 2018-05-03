package com.example.shang;

import java.util.HashMap;

public class LongestSubstringWithoutRepeat {

	public static void main(String[] args) {

		String s = "aabcfdefcde";
		int res = solution(s);
		System.out.println("结果为: "+res);
		
	}

	private static int solution(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int start = 0;
		int maxLen = 0;
		int len = 0;
		
		for (int i = 0; i < s.length(); i++) {
			// 如果没有包含该字符，添加进map
			if (!map.containsKey(s.charAt(i))) {
				len++;
				if (len>maxLen) {
					maxLen = len;
				}
				map.put(s.charAt(i), i);
			}else {
				
				// 得到字符第一次的位置
				int index = map.get(s.charAt(i));
				for (int j = start; j <= index; j++) {
					// 清除该字符前（包含该字符）的所有key-value
					map.remove(s.charAt(j));
				}
				// 把该字符第二次出现的位置加入
				map.put(s.charAt(i), i);
				// 起始的位置为该字符第一次的位置加1
				start = index +1;
				// 更新长度
				len = i-index;
			}
			
		}
		
		return maxLen;
	}

}
