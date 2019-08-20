/*

Longest common substring:

https://ru.wikipedia.org/wiki/%D0%9D%D0%B0%D0%B8%D0%B1%D0%BE%D0%BB%D1%8C%D1%88%D0%B0%D1%8F_%D0%BE%D0%B1%D1%89%D0%B0%D1%8F_%D0%BF%D0%BE%D0%B4%D1%81%D1%82%D1%80%D0%BE%D0%BA%D0%B0
https://en.wikipedia.org/wiki/Generalized_suffix_tree
https://github.com/trekhleb/javascript-algorithms/tree/master/src/algorithms/string/longest-common-substring
 */

//import java.util.Arrays
import kotlin.math.abs
import kotlin.math.min

/**
 * @see {@link https://rosettacode.org/wiki/Longest_Common_Substring#Kotlin }
 */
fun lcs(a: String, b: String): String {
    if (a.length > b.length) return lcs(b, a)
    var res = ""
    for (ai in 0 until a.length) {
        for (len in a.length - ai downTo 1) {
            for (bi in 0 until b.length - len) {
                if (a.regionMatches(ai, b, bi, len) && len > res.length) {
                    res = a.substring(ai, ai + len)
                }
            }
        }
    }
    return res
}

/*
 LCS using dynamic programming: https://github.com/trekhleb/javascript-algorithms/tree/master/src/algorithms/string/longest-common-substring
 */
fun lcsPerf(a: String, b: String): Int {
    // Создаем матрицу a.length + 1 x b.length + 1
    // IntArray инициирован нулями по-умолчанию
    val matrix = Array(a.length + 1) { IntArray(b.length + 1) }

    // Build the matrix of all substring lengths to use Dynamic Programming approach.
    var longestSubstringLength = 0

    for (row in 1..a.length) {
        for (col in 1..b.length) {
            if (a[row - 1] == b[col - 1]) matrix[row][col] = matrix[row - 1][col - 1] + 1
            // Try to find the biggest length of all common substring lengths
            // and to memorize its last character position (indices)
            if (matrix[row][col] > longestSubstringLength) longestSubstringLength = matrix[row][col]
        }
    }

    // print array
//    println(Arrays.deepToString(matrix))
//    println(longestSubstringLength)

    return longestSubstringLength;
}