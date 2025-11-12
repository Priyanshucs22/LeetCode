class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> l = new ArrayList<>();
        for(int i = 0;i<=n;i++){
            l.add(new ArrayList<>());
        }
        for(int[] t:times){
            int a = t[0];
            int b = t[1];
            int time = t[2];
            l.get(a).add(new int[]{b,time});
        } 
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        int[] res = new int[n+1];
        Arrays.fill(res,Integer.MAX_VALUE);
        res[k] = 0;
        pq.add(new int[]{k,0});
        while(!pq.isEmpty()){
            int[] pair = pq.poll();
            int u = pair[0];
            int time = pair[1];
            for(int[] ne:l.get(u)){
                int v = ne[0];
                int d = ne[1];
                if(d+time < res[v]){
                    res[v] = d+time;
                    pq.add(new int[] {v,d+time});
                }
            }
        }
        int max =0 ;
        for(int i=1;i<=n;i++){
            int e = res[i];
            if(e==Integer.MAX_VALUE) return -1;
            max = Math.max(e,max);
        }
        return max;
    }
}