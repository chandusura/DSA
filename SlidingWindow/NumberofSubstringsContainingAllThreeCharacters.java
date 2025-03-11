class Solution {
    public int numberOfSubstrings(String s) {
    int ref[] = {0, 0, 0}; // Frequency array for 'a', 'b', 'c'
    int count = 0;
    int n = s.length();
    int curr = 0; // Count of unique characters in window
    int left = 0;

    for (int i = 0; i < n; i++) {
        ref[s.charAt(i) - 'a']++; // Increment frequency of current character
        
        if (ref[s.charAt(i) - 'a'] == 1) {
            curr++; // If this character appears for the first time, increase unique count
        }
        
        while (curr == 3) { // When all 'a', 'b', and 'c' are present
            count += (n - i); // Count all valid substrings
            
            ref[s.charAt(left) - 'a']--; // Remove leftmost character
            
            if (ref[s.charAt(left) - 'a'] == 0) {
                curr--; // If a character count becomes zero, reduce unique count
            }
            
            left++; // Move left pointer (Fix)
        }
    }
    
    return count;
}

}
