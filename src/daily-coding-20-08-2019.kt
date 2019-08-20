import java.util.stream.Stream
import kotlin.streams.asStream

/**

This problem was asked by Microsoft.

Compute the running median of a sequence of numbers. That is, given a stream of numbers, print out the median of the list so far on each new element.

Recall that the median of an even-numbered list is the average of the two middle numbers.

For example, given the sequence [2, 1, 5, 7, 2, 0, 5], your algorithm should print out:

2
1.5
2
3.5
2
2
2

 */

fun findMedian(seq: Iterable<Int>) {
    var m1 = 0; // middle-left number
    val idx1 = 0;
    var m2 = 0; // middle-right number
    val idx2 = 0;
    val iterator = seq.iterator().withIndex();
    while(iterator.hasNext()) {

        println(iterator.next())
    }
}

fun main() {
    findMedian(listOf(2, 1, 5, 7, 2, 0, 5));
}