class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min = 101;
        int max = 0;
        for(int e:nums){
            min = Math.min(e,min);
            max = Math.max(e,max);
        }
        List<Integer> l = new ArrayList<>();
        int n = min;
        for(int i=min;i<=max;i++){
            boolean f = false;
            for(int j=0;j<nums.length;j++){
                if(i==nums[j]){
                    f = true;
                    break;
                }
            }
            if(!f) l.add(i);
        }
        return l;
    }
}