class Solution {
    fun trap(height: IntArray): Int {
        var maxArea = 0

        var l = 0
        var r = height.size-1
        var leftMax = height[l]
        var rightMax = height[r]

        while (l < r) {
            if (leftMax < rightMax) {
                l += 1
                leftMax = maxOf(leftMax, height[l])
                maxArea += leftMax - height[l]
            } else {
                r -= 1
                rightMax = maxOf(rightMax, height[r])
                maxArea += rightMax - height[r]
            }
        }

        return maxArea
    }
}
