import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) return result;

        // Step 1: Sort the array to easily handle duplicates and use two pointers
        Arrays.sort(nums);
        int n = nums.length;

        // First pointer (a)
        for (int i = 0; i < n - 3; i++) {
            // Skip duplicate values for the first element
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // Optional Early Pruning Optimization
            long minPossibleSum = (long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];
            if (minPossibleSum > target) break; // Smallest sum exceeds target; no further solutions possible

            long maxPossibleSum = (long) nums[i] + nums[n - 1] + nums[n - 2] + nums[n - 3];
            if (maxPossibleSum < target) continue; // Largest sum is too small for current i

            // Second pointer (b)
            for (int j = i + 1; j < n - 2; j++) {
                // Skip duplicate values for the second element
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                // Two pointers for the remaining two elements (c and d)
                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    long currentSum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (currentSum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        // Skip duplicate values for left and right pointers
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;

                        left++;
                        right--;
                    } else if (currentSum < target) {
                        left++; // Increase sum by moving left pointer rightward
                    } else {
                        right--; // Decrease sum by moving right pointer leftward
                    }
                }
            }
        }

        return result;
    }
}