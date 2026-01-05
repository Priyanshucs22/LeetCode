1class Solution {
2    public long maxMatrixSum(int[][] matrix) {
3        int neg = 0;
4        long sum = 0;
5        long minVal = Long.MAX_VALUE;
6
7        for (int[] row : matrix) {
8            for (int val : row) {
9                if (val < 0) {
10                    neg++;
11                }
12                sum += Math.abs(val);
13                minVal = Math.min(minVal, Math.abs(val));
14            }
15        }
16
17        if (neg % 2 == 1) {
18            sum -= 2 * minVal;
19        }
20
21        return sum;
22    }
23}