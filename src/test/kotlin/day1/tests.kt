package day1

import ch.tutteli.atrium.api.cc.en_UK.toBe
import ch.tutteli.atrium.verbs.expect.expect
import org.junit.Test

class TestSource {

    @Test
    fun shouldSolvePuzzle() {
        expect(day1.run("1122")).toBe(3)
    }
}
