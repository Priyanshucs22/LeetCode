class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> l1 = new ArrayList<>();
        List<String> l = new ArrayList<>();
        find(l1,l,s);
        return l1;
    }
    private static void find(List<List<String>> l1,List<String> l,String s){
        if(s.length() == 0){
            l1.add(new ArrayList<>(l));
            return;
        }
        for(int i=1;i<=s.length();i++){
            String p= s.substring(0,i);
            if(ispal(p)){ 
                l.add(p);
                find(l1,l,s.substring(i));
                l.remove(l.size()-1);
            }
        }
    }
    private static boolean ispal(String s){
        int i = 0;
        int j = s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}