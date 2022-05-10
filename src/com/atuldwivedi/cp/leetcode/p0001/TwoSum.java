package com.atuldwivedi.cp.leetcode.p0001;

import java.util.HashMap;

/**
 * @author Atul Dwivedi
 */
public class TwoSum {

    /**
     * @param nums
     * @param target
     * @return result
     * <p>
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> numIdxMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (numIdxMap.containsKey(target - nums[i])) {
                result[0] = numIdxMap.get(target - nums[i]);
                result[1] = i;
            } else {
                numIdxMap.put(nums[i], i);
            }
        }

        return result;
    }
}
