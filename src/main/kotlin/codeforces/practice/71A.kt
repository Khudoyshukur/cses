package uz.safix.codeforces.practice

import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt(); scanner.nextLine();
    val lines = mutableListOf<String>(); repeat(n) { lines += scanner.nextLine() }
    val modified = lines.map { if (it.length > 10) "${it.first()}${it.length - 2}${it.last()}" else it }

    modified.forEach { println(it) }
}