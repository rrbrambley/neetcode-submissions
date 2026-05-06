/*
// Definition for a Node.
class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}
*/

class Solution {
    fun copyRandomList(head: Node?): Node? {
        // map old node to its new one
        val nodes = mutableMapOf<Node?, Node?>()

        var c = head
        while (c != null) {
            val newNode = Node(c.`val`)
            nodes[c] = newNode
            c = c.next
        }

        c = head
        while (c != null) {
            val newNode = nodes[c]
            newNode?.next = nodes[c.next]
            newNode?.random = nodes[c.random]
            c = c.next
        }

        return nodes[head]
    }
}
