class Solution {
    // A naive approach would be to use a hash set, which takes
    // O(1) time to detect duplicates, and requires O(n) extra space

//    fun findDuplicate(nums: IntArray): Int {
//        val seen = HashSet<Int>()
//        for (num in nums) {
//            if (num in seen) {
//                return num
//            }
//            seen.add(num)
//        }
//        return -1
//    }

    // Time complexity: O(n)
    // Space complexity: O(1)
    fun findDuplicate(nums: IntArray): Int {
        for (num in nums) {
            val index = abs(num) - 1
            if (nums[index] < 0) {
                return abs(num)
            }
            nums[index] *= -1
        }

        return -1
    }
}