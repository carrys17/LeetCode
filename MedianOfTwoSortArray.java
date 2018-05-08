package com.example.shang;

/**https://www.cnblogs.com/summerkiki/p/5781757.html
 * https://www.cnblogs.com/voidsky/p/5373982.html
 * 问题：两个排序数组，找这两个排序数组的中位数，时间复杂度为O(log(m+n)) 
 * 先看第一个链接，知道这种思维方式，再看第二个链接，知道加多这个“#”，使得数组都为奇数
 * 该问题实际可以转换为就top k的问题（k<n+m）
 * 
 * 如何判断：就是比较L1,L2和R1,R2。
 * L1>R2，把C1减小，C2增大。—> C1向左二分
 * L2>R1，把C1增大，C2减小。—> C1向右二分
 * 
 * 
 * 越界问题：
 * 如果C1或C2已经到头了怎么办？
 * 这种情况出现在：如果有个数组完全小于或大于中值。可能有4种情况：
 * C1 = 0 —— 数组1整体都比中值大，L1 >R2，中值在2中
 * C2 = 0 —— 数组1整体都比中值小，L1 <R2，中值在1中
 * C1 = n*2 —— 数组1整体都比中值小，L1 <R2，中位数在2中
 * C2 = m*2 —— 数组1整体都比中值大，L1 >R2，中位数在1中
 * 考虑下面两种情况了，解决方案：
 * 如果C1 = 0 —> 那么我们缩小L1，L1 = INT_MIN，保证判断正确。
 * 如果C1 = n*2 —> 那么我们增大R1，R1 = INT_MAX，保证判断正确。
 */
public class MedianOfTwoSortArray {

	public static void main(String[] args) {
		int []nums1 = {1,2,3,4,7,8,9};
		int []nums2 = {2,3,4,5,9,10};
		
		double res = findMedian(nums1,nums2);
		System.out.println("Median为 ："+res);
	}

	private static double findMedian(int[] nums1, int[] nums2) {
		int len1 = nums1.length;
		int len2 = nums2.length;
		// 使得数组1肯定是短的那个
		if(len1 > len2){
			return findMedian(nums2, nums1);
		}
		// 两个数组离划分位置最近的左右值和中值
		int l1 = 0 ,l2 = 0,r1 = 0,r2 =0,c1 = 0,c2 = 0;
		int low = 0;
		int hight = 2 * len1;//我们目前是虚拟加了'#'所以数组1的长度为2*len1+1
		while(low <= hight){
			c1 = (low + hight)/2;
			c2 = len1 + len2 - c1;
			
			// 越界情况
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
