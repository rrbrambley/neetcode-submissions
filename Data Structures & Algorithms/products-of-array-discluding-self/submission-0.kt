class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val prefix: IntArray = getPrefixValues(nums)
        val suffix: IntArray = getSuffixValues(nums)
        return IntArray(nums.size) { i -> prefix[i] * suffix[i] }
    }

    private fun getPrefixValues(nums: IntArray): IntArray {
        val prefix = IntArray(nums.size)
        prefix[0] = 1
        for (i in 1..<nums.size) {
            prefix[i] = nums[i-1] * prefix[i-1]
        }
        return prefix
    }

    private fun getSuffixValues(nums: IntArray): IntArray {
        val suffix = IntArray(nums.size)
        suffix[nums.size-1] = 1
        for (i in nums.size - 2 downTo 0) {
            suffix[i] = nums[i+1] * suffix[i+1]
        }
        return suffix
    }
}
