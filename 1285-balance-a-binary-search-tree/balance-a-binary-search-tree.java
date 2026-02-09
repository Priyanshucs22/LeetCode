/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<TreeNode> l = new ArrayList<>();
        inorder(root,l);
        return create(l,0,l.size()-1);
    }
    public void inorder(TreeNode root,ArrayList<TreeNode> l){
        if(root==null) return;
        inorder(root.left,l);
        l.add(root);
        inorder(root.right,l);
    }
    public TreeNode create(ArrayList<TreeNode> l,int i,int j){
        if(i>j) return null;
        int mid = i + (j-i)/2;
        TreeNode root = l.get(mid);
        root.left = create(l,i,mid-1);
        root.right = create(l,mid+1,j);
        return root;
    }
}