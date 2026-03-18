
import java.util.HashMap;



public class LongestSubArrayk {

    public static void main(String[] args) {

        int arr[] = {1,2,3,4,5,6,7,1,1,1,-3,-7,-3,-4,-2,3,4,2,1,1,1,1,1,1,1};
        int k = 10;
        int ans = Longest(arr, k);
        System.out.println("Longest Subarray is Given one is : " + ans);
    }

    //optimal

    static int Longest(int arr[],int k){
        HashMap<Integer,Integer> map = new HashMap<>();

        int sum = 0 ;
        int maxLen = 0 ;

        for(int i = 0 ; i <arr.length ; i++){

            sum += arr[i];
           int target = sum -k;
            if(sum==k){
                maxLen = Math.max(maxLen, i+1);
            }

            if(map.containsKey(target)){
                maxLen = Math.max(maxLen,i-map.get(target));
            }

            if(!map.containsKey(sum)){
                map.put(sum,i);
            }

        }

        return maxLen;

    }
    
}
