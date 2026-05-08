/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
     private var result = 0

    fun diameterOfBinaryTree(root: TreeNode?): Int {
        dfs(root)
        return result
    }

    //
    // recursively run depth first search (DFS)
    //
    fun dfs(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        val left = dfs(root.left)
        val right = dfs(root.right)

        result = maxOf(result, left + right)

        return 1 + maxOf(left, right)
    }
}
