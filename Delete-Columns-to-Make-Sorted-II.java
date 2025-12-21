1class Solution {
2    public int minDeletionSize(String[] strs) {
3        int n = strs.length;
4        int m = strs[0].length();
5        boolean[] ok = new boolean[n];
6        int del = 0;
7        for (int c = 0; c < m; c++) {
8            boolean bad = false;
9            for (int i = 1; i < n; i++) {
10                if (!ok[i] && strs[i].charAt(c) < strs[i - 1].charAt(c)) {
11                    bad = true;
12                    break;
13                }
14            }
15            if (bad) {
16                del++;
17                continue;
18            }
19            for (int i = 1; i < n; i++) {
20                if (!ok[i] && strs[i].charAt(c) > strs[i - 1].charAt(c)) {
21                    ok[i] = true;
22                }
23            }
24        }
25        return del;
26    }
27}
28