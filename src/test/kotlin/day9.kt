import ch.tutteli.atrium.api.cc.en_UK.toBe
import ch.tutteli.atrium.verbs.expect.expect
import org.junit.Test

class Day9Test {

    @Test
    fun run() {
        println("solution=" + Day9().run(Day9().input()))
    }

    @Test
    fun more_cases() {
        expect(Day9().run("{<>}")).toBe(Pair(1, 0))
        expect(Day9().run("{<random characters>}")).toBe(Pair(1, 17))
        expect(Day9().run("{<<<<>}")).toBe(Pair(1, 3))
        expect(Day9().run("{<{!>}>}")).toBe(Pair(1, 2))
        expect(Day9().run("{<!!>}")).toBe(Pair(1, 0))
        expect(Day9().run("{<{o\"i!a,<{i<a>}")).toBe(Pair(1, 10))
    }

    @Test
    fun second_1() {
        expect(Day9().run("{<a>,<a>,<a>,<a>}")).toBe(Pair(1, 4))
    }

    @Test
    fun first_1() {
        expect(Day9().run("{}")).toBe(Pair(1, 0))
    }

    @Test
    fun first_2() {
        expect(Day9().run("{{{}}}")).toBe(Pair(6, 0))
    }

    @Test
    fun first_3() {
        expect(Day9().run("{{},{}}")).toBe(Pair(5, 0))
    }

    @Test
    fun first_4() {
        expect(Day9().run("{{{},{},{{}}}}")).toBe(Pair(16, 0))
    }

    @Test
    fun first_5() {
        expect(Day9().run("{<a>,<a>,<a>,<a>}")).toBe(Pair(1, 4))
    }

    @Test
    fun first_6() {
        expect(Day9().run("{{<ab>},{<ab>},{<ab>},{<ab>}}")).toBe(Pair(9, 8))
    }

    @Test
    fun first_7() {
        expect(Day9().run("{{<!!>},{<!!>},{<!!>},{<!!>}}")).toBe(Pair(9, 0))
    }

    @Test
    fun first_8() {
        expect(Day9().run("{{<a!>},{<a!>},{<a!>},{<ab>}}")).toBe(Pair(3, 17))
    }

    @Test
    fun first_9() {
        expect(Day9().run("{{<a!>},{<a!>},{<a!!>},{<ab>}}")).toBe(Pair(5, 13)) // 1 + 2 + 2
    }

    @Test
    fun first_10() {
        expect(Day9().run("{<{},{},{{}}>}")).toBe(Pair(1, 10)) // 1
    }

    @Test
    fun first_11() {
        expect(Day9().run("{<!!!>>}")).toBe(Pair(1, 0)) // 1
    }

    @Test
    fun first_12() {
        expect(Day9().run("{<{o\"i!a,<{i<a>}")).toBe(Pair(1, 10)) // 1
    }

    @Test
    fun first_13() {
        expect(Day9().run("{{<!>},{<!>},{<!>},{<a>}}")).toBe(Pair(3, 13)) // 1 + 2
    }

    @Test
    fun first_14() {
        expect(Day9().run("{{<!>}}},{<!>},{<!!>}}")).toBe(Pair(3, 10)) // 1 + 2
    }

    @Test
    fun first_15() {
        expect(Day9().run("{{<!}>}}")).toBe(Pair(3, 0)) // 1 + 2
    }

    @Test
    fun first_16() {
        expect(Day9().run("{{<!}>}{}}")).toBe(Pair(5, 0)) // 1 + 2 + 2
    }

    @Test
    fun first_17() {
        expect(Day9().run("{<!!!!>{}}")).toBe(Pair(3, 0)) // 1 + 2
    }

    @Test
    fun first_18() {
        expect(Day9().run("{<!!!!!>{}>}")).toBe(Pair(1, 2)) // 1
    }

    @Test
    fun first_19() {
        expect(Day9().run("{<!<>{}}")).toBe(Pair(3, 0)) // 1 + 2
    }

}
