class Solution {
    public int nextBeautifulNumber(int n) {
        n++;
        while (true) {
            if (isBeautiful(n)) return n;
            n++;
        }
    }
    private boolean isBeautiful(int n) {
        int[] freq = new int[10];
        int num = n;
        while (num > 0) {
            freq[num % 10]++;
            num /= 10;
        }
        for (int d = 0; d < 10; d++) {
            if (freq[d] != 0 && freq[d] != d) return false;
        }
        return true;
    }
}
