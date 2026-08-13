package uz.safix.solutions

import java.util.Scanner

fun main() {
    val scan = Scanner(System.`in`)
    val n = scan.nextInt()

    var res = 0
    val MOD = 1_000_000_007

    val modMap = mutableMapOf<Int, Int>()
    var calc = 1
    for (i in 0 until n) {
        modMap[i] = calc
        calc = ((calc % MOD) * (2 % MOD)) % MOD
    }

    //println(modMap)

    for (i in 0 until n) {
        res = (res % MOD + modMap[i]!!) % MOD
    }

    print(res + 1)
}