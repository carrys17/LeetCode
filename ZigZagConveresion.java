package com.example.shang;

/**The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

 P   A   H   N
 A P L S I I G
 Y   I   R
 And then read line by line: "PAHNAPLSIIGYIR"
 Write the code that will take a string and make this conversion given a number of rows:

 string convert(string text, int nRows);
 convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */

/**
 * ˼·��ת����ĵ�һ�к����һ�У����ǰ���2n-2��˳��һ���ӵġ� �����г��������Ǹ����ֹ��򣬾��ǻ�Ҫ����б�������ߵ��֣�
 * ���Է��������ߵ��ֵ�λ����Զ�ǵ�ǰ��j+(2n-2)-2i(i���е�index����
 * */
public class ZigZagConveresion {

	public static void main(String[] args) {
		String s = "PAYPALISHIRING";
		System.out.println(solution(s, 3));
	}

	private static String solution(String s, int nRows) {
		if (nRows <= 1)
			return s;
		String res = "";
		int size = 2 * nRows - 2;
		for (int i = 0; i < nRows; ++i) { // ��i��
			for (int j = i; j < s.length(); j += size) { // ÿһ�е�ֵ
				res += s.charAt(j);
				int tmp = j + size - 2 * i;
				if (i != 0 && i != nRows - 1 && tmp < s.length())
					res += s.charAt(tmp);
			}
		}
		return res;
	}

}
