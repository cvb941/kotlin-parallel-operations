package net.kusik.coroutines.transformations.test

import net.kusik.coroutines.transformations.reduce.reduceParallel
import kotlinx.coroutines.test.runTest
import kotlin.random.Random
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails
import kotlin.test.assertFailsWith

class ParallelReduceTest {
    companion object {
        fun getList() = listOf(1, 2, 3, 4, 5)

        fun getRandomListOfSize(listSize: Int): List<Int> {
            val random = Random(648)
            val list = ArrayList<Int>(listSize)
            repeat(listSize) {
                list.add(random.nextInt())
            }
            return list
        }
    }

    private fun theTest(chunks: Int) = runTest {
        val listSequential = getList()
        val listParallel = listSequential.toList()
        val operation = { acc: Int, i: Int -> acc + i }

        val sequentialResult = listSequential.reduce(operation)
        val parallelResult = listParallel.reduceParallel(chunks, operation)

        assertEquals(sequentialResult, parallelResult)
    }

    @Test
    fun parallelReduceNoChunks() {
        theTest(1)
    }

    @Test
    fun parallelReduce4Chunks() {
        theTest(4)
    }


    @Test
    fun parallelReduce0ChunksError() {
        assertFailsWith<IllegalArgumentException> {
            theTest(0)
        }
    }

    @Test
    fun parallelReduceNegativeChunksError() {
        assertFailsWith<IllegalArgumentException> {
            theTest(-10)
        }
    }
}
