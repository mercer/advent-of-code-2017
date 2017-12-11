//
// References:
// https://dzone.com/articles/solving-the-josephus-problem-in-kotlin

class CircularHash {

    fun calculate(circularListSize: Int, lengths: List<Int>): Pair<Int, Int> {
        var circle = generateList(circularListSize)
        println(circle); println()

        for (length in lengths) {
            circle = circle.pinchAndTwist(length);
            println(circle); println()
        }

        return Pair(-1, -1)
    }

    class CircleList(
        private val items: List<Int>,
        private val currentPosition: Int,
        private val skipSize: Int
    ) {

        private val firstBead = Bead(items[0])

        init {
            var currentBead = firstBead
            var nextBead = firstBead
            for (item in items.subList(1, items.lastIndex + 1)) {
                nextBead = Bead(item)
                currentBead.next = nextBead
                currentBead = nextBead
            }
            nextBead.next = firstBead

            debugBeads()
        }

        private fun debugBeads() {
            var currentBead = firstBead
            var beadsToList = listOf<Int>()
            for (i in 1..items.size) {
                beadsToList = beadsToList.plus(currentBead.position)
                currentBead = currentBead.next
            }
            println("beadsToList=$beadsToList")
        }

        fun pinchAndTwist(length: Int): CircleList {
            println("length=$length")
            val nextItems = pickBeadsToTwist(length)
                .asReversed()
                .plus(pickRemainingBeads(length))
            val nextCurrentPosition = length + skipSize
            return CircleList(nextItems, nextCurrentPosition, skipSize + 1)
        }

        private fun pickBeadsToTwist(length: Int): List<Int> {
            var currentBead = firstBead
            for (i in 1..currentPosition) {
                currentBead = currentBead.next
            }
            var returnItems = listOf<Int>()
            for (i in 1..length) {
                returnItems = returnItems.plus(currentBead.position)
                currentBead = currentBead.next
            }
            println("pickfirstitems=$returnItems")
            return returnItems
        }

        private fun pickRemainingBeads(length: Int): List<Int> {
            var currentBead = firstBead
            for (i in 1..currentPosition) {
                currentBead = currentBead.next
            }
            for (i in 1..length) {
                currentBead = currentBead.next
            }
            var returnItems = listOf<Int>()
            for (i in 1..items.size - length) {
                returnItems = returnItems.plus(currentBead.position)
                currentBead = currentBead.next
            }
            println("picklastitems=$returnItems")
            return returnItems
        }

        override fun toString(): String {
            return "CircleList(items=$items, currentPosition=$currentPosition, skipSize=$skipSize)"
        }

    }

    class Bead(val position: Int) {
        lateinit var next: Bead
        lateinit var previous: Bead
    }

    private fun generateList(circularListSize: Int): CircleList {
        var count = 0
        val items = generateSequence {
            (count++).takeIf { it < circularListSize }
        }.toList()
        return CircleList(items, 0, 0)
    }

}


