class Solution {
    public boolean asteroidsDestroyed(int m, int[] ast) {
        Arrays.sort(ast);
        long mass = (long) m;
        for (int i = 0; i < ast.length; i++) {
            if (mass >= ast[i]) {
                mass += ast[i];
            } else {
                return false;
            }
        }
        return true;
    }
}