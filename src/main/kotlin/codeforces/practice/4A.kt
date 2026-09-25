package uz.safix.codeforces.practice

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()

    val res = if (n % 2 == 0 && n > 2) "YES" else "NO"
    print(res)
}
