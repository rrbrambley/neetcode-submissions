/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        var merged: ListNode? = null
        val pointers: MutableList<ListNode?> = lists.toMutableList()

        var lowestNode: ListNode? = null
        var lowestIndex: Int? = getLowestIndexOrNull(pointers)


        //
        //   x1.     2.     4.
        //   1.     3.     5.
        //.  3.     6
        //

        while (lowestIndex != null) {
            val nextLowestNode = pointers[lowestIndex]

            if (merged == null) {
                merged = nextLowestNode
            } else {
                lowestNode!!.next = nextLowestNode
            }

            pointers[lowestIndex] = nextLowestNode?.next

            lowestNode = nextLowestNode
            lowestIndex = getLowestIndexOrNull(pointers)
        }

        return merged
    }

    private fun getLowestIndexOrNull(pointers: List<ListNode?>): Int? {
        var lowestIndex: Int? = null
        var lowestValue: Int? = null
        for ((index, pointer) in pointers.withIndex()) {
            if (pointer != null && (lowestValue == null || pointer!!.`val` < lowestValue)) {
                lowestIndex = index
                lowestValue = pointer!!.`val`
            }
        }
        return lowestIndex
    }
}
