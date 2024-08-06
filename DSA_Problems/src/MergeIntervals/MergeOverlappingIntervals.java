// https://www.geeksforgeeks.org/merging-intervals/
package MergeIntervals;

import java.util.Arrays;
import java.util.Comparator;

public class MergeOverlappingIntervals {

    public static void main(String args[])
    {
        Interval arr[] = new Interval[4];
        arr[0] = new Interval(6, 8);
        arr[1] = new Interval(1, 9);
        arr[2] = new Interval(2, 4);
        arr[3] = new Interval(4, 7);
        mergeIntervals(arr);
    }

    private static void mergeIntervals(Interval[] arr) {
        Arrays.sort(arr, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return Integer.compare(o1.start,o2.end);
            }
        });

        int idx=0;
        for(int i=1;i< arr.length;i++){
            if(arr[idx].end >=arr[i].start){
                arr[idx].end=Math.max(arr[idx].end, arr[i].end);
            }else{
                idx++;
                arr[idx]=arr[i];
            }
        }
        System.out.print("The Merged Intervals are: ");
        for (int i = 0; i <= idx; i++) {
            System.out.print("[" + arr[i].start + ","
                    + arr[i].end + "]");
        }
    }
}
