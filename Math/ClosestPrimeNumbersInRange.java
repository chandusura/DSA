package DSA.Math;

import java.util.Arrays;

class Solution {
    public int[] closestPrimes(int left, int right) {
       boolean prime[]=new boolean[right+1];
       Arrays.fill(prime,true);
       for(int i=2;i<=right;i++){
            if(prime[i]){
                for(int j=i*i;j<=right;j=j+i){
                    prime[j]=false;
                }
            }
       }
        int res[]=new int[]{-1,-1};
        int prev=-1;
        int minDiff=Integer.MAX_VALUE;
        for(int i=left;i<=right;i++){
            if(prime[i]){
                // System.out.println(i);
                if(prev==-1){
                    prev=i;
                }else{
                    if(i-prev<minDiff){
                       
                        res[0]=prev;
                        res[1]=i;
                         minDiff=i-prev;
                    }
                    prev=i;
                }
            }
        }
       return  res;
    }
}