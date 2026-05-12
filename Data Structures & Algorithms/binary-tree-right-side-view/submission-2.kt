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
            val queueSize = queue.size

            for (i in 0 until queueSize) {
                val node = queue.removeFirst()
                if (i == queueSize - 1) {
                    result.add(node.`val`)
                }

                node.left?.let { queue.addLast(it) }
                node.right?.let { queue.addLast(it) }
            }
        }

        return result
    }
}
