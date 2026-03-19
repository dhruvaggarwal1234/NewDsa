/*
========================================
🧠 Maximum Subarray Sum + Print Subarray
========================================

📌 Problem:
Find the maximum sum of a contiguous subarray
AND print that subarray.

----------------------------------------
🥇 Optimal Approach (Kadane + Index Tracking)
👉 Technique: Greedy + Dynamic Programming
⏱ Time: O(n)
⏱ Space: O(1)
----------------------------------------

💡 Idea:
1. Use Kadane’s Algorithm to calculate max sum
2. Track indices to print subarray

----------------------------------------
🔑 Key Variables:

sum        → current subarray sum
max        → maximum sum found
tempStart  → potential start of subarray
start      → final start index
end        → final end index

----------------------------------------
⚡ Logic:

- Add element to sum
- If sum > max → update max, start, end
- If sum < 0 → reset sum and shift tempStart

----------------------------------------
*/

public class printmaxSubarray {

    public static void kadanePrint(int[] arr) {

        int sum = 0;
        int max = Integer.MIN_VALUE;

        int start = 0;
        int end = 0;
        int tempStart = 0;

        for (int i = 0; i < arr.length; i++) {

            sum += arr[i];

            // update max and indices
            if (sum > max) {
                max = sum;
                start = tempStart;
                end = i;
            }

            // reset when sum becomes negative
            if (sum < 0) {
                sum = 0;
                tempStart = i + 1;
            }
        }

        // 📌 Output
        System.out.println("Maximum Sum: " + max);

        System.out.print("Subarray: ");
        for (int i = start; i <= end; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    /*
    ----------------------------------------
    🧪 Example:
    arr = {-2,1,-3,4,-1,2,1,-5,4}

    Output:
    Maximum Sum: 6
    Subarray: 4 -1 2 1
    ----------------------------------------
    */

    public static void main(String[] args) {

        int[] arr = {-2, 1, -3, 4, -1, 2, 1,3,3,4 -5, 4};

        kadanePrint(arr);
    }
}