
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

/*

Reasoning:

let's keep array of 4 Ints = [0, 0, 0, 0];

vars:

v - our array of 4 numbers
idx - current number index in stream
n - current value

steps:

idx === 0: put n at v[1]
ids === 1: if(n > v[1]) v[2] = n; else { v.unshift(0); v[1] = n; }
ids === 2: if(n < v[1]) v[0] = n; else { if(n < v[2]) { v[3] = v[2]; v[2] = n };  else {v[3] = n} }
ids === 3: v += n; v.sort().slice(0)

next steps


return (v[1] + v[2]) / 2

 */

fun findMedian(seq: Iterable<Int>) {
    val allint = mutableListOf<Int>();
    var heap = mutableListOf<Int>();
    val iterator = seq.iterator().withIndex();
    while (iterator.hasNext()) {
        val n = iterator.next();
        allint.add(n.value);
        when (n.index) {
            0, 1 -> {
                heap.add(n.value); println(heap.average())
            }
            2, 3 -> {
                heap.add(n.value);
                heap.sort();
                println(heap);
                // if len is even, then return average of middle
                // else return just one middle element
                if ((n.index + 1) % 2 == 0) println(heap.slice(1..2).average())
                else println(heap[1])
            }
            else -> {
                if (n.value <= heap[0]) {
                    // put it at start and remove last element
                    heap.add(0, n.value)
                    heap.removeAt(4)
                } else if (n.value >= heap[3]) {
                    // put it at end and remove first element
                    heap.add(n.value)
                    heap.removeAt(0);
                } else {
                    // put it into the list, sort, and remove last one
                    heap.add(n.value);
                    heap.sort();
                    heap.removeAt(4);
                }
                println("For list: ${ allint.sorted() } (size: ${allint.size}), heap is: ${heap}");
                if (n.index % 2 == 0) println(heap.slice(1..2).average())
                else println(heap.slice(2..3).average())
            }

        }

    }
}

fun main() {
    findMedian(listOf(2, 1, 5, 7, 2, 0, 5, -1, 10, 0, 5, 4, 4, 4, 4));
}