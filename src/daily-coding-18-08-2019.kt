/*

 This problem was asked by Google.

The edit distance between two strings refers to the minimum number of character insertions,
deletions, and substitutions required to change one string to the other.
For example, the edit distance between “kitten” and “sitting” is three: substitute the “k” for “s”, substitute the “e” for “i”, and append a “g”.

Given two strings, compute the edit distance between them.

 */

/**
 * Way to improve naive implementation - find longest common substring (will be O(a.length * b.length)),
 * split string by it and analyze return editPathLen(prefixA, prefixB) + editPathLen(suffixA, suffixB)
 */

import kotlin.math.min

fun editPathLen(a: String, b: String): Int {
    if (a.isEmpty()) return b.length;
    if (b.isEmpty()) return a.length;
    if (b.length == 1) {
        if (a == b) return 0;
        return 1;
    }
    if (a.length == 1) {
        // b is longer than 1 character here
        if (a[0] == b[0]) return b.length - 1;
        // if a != b[0] then we need to replace a and add b.length - 1 characters
        return b.length;
    }
    // a and b is longer than 1 character at this point
    if (a[0] == b[0]) return editPathLen(a.substring(1), b.substring(1));
    val shortenA = a.substring(1);
    val removingLen = editPathLen(shortenA, b);
    val replacingLen = editPathLen(b[0] + shortenA, b);
    return 1 + min(removingLen, replacingLen);
}

fun main() {
    print("Edit distance: ");
    println(editPathLen("kitten", "sitting"))
}