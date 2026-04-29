class Solution {
    fun findMin(nums: IntArray): Int {
        var l = 0
        var r = nums.size - 1
        var res = nums[0]

        while (l <= r) {
            // special case, where array isn't rotated
            if (nums[l] < nums[r]) {
                res = minOf(res, nums[l])
                break
            }

            val m = (l + r) / 2
            res = minOf(res, nums[m])

            // to check if middle value is part of left sorted portion,
            // or the right sorted portion, simply check if nums[m] >= nums[l]
            if (nums[m] >= nums[l]) {
                l = m + 1
            } else {
                r = m - 1
            }
        }

        return res
    }
}
