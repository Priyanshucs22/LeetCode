class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        Map<Integer, PriorityQueue<Integer>> minHeap = new HashMap<>();
        Map<Integer, PriorityQueue<Integer>> maxHeap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j;
                if (key >= 0) {
                    maxHeap.putIfAbsent(key, new PriorityQueue<>(Collections.reverseOrder()));
                    maxHeap.get(key).offer(grid[i][j]);
                } else {
                    minHeap.putIfAbsent(key, new PriorityQueue<>());
                    minHeap.get(key).offer(grid[i][j]);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j;
                if (key >= 0) {
                    grid[i][j] = maxHeap.get(key).poll();
                } else {
                    grid[i][j] = minHeap.get(key).poll();
                }
            }
        }
        return grid;
    }
}