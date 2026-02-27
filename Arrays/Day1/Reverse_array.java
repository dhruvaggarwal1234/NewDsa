
 public class Reverse_array {
   
   public static void main (String [] args){

    int [] arr = {1,2,3,4,5};
    
    int x = 0;
    int y = arr.length-1;

    while (x<y){

      int swap = arr[x];
       arr[x] = arr[y];
      arr[y] = swap;  
      x++;
      y--;

    }

    for(int a : arr){
      System.err.print(a + " ");
    }


   }

}