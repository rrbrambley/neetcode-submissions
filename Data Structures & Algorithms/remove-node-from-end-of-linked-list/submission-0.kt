/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val list = mutableListOf<ListNode>()
        var current = head
        while (current != null) {
            list.add(current)
            current = current.next
        }

        val removeIndex = list.size-n
        if (removeIndex == 0) {
            return head?.next
        }

        list[removeIndex-1].next = list[removeIndex].next
        return head
    }
}
