import java.util.ArrayList;

public class LongestPostiveSubarray {

    /*
    =========================================
    🔥 LONGEST SUBARRAY WITH SUM = K (POSITIVE)
    =========================================

    📌 Problem:
    Find the length of longest subarray whose sum = k

    ⚠️ Condition:
    Works ONLY when all elements are POSITIVE

    -----------------------------------------
    ❌ MY FIRST APPROACH (WRONG)
    -----------------------------------------

    Mistakes I made:

    1. ❌ Checking before adding element
       → sum < k checked before including nums[i]

    2. ❌ Using if-else chain
       → Only one condition runs
       → But we need: add + shrink + check

    3. ❌ Shrinking only once
       → Used: if(sum > k)
       → Should be: while(sum > k)

    4. ❌ Wrong max update
       → count++ instead of updating Max

    5. ❌ Unnecessary ArrayList
       → increases complexity (removal = O(n))

    -----------------------------------------
    🧠 WRONG CODE (for learning)
    -----------------------------------------
    */

    public static int subarraySum(int[] nums, int k) {

        ArrayList<Integer> res = new ArrayList<>();

        int Max = 0;
        int count = 0;
        int sum = 0;
        int j = 0;

        for(int i = 0 ; i < nums.length; i++){

            if(sum < k){
                res.add(nums[i]);
                sum += nums[i];
                count++;
            }

            else if(sum == k){
                if(Max < count){
                    count++;   // ❌ wrong (should update Max)
                }
            }

            else{
                res.remove(j++); // ❌ slow + wrong logic
                count--;
            }
        }

        return Max;
    }

    /*
    -----------------------------------------
    ✅ CORRECT APPROACH (SLIDING WINDOW)
    -----------------------------------------

    ✔️ Steps:
    1. Always ADD element first
    2. SHRINK window while sum > k
    3. CHECK if sum == k

    -----------------------------------------
    🧠 CORE PATTERN:
    -----------------------------------------
        Expand → Shrink → Check

    -----------------------------------------
    ⏱️ Complexity:
    -----------------------------------------
    Time  → O(n)
    Space → O(1)

    -----------------------------------------
    */

    public static int CorrectarraySum(int[] nums, int k) {

        int Max = 0;
        int count = 0;
        int sum = 0;
        int j = 0;

        for(int i = 0 ; i < nums.length; i++){

            // ✅ Step 1: Expand window
            sum += nums[i];
            count++;

            // ✅ Step 2: Shrink window
            while(sum > k){
                sum -= nums[j++];
                count--;
            }

            // ✅ Step 3: Check condition
            if(sum == k){
                if(count > Max){
                    Max = count;
                }
            }
        }

        return Max;
    }

    /*
    -----------------------------------------
    🎯 FINAL LEARNING
    -----------------------------------------

    ✔️ Sliding Window works ONLY for positive arrays

    ✔️ Always follow:
        1. Add
        2. Shrink (while)
        3. Check

    ✔️ Never use:
        if(sum > k) ❌
        → always use while(sum > k) ✅

    ✔️ Avoid unnecessary data structures

    -----------------------------------------
    */

    public static void main(String[] args) {

        int arr[] = {2,1,3,4,2,1,1,1,1,1};
        int k = 7;

        int ans = CorrectarraySum(arr, k);

        System.out.println("Fixed Output: " + ans);
    }
}