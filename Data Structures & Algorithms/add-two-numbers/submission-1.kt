/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    // this problem relies on us seeing the addition as a pen-and-paper added sum, i.e,
    //  1 2 3
    //+ 4 5 6
    //-------
    //  5 7 9

    // 1. create dummy and initialize current to dummy
    // 2. create pointers p1 and p2 to point to l1 and l2, and carry = 0 to carry tens place when adding
    // 3. while either pointers is not null or carry != 0, sum values from both pointers together, plus carry
    // 4. calculate new carry with sum / 10
    // 5. assign cur.next = ListNode(sum % 10)
    // 6. update cur, p1, and p2 to move onto next loop iteration
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val dummy = ListNode(0)

        var current = dummy
        var carry = 0

        var p1 = l1
        var p2 = l2

        while (p1 != null || p2 != null || carry != 0) {
            val v1 = p1?.`val` ?: 0
            val v2 = p2?.`val` ?: 0
            val sum = v1 + v2 + carry
            carry = sum / 10
            current.next = ListNode(sum % 10)

            current = current.next!!
            p1 = p1?.next
            p2 = p2?.next
        }

        return dummy.next
    }
}
