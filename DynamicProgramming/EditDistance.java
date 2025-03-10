package DSA.DynamicProgramming;

import java.util.Arrays;

class Solution {
    
    public int editDistance(String s1, String s2) {
        // Code here
        int n=s1.length(),n2=s2.length();
        int dp[][]=new int [n+1][n2+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        // memorization calling
        return rec(n-1,n2-1,s1,s2,dp);
        
    }
    
    
    // Memorization
    public  int rec(int i,int j,String s1,String s2,int dp[][]){
        
        
        if(i<0 || j<0){
            if(i>=0)  return i+1;
            if(j>=0) return j+1;
             return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        
        if (s1.charAt(i) == s2.charAt(j)){
            return dp[i][j]= rec(i-1,j-1,s1,s2,dp);
        }
         
        //  insert remove replace 
        
        return dp[i][j]= Math.min(1+rec(i,j-1,s1,s2,dp),Math.min(1+rec(i-1,j,s1,s2,dp),1+rec(i-1,j-1,s1,s2,dp)));
    }
}

// Tabulation 
class Solution2 {
    
    public int editDistance(String s1, String s2) {
        // Code here
        int n=s1.length(),n2=s2.length();
        int dp[][]=new int [n+1][n2+1];
       
        for(int i=0;i<=n;i++){
            dp[i][0]=i;
        }
        for(int i=0;i<=n2;i++){
            dp[0][i]=i;
        }
        dp[0][0]=0;
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n2;j++){
                 
                if (s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.min(1+dp[i-1][j],Math.min(1+dp[i][j-1],1+dp[i-1][j-1]));
                }
            }
        }
        return dp[n][n2];
    }
}