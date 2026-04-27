class Solution {
    private val seenInts = mutableSetOf<Int>()

    fun hasDuplicate(nums: IntArray): Boolean {
        return nums.toSet().size != nums.size
    }
}
