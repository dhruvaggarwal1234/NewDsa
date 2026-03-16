public class SingleArrayTwice {
    //the solution i have use 

   // o(n)

    int single(int[] arr) {
        int xor = 0;

        for(int num : arr){
            xor ^= num;
        }

        return xor;
    }



    //the solution 0(logn)
    


}
