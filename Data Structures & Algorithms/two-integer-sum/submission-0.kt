class Solution {
    // compliment : indexOfCompliment
    private val complimentsMap = mutableMapOf<Int, Int>()
    
    fun twoSum(nums: IntArray, target: Int): IntArray {
        for ((index, value) in nums.withIndex()) {
            val compliment = target - value
            val complimentIndex = complimentsMap.get(compliment)
            if (complimentIndex != null) {
                return intArrayOf(complimentIndex, index)
            }
            complimentsMap[value] = index
        }
        return intArrayOf()
    }
}
