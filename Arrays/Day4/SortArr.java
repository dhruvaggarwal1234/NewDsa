//problem :- 0's , 1's , 2's sort the arr

public class SortArr {
    
    public static void main(String[] args) {
        int arr [] = {1,0,1,0,2,0,1,0,2,0,2};
        arr = sort(arr);

        for(int a :arr){
            System.out.print(a + ",");
        }

    }

    static int [] sort(int arr []){

       int low = 0 ;
       int mid = 0;
       int high = arr.length-1;

       while(mid<=high){
        if(arr[mid]==0){
            int temp = arr[low];
            arr[low]=arr[mid];
            arr[mid]=temp;
            low++;
            mid++;
        }

        else if(arr[mid]==2){
            int temp = arr[high];
            arr[high]= arr[mid];
            arr[mid] = temp;
            high--;
        }
        else{
            mid++;
        }



       }

        return arr;
    }
    
}
