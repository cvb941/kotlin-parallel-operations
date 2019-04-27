package com.lukaskusik.coroutines.transformations.benchmark

import com.carrotsearch.junitbenchmarks.AbstractBenchmark
import com.carrotsearch.junitbenchmarks.annotation.AxisRange
import com.carrotsearch.junitbenchmarks.annotation.BenchmarkMethodChart
import com.lukaskusik.coroutines.transformations.mapParallel
import com.lukaskusik.coroutines.transformations.mapParallelChunked
import com.lukaskusik.coroutines.transformations.test.ParallelMapTest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.junit.Test

class ParallelMapBenchmark : AbstractBenchmark() {

    companion object {
        const val LIST_SIZE = 1000
    }

    private val list = ParallelMapTest.getRandomListOfSize(LIST_SIZE)


    @Test
    fun sequential() {
        list.map { Thread.sleep(1); it / 2 }
    }

    @Test
    fun coroutineOnMain() {
        runBlocking {
            list.mapParallel { Thread.sleep(1); it / 2 }
        }
    }

    @Test
    fun coroutineOnThreadPool() {
        runBlocking(Dispatchers.Default) {
            list.mapParallel { Thread.sleep(1); it / 2 }
        }
    }

    @Test
    fun coroutineOnThreadPoolChunked4() {
        runBlocking(Dispatchers.Default) {
            list.mapParallelChunked(4) { Thread.sleep(1); it / 2 }
        }
    }

    @Test
    fun coroutineOnThreadPoolChunked8() {
        runBlocking(Dispatchers.Default) {
            list.mapParallelChunked(8) { Thread.sleep(1); it / 2 }
        }
    }


}