//https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/

public class MaximumSubarray {
    public static void main(String[] args) {
        int a[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int n = a.length;
        maxSubArraySum(a, n);
    }

    private static void maxSubArraySum(int[] arr, int n) {
        int cur=0,maxSum=Integer.MIN_VALUE,end=0,start=0;

        for(int i=0;i<n;i++){
            cur+=arr[i];

            if(cur<0){
                cur=0;
                start=i+1;
            }

//            maxSum=Math.max(maxSum,cur);
            if(maxSum<cur){
                maxSum=cur;
                end=i;
            }
        }

        System.out.println("Maximum contiguous sum is "+maxSum);
        System.out.println("Starting index " + start);
        System.out.println("Ending index " + end);
    }


}
