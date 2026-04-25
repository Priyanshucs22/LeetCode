class Solution {
    public List<Integer> findGoodIntegers(int n) {
        List<Integer> l = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        int m = (int)Math.cbrt(n);
        for(int i=1;i<=m;i++){
            int a = i*i*i;
            for(int j=i;j<=m;j++){
                int sum = a + j*j*j;
                if(sum>n) break;
                map.put(sum,map.getOrDefault(sum,0)+1);
            }
        }
        for(int k:map.keySet()){
            if(map.get(k)>=2){
                l.add(k);
            }
        }
        Collections.sort(l);
        return l;
    }
}