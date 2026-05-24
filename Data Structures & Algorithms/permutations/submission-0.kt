class Solution {
    /**
     * Time Complexity: O(n! * n)
     * Space Complexity: O(n! * n)
     */
    fun permute(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        backtrack(result, mutableListOf(), nums, BooleanArray(nums.size))
        return result
    }

    private fun backtrack(result: MutableList<List<Int>>, 
                          cur: MutableList<Int>, 
                          nums: IntArray, 
                          used: BooleanArray) {
        
        if (cur.size == nums.size) {
            result.add(cur.toList())
            return
        }
        
        for (i in nums.indices) {
            if (!used[i]) {
                cur.add(nums[i])
                used[i] = true
                backtrack(result, cur, nums, used)
                cur.removeAt(cur.lastIndex)
                used[i] = false
            }
        }
    }
}
