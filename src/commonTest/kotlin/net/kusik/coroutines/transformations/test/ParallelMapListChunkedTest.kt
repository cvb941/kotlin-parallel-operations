package net.kusik.coroutines.transformations.test

import kotlinx.coroutines.test.runTest
import net.kusik.coroutines.transformations.map.mapParallelChunked
import kotlin.random.Random
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails

class ParallelMapListChunkedTest {

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
    fun parallelMap4Chunks() = runTest {
        var listSequential = listOf(1, 3, 3, 4, 5)
        var listParallel = listSequential.toList()

        listSequential = listSequential.map { it * 2 }
        listParallel = listParallel.mapParallelChunked(4) { it * 2 }

        assertEquals(listSequential, listParallel)
    }

    @Test
    fun parallelMapEmpty() = runTest {
        var listSequential = emptyList<Int>()
        var listParallel = listSequential.toList()

        listSequential = listSequential.map { it * 2 }
        listParallel = listParallel.mapParallelChunked(4) { it * 2 }


        assertEquals(listSequential, listParallel)
    }

    @Test
    fun parallelMap0Chunks() = runTest {
        var listSequential = listOf(1, 3, 3, 4, 5)
        var listParallel = listSequential.toList()

        assertFails {
            listParallel = listParallel.mapParallelChunked(0) { it * 2 }
        }
    }

    @Test
    fun parallelMapMoreChunksThanItems() = runTest {
        var listSequential = listOf(1, 3, 3, 4, 5)
        var listParallel = listSequential.toList()

        listSequential = listSequential.map { it * 2 }
        listParallel = listParallel.mapParallelChunked(10) { it * 2 }


        assertEquals(listSequential, listParallel)
    }
}
