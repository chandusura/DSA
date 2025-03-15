package DSA.DynamicProgramming;


class Solution {
    public int count(int coins[], int sum) {
        
        // return rec(coins.length-1,coins,sum);
        int n=coins.length;
        int dp[][]=new int [n+1][sum+1];
        for(int i=0;i<=n;i++){
            dp[i][0]=1;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
               
               if(coins[i-1]<=j){
                   dp[i][j]=dp[i][j-coins[i-1]]+dp[i-1][j];
               }
               else{
                   dp[i][j]=dp[i-1][j];
               }
            }
        }
        return dp[n][sum];
        
    }
    // Recursion
    public int rec(int i,int coins[],int sum){
        if(sum==0){
            return 1;
        }
        if(i<0){
            return 0;
        }
        
        if(coins[i]<=sum){
            return rec(i,coins,sum-coins[i])+rec(i-1,coins,sum);
        }
        return rec(i-1,coins,sum);
        
    }
    
}
