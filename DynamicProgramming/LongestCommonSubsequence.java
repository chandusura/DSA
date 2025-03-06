package DSA.DynamicProgramming;
import java.util.*;
// https://www.geeksforgeeks.org/problems/longest-common-subsequence-1587115620/1


 // using recurion 
class Solution {
    static int lcs(String s1, String s2) {
        // code here
        int n=s1.length();
        int m=s2.length();
       return rec(n-1,m-1,s1,s2);
        
    }
    
   
    public static int rec(int index1,int index2,String s1,String s2){
        if(index1<0 || index2<0){
            return 0;
        }
        if(s1.charAt(index1)==s2.charAt(index2)){
            return 1+rec(index1-1,index2-1,s1,s2);
        }
        return Math.max(rec(index1-1,index2,s1,s2),rec(index1,index2-1,s1,s2));
    }
}

// Using dp 


class Solution2 {
    static int lcs(String s1, String s2) {
        // code here
        int n=s1.length();
        int m=s2.length();
        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
       return rec(n-1,m-1,s1,s2,dp);
        
    }
    
    
    public static int rec(int index1,int index2,String s1,String s2,int [][]dp){
        if(index1<0 || index2<0){
            return 0;
        }
        if(dp[index1][index2]!=-1){
            return dp[index1][index2];
        }
        if(s1.charAt(index1)==s2.charAt(index2)){
            return dp[index1][index2]=1+rec(index1-1,index2-1,s1,s2,dp);
        }
        return dp[index1][index2]=Math.max(rec(index1-1,index2,s1,s2,dp),rec(index1,index2-1,s1,s2,dp));
    }


//   Tabulation
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length(),n=text2.length(),i,j;
        int matrix[][]=new int[m+1][n+1];
        for(i=1;i<=m;i++){
            for(j=1;j<=n;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    matrix[i][j]=matrix[i-1][j-1]+1;
                }
                else{
                    matrix[i][j]=Math.max(matrix[i][j-1],matrix[i-1][j]);
                }
            }
        }
        return matrix[m][n];
    }
}
