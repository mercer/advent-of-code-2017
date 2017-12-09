import ch.tutteli.atrium.api.cc.en_UK.toBe
import ch.tutteli.atrium.verbs.expect.expect
import org.junit.Test

class Day9Test {

    @Test
    fun first_1() {
        expect(Day9().first("{}")).toBe(1)
    }

    @Test
    fun first_2() {
        expect(Day9().first("{{{}}}")).toBe(6)
    }

    @Test
    fun first_3() {
        expect(Day9().first("{{},{}}")).toBe(5)
    }

    @Test
    fun first_4() {
        expect(Day9().first("{{{},{},{{}}}}")).toBe(16)
    }

    @Test
    fun first_5() {
        expect(Day9().first("{<a>,<a>,<a>,<a>}")).toBe(1)
    }

    @Test
    fun first_6() {
        expect(Day9().first("{{<ab>},{<ab>},{<ab>},{<ab>}}")).toBe(9)
    }

    @Test
    fun first_7() {
        expect(Day9().first("{{<!!>},{<!!>},{<!!>},{<!!>}}")).toBe(9)
    }

    @Test
    fun first_8() {
        expect(Day9().first("{{<a!>},{<a!>},{<a!>},{<ab>}}")).toBe(3)
    }

    @Test
    fun first_9() {
        expect(Day9().first("{{<a!>},{<a!>},{<a!!>},{<ab>}}")).toBe(5) // 1 + 2 + 2
    }

    @Test
    fun first_10() {
        expect(Day9().first("{<{},{},{{}}>}")).toBe(1) // 1
    }

    @Test
    fun first_11() {
        expect(Day9().first("{<!!!>>}")).toBe(1) // 1
    }

    @Test
    fun first_12() {
        expect(Day9().first("{<{o\"i!a,<{i<a>}")).toBe(1) // 1
    }

    @Test
    fun first_13() {
        expect(Day9().first("{{<!>},{<!>},{<!>},{<a>}}")).toBe(3) // 1 + 2
    }

    @Test
    fun first_14() {
        expect(Day9().first("{{<!>}}},{<!>},{<!!>}}")).toBe(3) // 1 + 2
    }

    @Test
    fun first_15() {
        expect(Day9().first("{{<!}>}}")).toBe(3) // 1 + 2
    }

    @Test
    fun first_16() {
        expect(Day9().first("{{<!}>}{}}")).toBe(5) // 1 + 2 + 2
    }

    @Test
    fun first_17() {
        expect(Day9().first("{<!!!!>{}}")).toBe(3) // 1 + 2
    }

    @Test
    fun first_18() {
        expect(Day9().first("{<!!!!!>{}>}")).toBe(1) // 1
    }

    @Test
    fun shouldSolveSecondPuzzle() {
    }
}
