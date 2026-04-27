class Solution {
    
    private val anagrams = mutableMapOf<List<Int>, MutableList<String>>()

    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        for (str in strs) {
            val counts = getLetterCounts(str)
            anagrams.getOrPut(counts, { mutableListOf() }).add(str)
        }

        return anagrams.values.toList()
    }

    private fun getLetterCounts(s: String): MutableList<Int> {
        val count = MutableList(26) { 0 }
        for (c in s) {
            count[c - 'a']++
        }
        return count
    }
}
