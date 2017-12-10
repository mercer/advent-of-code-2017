class Day9 {
    fun input(): String {
        return this::class.java.classLoader.getResource("day9.txt").readText();
    }

    fun first(input: String): Int {
        var escapeNext = false;
        var garbage = false;
        val firstPass = input
            .map { c ->
                when (c) {
                    '!' -> {
                        when {
                            !escapeNext -> escapeNext = true
                            escapeNext -> escapeNext = false
                        }; 'g'
                    }
                    '<' -> {
                        garbage = true; 'g'
                    }
                    '>' -> {
                        when {
                            !escapeNext -> garbage = false
                            else -> escapeNext = false
                        }; 'g'
                    }
                    '{' -> {
                        when {
                            garbage -> {
                                if (escapeNext) escapeNext = false
                                'g'
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
                                'g'
                            }
                            else -> {
                                '}'
                            }
                        }
                    }
                    else -> {
                        when {
                            escapeNext -> escapeNext = false
                        }; 'g'
                    }
                }
            }
            .filter { c -> c != 'g' }
        println(firstPass)

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
}

