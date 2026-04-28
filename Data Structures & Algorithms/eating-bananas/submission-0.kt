class Solution {
    // find minimum num bananas k eaten per hour such that all bananas will be eaten in h hours
    //
    // 1. brute force - start with k = [1..maxOf(piles)] until you can eat all bananas
    //    time complexity: O(max(piles) * p)
    //
    // 2. use binary search
    //    time complexity: O(log(max(p)) * p)
    //
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        var l = 1
        var r = piles.max()
        var res = r

        while (l <= r) {
            val k = (l + r) / 2
            val hours = getHours(piles, k)
            if (hours <= h) {
                res = k
                r = k - 1
            } else { //if (hours > h) {
                l = k + 1
            }
        }
        return res
    }

    private fun getHours(piles: IntArray, k: Int): Int {
        return piles.sumOf { ceil((it.toDouble() / k)).roundToInt() }
    }
}
