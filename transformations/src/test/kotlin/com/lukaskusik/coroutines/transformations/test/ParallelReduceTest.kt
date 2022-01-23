package com.lukaskusik.coroutines.transformations.test

import com.lukaskusik.coroutines.transformations.reduce.reduceParallel
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import kotlin.random.Random

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

    private fun theTest(chunks: Int) {
        val listSequential = getList()
        val listParallel = listSequential.toList()
        val operation = { acc: Int, i: Int -> acc + i }

        val sequentialResult = listSequential.reduce(operation)
        var parallelResult: Int? = null
        runBlocking {
            parallelResult = listParallel.reduceParallel(chunks, operation)
        }

        Assert.assertEquals(sequentialResult, parallelResult)
    }

    @Test
    fun parallelReduceNoChunks() {
        theTest(1)
    }

    @Test
    fun parallelReduce4Chunks() {
        theTest(4)
    }


    @Test(expected = IllegalArgumentException::class)
    fun parallelReduce0ChunksError() {
        theTest(0)
    }

    @Test(expected = IllegalArgumentException::class)
    fun parallelReduceNegativeChunksError() {
        theTest(-10)
    }
}
