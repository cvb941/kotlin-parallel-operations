package com.lukaskusik.coroutines.transformations.benchmark

import com.carrotsearch.junitbenchmarks.AbstractBenchmark
import com.lukaskusik.coroutines.transformations.reduce.reduceParallel
import com.lukaskusik.coroutines.transformations.test.ParallelMapListTest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.junit.Test

class ParallelReduceBenchmark : AbstractBenchmark() {

    companion object {
        const val LIST_SIZE = 1000
    }

    private val list = ParallelMapListTest.getRandomListOfSize(LIST_SIZE)

    private val operation = { acc: Int, i: Int -> Thread.sleep(1); acc + i }

    @Test
    fun sequential() {
        list.reduce(operation)
    }

    @Test
    fun coroutineOnMain() {
        runBlocking {
            list.reduceParallel(1, operation)
        }
    }

    @Test
    fun coroutineOnThreadPool() {
        runBlocking(Dispatchers.Default) {
            list.reduceParallel(1, operation)
        }
    }

    @Test
    fun coroutineOnThreadPoolChunked4() {
        runBlocking(Dispatchers.Default) {
            list.reduceParallel(4, operation)
        }
    }

    @Test
    fun coroutineOnThreadPoolChunked8() {
        runBlocking(Dispatchers.Default) {
            list.reduceParallel(8, operation)
        }
    }


}