package net.kusik.coroutines.transformations.test

import net.kusik.coroutines.transformations.map.mapParallel
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.runTest
import kotlin.random.Random
import kotlin.test.Test
import kotlin.test.assertEquals

class ParallelMapListTest {

    companion object {
        fun getRandomListOfSize(listSize: Int): List<Int> {
            val random = Random(648)
            val list = ArrayList<Int>(listSize)
            repeat(listSize) {
                list.add(random.nextInt())
            }
            return list
        }
    }

    @Test
    fun parallelMapNoChunks() = runTest {
        var listSequential = getRandomListOfSize(100)
        var listParallel = listSequential.toList()

        listSequential = listSequential.map { it * 2 }
        listParallel = listParallel.mapParallel { it * 2 }


        assertEquals(listSequential, listParallel)
    }

    @Test
    fun parallelMapSuspendingTransform() = runTest {
        suspend fun suspending(number: Number): Number {
            delay(10)
            return number
        }

        val one = listOf(1, 2, 3).map {
            suspending(it)
        }

        val two = listOf(1, 2, 3).mapParallel {
            suspending(it)
        }

        assertEquals(one, two)
    }
}
