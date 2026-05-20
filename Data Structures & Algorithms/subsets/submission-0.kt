class Solution {
    /**
     * Start with just one subset: the empty set [].
     *
     * For every number in the array, we take all the subsets we have so far and
     * create new subsets by adding the current number to each of them.
     *
     * Example:
     *
     * nums = [1,2,3]
     *
     * Start: [[]]
     * Add 1 → [[], [1]]
     * Add 2 → [[], [1], [2], [1,2]]
     * Add 3 → [[], [1], [2], [1,2], [3], [1,3], [2,3], [1,2,3]]
     *
     * 1. Initialize res = [[]] (start with empty subset).
     * 2. For each number num in the input array:
     *    For every subset already in res:
     *      Create a new subset that includes num
     *   Append all these newly created subsets to res.
     * 3. Return res after processing all numbers.
     */
    fun subsets(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>(listOf())

        for (num in nums) {
            val numResults = result.size

            for (i in 0 until numResults) {
                val newSubset = result[i].toMutableList()
                newSubset.add(num)
                result.add(newSubset)
            }

        }
        return result
    }
}
