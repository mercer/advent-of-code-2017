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
                        escapeNext = false
                        garbage = true
                        'g'
                    }
                    '>' -> {
                        when {
                            !escapeNext -> {
                                garbage = false
                            }
                            else -> {
                                escapeNext = false
                            }
                        }; 'g'
                    }
                    '{' -> {
                        when {
                            garbage -> {
                                escapeNext = false
                                'g'
                            }
                            else -> {
                                escapeNext = false
                                '{'
                            }
                        }
                    }
                    '}' -> {
                        when {
                            garbage -> {
                                escapeNext = false
                                'g'
                            }
                            else -> {
                                escapeNext = false
                                '}'
                            }
                        }
                    }
                    else -> {
                        escapeNext = false
                        'g'
                    }
                }
            }
            .filter { c -> c != 'g' }

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
                        throw RuntimeException("Unexpected character char=" + c)
                    }
                }
            }

        println(firstPass)
        println(secondPass)

        return secondPass
            .reduce { sum, item -> sum + item }
            .toInt()
    }
}

