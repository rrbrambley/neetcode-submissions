/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    // - In order to know the kth smallest integer in the tree,
    //   we must visit every node in the tree.
    // - And since it's a binary search tree, we already know it's sorted.
    // - So, we should construct an array of sorted integers, and return the kth element.

    fun kthSmallest(root: TreeNode?, k: Int): Int {
        val result = ArrayList<Int>()
        inOrder(root, result)
        return result[k-1]
    }

    fun inOrder(root: TreeNode?, result: ArrayList<Int>) {
        if (root != null) {
            inOrder(root.left, result)
            result.add(root.`val`)
            inOrder(root.right, result)
        }
    }
}
