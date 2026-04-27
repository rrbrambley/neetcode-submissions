class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val counts: Map<Int, Int> = getCounts(nums)
        val frequencies: List<List<Int>> = getFrequencies(nums, counts)
        return getTopKFrequentNums(frequencies, k)
    }
    
    private fun getCounts(nums: IntArray): Map<Int, Int> {
        val counts = mutableMapOf<Int, Int>()
        for (num in nums) {
            counts[num] = (counts[num] ?: 0) + 1
        }
        return counts
    }

    // frequency = index
    private fun getFrequencies(nums: IntArray, counts: Map<Int, Int>): List<List<Int>> {
        val frequencies = List(nums.size + 1) { mutableListOf<Int>() }

        for ((num, cnt) in counts) {
            frequencies[cnt].add(num)
        }
        return frequencies
    }
    
    private fun getTopKFrequentNums(frequencies: List<List<Int>>, k: Int): IntArray {
        val res = mutableListOf<Int>()
        for (i in frequencies.size - 1 downTo 1) {
            for (num in frequencies[i]) {
                res.add(num)
                if (res.size == k) {
                    return res.toIntArray()
                }
            }
        }
        return res.toIntArray()
    }
}
