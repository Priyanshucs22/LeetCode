class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> l = new ArrayList<>();
        for(int e:nums){
            map.put(e,map.getOrDefault(e,0)+1);
        }
        for(int k:map.keySet()){
            if(map.get(k)>1){
                l.add(k);
            }
        }
        int[] arr = new int[l.size()];
        int i= 0;
        for(int e:l){
            arr[i] = e;
            i++;
        }
        return arr;
    }
}