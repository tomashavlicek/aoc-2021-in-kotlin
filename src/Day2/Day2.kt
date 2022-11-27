package Day2

import readInput

fun main() {

    data class Operation(val operation: String, val amount: Int)

    fun part1(input: List<String>): Int {
        var horizontalPosition = 0
        var depth = 0
        val operations = input.map { it.split(' ') }.map { Operation(operation = it[0], amount = it[1].toInt()) }
        for ((direction, amount) in operations) {
            when (direction) {
                "forward" -> horizontalPosition += amount
                "down" -> depth += amount
                "up" -> depth -= amount
            }
        }
        return horizontalPosition * depth
    }

    fun part2(input: List<String>): Int {
        var horizontalPosition = 0
        var depth = 0
        var aim = 0
        val operations = input.map { it.split(' ') }.map { Operation(operation = it[0], amount = it[1].toInt()) }
        for ((direction, amount) in operations) {
            when (direction) {
                "forward" -> {
                    horizontalPosition += amount
                    depth += aim * amount
                }
                "down" -> aim += amount
                "up" -> aim -= amount
            }
        }
        return horizontalPosition * depth
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day2/Day2_test")
    check(part1(testInput) == 150)
    check(part2(testInput) == 900)

    val input = readInput("Day2/Day2")
    println(part1(input))
    println(part2(input))
}