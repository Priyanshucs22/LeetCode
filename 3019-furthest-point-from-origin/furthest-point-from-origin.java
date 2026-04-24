class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int l = 0, r = 0, d = 0;
        for(int i = 0;i<moves.length();i++){
            if(moves.charAt(i)=='L') l++;
            else if(moves.charAt(i)=='R') r++;
            else d++;
        }
        return l>r?l+d-r:r+d-l;
    }
}