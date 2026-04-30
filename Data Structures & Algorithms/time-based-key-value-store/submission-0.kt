class TimeMap() {
    val map = mutableMapOf<String, MutableList<Pair<String, Int>>>()

    // every successive set() must have increased time
    //
    fun set(key: String, value: String, timestamp: Int) {
        val values = map.getOrDefault(key, mutableListOf())
        values.add(Pair(value, timestamp))
        map[key] = values
    }

    // for any given key, the list of values' times should be sorted ascending,
    // because every successive set() must have increased time
    // get operation worst case is a O(logn) operation
    fun get(key: String, timestamp: Int): String {
        var result = ""

        val values = map.getOrDefault(key, mutableListOf())
        var l = 0
        var r = values.size - 1
        while (l <= r) {
            val m = (l + r) / 2

            if (values[m].second <= timestamp) {
                result = values[m].first
                l = m + 1
            } else {
                r = m - 1
            }
        }

        return result
    }
}
