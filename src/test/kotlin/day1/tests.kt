package day1

import ch.tutteli.atrium.api.cc.en_UK.toBe
import ch.tutteli.atrium.verbs.expect.expect
import org.junit.Test

class TestSource {

    @Test
    fun shouldSolveFirstPuzzle() {
        expect(day1.first("1122")).toBe(3)
        expect(day1.first("1111")).toBe(4)
        expect(day1.first("1234")).toBe(0)
        expect(day1.first("91212129")).toBe(9)
    }
}
