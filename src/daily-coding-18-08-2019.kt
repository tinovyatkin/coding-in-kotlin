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

fun editPathLen(a: String, b: String, cache: MutableMap<String, MutableMap<String, Int>> = mutableMapOf()): Int {
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
    val shortenA = a.substring(1);
    if (a[0] == b[0]) {
        val shortenB = b.substring(1);
        val nextStep = editPathLen(shortenA, shortenB, cache);
        if(!cache.contains(shortenA)) cache[shortenA] = mutableMapOf(shortenB to nextStep);
        else cache[shortenA]!![shortenB] = nextStep;
        return nextStep;
    };
    // check memoisation
    val subcache = cache.get(a);
    if(subcache != null) {
        val res = subcache.get(b);
        if(res != null) {
            print("Found cache for ");
            print(a);
            print(": ")
            println(cache[a]);
            return res;
        }
    }
    val removingLen = editPathLen(shortenA, b, cache);
    if(!cache.contains(shortenA)) cache[shortenA] = mutableMapOf(b to removingLen);
    else cache[shortenA]!![b] = removingLen;
    val replacingLen = editPathLen(b[0] + shortenA, b, cache);
    return 1 + min(removingLen, replacingLen);
}

fun main() {
    println("Edit distance: ");
    println(editPathLen("kitten", "sitting"))
}