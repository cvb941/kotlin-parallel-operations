package com.lukaskusik.coroutines.transformations.benchmark

import com.carrotsearch.junitbenchmarks.AbstractBenchmark
import com.lukaskusik.coroutines.transformations.mapParallel
import com.lukaskusik.coroutines.transformations.mapParallelChunked
import com.lukaskusik.coroutines.transformations.test.ParallelMapListTest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.random.Random

class ParallelMapArrayBenchmark : AbstractBenchmark() {

    companion object {
        const val ARRAY_SIZE = 100
    }

    private val random = Random(468)
    private val list = Array(ARRAY_SIZE) { java.util.UUID.randomUUID().toString() }


    @Test
    fun sequential() {
        list.map { Thread.sleep(1); it + it }
    }

    @Test
    fun coroutineOnMain() {
        runBlocking {
            list.mapParallel { Thread.sleep(1); it + it }
        }
    }

    @Test
    fun coroutineOnThreadPool() {
        runBlocking(Dispatchers.Default) {
            list.mapParallel { Thread.sleep(1); it + it }
        }
    }


}