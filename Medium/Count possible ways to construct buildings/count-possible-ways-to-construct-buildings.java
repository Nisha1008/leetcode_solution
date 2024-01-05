//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.TotalWays(N);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int TotalWays(int n)
    {
        // Code here
        long bCount =1, sCount=1;
        int mod = 1000000007;
        
        for(int i=2;i<=n;i++){
            long newCount = sCount;
            long newsCount = bCount%mod +sCount%mod;
            bCount = newCount;
            sCount = newsCount;
        }
        long total = sCount+bCount;
        return (int)(total%mod*total%mod)%mod;
    }
}