/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reorderList(head: ListNode?) {
        if (head == null) return

        val nodes = mutableListOf<ListNode>()
        var cur: ListNode? = head
        while (cur != null) {
            nodes.add(cur)
            cur = cur.next
        }

        var i = 0
        var j = nodes.size - 1
        while (i < j) {
            nodes[i].next = nodes[j]
            i++
            if (i >= j) break
            nodes[j].next = nodes[i]
            j--
        }

        nodes[i].next = null
    }
}
