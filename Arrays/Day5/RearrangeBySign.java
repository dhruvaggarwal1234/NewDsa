/*
========================================
🧠 Rearrange Array by Sign
========================================

📌 Problem:
Rearrange array so that positive and negative
numbers are placed alternately.

----------------------------------------
🥉 1. Brute Force
👉 Technique: Separate + Merge
⏱ Time: O(n)
⏱ Space: O(n)
----------------------------------------
*/

import java.util.*;

public class RearrangeBySign {

    // 🥉 Brute
    public static int[] brute(int[] arr) {

        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        // separate positives and negatives
        for (int num : arr) {
            if (num >= 0) pos.add(num);
            else neg.add(num);
        }

        int i = 0, p = 0, n = 0;

        // merge alternately
        while (p < pos.size() && n < neg.size()) {
            arr[i++] = pos.get(p++);
            arr[i++] = neg.get(n++);
        }

        return arr;
    }

    /*
    ----------------------------------------
    🥇 Optimal Approach
    👉 Technique: Index Placement
    ⏱ Time: O(n)
    ⏱ Space: O(n)
    ----------------------------------------

    💡 Idea:
    - Place positives at even index
    - Place negatives at odd index
    */

    public static int[] optimal(int[] arr) {

        int n = arr.length;
        int[] result = new int[n];

        int posIndex = 0; // even index
        int negIndex = 1; // odd index

        for (int num : arr) {
            if (num >= 0) {
                result[posIndex] = num;
                posIndex += 2;
            } else {
                result[negIndex] = num;
                negIndex += 2;
            }
        }

        return result;
    }

    /*
    ----------------------------------------
    🧪 Example:
    Input:  [3,1,-2,-5,2,-4]
    Output: [3,-2,1,-5,2,-4]
    ----------------------------------------
    */

    public static void main(String[] args) {

        int[] arr = {3, 1, -2, -5, 2, -4};

        System.out.println("Brute: " + Arrays.toString(brute(arr.clone())));
        System.out.println("Optimal: " + Arrays.toString(optimal(arr)));
    }
}