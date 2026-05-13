/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    fun goodNodes(root: TreeNode?): Int {
        if (root == null) return 0

        var res = 0
        val q = ArrayDeque<Pair<TreeNode, Int>>()
        q.add(root to Int.MIN_VALUE)

        while (q.isNotEmpty()) {
            val (node, max) = q.removeFirst()

            if (node.`val` >= max) {
                res++
            }

            val newMaxVal = maxOf(max, node.`val`)
            node.left?.let { q.add(it to newMaxVal) }
            node.right?.let { q.add(it to newMaxVal) }
        }

        return res
    }
}
