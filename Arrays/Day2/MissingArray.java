public class MissingArray {
    
    public static void main(String[] args) {

        int arr1[] = {1,2,3,4,9,7,5,6};

        MissingArray b = new MissingArray();

        int a = b.missingNum(arr1);

        System.out.println(a);
    
    
    }
    
    int missingNum(int arr[]) {

        int n = arr.length + 1;

        int xor = 0;

        for(int i = 1; i <= n; i++){
            xor ^= i;
        }

        for(int num : arr){
            xor ^= num;
        }

        return xor;
    }

}
