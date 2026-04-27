class Solution {

    fun longestConsecutive(nums: IntArray): Int {
        val numSet = nums.toSet()
        var longest = 0

        for (n in nums) {

            // this marks the beginning of a sequence
            if (n-1 !in numSet) {
                var length = 1
                while ((n + length) in numSet) {
                    length++
                }
                longest = max(longest, length)
            }
        }
        return longest
    }
}
