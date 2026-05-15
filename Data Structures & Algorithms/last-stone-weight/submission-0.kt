class Solution {
    val heap = PriorityQueue<Int>()

    fun lastStoneWeight(stones: IntArray): Int {
        stones.forEach { heap.offer(-it) }

        while (heap.size > 1) {
            val x = heap.poll()
            val y = heap.poll()
            if (x == y) continue
            heap.offer( x-y)
        }

        return abs(heap.poll() ?: 0)
    }
}
