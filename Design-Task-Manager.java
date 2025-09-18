class TaskManager {
    Map<Integer, int[]> map;
    PriorityQueue<int[]> pq;
    public TaskManager(List<List<Integer>> tasks) {
        map = new HashMap<>();
        pq = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) return b[1] - a[1];
            return b[0] - a[0]; 
        });
        for (List<Integer> t : tasks) {
            int userId = t.get(0), taskId = t.get(1), priority = t.get(2);
            map.put(taskId, new int[]{userId, priority});
            pq.offer(new int[]{taskId, priority});
        }
    }
    public void add(int userId, int taskId, int priority) {
        map.put(taskId, new int[]{userId, priority});
        pq.offer(new int[]{taskId, priority});
    }

    public void edit(int taskId, int newPriority) {
        int[] old = map.get(taskId);
        map.put(taskId, new int[]{old[0], newPriority});
        pq.offer(new int[]{taskId, newPriority}); 
    }

    public void rmv(int taskId) {
        map.remove(taskId);
    }

    public int execTop() {
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int taskId = cur[0], priority = cur[1];
            if (map.containsKey(taskId) && map.get(taskId)[1] == priority) {
                int userId = map.get(taskId)[0];
                map.remove(taskId);
                return userId;
            }
        }
        return -1;
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */