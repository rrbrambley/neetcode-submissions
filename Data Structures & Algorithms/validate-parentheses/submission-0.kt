class Solution {

    val stack = Stack<Char>()


    fun isValid(s: String): Boolean {
        // Iterate through the string, pushing opening brackets onto the stack
        // and popping the corresponding closing bracket from the stack
        // when a closing bracket is encountered.
        for (c in s) {
            when (c) {
                '(', '{', '[' -> stack.push(c)
                ')' -> if (stack.isEmpty() || stack.pop() != '(') return false
                '}' -> if (stack.isEmpty() || stack.pop() != '{') return false
                ']' -> if (stack.isEmpty() || stack.pop() != '[') return false
            }
        }
        return stack.isEmpty()
    }
}
