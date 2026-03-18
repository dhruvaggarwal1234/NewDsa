// # 🧠 Majority Element (n/2) — Complete Notes

// ---

// ## 🔹 Problem

// Find the element that appears **more than n/2 times** in the array.

// ---

// # ✅ Approach 1: HashMap (Brute Optimal)

// ## 🔸 Idea

// * Count frequency of each element
// * Return element with frequency > n/2

// ---

// ## 🔸 Code

// ```java
// HashMap<Integer, Integer> map = new HashMap<>();

// for(int i = 0; i < arr.length; i++){
//     map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
// }

// for(Map.Entry<Integer,Integer> entry : map.entrySet()){
//     if(entry.getValue() > arr.length/2){
//         return entry.getKey();
//     }
// }
// return -1;
// ```

// ---

// ## 🔸 Complexity

// * Time: O(n)
// * Space: O(n)

// ---

// ## 🔸 Key Concept

// element → frequency

// ---

// # 🏆 Approach 2: Boyer-Moore Voting Algorithm (Optimal)

// ---

// ## 🔸 Idea

// * Same element → count++
// * Different element → count--
// * Majority element survives

// ---

// ## 🔸 Code

// ```java
// static int Boyer_Voting(int arr[]){
//     int count = 0;
//     int candidate = 0;

//     // Step 1: Find candidate
//     for(int num : arr){
//         if(count == 0){
//             candidate = num;
//             count = 1;
//         }
//         else if(candidate == num){
//             count++;
//         } 
//         else{
//             count--;
//         }
//     }

//     // Step 2: Verify candidate
//     count = 0;
//     for(int num : arr){
//         if(candidate == num) count++;
//     }

//     return (count > arr.length/2) ? candidate : -1;
// }
// ```

// ---

// ## 🔸 Complexity

// * Time: O(n)
// * Space: O(1) ✅

// ---

// # 🔥 Using Both Together (Best Practice)

// ```java

import java.util.*;
public class MajorityElement {

    public static void main(String[] args) {

        int arr[] = {1,2,1,2,3,1,1,1,2,3,1};

        // HashMap Approach
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() > arr.length/2){
                System.out.println("HashMap Majority: " + entry.getKey());
            }
        }

        // Boyer-Moore Approach
        System.out.println("Boyer-Moore Majority: " + Boyer_Voting(arr));
    }

    static int Boyer_Voting(int arr[]){
        int count = 0;
        int candidate = 0;

        for(int num : arr){
            if(count == 0){
                candidate = num;
                count = 1;
            }
            else if(candidate == num){
                count++;
            } 
            else{
                count--;
            }
        }

        count = 0;
        for(int num : arr){
            if(candidate == num) count++;
        }

        return (count > arr.length/2) ? candidate : -1;
    }
}
// ```

// ---

// # ⚠️ Common Mistakes

// ❌ Using index as key
// ❌ Modifying array (`arr[i]++`)
// ❌ Not verifying Boyer-Moore result
// ❌ Not calling function

// ---

// # 🧠 Interview Tips

// 👉 Start with HashMap
// 👉 Then optimize to Boyer-Moore

// Say:
// "I can reduce space complexity to O(1) using Boyer-Moore Voting Algorithm."

// ---

// # 🚀 Final Summary

// * HashMap → Easy, O(n) space
// * Boyer-Moore → Optimal, O(1) space
// * Always verify candidate in Boyer-Moore

// ---
