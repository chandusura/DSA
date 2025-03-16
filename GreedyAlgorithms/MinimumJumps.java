package DSA.GreedyAlgorithms;


class Solution {
    static int minJumps(int[] arr) {
        int current = 0;
        int max = 0;
        int count = 0;
        int n = arr.length;

        if (n == 1) return 0; // No jumps needed if already at the destination
        if (arr[0] == 0) return -1; // Can't move if first element is 0

        for (int i = 0; i < n - 1; i++) {
            max = Math.max(arr[i] + i, max);
            
            if (current == i) {
                count++;
                current = max;
                if (current >= n - 1) return count; // Reached the end
            }
            
            if (current <= i) return -1; // Stuck, can't move forward
        }
        return -1;
    }
}
