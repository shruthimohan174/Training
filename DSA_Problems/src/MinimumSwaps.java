//https://www.geeksforgeeks.org/minimum-swaps-required-group-1s-together/
public class MinimumSwaps {
    public static void main(String args[]){
        int a[] = {0,1,1,1,0,0,1,1,0};
        int n = a.length;
        System.out.println( minSwaps(a, n));

    }

    private static int minSwaps(int[] arr, int n) {

        int i,j,k=0,curCount=0,maxCount=0;
        for(i=0;i<n;i++){
            if(arr[i]==1)
                k++;
        }

        for(j=0;j<k;j++){
            if(arr[j]==1){
                curCount++;
            }
        }
        if(curCount==k){return 0;}

        maxCount=Math.max(maxCount,curCount);

        i=0;
        while(i<n){
            if(arr[i]==1) curCount--;
            if(arr[j]==1)  curCount++;

            i++;
            j++;
            j=j%n;
            maxCount=Math.max(maxCount,curCount);
        }

        return k-maxCount;
    }
}
