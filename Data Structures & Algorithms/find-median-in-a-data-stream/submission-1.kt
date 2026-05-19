class MedianFinder {

    // small is maxHeap, large is minHeap
    private val small = PriorityQueue<Int>(compareByDescending { it })
    private val large = PriorityQueue<Int>()

    fun addNum(num: Int) {
        if (large.isNotEmpty() && num > large.peek()) {
            large.offer(num)
        } else {
            small.offer(num)
        }

        // Rebalance
        if (small.size > large.size + 1) {
            large.add(small.poll())
        }
        if (large.size > small.size + 1) {
            small.add(large.poll())
        }
    }

    fun findMedian(): Double {
        return when { 
            small.size > large.size -> small.peek().toDouble()
            large.size > small.size -> large.peek().toDouble()
            else -> (small.peek() + large.peek()).toDouble() / 2.0
        }
    }
}
