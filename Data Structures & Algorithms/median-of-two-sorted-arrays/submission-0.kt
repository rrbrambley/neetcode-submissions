class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        var a = nums1
        var b = nums2

        if (a.size > b.size) {
            a = nums2
            b = nums1
        }

        val total = a.size + b.size
        val half = (total + 1) / 2

        var l = 0
        var r = a.size
        while (l <= r) {
            val i = (l + r) / 2
            val j = half - i

            val aLeft = if (i > 0) a[i - 1] else Int.MIN_VALUE
            val aRight = if (i < a.size) a[i] else Int.MAX_VALUE
            val bLeft = if (j > 0) b[j - 1] else Int.MIN_VALUE
            val bRight = if (j < b.size) b[j] else Int.MAX_VALUE

            if (aLeft <= bRight && bLeft <= aRight) {
                // even number of elements, will have to average the two middle
                return if (total % 2 == 0) {
                    (maxOf(aLeft.toDouble(), bLeft.toDouble()) +
                            minOf(aRight.toDouble(), bRight.toDouble())) / 2.0
                } else {
                    maxOf(aLeft.toDouble(), bLeft.toDouble())
                }
            } else if (aLeft > bRight) {
                r = i - 1
            } else {
                l = i + 1
            }
        }
        return -1.0
    }
}
