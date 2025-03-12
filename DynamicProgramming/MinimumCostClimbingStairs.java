package DSA.DynamicProgramming;

public class MinimumCostClimbingStairs {

public int minCostClimbingStairs(int[] cost) {
    int n = cost.length;
    int dp[] = new int[n + 1];

    //  Initialize first two steps
    dp[0] = 0;
    dp[1] = 0;

    // DP Transition Formula
    for (int i = 2; i <= n; i++) {
        dp[i] = Math.min(cost[i - 1] + dp[i - 1], cost[i - 2] + dp[i - 2]);
    }

    return dp[n];
}

// Recursion
public static int rec(int cost[],int i){
    if(i<=0){
        return 0;
    }
    return Math.min(cost[i]+rec(cost,i-1),cost[i-1]+rec(cost,i-2));
}


}
