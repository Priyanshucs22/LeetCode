1class Solution {
2    public int maxTwoEvents(int[][] events) {
3        Arrays.sort(events, (a, b) -> a[0] - b[0]);
4        int n = events.length;
5        int[] suffixMax = new int[n];
6        suffixMax[n - 1] = events[n - 1][2];
7        for (int i = n - 2; i >= 0; i--) {
8            suffixMax[i] = Math.max(suffixMax[i + 1], events[i][2]);
9        }
10        int ans = 0;
11
12        for (int i = 0; i < n; i++) {
13            int val = events[i][2];
14            int next = findNext(events, events[i][1]);
15            if (next != -1) {
16                val += suffixMax[next];
17            }
18            ans = Math.max(ans, val);
19        }
20
21        return ans;
22    }
23
24    private int findNext(int[][] events, int end) {
25        int l = 0, r = events.length - 1;
26        int res = -1; 
27        while (l <= r) {
28            int mid = (l + r) / 2;
29            if (events[mid][0] > end) {
30                res = mid;
31                r = mid - 1;
32            } else {
33                l = mid + 1;
34            }
35        }
36        return res;
37    }
38}
39