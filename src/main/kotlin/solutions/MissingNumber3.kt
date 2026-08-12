package uz.safix.solutions

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt(); scanner.nextLine()
    val numbersLine = scanner.nextLine().split(" ")

    var sum = 0L
    for (i in numbersLine.indices) { sum += numbersLine[i].toInt() }

    val actualSum = ((1L + n) * n) / 2

    println(actualSum - sum)
}