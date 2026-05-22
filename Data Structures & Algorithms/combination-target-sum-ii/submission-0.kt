class Solution {
    /**
     * Time Complexity: O(n * 2^n)
     * Space Complexity: O(n)
     */
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        val res = mutableListOf<List<Int>>()
        candidates.sort()

        fun dfs(index: Int, path: MutableList<Int>, current: Int) {
            if (current == target) {
                res.add(ArrayList(path))
                return
            }

            for (i in index until candidates.size) {
                if (i > index && candidates[i] == candidates[i-1]) continue
                if (current + candidates[i] > target) break
                
                path.add(candidates[i])
                dfs(i+1, path, current + candidates[i])
                path.removeAt(path.size - 1)
            }
        }
        
        dfs(0, mutableListOf(), 0)
        return res
    }
}
