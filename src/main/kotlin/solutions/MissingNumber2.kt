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

// using set
private fun missingNumber(numbers: IntArray): Int {
    val set = BooleanArray(numbers.size + 1)

    for (num in numbers) {
        set[num - 1] = true
    }

    for (i in set.indices) {
        if (!set[i]) return i + 1
    }

    return set.size + 1
}