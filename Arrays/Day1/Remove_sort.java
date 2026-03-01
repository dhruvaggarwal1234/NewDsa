public class Remove_sort {
    
    public static void main(String[] args) {
        
        int [] arr = {1,2,3,4,5,5,6};
       
        int k = 1 ; 
        
        for(int i = 1 ; i < arr.length ; i++){

            if(arr[i] != arr[i-1]){
                arr[k]=arr[i];
                k++;
            }
           
        }
       
        for(int a =0; a<k;a++){
            System.out.print(arr[a] + "");
        }

    }

}
