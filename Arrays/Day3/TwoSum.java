import java.util.*;

public class TwoSum {

    /*
    =========================================
    🔥 TWO SUM (Important Pattern)
    =========================================

    📌 Problem:
    Given an array and a target,
    check if any two numbers sum to target.

    -----------------------------------------
    🧠 APPROACH 1: BRUTE FORCE
    -----------------------------------------
    - Check all pairs
    - Time: O(n²)
    - Not optimal ❌

    -----------------------------------------
    🧠 APPROACH 2: HASHING (OPTIMAL)
    -----------------------------------------
    - Use HashSet (for boolean)
    - Use HashMap (for indices)

    -----------------------------------------
    💡 CORE IDEA:
    -----------------------------------------
    For every element:
        complement = target - current element

    Check:
        if complement already exists?

    -----------------------------------------
    ⚡ WHY IT WORKS:
    -----------------------------------------
    If:
        a + b = target
    Then:
        b = target - a

    -----------------------------------------
    ⏱️ COMPLEXITY:
    -----------------------------------------
    Time  → O(n)
    Space → O(n)

    -----------------------------------------
    🟢 WHEN TO USE:
    -----------------------------------------
    - Pair problems
    - Sum problems
    - "Find two numbers" type questions

    =========================================
    */

    // ✅ BOOLEAN VERSION (Using HashSet)
    public static boolean twoSum(int[] arr, int target){

        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < arr.length; i++){

            int complement = target - arr[i];

            if(set.contains(complement)){
                return true;
            }

            set.add(arr[i]);
        }

        return false;
    }

    // ✅ INDEX VERSION (Using HashMap)
    public static int[] twoSumIndex(int[] arr, int target){

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++){

            int complement = target - arr[i];

            if(map.containsKey(complement)){
                return new int[]{map.get(complement), i};
            }

            map.put(arr[i], i);
        }

        return new int[]{};
    }

    // 🔽 MAIN METHOD (TESTING)
    public static void main(String[] args) {

        int[] arr = {2, 7, 11, 15};
        int target = 9;

        System.out.println(twoSum(arr, target)); // true

        System.out.println(Arrays.toString(twoSumIndex(arr, target))); // [0,1]
    }
}