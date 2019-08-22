/*
https://leetcode.com/problems/armstrong-number/

The k-digit number N is an Armstrong number if and only if the k-th power of each digit sums to N.

Given a positive integer N, return true if and only if it is an Armstrong number.

Example 1:

Input: 153
Output: true
Explanation:
153 is a 3-digit number, and 153 = 1^3 + 5^3 + 3^3.
Example 2:

Input: 123
Output: false
Explanation:
123 is a 3-digit number, and 123 != 1^3 + 2^3 + 3^3 = 36.

 */
import kotlin.math.log10;
import kotlin.math.ceil;
import kotlin.math.pow;

fun isArmstrong(N: Int): Boolean {
    val len = ceil(log10(N.toDouble())).toInt()
    var num = N % 10
    var sum = 0;
    var left = N / 10
    while(left + num > 0 && sum < N) {
//        println("num: ${num}, sum: ${sum}, left: ${left}")
        sum += num.toDouble().pow(len).toInt()
        num = left % 10
        left /= 10
    }
    return sum == N
}

fun main() {
    println("1 is armstrong: ${isArmstrong(1)}")
    println("10 is armstrong: ${isArmstrong(10)}")
    println("153 is armstrong: ${isArmstrong(153)}")
    println("123 is armstrong: ${isArmstrong(123)}")
}