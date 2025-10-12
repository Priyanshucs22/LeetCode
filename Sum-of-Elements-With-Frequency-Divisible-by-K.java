class Solution {
    public int sumDivisibleByK(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int e:nums){
            map.put(e,map.getOrDefault(e,0)+1);
        }
        int sum= 0;
        for(int key:map.keySet()){
            int fr = map.get(key);
            if(fr%k==0){
                sum += fr*key;
            }
        }
        return sum;
    }
}