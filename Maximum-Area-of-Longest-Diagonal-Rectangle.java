class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        double max = 0;
        int area = 0;
        for (int[] d : dimensions) {
            double sq = Math.sqrt(d[0] * d[0] + d[1] * d[1]);
            int ar = d[0] * d[1];
            if (sq > max) {
                max = sq;
                area = ar;
            } else if (sq == max && ar > area) {
                area = ar;
            }
        }
        return area;
    }
}