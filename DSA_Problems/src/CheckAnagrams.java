//https://www.geeksforgeeks.org/check-whether-two-strings-are-anagram-of-each-other/

public class CheckAnagrams {
    public static void main(String[] args)
    {
        String str1 = "listen";
        String str2 = "silent";

        if (areAnagrams(str1, str2)) {
            System.out.println("True");
        }
        else {
            System.out.println("False");
        }

        str1 = "gram";
        str2 = "arm";

        if (areAnagrams(str1, str2)) {
            System.out.println("True");
        }
        else {
            System.out.println("False");
        }
    }

    private static boolean areAnagrams(String str1, String str2) {
        if(str1.length()!=str2.length()){
            return false;
    }
        int count[]=new int[26];

        for(char ch:str1.toCharArray()){
            count[ch-'a']++;
        }

        for(char ch:str2.toCharArray()){
           count[ch-'a']--;
        }

        for(int i=0;i<26;i++){
            if(count[i]!=0){
              return false;
            }
        }
        return true;
}
}
