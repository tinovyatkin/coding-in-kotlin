/*

https://leetcode.com/problems/remove-vowels-from-a-string/

 */
class Solution {
    fun removeVowels(S: String): String {
//        val vovels: Set<Char> = setOf('a', 'e', 'i', 'o', 'u')
        // return S.asSequence().filterNot { c -> vovels.contains(c) }.joinToString("");
        // correct way from LeetCode
        return S.filter { it !in "aeiou" }.toString()
    }
}

fun main() {
    val solution = Solution();
    println(solution.removeVowels("leetcodeisacommunityforcoders")) // should be  "ltcdscmmntyfrcdrs"
    println(solution.removeVowels("aeiou")) // should be ""
}