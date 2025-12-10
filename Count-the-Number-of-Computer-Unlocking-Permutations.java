1class Solution {
2    static final int MOD = 1_000_000_007;
3    public int countPermutations(int[] comp) {
4        int n = comp.length;
5        int first = comp[0];
6        for (int i = 1; i < n; i++) {
7            if (comp[i] <= first) return 0;
8        }
9        long fact = 1;
10        for (int i = 2; i < n; i++) {
11            fact = (fact * i) % MOD;
12        }
13        return (int) fact;
14    }
15}