class MinStack() {
    var mins = Stack<Int>()
    val stack = Stack<Int>()

    fun push(`val`: Int) {
        stack.push(`val`)
        if (mins.isEmpty()) {
            mins.push(`val`)
        } else {
            mins.push(minOf(mins.peek(), `val`))
        }
    }

    fun pop() {
        val popped = stack.pop()
        mins.pop()
    }

    fun top(): Int {
        return stack.peek()
    }

    fun getMin(): Int {
        return mins.peek()
    }
}
