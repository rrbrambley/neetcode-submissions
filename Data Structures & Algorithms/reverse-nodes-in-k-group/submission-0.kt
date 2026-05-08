/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head
        var groupPrev: ListNode? = dummy
        
        while (true) {
            // if there aren't k left, we leave them as-is by breaking
            val kth = getKth(groupPrev, k) ?: break

            val groupNext = kth.next
            var prev: ListNode? = groupNext
            var curr: ListNode? = groupPrev!!.next
            
            while (curr != groupNext) {
                val tmp = curr!!.next
                curr.next = prev
                prev = curr
                curr = tmp
            }
            
            val tmp = groupPrev.next
            groupPrev.next = kth
            groupPrev = tmp
        }
        
        return dummy.next
    }
    
    private fun getKth(current: ListNode?, k: Int): ListNode? {
        var curr = current
        var k = k
        while (curr != null && k > 0) {
            curr = curr.next
            k--
        }
        
        return curr
    }
}
