import ch.tutteli.atrium.api.cc.en_UK.toBe
import ch.tutteli.atrium.verbs.expect.expect
import org.junit.Test

class Day1Test {

    @Test
    fun shouldSolveFirstPuzzle() {
        expect(Day1().first("1122")).toBe(3)
        expect(Day1().first("1111")).toBe(4)
        expect(Day1().first("1234")).toBe(0)
        expect(Day1().first("91212129")).toBe(9)
    }

    @Test
    fun shouldSolveSecondPuzzle() {
        expect(Day1().second("1212")).toBe(6)
        expect(Day1().second("1221")).toBe(0)
        expect(Day1().second("123425")).toBe(4)
        expect(Day1().second("123123")).toBe(12)
        expect(Day1().second("12131415")).toBe(4)
    }
}
