/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    private var result = Int.MIN_VALUE

    // use a DFS, with global variable to track the max path sum
    // this is the same as diameter, but using root.val instead of 1 for each node
    fun maxPathSum(root: TreeNode?): Int {
        dfs(root)
        return result
    }

    fun dfs(root: TreeNode?): Int {
        if (root == null) return 0

        val left = maxOf(dfs(root.left), 0)
        val right = maxOf(dfs(root.right), 0)

        result = maxOf(result, root.`val` + left + right)

        return root.`val` + maxOf(left, right)
    }
}
