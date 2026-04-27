class Solution {

    fun checkInclusion(s1: String, s2: String): Boolean {
        if (s1.length > s2.length) return false

        val frequencyCountS1 = getFrequencyCount(s1)
        var i = 0
        for (j in s1.length..s2.length) {
            val permutation = s2.substring(i, j)
            val frequencyCount = getFrequencyCount(permutation)
            if (frequencyCount == frequencyCountS1) return true
            i++
        }

        return false
    }

    private fun getFrequencyCount(s: String): Map<Char, Int> {
        val frequencies = mutableMapOf<Char, Int>()
        for (c in s) {
            frequencies[c] = (frequencies[c] ?: 0) + 1
        }
        return frequencies
    }
}
