class Solution {
    val result = mutableListOf<String>()
    val stack = ArrayDeque<Char>()

    fun generateParenthesis(n: Int): List<String> {

        fun backtrack(openN: Int, closedN: Int) {
            if (openN == closedN && openN == n) {
                result.add(stack.joinToString(""))
                return
            }
            
            if (openN < n) {
                stack.add('(')
                backtrack(openN + 1, closedN)
                stack.removeLast()
            }
            
            if (closedN < openN) {
                stack.add(')')
                backtrack(openN, closedN + 1)
                stack.removeLast()
            }
        }

        backtrack(0, 0)
        return result
    }
}
