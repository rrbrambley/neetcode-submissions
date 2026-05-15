class KthLargest(k: Int, nums: IntArray) {

    private val k = k
    private val minHeap = PriorityQueue<Int>()
    
    init {
        nums.forEach { minHeap.offer(it) }
        while (minHeap.size > k) {
            minHeap.poll()
        }
    }
    
    fun add(`val`: Int): Int {
        minHeap.offer(`val`)
        if (minHeap.size > k) {
            minHeap.poll()
        }
        return minHeap.peek()
    }
}
