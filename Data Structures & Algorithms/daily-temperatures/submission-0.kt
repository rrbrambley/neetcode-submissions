class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val res = IntArray(temperatures.size) { 0 }
        val stack = Stack<Int>()

        for (i in temperatures.indices) {

            while (stack.isNotEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                val idx = stack.pop()
                res[idx] = i - idx
            }

            // NOTE: pushing indices to the stack
            stack.push(i)
        }

        return res
    }
}
