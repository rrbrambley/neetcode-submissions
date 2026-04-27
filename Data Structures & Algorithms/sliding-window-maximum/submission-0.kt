class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val output = IntArray(nums.size - k + 1) { -1 }

        for (i in output.indices) {
            output[i] = getMaxOfWindow(nums, i, i + k)
        }

        return output
    }

    private fun getMaxOfWindow(nums: IntArray, i: Int, j: Int): Int {
        val nextWindow = nums.sliceArray(i until j)
        return nextWindow.max()
    }
}
