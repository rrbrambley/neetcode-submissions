class Solution {
fun findKthLargest(nums: IntArray, k: Int): Int {
    val pq = PriorityQueue<Int>()
    nums.onEach {
        pq.offer(it)
        if (pq.size > k) pq.poll()
    }
    return pq.peek()
}
}
