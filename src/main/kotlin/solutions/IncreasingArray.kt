package uz.safix.solutions

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt(); scanner.nextLine();
    val numbersLine = scanner.nextLine().trim().split(" ")
    val numbers = LongArray(n)
    for (i in numbersLine.indices) { numbers[i] = numbersLine[i].toLong() }

    println(increasingArraySteps(numbers))
}

private fun increasingArraySteps(arr: LongArray): Long {
    var steps = 0L

    for (i in 1 until arr.size) {
        if (arr[i] >= arr[i - 1]) continue

        steps += (arr[i - 1] - arr[i])
        arr[i] = arr[i - 1]
    }

    return steps
}