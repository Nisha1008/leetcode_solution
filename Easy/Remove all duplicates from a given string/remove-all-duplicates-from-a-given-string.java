//{ Driver Code Starts
//Initial Template for Java



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String str = br.readLine().trim();

            String ans = new Solution().removeDuplicates(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    String removeDuplicates(String str) {
        String ans ="";
        int n = str.length();
        char[] arr = str.toCharArray();
        HashMap<Character,Integer> mp = new HashMap<>();
        for(int i=0;i<n;i++){
            if(!mp.containsKey(arr[i])){
                ans+= arr[i];
                mp.put(arr[i],1);
            }
        }
        return ans;
    }
}

