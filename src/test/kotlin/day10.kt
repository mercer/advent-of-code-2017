import ch.tutteli.atrium.api.cc.en_UK.toBe
import ch.tutteli.atrium.verbs.expect.expect
import org.junit.Test

class Day10Test {

    @Test
    fun randomInput() {
        expect(Day10().run(6, "3, 4, 1, 5")).toBe(Pair(12, -1))
    }

    @Test
    fun run() {
        println("solution=" + Day10().run(256, "199,0,255,136,174,254,227,16,51,85,1,2,22,17,7,192"))
    }

}
