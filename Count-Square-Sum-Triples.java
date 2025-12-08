1class Solution {
2    public int countTriples(int n) {
3        int count = 0;
4        for (var a = 1; a < n; a++)
5            for (var b = 1; b < n; b++) {
6                double c = Math.sqrt(a * a + b * b);
7                if (c == (int) c && c <= n)
8                    count++;
9            }
10        return count;
11    }
12}