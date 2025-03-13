package DSA.DynamicProgramming;


class Solution {
    static int knapsack(int W, int val[], int wt[]) {
    
        //  return rec(wt.length-1,val,wt,W);
        return tabulation(W,val,wt);
        
        
        
    }
    public static int  rec(int i,int val[],int wt[],int w){
        if(w<0||i<0){
            return 0;
        }
        if(wt[i]<=w){
            return Math.max(val[i]+rec(i-1,val,wt,w-wt[i]),rec(i-1,val,wt,w));
        }
        return rec(i-1,val,wt,w);
    }
    
    public static int tabulation(int w,int val[],int wt[]){
         int n=val.length;
        int dp[][]=new int[n+1][w+1];
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=w;j++){
                if(wt[i-1]<=j){
                    dp[i][j]=Math.max(val[i-1]+dp[i-1][j-wt[i-1]],dp[i-1][j]);
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][w];
    }
}



