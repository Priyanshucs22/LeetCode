1class Solution {
2    public long maxProfit(int[] prices, int[] strategy, int k) {
3        int n = prices.length;
4        long[] pr = new long[n];
5        long totalProfit = 0;
6
7        // Base profit
8        for (int i = 0; i < n; i++) {
9            pr[i] = (long) prices[i] * strategy[i];
10            totalProfit += pr[i];
11        }
12
13        long maxExtra = 0;
14        long original = 0;   // sum of pr in window
15        long modified = 0;   // sum of prices in second half
16
17        int i = 0;
18
19        for (int j = 0; j < n; j++) {
20            original += pr[j];
21
22            // add to modified part if in second half
23            if (j - i + 1 > k / 2) {
24                modified += prices[j];
25            }
26
27            // shrink window if size exceeds k
28            if (j - i + 1 > k) {
29                original -= pr[i];
30
31                // remove from modified if needed
32                if (j - i + 1 > k / 2 + 1) {
33                    modified -= prices[i + k / 2];
34                }
35                i++;
36            }
37
38            // window exactly size k
39            if (j - i + 1 == k) {
40                maxExtra = Math.max(maxExtra, modified - original);
41            }
42        }
43
44        return totalProfit + maxExtra;
45    }
46}
47