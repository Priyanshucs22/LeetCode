class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (x, y) -> (y[1] - y[0]) - (x[1] - x[0]));
        int ans = 0;
        int energy = 0;
        for (int[] t : tasks) {
            int actual = t[0];
            int minimum = t[1];
            if (energy < minimum) {
                ans += minimum - energy;
                energy = minimum;
            }
            energy -= actual;
        }

        return ans;
    }
}