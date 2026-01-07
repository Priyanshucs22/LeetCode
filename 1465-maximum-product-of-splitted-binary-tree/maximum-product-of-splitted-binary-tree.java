class Solution {
    long totalSum = 0;
    long maxProduct = 0;
    static final int MOD = 1000000007;
    public int maxProduct(TreeNode root) {
        totalSum = dfsProduct(root);   
        dfsProduct(root);          
        return (int)(maxProduct % MOD);
    }
    long dfsProduct(TreeNode root) {
        if (root == null) return 0;
        long left = dfsProduct(root.left);
        long right = dfsProduct(root.right);
        long subTreeSum = root.val + left + right;
        System.out.print(subTreeSum+" ");
        maxProduct = Math.max(maxProduct, subTreeSum * (totalSum - subTreeSum));
        return subTreeSum;
    }
}