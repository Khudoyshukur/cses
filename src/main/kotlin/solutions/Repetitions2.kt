package uz.safix.solutions

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val str = scanner.nextLine().trim()

    println(longestSubstringWithoutRepeatingChar(str))
}

private fun longestSubstringWithoutRepeatingChar(str: String): Int {
    var left = 0
    var right = 0
    var res = 0

    while (right < str.length) {
        if (str[right] != str[left]) {
            res = maxOf(res, right - left)
            left = right
        }
        right++
    }
    res = maxOf(res, right - left)

    return res
}