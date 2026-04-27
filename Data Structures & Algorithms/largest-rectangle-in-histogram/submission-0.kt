class Solution {
fun largestRectangleArea(heights: IntArray): Int {
    val leftMost = getLeftMosts(heights)
    val rightMost = getRightMosts(heights)

    var maxArea = 0
    for ((i, height) in heights.withIndex()) {
        leftMost[i]++
        rightMost[i]--
        maxArea = maxOf(maxArea, height * (rightMost[i] - leftMost[i] + 1))
    }

    return maxArea
}

private fun getLeftMosts(heights: IntArray): IntArray {
    val stack = Stack<Int>()
    val n = heights.size
    val leftMost = IntArray(n) { -1 }
    for (i in 0 until n) {
        while (stack.isNotEmpty() && heights[stack.last()] >= heights[i]) {
            stack.removeLast()
        }
        if (stack.isNotEmpty()) {
            leftMost[i] = stack.last()
        }
        stack.addLast(i)
    }
    return leftMost
}

private fun getRightMosts(heights: IntArray): IntArray {
    val stack = Stack<Int>()
    val n = heights.size
    val rightMost = IntArray(n) { n }
    for (i in n - 1 downTo 0) {
        while (stack.isNotEmpty() && heights[stack.last()] >= heights[i]) {
            stack.removeLast()
        }
        if (stack.isNotEmpty()) {
            rightMost[i] = stack.last()
        }
        stack.addLast(i)
    }
    return rightMost
}
}
