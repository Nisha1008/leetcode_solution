//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String St[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(St[0]);
            int K = Integer.parseInt(St[1]);
            
            String S[] = read.readLine().split(" ");
            
            int[] arr = new int[N];
            
            for(int i=0 ; i<N ; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.splitArray(arr,N,K));
        }
    }
}
// } Driver Code Ends


class Solution {
    static int splitArray(int[] arr , int N, int k) {
        // code here
        int l = Arrays.stream(arr).max().getAsInt(), h = Arrays.stream(arr).sum() , ans =0;
        
        while(l<=h){
            int mid = (l+h)/2;
            if(check(mid,arr,k)){
                ans = mid;
                h = mid-1;
            }else{
                l = mid+1;
            }
        }
        return ans;
    }
    static boolean check(int mid,int[] arr,int k){
        int tot=1,sum=0;
        for(int i=0;i<arr.length;i++){
            sum +=arr[i];
            if(sum >mid){
                sum = arr[i];
                tot++;
            }
        }
        return tot<=k;
    }
};