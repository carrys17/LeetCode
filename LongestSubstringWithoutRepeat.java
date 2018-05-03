package com.example.shang;

import java.util.HashMap;

public class LongestSubstringWithoutRepeat {

	public static void main(String[] args) {

		String s = "aabcfdefcde";
		int res = solution(s);
		System.out.println("���Ϊ: "+res);
		
	}

	private static int solution(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int start = 0;
		int maxLen = 0;
		int len = 0;
		
		for (int i = 0; i < s.length(); i++) {
			// ���û�а������ַ�����ӽ�map
			if (!map.containsKey(s.charAt(i))) {
				len++;
				if (len>maxLen) {
					maxLen = len;
				}
				map.put(s.charAt(i), i);
			}else {
				
				// �õ��ַ���һ�ε�λ��
				int index = map.get(s.charAt(i));
				for (int j = start; j <= index; j++) {
					// ������ַ�ǰ���������ַ���������key-value
					map.remove(s.charAt(j));
				}
				// �Ѹ��ַ��ڶ��γ��ֵ�λ�ü���
				map.put(s.charAt(i), i);
				// ��ʼ��λ��Ϊ���ַ���һ�ε�λ�ü�1
				start = index +1;
				// ���³���
				len = i-index;
			}
			
		}
		
		return maxLen;
	}

}
