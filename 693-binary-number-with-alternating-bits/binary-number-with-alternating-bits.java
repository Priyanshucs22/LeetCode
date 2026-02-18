class Solution {
    public boolean hasAlternatingBits(int n) {
        String s = Integer.toBinaryString(n);
        boolean b = false;
        for(char c:s.toCharArray()){
            if(c=='1' && !b){
                b = true;
            }
            else if(c=='0' && b){
                b = false;
            }
            else return false;
        }
        return true;
    }
}