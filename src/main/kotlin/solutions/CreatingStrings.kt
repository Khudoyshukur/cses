package uz.safix.solutions

import java.util.Scanner

fun main() {
    val scan = Scanner(System.`in`)

    val s = scan.nextLine().trim()

    val chars = IntArray(26)
    s.forEach { chars[it - 'a']++ }

    val res = mutableSetOf<String>()
    fun generate(state: IntArray, path: StringBuilder) {
        if (path.length == s.length) {
            res.add(path.toString())
            return
        }

        for (i in state.indices) {
            if (state[i] == 0) continue

            state[i]--
            path.append((i + 'a'.code).toChar())

            generate(state, path)

            state[i]++
            path.deleteCharAt(path.lastIndex)
        }
    }
    generate(chars, StringBuilder())

    println(res.size)
    println(res.joinToString(separator = "\n"))
}