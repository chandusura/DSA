package DSA.DynamicProgramming;

 
 class Solution {
    public int longestPalinSubseq(String s) {
        // Reverse the string to compare
        StringBuilder str = new StringBuilder(s);
        String s2 = str.reverse().toString();
        int n = s.length();
        int dp[][] = new int[n + 1][n + 1];

        // Fill DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) { 
                if (s.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); 
                }
            }
        }

        return dp[n][n]; // The last cell contains the result
    }
}
