public class Second_largest {

    public static void main(String[] args) {

        int arr[] = {1,2,3,4,8,7,2,3,4,8,9,9};

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++) {

            if(arr[i] > first) {
                second = first;
                first = arr[i];
            }

            else if(arr[i] > second && arr[i] != first) {
                second = arr[i];
            }
        }

        if(second == Integer.MIN_VALUE) {
            System.out.println("Second largest does not exist");
        } else {
            System.out.println("Largest: " + first);
            System.out.println("Second Largest: " + second);
        }
    }
}