package DSA.DynamicProgramming;

import java.util.*;

public class LongestStringChain {
    public int longestStringChain(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length)); // Sort words by length
        Map<String, Integer> dp = new HashMap<>();
        int maxLen = 0;

        for (String word : words) {
            int longestChain = 0;

            // Try removing each character to find a valid predecessor
            for (int i = 0; i < word.length(); i++) {
                String prevWord = word.substring(0, i) + word.substring(i + 1);
                longestChain = Math.max(longestChain, dp.getOrDefault(prevWord, 0) + 1);
            }

            dp.put(word, longestChain);
            maxLen = Math.max(maxLen, longestChain);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LongestStringChain obj = new LongestStringChain();
        String[] words = {"a", "b", "ba", "bca", "bda", "bdca"};
        System.out.println(obj.longestStringChain(words)); // Output: 4 (a → ba → bda → bdca)
    }
}
