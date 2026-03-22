import java.util.*;

public class LeaderArray {

// Function to find leaders in array
static ArrayList<Integer> leaders(int arr[]) {
    
    ArrayList<Integer> result = new ArrayList<>();
    int n = arr.length;

    // Last element is always a leader
    int maxFromRight = arr[n - 1];
    result.add(maxFromRight);

    // Traverse from right to left
    for (int i = n - 2; i >= 0; i--) {
        if (arr[i] >= maxFromRight) {
            maxFromRight = arr[i];
            result.add(maxFromRight);
        }
    }

    // Reverse to maintain order
    Collections.reverse(result);

    return result;
}

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter number of elements: ");
    int n = sc.nextInt();

    int arr[] = new int[n];

    System.out.println("Enter elements:");
    for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
    }

    ArrayList<Integer> leadersList = leaders(arr);

    System.out.println("Leaders in the array:");
    for (int num : leadersList) {
        System.out.print(num + " ");
    }

    sc.close();
}

}
