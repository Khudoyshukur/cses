package uz.safix.solutions

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    var n = scanner.nextLong()

    val res = StringBuilder("$n")

    while (n != 1L) {
        if (n % 2 == 0L) {
            n /= 2
        } else {
            n = n * 3 + 1
        }

        res.append(" $n")
    }

    println(res)
}

