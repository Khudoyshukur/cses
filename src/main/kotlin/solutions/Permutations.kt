package uz.safix.solutions

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()

    val result = permutations(n)
    if (result.isNotEmpty()) {
        println(result.joinToString(separator = " "))
    } else {
        println("NO SOLUTION")
    }
}

private fun permutations(n: Int): List<Int> = buildList {
    if (n == 1) return listOf(1)
    if (n <= 3) return@buildList

    for (i in 2..n step 2) { add(i) }
    for (i in 1..n step 2) { add(i) }
}