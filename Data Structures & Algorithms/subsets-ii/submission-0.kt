class Solution {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        nums.sort()
        val result = mutableListOf<List<Int>>(listOf())
        var previousIndex = 0
        var index = 0

        for (i in nums.indices) {
            val num = nums[i]
            index = if (i > 0 && num == nums[i-1]) previousIndex else 0
            previousIndex = result.size
            
            for (j in index until previousIndex) {
                val newSubset = result[j].toMutableList()
                newSubset.add(num)
                result.add(newSubset)
            }
        }
        return result
    }
}
