class Solution {
    val counts = mutableMapOf<Int, Int>()

    fun topKFrequent(nums: IntArray, k: Int): IntArray {

        for (num in nums) {
            val count = (counts[num] ?: 0)
            counts[num] = count + 1
        }

        return counts.entries
            .sortedByDescending { it.value }
            .take(k)
            .map { it.key }
            .toIntArray()
    }
}
