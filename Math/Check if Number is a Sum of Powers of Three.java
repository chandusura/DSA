package DSA.Math;

class Solution {
    public boolean checkPowersOfThree(int n) {
         while(n!=0){
            int r=n%3;
            if(r>1){
                return false;
            }
            n=n/3;
         }
         return true;
    }
}