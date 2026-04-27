class Solution {

    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false
        val sCounts = getLetterCounts(s)
        val tCounts = getLetterCounts(t)
        return sCounts == tCounts
    }

    private fun getLetterCounts(s: String): Map<Char, Int> {
        val charCount = mutableMapOf<Char, Int>()
        s.map { charCount[it] = (charCount[it] ?: 0) + 1 }
        return charCount
    }
}
