
//https://www.geeksforgeeks.org/problems/longest-increasing-subsequence-1587115620/1

package DSA.DynamicProgramming;
import java.util.*;


class Solution {
    
    static int dp[];
    static int lis(int arr[]) {
        // code here
        int n = arr.length;
        dp = new int[n];
    Arrays.fill(dp, 1); // Initialize dp array with 1s

    int max = 1;
    for (int i = 1; i < n; i++) {
        for (int j = 0; j < i; j++) {
            if (arr[i] > arr[j]) {
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        max = Math.max(max, dp[i]);
    }
    return max;
        
    }
    

}

