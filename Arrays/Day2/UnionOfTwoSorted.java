import java.util.ArrayList;

public class UnionOfTwoSorted {
    public static void main(String[] args){

        int arr[] = {1,2,3,4,5};
        int arr2[] = {1,3,4,5,6,7,8,9};

        UnionOfTwoSorted obj = new UnionOfTwoSorted();

        ArrayList<Integer> res = obj.sorted(arr, arr2);

        System.out.println(res);
    }

    public ArrayList<Integer> sorted(int a[], int b[]){

        ArrayList<Integer> res = new ArrayList<>();

        int i = 0;
        int j = 0;

        while(i < a.length && j < b.length){

            if(a[i] <= b[j]){
                if(res.size()==0 || res.get(res.size()-1)!=a[i]){
                    res.add(a[i]);
                }
                i++;
            }
            else{
                if(res.size()==0 || res.get(res.size()-1)!=b[j]){
                    res.add(b[j]);
                }
                j++;
            }
        }

        while(i < a.length){
            if(res.size()==0 || res.get(res.size()-1)!=a[i]){
                res.add(a[i]);
            }
            i++;
        }

        while(j < b.length){
            if(res.size()==0 || res.get(res.size()-1)!=b[j]){
                res.add(b[j]);
            }
            j++;
        }

        return res;
    }
}
