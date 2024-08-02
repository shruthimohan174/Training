//https://www.geeksforgeeks.org/find-duplicates-given-array-elements-not-limited-range/

import java.util.*;

public class FIndDuplicates {
    public static void main(String[] args) {

        int[] arr = {3,4,1,2}; // Example input array
        findDuplicate(arr);
    }

    private static void findDuplicate(int[] arr) {
        HashMap<Integer,Integer> countMap=new HashMap();

        for(int num:arr){
            if(countMap.containsKey(num))
                countMap.put(num,countMap.get(num)+1);

            else
                countMap.put(num,1);
        }

        List<Integer> duplicates=new ArrayList<>();
        for(Map.Entry<Integer,Integer>entry:countMap.entrySet()){
            if(entry.getValue()>1)
                duplicates.add(entry.getKey());
        }
        if(!duplicates.isEmpty())
            System.out.println("Duplicate elements: " + duplicates);
        else
            System.out.println("No duplicates found");


    }

}
