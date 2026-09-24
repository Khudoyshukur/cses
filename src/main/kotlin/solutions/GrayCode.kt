package uz.safix.solutions

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    if (!scanner.hasNextInt()) return
    val n = scanner.nextInt()

    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val total = 1 shl n // 2^n

    for (i in 0 until total) {
        val g = i xor (i ushr 1)

        // Append n bits from MSB to LSB
        for (bit in n - 1 downTo 0) {
            val b = (g ushr bit) and 1
            bw.write(if (b == 1) '1'.code else '0'.code)
        }
        bw.newLine()
    }
    bw.flush()
}