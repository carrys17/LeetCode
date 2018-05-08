package com.example.shang;

/**https://www.cnblogs.com/summerkiki/p/5781757.html
 * https://www.cnblogs.com/voidsky/p/5373982.html
 * ���⣺�����������飬�������������������λ����ʱ�临�Ӷ�ΪO(log(m+n)) 
 * �ȿ���һ�����ӣ�֪������˼ά��ʽ���ٿ��ڶ������ӣ�֪���Ӷ������#����ʹ�����鶼Ϊ����
 * ������ʵ�ʿ���ת��Ϊ��top k�����⣨k<n+m��
 * 
 * ����жϣ����ǱȽ�L1,L2��R1,R2��
 * L1>R2����C1��С��C2���󡣡�> C1�������
 * L2>R1����C1����C2��С����> C1���Ҷ���
 * 
 * 
 * Խ�����⣺
 * ���C1��C2�Ѿ���ͷ����ô�죿
 * ������������ڣ�����и�������ȫС�ڻ������ֵ��������4�������
 * C1 = 0 ���� ����1���嶼����ֵ��L1 >R2����ֵ��2��
 * C2 = 0 ���� ����1���嶼����ֵС��L1 <R2����ֵ��1��
 * C1 = n*2 ���� ����1���嶼����ֵС��L1 <R2����λ����2��
 * C2 = m*2 ���� ����1���嶼����ֵ��L1 >R2����λ����1��
 * ����������������ˣ����������
 * ���C1 = 0 ��> ��ô������СL1��L1 = INT_MIN����֤�ж���ȷ��
 * ���C1 = n*2 ��> ��ô��������R1��R1 = INT_MAX����֤�ж���ȷ��
 */
public class MedianOfTwoSortArray {

	public static void main(String[] args) {
		int []nums1 = {1,2,3,4,7,8,9};
		int []nums2 = {2,3,4,5,9,10};
		
		double res = findMedian(nums1,nums2);
		System.out.println("MedianΪ ��"+res);
	}

	private static double findMedian(int[] nums1, int[] nums2) {
		int len1 = nums1.length;
		int len2 = nums2.length;
		// ʹ������1�϶��Ƕ̵��Ǹ�
		if(len1 > len2){
			return findMedian(nums2, nums1);
		}
		// ���������뻮��λ�����������ֵ����ֵ
		int l1 = 0 ,l2 = 0,r1 = 0,r2 =0,c1 = 0,c2 = 0;
		int low = 0;
		int hight = 2 * len1;//����Ŀǰ���������'#'��������1�ĳ���Ϊ2*len1+1
		while(low <= hight){
			c1 = (low + hight)/2;
			c2 = len1 + len2 - c1;
			
			// Խ�����
			l1 = (c1==0) ? Integer.MIN_VALUE : nums1[(c1-1)/2];
			r1 = (c1==2*len1) ? Integer.MAX_VALUE : nums1[c1/2];
			l2 = (c2==0) ? Integer.MIN_VALUE : nums2[(c2-1)/2];
			r2 = (c2==2*len2) ? Integer.MAX_VALUE : nums2[c2/2];
			
			if(l1>r2){
				hight = c1 - 1;
			}
			if (l2>r1) {
				hight = c1 + 1;
			}
			else {
				break;
			}
			
		}
		return ( Math.max(l1, l2) + Math.min(r1, r2) )/2.0;
	}

}
