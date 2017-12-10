class Day9 {
    fun input(): String {
        return this::class.java.classLoader.getResource("day9.txt").readText();
    }

    fun run(input: String): Pair<Int, Int> {
        var isEscapeNext = false;
        var isGarbageSection = false;
        val GARBAGE = 'G'
        val GARBAGE_CONTROL = '#'
        val CANCELLED_GARBAGE = 'C'
        val annotatedInput = input
            .map { c ->
                when (c) {
                    '!' -> {
                        when {
                            !isEscapeNext -> isEscapeNext = true
                            isEscapeNext -> isEscapeNext = false
                        }; GARBAGE_CONTROL
                    }
                    '<' -> {
                        when {
                            isEscapeNext -> {
                                isEscapeNext = false
                                CANCELLED_GARBAGE
                            }
                            isGarbageSection -> {
                                GARBAGE
                            }
                            else -> {
                                isGarbageSection = true
                                GARBAGE_CONTROL
                            }
                        }
                    }
                    '>' -> {
                        when {
                            isEscapeNext -> {
                                isEscapeNext = false
                                CANCELLED_GARBAGE
                            }
                            isGarbageSection -> {
                                isGarbageSection = false
                                GARBAGE_CONTROL
                            }
                            else -> {
                                throw RuntimeException("expected garbage section when encountering not-cancelled '>'")
                            }
                        }
                    }
                    '{' -> {
                        when {
                            isEscapeNext -> {
                                isEscapeNext = false
                                CANCELLED_GARBAGE
                            }
                            isGarbageSection -> {
                                GARBAGE
                            }
                            else -> {
                                '{'
                            }
                        }
                    }
                    '}' -> {
                        when {
                            isEscapeNext -> {
                                isEscapeNext = false
                                CANCELLED_GARBAGE
                            }
                            isGarbageSection -> {
                                GARBAGE
                            }
                            else -> {
                                '}'
                            }
                        }
                    }
                    ',' -> {
                        when {
                            isEscapeNext -> {
                                isEscapeNext = false
                                CANCELLED_GARBAGE
                            }
                            isGarbageSection -> {
                                GARBAGE
                            }
                            else -> {
                                ','
                            }
                        }
                    }
                    else -> {
                        when {
                            isEscapeNext -> {
                                isEscapeNext = false
                                CANCELLED_GARBAGE
                            }
                            else -> {
                                GARBAGE
                            }
                        }
                    }
                }
            }

        val value = 1
        var multiplier = 0
        val firstPartSolution = annotatedInput
            .filter { c -> c !in arrayListOf(GARBAGE, GARBAGE_CONTROL, CANCELLED_GARBAGE) }
            .filter { c -> c != ',' }
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
            }.reduce { sum, item -> sum + item }

        val secondPartSolution = annotatedInput
            .filter { c -> c == GARBAGE }
            .size

        return Pair(firstPartSolution, secondPartSolution)
    }

}

