class Solution {
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    fun isPalindrome(s: String): Boolean {
        var l = 0
        var r = s.length-1

        while (l < r) {
            // find next alphanumeric char on left end
            while (l < r && !s[l].isLetterOrDigit()) {
                l++
            }
            // find next alphanumeric char on right end
            while (r > l && !s[r].isLetterOrDigit()) {
                r--
            }

            if (s[l].lowercase() != s[r].lowercase()) {
                return false
            }
            l++
            r--
        }
        
        return true
    }
}
