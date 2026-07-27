class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int[] charIndex = new int[128];

        for (int right = 0, left = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            left = Math.max(left, charIndex[currentChar]);

            maxLength = Math.max(maxLength, right - left + 1);

            charIndex[currentChar] = right + 1;
        }

        return maxLength;
    }
}