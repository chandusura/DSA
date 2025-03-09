package DSA.DynamicProgramming;


class Solution {
    public int countPS(String s) {
   int count = 0;
    
    for (int i = 0; i < s.length(); i++) {
        count += expandAroundCenter(s, i-1, i+1);   // Count odd-length palindromes
        count += expandAroundCenter(s, i, i+1); // Count even-length palindromes
    }
    
    return count;
}

private int expandAroundCenter(String s, int left, int right) {
    int count = 0;
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
        count++;
        left--;
        right++;
    }
    return count;
}
    
}