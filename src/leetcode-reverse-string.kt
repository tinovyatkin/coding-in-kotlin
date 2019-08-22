/*
```md
# Reverse String

Write a function that reverses a string. The input string is given as an array of characters char[].

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

You may assume all the characters consist of printable ascii characters.

Example 1:

"a", "b", "c", "d"

Input: ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
Example 2:

Input: ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]
```
 */

fun reverseString(s: CharArray): Unit {
    // we will pass till middle and swap in place
    var low = 0;
    var high = s.size - 1

    while(low < high) {
        s[low] = s[high].also { s[high] = s[low] }
        low++;
        high--;
    }
}

fun main() {
    val input1 = charArrayOf('h', 'e', 'l', 'l', 'o');
    print("For input ${input1.toList()}, got ")
    reverseString(input1);
    println(input1.toList());

    val input2 = charArrayOf('A',' ','m','a','n',',',' ','a',' ','p','l','a','n',',',' ','a',' ','c','a','n','a','l',':',' ','P','a','n','a','m','a');
    val str1 = input2.joinToString("");
    print("For input ${input2.toList()}, got ")
    reverseString(input2);
    println(input2.toList());
    reverseString(input2);
    println(input2.toList().joinToString(""));
}
// ["a","m","a","n","a","P"," ",":","l","a","n","a","c"," ","a"," ",",","n","a","l","p"," ","a"," ",",","n","a","m"," ","A"]
// ["a","m","a","n","a","P"," ",":","l","a","n","a","c"," "," ","a",",","n","a","l","p"," ","a"," ",",","n","a","m"," ","A"]