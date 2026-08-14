package uz.safix.solutions

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val str = scanner.nextLine()

    // the str only contains uppercase letters, so we can use IntArray of size 26 to count letters
    // to be able to form a palindrome, each letter should be even times in the str

    val letterCount = IntArray(26)
    for (ch in str) { letterCount[ch - 'A']++ }

    val oddCount = letterCount.count { it % 2 != 0 }
    if (oddCount > 1 || (oddCount == 1 && str.length % 2 == 0)) {
        println("NO SOLUTION")
        return
    }

    val res = StringBuilder(str)
    var currIndex = 0
    for (i in letterCount.indices) {
        while (letterCount[i] > 1) {
            val char = 'A' + i
            res.setCharAt(currIndex, char)
            res.setCharAt(res.lastIndex - currIndex, char)

            currIndex++
            letterCount[i] -= 2
        }
    }
    for (i in letterCount.indices) {
        if (letterCount[i] == 1) {
            res.setCharAt(currIndex, ('A' + i))
            break
        }
    }

    println(res)
}