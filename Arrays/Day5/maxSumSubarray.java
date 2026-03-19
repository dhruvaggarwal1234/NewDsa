

/*
========================================
🧠 Maximum Subarray Sum (Kadane's Algorithm)
========================================

📌 Problem:
Find the maximum sum of a contiguous subarray.

----------------------------------------
🥉 1. Brute Force (3 Loops)
👉 Technique: Check all subarrays
⏱ Time: O(n^3)
----------------------------------------
*/

public class maxSumSubarray {

    // 🥉 Brute Force
    public static int bruteForce(int[] arr) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {

                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }

                max = Math.max(max, sum);
            }
        }

        return max;
    }

    /*
    ----------------------------------------
    🥈 Better Approach (2 Loops)
    👉 Technique: Carry Forward Sum
    ⏱ Time: O(n^2)
    ----------------------------------------
    */

    public static int better(int[] arr) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;

            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                max = Math.max(max, sum);
            }
        }

        return max;
    }

    /*
    ----------------------------------------
    🥇 Optimal Approach (Kadane’s Algorithm)
    👉 Technique: Greedy + Dynamic Programming
    ⏱ Time: O(n)
    ----------------------------------------
    */

    public static int kadane(int[] arr) {
        int sum = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            max = Math.max(max, sum);

            // reset if negative
            if (sum < 0) {
                sum = 0;
            }
        }

        return max;
    }

    /*
    ----------------------------------------
    🔥 Best Version (Interview Preferred)
    ----------------------------------------
    */

    public static int kadaneBest(int[] arr) {
        int sum = arr[0];
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            sum = Math.max(arr[i], sum + arr[i]);
            max = Math.max(max, sum);
        }

        return max;
    }

    /*
    ----------------------------------------
    🧪 Main Method (Testing)
    ----------------------------------------
    */

    public static void main(String[] args) {

        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println("Brute Force: " + bruteForce(arr));
        System.out.println("Better: " + better(arr));
        System.out.println("Kadane: " + kadane(arr));
        System.out.println("Kadane Best: " + kadaneBest(arr));
    }
}