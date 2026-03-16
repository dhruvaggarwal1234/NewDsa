public class MoveOfZeroends {
    

    public static void main(String[] args) {
        
        int arr []  = {0,1,0,2,0,3,4,7,0};

        
        
        int k = 0 ; 

        for(int i = 0 ; i <arr.length;i++){
            
            if(arr[i]!=0){

                    int temp = arr[k];
                    arr[k++]=arr[i];
                    arr[i]=temp;
                    
            }

        }

        for(int a : arr){

            System.out.print(a+" ");
        }
    }

}
