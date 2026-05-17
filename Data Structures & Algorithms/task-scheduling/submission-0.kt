class Solution {
    fun leastInterval(tasks: CharArray, n: Int): Int {
        val count = IntArray(26)
        for (task in tasks) {
            count[task - 'A']++
        }

        val maxFrequency = count.maxOrNull() ?: 0
        var numMaxFrequency = count.count { it == maxFrequency }
        val time = (maxFrequency - 1) * (n + 1) + numMaxFrequency
        return maxOf(tasks.size, time)
    }
}
