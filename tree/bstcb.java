int max = 0;
Node maxNode;

public int largestBSTSubtree(TreeNode root) {
    maxNode = root;
    helper(root);
    // return max;
    return maxNode;
}

private int[] helper(TreeNode root){
    int[] res = new int[]{0, Integer.MAX_VALUE, Integer.MIN_VALUE};
    if(root == null) return res;
    int[] left = helper(root.left);
    int[] right = helper(root.right);
    
    // breaking case
    // left is null
    // right is null
    // curr is less than smallest of left = NOT BST
    // curr is more than biggest of right = NOT BST
    if(left[0] == -1 || right[0] == -1 || root.val <= left[2] || root.val >= right[1]){
        res[0] = -1; res[1] = 0; res[2] = 0;
        return res;
    }
    res[0] = left[0] + 1 + right[0];
    // max = Math.max(res[0], max);
    if (res[0] > max) {
        max = res[0];
        maxNode = root;
    }
    res[1] = Math.min(left[1], root.val);
    res[2] = Math.max(right[2], root.val);
    return res;
}