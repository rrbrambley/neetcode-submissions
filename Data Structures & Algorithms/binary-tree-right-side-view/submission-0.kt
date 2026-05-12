/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {

    fun rightSideView(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        if (root == null) {
            return result
        }

        val queue = ArrayDeque<TreeNode>()
        queue.addLast(root)

        while (queue.isNotEmpty()) {
            val level = mutableListOf<Int>()
            val queueSize = queue.size

            for (i in 0 until queueSize) {
                val node = queue.removeFirst()
                level.add(node.`val`)

                node.left?.let { queue.addLast(it) }
                node.right?.let { queue.addLast(it) }
            }

            result.add(level.last())
        }

        return result
    }
}
