class Day1 {
    fun input(): String {
        return this::class.java.classLoader.getResource("day1.txt").readText();
    }

    fun first(input: String): Int {
        return input
            .mapIndexed { i, c -> if (hasTwin(c, input, i, 1)) c.toString().toInt() else 0 }
            .reduce { sum, element -> sum + element }
    }

    fun second(input: String): Int {
        return input
            .mapIndexed { i, c -> if (hasTwin(c, input, i, input.length / 2)) c.toString().toInt() else 0 }
            .reduce { sum, element -> sum + element }
    }

    private fun hasTwin(c: Char, input: String, index: Int, steps: Int): Boolean {
        return c == input[(index + steps) % input.length]
    }

}

fun main(args: Array<String>) {
    println(Day1().first(Day1().input()))
    println(Day1().second(Day1().input()))
}


