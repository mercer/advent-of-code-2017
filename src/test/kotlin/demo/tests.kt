package demo

import ch.tutteli.atrium.api.cc.en_UK.isGreaterThan
import ch.tutteli.atrium.api.cc.en_UK.isLessThan
import ch.tutteli.atrium.verbs.assert.assert
import org.junit.Test

class TestSource {
    @Test
    fun f() {
        assert(4 + 6).isLessThan(5).isGreaterThan(10)
    }
}
