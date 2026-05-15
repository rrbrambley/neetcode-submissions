/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Codec {
    fun serialize(root: TreeNode?): String {
        if (root == null) return "null"
        var result = mutableListOf<String>()
        val queue: Queue<TreeNode?> = LinkedList()
        queue.add(root)

        while (queue.isNotEmpty()) {
            val node = queue.poll()
            if (node == null || node.`val` == null) {
                result.add("null")
            } else {
                result.add(node.`val`.toString())
                queue.add(node.left)
                queue.add(node.right)
            }
        }
        return result.joinToString(separator = ",")
    }

    fun deserialize(data: String): TreeNode? {
        val nodes = data.split(",")
        if (nodes[0] == "null") return null

        val root = TreeNode(nodes[0].toInt())
        val queue: ArrayDeque<TreeNode> = ArrayDeque()
        queue.add(root)
        var i = 1

        while (queue.isNotEmpty() && i < nodes.size) {
            val node = queue.removeFirst()

            if (nodes[i] != "null") {
                node.left = TreeNode(nodes[i].toInt())
                queue.add(node.left!!)
            }
            i++

            // Handle Right Child
            if (i < nodes.size && nodes[i] != "null") {
                node.right = TreeNode(nodes[i].toInt())
                queue.add(node.right!!)
            }
            i++
        }

        return root
    }
}
