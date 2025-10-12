class Solution {
    public int longestBalanced(String s) { 
        int n = s.length(), ans = 0;
        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];
            int distinct = 0;
            for (int j = i; j < n; j++) {
                char c = s.charAt(j);
                if (freq[c - 'a'] == 0) distinct++;
                freq[c - 'a']++;
                if (isBalanced(freq, distinct)) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }
    private boolean isBalanced(int[] freq, int distinct) {
        int common = 0;
        for (int f : freq) {
            if (f > 0) {
                if (common == 0) common = f;
                else if (f != common) return false;
            }
        }
        return true;
    }
}
