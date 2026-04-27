class Solution {

    private val delimiter: Char = '#'

    // example: ["plus", "fi#ve"]
    fun encode(strs: List<String>): String {
        val output: StringBuilder = StringBuilder()
        for (str in strs) {
            output
                .append(str.length)
                .append(delimiter)
                .append(str)
        }
        return output.toString()
    }

    // example: "4#plus5#fi#ve"
    fun decode(str: String): List<String> {
        val decoded = mutableListOf<String>()
        var i = 0
        while (i < str.length) {
            var length = 0
            var j = i
            while (str[j] != delimiter) {
                j += 1
            }
            length = str.substring(i, j).toInt()
            val startIndex = j+1
            val nextString = str.substring(startIndex, startIndex+length)
            decoded.add(nextString)
            i = j + 1 + length
        }
        return decoded
    }
}
