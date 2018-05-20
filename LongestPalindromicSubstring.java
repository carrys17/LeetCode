package com.example.shang;

/**
 * 最长回文子串 Given a string s, find the longest palindromic substring in s. You may
 * assume that the maximum length of s is 1000.
 */


public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		String s = "abcchbhccbessa";
		System.out.println(solution(s));
	}

	// 这种是中心扩展法 ，时间复杂度为O(n^2)
	private static String solution(String s) {
		int len = s.length();
		int max = 0;
		int start = 0;
		// 这种是aba的情况，以i为中心向两边扩展
		for (int i = 0; i < len; i++) {
			int j = i - 1;
			int k = i + 1;
			while (j > 0 && k < len && s.charAt(j) == s.charAt(k)) {
				if (k - j + 1 > max) {
					max = k - j + 1;
					start = j;
				}
				j--;
				k++;
			}
		}

		// 这种是abba的情况，以i，i+1为中心向两边扩展
		for (int i = 0; i < len; i++) {
			int j = i;
			int k = i + 1;
			while (j > 0 && k < len && s.charAt(j) == s.charAt(k)) {
				if (k - j + 1 > max) {
					max = k - j + 1;
					start = j;
				}
				j--;
				k++;
			}
		}

		if (max > 0) {
			return s.substring(start, start + max);
		}

		return null;
	}

}
