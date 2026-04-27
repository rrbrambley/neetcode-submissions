class Solution {

    fun maxArea(heights: IntArray): Int {
        var maxArea = 0

        var l = 0
        var r = heights.size-1

        while (l < r) {
            val area = (r-l) * minOf(heights[l], heights[r])
            maxArea = maxOf(maxArea, area)

            if (heights[l] <= heights[r]) {
                l++
            } else {
                r--
            }
        }

        return maxArea
    }
}
