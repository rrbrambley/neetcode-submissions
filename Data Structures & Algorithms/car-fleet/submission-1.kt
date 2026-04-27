class Solution {
    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
        // sort cars by position. each is a Pair<Position, Speed>
        val cars = position.zip(speed).sortedByDescending { it.first }
        val fleets = mutableListOf<Double>()

        for ((p, s) in cars) {
            val timeToDestination = (target - p).toDouble() / s
            fleets.add(timeToDestination)

            // if the latest fleet is going to be surpassed or joined
            // then remove the latest (consider them both one fleet)
            if (fleets.size >= 2 && fleets[fleets.size - 1] <= fleets[fleets.size - 2]) {
                fleets.removeAt(fleets.size - 1)
            }
        }

        return fleets.size
    }
}
