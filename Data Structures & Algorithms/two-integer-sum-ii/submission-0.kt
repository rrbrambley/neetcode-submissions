class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var i = 0
        var j = numbers.lastIndex
        while (i < j) {
            if (numbers[i] + numbers[j] > target) {
                j--
            } else if (numbers[i] + numbers[j] < target) {
                i++
            } else {
                // add one to each index only because this calls for 1-based indices
                // (which is just kind of a random nuance of this problem)
                return intArrayOf(i+1, j+1)
            }
        }
        return intArrayOf()
    }
}
