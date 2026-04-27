class Solution {
    
    fun threeSum(nums: IntArray): List<List<Int>> {
        val sorted = nums.sorted()
        val result = mutableListOf<List<Int>>()

        //find beginning of triplet
        for (i in sorted.indices) {
            val a = sorted[i]
            if (i > 0 && sorted[i - 1] == a)  {
                continue
            }

            //do Two pointers solution with l = i + 1; r = last index, sliding inwards
            var l = i + 1
            var r = sorted.lastIndex

            while (l < r) {
                val threeSum = a + sorted[l] + sorted[r]
                when {
                    threeSum > 0 -> r--
                    threeSum < 0 -> l++
                    else -> {
                        result.add(listOf(a, sorted[l], sorted[r]))
                        l++
                        while (l < r && sorted[l] == sorted[l - 1]) {
                            l++
                        }
                    }
                }
            }
        }
        return result
    }
}
