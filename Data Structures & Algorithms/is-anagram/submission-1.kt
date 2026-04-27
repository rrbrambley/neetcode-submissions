class Solution {

    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false
        val sSorted = s.toCharArray().sorted()
        val tSorted = t.toCharArray().sorted()
        return sSorted == tSorted
    }
}
