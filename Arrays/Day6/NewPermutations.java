public class NewPermutations {

    /*
    ================== NEXT PERMUTATION ==================

    👉 Pattern: Dip → Swap → Reverse

    STEPS:
    1. Find breakpoint (nums[i] < nums[i+1] from right)
    2. If found → swap with next greater element
    3. Reverse right part
    4. If not found → reverse whole array

    Time: O(n)
    Space: O(1)
    */

    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;

        // Step 1: Find breakpoint
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // Step 2: Swap if breakpoint exists
        if (i >= 0) {
            int j = n - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }

        // Step 3: Reverse right side
        reverse(nums, i + 1, n - 1);
    }

    // Swap helper
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Reverse helper
    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    // MAIN METHOD (for testing in VS Code)
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 4, 2};

        nextPermutation(arr);

        // Print result
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}