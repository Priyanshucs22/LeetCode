class Solution {
    public int mirrorFrequency(String s) {
        int ans = 0;
        int[] f = new int[128];
        for (char c : s.toCharArray()) {
            f[c]++;
        }
        for (char c = '0'; c <= 'z'; c++) {
            if (f[c] == 0) continue;
            char d;
            if (c >= '0' && c <= '9') {
                d = (char) ('0' + (9 - (c - '0')));
            } else if (c >= 'a' && c <= 'z') {
                d = (char) ('z' - (c - 'a'));
            } else continue;
            int idx = s.indexOf(d);
            int idx2 = s.indexOf(c);
            if(idx!=-1 && idx < idx2) continue;
            System.out.println(c +" "+ d);
            ans += Math.abs(f[c] - f[d]);
        }

        return ans;
    }
}