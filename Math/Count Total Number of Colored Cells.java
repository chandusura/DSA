package DSA.Math;
class Solution {
    public long coloredCells(int n) {
        long res=n;
        return 1+ (res) * (res-1) * 2;

    }
}