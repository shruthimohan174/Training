//https://www.geeksforgeeks.org/find-non-overlapping-intervals-among-a-given-set-of-intervals/
package NonOverlappingIntervals;

import MergeIntervals.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class OverlappingIntervals {
public static void main(String[] args)
{   int[][] arr = { { 1, 3 },
            { 2, 4 },
            { 3, 5 },
            { 7, 9 } };

    int N = arr.length;
    findFreeinterval(arr, N);
}

private static void findFreeinterval(int[][] arr, int n) {
    Arrays.sort(arr, new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            return Integer.compare(o1[0],o2[0]);
        }
    });

    List<Interval> list=new ArrayList<>();

    for(int i=1;i<n;i++){
        int end=arr[i-1][1];
        int start=arr[i][0];

        if(end<start){
            Interval interval=new Interval(end,start);
            list.add(interval);
        }
    }

    for (int i = 0; i < list.size(); i++)
    {
        System.out.println("[" + list.get(i).start +
                ", " + list.get(i).end + "]");
    }
}
}
