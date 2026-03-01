public class check_sorted {

    
    public static void main(String[] args) {
        
        int [] arr = {1,2,3,4,4,3,5,6};

        boolean ans = true;


        for(int i = 1 ; i < arr.length ; i++){

            if(arr[i]<arr[i-1]){
                ans = false;
                break;
            }

        }

        System.out.print(ans);




    }
}
