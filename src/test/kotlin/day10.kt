import ch.tutteli.atrium.api.cc.en_UK.toBe
import ch.tutteli.atrium.verbs.expect.expect
import org.junit.Test

class Day10Test {

    @Test
    fun first_1() {
        expect(Day10().first(6, "3, 4, 1, 5")).toBe(12)
    }

    @Test
    fun first_2() {
        expect(Day10().first(256, "199,0,255,136,174,254,227,16,51,85,1,2,22,17,7,192")).toBe(-1)
    }

}
