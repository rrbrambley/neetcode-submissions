/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
      fun isValidBST(root: TreeNode?): Boolean {
        return isValid(root, Int.MIN_VALUE, Int.MAX_VALUE)
    }

    fun isValid(root: TreeNode?, leftBound: Int, rightBound: Int): Boolean {
        if (root == null) return true

        if (!(root.`val` > leftBound && root.`val` < rightBound)) return false

        return isValid(root.left, leftBound, root.`val`) &&
                isValid(root.right, root.`val`, rightBound)
    }

}
