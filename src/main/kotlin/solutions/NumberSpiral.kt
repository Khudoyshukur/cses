package uz.safix.solutions

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val t = scanner.nextInt(); scanner.nextLine()

    val res = mutableListOf<Long>()
    repeat(t) {
        val test = scanner.nextLine().trim().split(" ")
        val row = test[0].toLong(); val col = test[1].toLong()

        val max = maxOf(row, col)

        if (max % 2 == 1L) {
            if (row == col) {
                res.add((row * row) - (row - 1))
            } else if (row > col) {
                res.add(((row - 1) * (row - 1)) + col)
            } else {
                res.add((col * col) - (row - 1))
            }
        } else {
            if (row == col) {
                res.add((row * row) - (row - 1))
            } else if (row > col) {
                res.add((row * row) - (col - 1))
            } else {
                res.add(((col - 1) * (col - 1)) + row)
            }
        }
    }

    println(res.joinToString(separator = "\n"))
}