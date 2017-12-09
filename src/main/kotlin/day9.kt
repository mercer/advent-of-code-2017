class Day9 {
    fun input(): String {
        return this::class.java.classLoader.getResource("day9.txt").readText();
    }

    fun first(input: String): Int {
        // {{<a!>},{<a!>},{<a!>},{<ab>}}

        // {{<a!>},{<a!>},{<a!>},{<ab>}}
        var escapeNext = false;
        var garbage = false;
        val firstPass = input
            .map { c ->
                when (c) {
                    '!' -> {
                        when {
                            !escapeNext -> escapeNext = true
                            escapeNext -> escapeNext = false
                        }; '-'
                    }
                    '<' -> {
                        garbage = true; '-'
                    }
                    '>' -> {
                        when {
                            !escapeNext -> garbage = false
                            else -> escapeNext = false
                        }; '-'
                    }
                    '{' -> {
                        when {
                            garbage -> {
                                if (escapeNext) escapeNext = false
                                '-'
                            }
                            else -> {
                                '{'
                            }
                        }
                    }
                    '}' -> {
                        when {
                            garbage -> {
                                if (escapeNext) escapeNext = false
                                '-'
                            }
                            else -> {
                                '}'
                            }
                        }
                    }
                    else -> {
                        when {
                            escapeNext -> escapeNext = false
                        }; '-'
                    }
                }
            }

        // 12000000200000020000002000000 should be
        // 12000000000000000000000000000
        val value = 1
        var multiplier = 0
        val secondPass = firstPass
            .map { c ->
                when (c) {
                    '{' -> {
                        multiplier++
                        value * multiplier
                    }
                    '}' -> {
                        multiplier--
                        0
                    }
                    else -> {
                        0
                    }
                }
            }
        println(secondPass)

        return secondPass
            .reduce { sum, item -> sum + item }
            .toInt()
    }

    fun second(input: String): Int {
        return 0
    }

}

fun main(args: Array<String>) {
    println(Day9().first(Day9().input()))
    println(Day9().second(Day9().input()))
}


