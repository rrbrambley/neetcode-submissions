class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        // first do binary search to find the correct row (first dimension of array)
        val row = getRow(matrix, target)
        if (row == -1) return false

        // now find the column
        return binarySearch(matrix[row], target) != -1
    }

    private fun getRow(matrix: Array<IntArray>, target: Int): Int {
        val rows = matrix.size
        val cols = matrix[0].size

        var top = 0
        var bot = rows - 1
        while (top <= bot) {
            val row = (top + bot) / 2
            if (target > matrix[row][cols-1]) {
                top = row + 1
            } else if (target < matrix[row][0]) {
                bot = row - 1
            } else {
                // found the row
                break
            }
        }

        if (top > bot) return -1
        return (top + bot) / 2
    }

    private fun binarySearch(nums: IntArray, target: Int): Int {
        var l = 0
        var r = nums.size

        // split the search in half each iteration
        while (l < r) {
            val mid = l + (r - l) / 2

            // if target is less than or equal to middle value, make right boundary the mid
            // else, move left boundary to mid + 1
            if (target <= nums[mid]) {
                r = mid
            } else {
                l = mid + 1
            }
        }

        return if (l < nums.size && nums[l] == target) l else -1
    }
}
