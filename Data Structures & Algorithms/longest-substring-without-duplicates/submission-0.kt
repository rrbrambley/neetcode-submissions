class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val charSet = mutableSetOf<Char>()
        var l = 0
        var longestLength = 0

        for (r in s.indices) {
            while (s[r] in charSet) {
                charSet.remove(s[l])
                l++
            }

            charSet.add(s[r])
            longestLength = maxOf(longestLength, r - l + 1)
        }

        return longestLength
    }
}
