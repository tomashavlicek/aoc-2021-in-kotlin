package Day1

import readInputAsInts

fun main() {
    fun part1(input: List<Int>): Int {
        return input.windowed(size = 2).count { it.first() < it.last() }
    }

    fun part2(input: List<Int>): Int {
//        return input.windowed(size = 3).windowed(2).count {
//            (firstWindow, secondWindow) -> firstWindow.sum() < secondWindow.sum()
//        }

        // A + B + C <=> B + C + D ==> A <=> D
        return input.windowed(size = 4).count {
            it.first() < it.last()
        }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInputAsInts("Day1/Day1_test")
    check(part1(testInput) == 7)
    check(part2(testInput) == 5)

    val input = readInputAsInts("Day1/Day1")
    println(part1(input))
    println(part2(input))
}
