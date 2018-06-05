package com.example.shang;

public class Atoi {
	
	public static void main(String[] args) {
		String s = "  -  4541s784";
		System.out.println(solution(s));
	}

	private static int solution(String s) {
		// ���Ϊnull��ֱ�ӷ���
		if (s == null) {
			return 0;
		}
		s = s.trim();
		// ����Ϊ0��ֱ�ӷ���
		if (s.length() == 0) {
			return 0;
		}
		// ����double���ʹ������ں���������ޱȽ�
		double res = 0.0f;
		// ��ʶλ���ж�����
		char flag = '+'; 
		int i = 0;
		char ch = '0';
		while(i < s.length()){
			ch = s.charAt(i);
			// �ж��Ƿ�Ϊ��������
			if (ch == '-' || ch == '+') {
				// ������ϲ�����λ��ֱ�ӷ���
				if (i!=0) {
					return 0;
				}
				// ���Ϊ��������ʶλ��¼Ϊ'-'
				if (ch == '-') {
					flag = '-';
				}
			}else if(ch>='0'&& ch<='9'){
				res = res * 10 + (s.charAt(i)-'0');
			}else if(ch!=' '){ // �����������ֺͿո�ģ�ֱ�ӷ���ǰ��Ľ��
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
