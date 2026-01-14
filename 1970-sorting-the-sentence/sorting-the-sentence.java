class Solution {
    public String sortSentence(String s) {
        String[] words = s.split(" ");
        String[] sort = new String[words.length];
        
        for (String word : words) {
            int position = word.charAt(word.length() - 1) - '0';
            sort[position - 1] = word.substring(0, word.length() - 1);
        }
        
        return String.join(" ", sort);
    }
}