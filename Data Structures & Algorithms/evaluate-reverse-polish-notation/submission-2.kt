class Solution {
    fun evalRPN(tokens: Array<String>): Int {
        val stack = Stack<Int>()
        for (token in tokens) {
            when (token) {
                "+" -> {
                    var a = stack.pop()
                    var b = stack.pop()
                    stack.push(b + a)
                }

                "-" -> {
                    var a = stack.pop()
                    var b = stack.pop()
                    stack.push(b - a)
                }

                "*" -> {
                    var a = stack.pop()
                    var b = stack.pop()
                    stack.push(b * a)
                }

                "/" -> {
                    var a = stack.pop()
                    var b = stack.pop()
                    stack.push(b / a)
                }

                else -> {
                    stack.push(token.toInt())
                }
            }
        }
        return stack.pop().toInt()
    }
}
