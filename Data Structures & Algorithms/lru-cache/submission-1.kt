
class LRUCache(val capacity: Int) {

    data class LRUNode(
        var key: Int,
        var value: Int,
        var next: LRUNode? = null,
        var prev: LRUNode? = null,
    )

    private val map: MutableMap<Int, LRUNode> = HashMap()
    private var tail: LRUNode = LRUNode(-1, -1)
    private var head: LRUNode = LRUNode(-1, -1)

    init {
        tail.next = head
        head.next = tail
    }

    fun get(key: Int): Int {
        val node = map[key] ?: return -1
        moveToHead(node)
        return node.value
    }

    private fun moveToHead(node: LRUNode) {
        removeNode(node)
        addToFront(node)
    }

    private fun removeNode(node: LRUNode) {
        node.prev?.next = node.next
        node.next?.prev = node.prev
        node.next = null
        node.prev = null
    }

    private fun addToFront(node: LRUNode) {
        node.next = head.next
        node.prev = head

        head.next?.prev = node
        head.next = node
    }

    fun put(key: Int, value: Int) {
        var node = map[key]
        if (node != null) {
            node.value = value
            moveToHead(node)
            return
        } else {
            node = LRUNode(key, value)
            map[key] = node
            addToFront(node)
        }

        capacityCheck()
    }

    private fun capacityCheck() {
        if (map.size > capacity) {
            val lastNode = tail.prev
            if (lastNode != null) {
                removeNode(lastNode)
                map.remove(lastNode.key)
            }
        }
    }
}
