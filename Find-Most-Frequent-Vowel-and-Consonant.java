class Solution {
    public int maxFreqSum(String s) {
        int maxC = 0;
        String vow = "aeiou";
        HashMap<Character,Integer> map = new HashMap<>();
        int maxV = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for(char k:map.keySet()){
            if(vow.indexOf(k)!=-1){
                maxV = Math.max(maxV,map.get(k));
            }else{
                maxC = Math.max(maxC,map.get(k));
            }
        }
        return maxC + maxV;
    }
}