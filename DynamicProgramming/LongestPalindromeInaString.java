package DSA.DynamicProgramming;
class Solution {
    static String longestPalindrome(String s) {
        int n = s.length(); // Get the length of the string
        int start = 0, end = 0; // Variables to store the start and end indices of the longest palindrome
        int max = 1; // Variable to store the length of the longest palindrome

        // Iterate through the string to check for palindromic substrings
        for (int i = 1; i < n; i++) {
            // Check for odd-length palindromes with center at 'i'
            int left = i, right = i;
            while (left - 1 >= 0 && right + 1 < n) {
                if (s.charAt(left - 1) == s.charAt(right + 1)) {
                    left--;
                    right++;
                    if (right - left + 1 > max) { // Update the max length and start/end indices
                        max = right - left + 1;
                        start = left;
                        end = right;
                    }
                } else {
                    break; // Stop when characters don't match
                }
            }

            // Check for even-length palindromes with center at 'i' and 'i+1'
            left = i;
            right = i + 1;
            if (right < n && s.charAt(left) == s.charAt(right)) { // Ensure valid indices and matching characters
                while (left - 1 >= 0 && right + 1 < n) {
                    if (s.charAt(left - 1) == s.charAt(right + 1)) {
                        left--;
                        right++;
                        if (right - left + 1 > max) { // Update the max length and start/end indices
                            max = right - left + 1;
                            start = left;
                            end = right;
                        }
                    } else {
                        break; // Stop when characters don't match
                    }
                }
            }
        }
        return s.substring(start, end + 1); // Return the longest palindromic substring
    }
}
