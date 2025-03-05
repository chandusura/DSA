package DSA.Math;
//https://leetcode.com/problems/count-total-number-of-colored-cells/description/?envType=daily-question&envId=2025-03-05
class Solution {
    public long coloredCells(int n) {
        long res=n;
        return 1+ (res) * (res-1) * 2;

    }
}