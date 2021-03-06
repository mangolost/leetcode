package mangolost;

//You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
//
//        The Next Greater Number of a checkNumber x in nums1 is the first greater checkNumber to its right in nums2. If it does not exist, output -1 for this checkNumber.
//
//        Example 1:
//        Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
//        Output: [-1,3,-1]
//        Explanation:
//        For checkNumber 4 in the first array, you cannot find the next greater checkNumber for it in the second array, so output -1.
//        For checkNumber 1 in the first array, the next greater checkNumber for it in the second array is 3.
//        For checkNumber 2 in the first array, there is no next greater checkNumber for it in the second array, so output -1.
//        Example 2:
//        Input: nums1 = [2,4], nums2 = [1,2,3,4].
//        Output: [3,-1]
//        Explanation:
//        For checkNumber 2 in the first array, the next greater checkNumber for it in the second array is 3.
//        For checkNumber 4 in the first array, there is no next greater checkNumber for it in the second array, so output -1.
//        Note:
//        All elements in nums1 and nums2 are unique.
//        The length of both nums1 and nums2 would not exceed 1000.

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *
 */
public class Solution0496 {

	/**
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		int len1 = nums1.length;
		Stack<Integer> stack = new Stack<>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums2) {
			while (!stack.isEmpty() && stack.peek() < num) {
				map.put(stack.pop(), num);
			}
			stack.push(num);
		}
		int[] num = new int[len1];
		for (int i = 0; i < len1; i++) {
			num[i] = map.getOrDefault(nums1[i], -1);
		}
		return num;
	}

	public static void main(String[] args) {
		Solution0496 solution = new Solution0496();
		int[] nums1 = {1, 9, 8, 7, 0, 7, 1, 5}, nums2 = {1, 9, 9, 3, 0, 7, 1, 6};
		int[] result = solution.nextGreaterElement(nums1, nums2);
		System.out.println(Arrays.toString(result));
	}
}