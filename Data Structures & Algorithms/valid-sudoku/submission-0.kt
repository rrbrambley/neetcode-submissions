class Solution {

    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val rows = Array(9) { hashSetOf<Char>() }
        val cols = Array(9) { hashSetOf<Char>() }
        val squares = Array(9) { hashSetOf<Char>() }

        for (r in 0..<9) {
            for (c in 0..<9) {
                val value = board[r][c]
                if (value == '.') continue

                val squareIdx = (r / 3) * 3 + (c / 3)
                if (rows[r].contains(value) || cols[c].contains(value) || squares[squareIdx].contains(value)) {
                    return false
                }
                rows[r].add(value)
                cols[c].add(value)
                squares[squareIdx].add(value)
            }
        }

        return true
    }
}
