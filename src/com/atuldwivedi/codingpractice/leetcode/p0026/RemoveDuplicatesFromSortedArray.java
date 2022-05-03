package com.atuldwivedi.codingpractice.leetcode.p0026;

/**
 * @author Atul Dwivedi
 */
public class RemoveDuplicatesFromSortedArray {

    /**
     * Remove Duplicates from Sorted Array
     *
     * @param nums
     * @return uniqueElementCount
     * <p>
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * References:
     * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
     */
    public int removeDuplicates(int[] nums) {
        int n = nums.length;

        if (n < 2) {
            return n;
        }

        int currIndex = 0;
        int uniqueElementCount = 1;
        for (int i = 0; i < n; i++) {
            if (nums[currIndex] != nums[i]) {
                nums[currIndex + 1] = nums[i];
                currIndex++;
                uniqueElementCount++;
            }
        }

        return uniqueElementCount;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        RemoveDuplicatesFromSortedArray obj = new RemoveDuplicatesFromSortedArray();
        int k = obj.removeDuplicates(nums);
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
