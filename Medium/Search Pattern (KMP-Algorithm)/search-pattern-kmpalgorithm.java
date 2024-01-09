//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s, patt;
            s = sc.next();
            patt = sc.next();
            
            Solution ob = new Solution();
            
            ArrayList<Integer> res = ob.search(patt, s);
            if(res.size()==0)
                System.out.print(-1);
            else {
                for(int i = 0;i<res.size();i++)
                    System.out.print(res.get(i) + " ");
            }
            System.out.println();    
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    ArrayList<Integer> search(String pat, String txt)
    {
        // your code here
        //Computing prefix function
        ArrayList<Integer> al=new ArrayList<Integer>();
        int m=pat.length();
        int n=txt.length();
        int[] pi=new int[m];
        pi[0]=-1;
        int k=-1, q;
        //Computing prefix function
        for(q=1; q<m; q++){
            while(k>-1&&pat.charAt(k+1)!=pat.charAt(q))
                k=pi[k];
            if(pat.charAt(q)==pat.charAt(k+1))
                k++;
            pi[q]=k;
        }
        
        //Matching pattern with text
        q=-1;
        for(int i=0; i<n; i++){
            while(q>-1&&pat.charAt(q+1)!=txt.charAt(i))
                q=pi[q];
            if(pat.charAt(q+1)==txt.charAt(i))
                q++;
            if(q==m-1){
                al.add(i-q+1);
                q=pi[q];
            }
        }
        return al;
    }
}