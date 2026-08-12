package uz.safix.solutions

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt(); scanner.nextLine()
    val numbers = IntArray(n - 1)
    val numbersLine = scanner.nextLine().split(" ")

    for (i in numbers.indices) { numbers[i] = numbersLine[i].toInt() }

    println(missingNumber(numbers))
}

// sort the array, and find a missing number
private fun missingNumber(numbers: IntArray): Int {
    val sorted = numbers.sorted()
    if (sorted[0] != 1) return 1

    for (i in 1 until sorted.size) {
        if ((sorted[i] - sorted[i - 1] != 1)) {
            return sorted[i] - 1
        }
    }

    return numbers.size + 1
}