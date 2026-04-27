class Solution {

    fun maxArea(heights: IntArray): Int {
        var maxArea = 0

        var l = 0
        var r = heights.size-1

        while (l < r) {
            val area = (r-l) * Math.min(heights[l], heights[r])
            maxArea = Math.max(maxArea, area)

            if (heights[l] < heights[r]) {
                l++
            } else {
                r--
            }
        }

        return maxArea
    }
}
