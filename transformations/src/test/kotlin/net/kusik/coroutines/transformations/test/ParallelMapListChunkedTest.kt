package net.kusik.coroutines.transformations.test

import net.kusik.coroutines.transformations.map.mapParallelChunked
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import kotlin.random.Random
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
    fun parallelMap4Chunks() {
        var listSequential = listOf(1, 3, 3, 4, 5)
        var listParallel = listSequential.toList()

        listSequential = listSequential.map { it * 2 }
        runBlocking {
            listParallel = listParallel.mapParallelChunked(4) { it * 2 }
        }


        Assert.assertEquals(listSequential, listParallel)
    }

    @Test
    fun parallelMapEmpty() {
        var listSequential = emptyList<Int>()
        var listParallel = listSequential.toList()

        listSequential = listSequential.map { it * 2 }
        runBlocking {
            listParallel = listParallel.mapParallelChunked(4) { it * 2 }
        }


        Assert.assertEquals(listSequential, listParallel)
    }

    @Test
    fun parallelMap0Chunks() {
        var listSequential = listOf(1, 3, 3, 4, 5)
        var listParallel = listSequential.toList()

        runBlocking {
            assertFails {
                listParallel = listParallel.mapParallelChunked(0) { it * 2 }
            }
        }
    }

    @Test
    fun parallelMapMoreChunksThanItems() {
        var listSequential = listOf(1, 3, 3, 4, 5)
        var listParallel = listSequential.toList()

        listSequential = listSequential.map { it * 2 }
        runBlocking {
            listParallel = listParallel.mapParallelChunked(10) { it * 2 }
        }


        Assert.assertEquals(listSequential, listParallel)
    }
}
