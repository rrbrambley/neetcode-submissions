class Solution {
    fun combinationSum(nums: IntArray, target: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        nums.sort()

        fun dfs(i: Int, cur: MutableList<Int>, total: Int) {
            if (total == target) {
                result.add(cur.toList())
                return
            }

            for (j in i until nums.size) {
                if (total + nums[j] > target) {
                    break
                }
                cur.add(nums[j])
                dfs(j, cur, total + nums[j])
                cur.removeAt(cur.lastIndex)
            }
        }

        dfs(0, mutableListOf(), 0)
        return result
    }
}
