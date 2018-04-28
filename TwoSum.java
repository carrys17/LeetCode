package com.example.shang;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**������֮��
 * ����һ�����������һ��Ŀ��ֵ���ҳ������к�ΪĿ��ֵ����������
 * ����Լ���ÿ������ֻ��Ӧһ�ִ𰸣���ͬ����Ԫ�ز��ܱ��ظ����á�
 * 
 * ���ӣ�
 * 	���� nums = [2, 7, 11, 15], target = 9
 *	��Ϊ nums[0] + nums[1] = 2 + 7 = 9
 *	���Է��� [0, 1]
 * 
 * ˼·����ͨ�ľ��Ǳ����������飬��һ�β���nums[i],�ڶ��β���target-nums[i]��
 * ������ʱ�临�Ӷ�ΪO(n*n)
 * 
 * �Ľ�����map�����ԣ��������value���±� ��Ϊkey-value������һ��map��
 * ��ȥ���������־��ǿռ任ʱ�䣬ʱ�临�Ӷ�ΪO(n)
 */
public class TwoSum {

	public static void main(String[] args) {
		int []nums = {4,5,6,3,2,451,56,78,45};
		int target = 12;
		int []res = findTwoSum(nums,target);
		System.out.println("���������±��ǣ�"+Arrays.toString(res));
	}

	private static int[] findTwoSum(int[] nums, int target) {
		int []res = {-1,-1};
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			// �������value���±���Ϊkey-value������map��
			map.put(nums[i], i);
		}
		
		for (int i = 0; i < nums.length; i++) {
			int sec = target - nums[i];
			// �ж�sec�Ƿ���map�У�ͬʱ�ж������Ƿ���ͬһ��������Ϊ�����õ���&&��
			// ����map.get(sec)���ÿ���nullֵ������
			if(map.containsKey(sec) && map.get(sec)!=i){
				res[0] = i;
				res[1] = map.get(sec);
			}
		}
		return res;
	}
}
