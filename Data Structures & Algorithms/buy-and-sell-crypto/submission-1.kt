class Solution {
    fun maxProfit(prices: IntArray): Int {
        var lowestPrice = Int.MAX_VALUE
        var maxProfit = 0

        for (p in prices) {
            lowestPrice = minOf(lowestPrice, p)
            maxProfit = maxOf(maxProfit, p - lowestPrice)
        }
        return maxProfit
    }
}
