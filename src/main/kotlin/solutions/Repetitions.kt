package uz.safix.solutions

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val str = scanner.nextLine().trim()

    println(longestSubstringWithoutRepeatingChar(str))
}

private fun longestSubstringWithoutRepeatingChar(str: String): Int {
    // the string only contains letters ACGT
    // lets map then as 0 1 2 3
    val lettersCount = IntArray(4)

    var left = 0
    var right = 0
    var res = 0
    while (right < str.length) {
        lettersCount[str[right++].mIndex]++

        if (lettersCount.isValid()) {
            res = maxOf(res, right - left)
        } else {
            while (lettersCount.isValid().not()) {
                lettersCount[str[left++].mIndex]--
            }
        }
    }
    res = maxOf(res, right - left)

    return res
}

private val Char.mIndex get() = when (this) {
    'A' -> 0
    'C' -> 1
    'G' -> 2
    else -> 3
}

private fun IntArray.isValid(): Boolean {
    val sum = this.sum()
    return this.any { it == sum }
}