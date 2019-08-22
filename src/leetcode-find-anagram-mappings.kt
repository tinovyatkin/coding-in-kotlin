/*
https://leetcode.com/problems/find-anagram-mappings/
 */
fun anagramMappings(A: IntArray, B: IntArray): IntArray {
    val bMap = mutableMapOf<Int, Int>()
    B.forEachIndexed { index, i -> bMap.set(i, index) }
    return A.map { i -> bMap.getOrDefault(i, -1) }.toIntArray()
}

fun main() {
    println(anagramMappings(intArrayOf(12, 28, 46, 32, 50), intArrayOf(50, 12, 32, 46, 28)).toList())
}