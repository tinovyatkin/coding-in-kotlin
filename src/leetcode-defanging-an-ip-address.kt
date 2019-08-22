/*
https://leetcode.com/problems/defanging-an-ip-address/
 */
fun defangIPaddr(address: String): String {
//    return address.replace(".", "[.]")
    // if we can't use replace

    /*
    second fastest on LeetCode
    val stringBuilder = StringBuilder()

    address.forEach {
        if (it == '.') {
            stringBuilder.append("[.]")
        } else {
            stringBuilder.append(it)
        }
    }

    return stringBuilder.toString()
     */

    val sb = StringBuilder();
    address.forEach { char ->
        when (char) {
            '.' -> sb.append("[.]")
            else -> sb.append(char)
        }
    }
    return sb.toString();
}

fun main() {
    println(defangIPaddr("1.1.1.1"))
    println(defangIPaddr("255.100.50.0"))
}