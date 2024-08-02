//https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-rotated-array-with-duplicates/

public class SearchInRotatedSorted {
    public static void main (String[] args)
    {
        int arr[] ={3, 3, 1, 2, 3, 3};
        int n = arr.length;
        int key = 3;

        System.out.println(search(arr, 0, n - 1, key));
    }

    private static boolean search(int[] arr, int left, int right, int key) {

        while(left<=right){
            int mid=(left+right)/2;

            if(arr[mid]==key){
                return true;
            }
            else if(arr[mid] >=arr[left]){
                if(arr[mid]>=key && arr[left]<key){
                    right=mid-1;
                }
                else
                    left=mid+1;
            }
            else{
                if(arr[mid]<=key && arr[right]>key){
                    left=mid+1;
                }
                else
                    right=mid-1;
            }
        }
        return false;
    }
}
