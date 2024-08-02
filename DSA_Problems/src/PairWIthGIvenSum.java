//https://www.geeksforgeeks.org/check-if-pair-with-given-sum-exists-in-array/

import java.util.Arrays;

public class PairWIthGIvenSum {

    public static void main(String args[]){
        int arr[]=new int[]{1, 4, 45, 6, 10, -8};
        int sum=14,n=6;
        boolean foundPair = false;

        Arrays.sort(arr);

        for(int i=0;i<n;i++){
            int key=sum-arr[i];
            if(binarySearch(arr,0,n-1,key) && key!=arr[i]){
                System.out.println("Yes");
                foundPair = true;
                break;
            }
        }
        if(!foundPair)
            System.out.println("No");
    }

    private static boolean binarySearch(int[] arr, int left, int right, int key) {
        while(left<=right){
            int mid=(left+right)/2;
            if(arr[mid]==key)
                return true;
            else if(arr[mid]>key)
                right=mid-1;
            else
                left=mid+1;
        }
        return false;
    }
}
