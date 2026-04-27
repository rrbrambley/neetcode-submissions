class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var l = 0
        var r = nums.size

        // split the search in half each iteration
        while (l < r) {
            val mid = l + (r - l) / 2

            // if target is less than or equal to middle value, make right boundary the mid
            // else, move left boundary to mid + 1
            if (target <= nums[mid]) {
                r = mid
            } else {
                l = mid + 1
            }
        }

        return if (l < nums.size && nums[l] == target) l else -1
    }
}
