class Solution {
    
    /**
      for each str in strs
       sorted = sort(str)
       if (anagrams.contains(sorted))
         anagrams[sorted].add(str)
       else
         anagrams[sorted] = mutableListOf<String>(str)
    */

    private val anagrams = mutableMapOf<String, MutableList<String>>()

    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        for (str in strs) {
            val sorted: String = str.toCharArray().sorted().joinToString("")

            if (anagrams.contains(sorted)) {
                anagrams[sorted]!!.add(str)
            } else {
                anagrams[sorted] = mutableListOf(str)
            }
        }

        return anagrams.values.toList()
    }
}
