class Solution {
	
	
    public List<Integer> inorderTraversalIterator(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            resultList.add(root.val);
            root = root.right;
        }
        return resultList;
    }
	
	public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> resultList = null;
        if (root.left != null) {
            resultList = inorderTraversal(root.left);
        }
        if (resultList == null) {
            resultList = new ArrayList<>();
            resultList.add(root.val);
        } else {
            resultList.add(root.val);
        }
        if (root.right != null) {
            resultList.addAll(inorderTraversal(root.right));
        }
        return resultList;
    }
}