class Solution {

    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()
        
        for (c in s) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c)
            } else if (
                (c == ')' && (stack.isEmpty() || stack.pop() != '(')) ||
                (c == ']' && (stack.isEmpty() || stack.pop() != '[')) ||
                (c == '}' && (stack.isEmpty() || stack.pop() != '{'))
            ) {
                return false
            }
        }
        return stack.isEmpty()
    }
}
