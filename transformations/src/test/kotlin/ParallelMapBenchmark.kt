package com.lukaskusik.coroutines.transformations.test

import com.carrotsearch.junitbenchmarks.AbstractBenchmark
import com.lukaskusik.coroutines.transformations.mapParallel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.junit.Test

class ParallelMapBenchmark : AbstractBenchmark() {

    companion object {
        const val LIST_SIZE = 100
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

//    @Test
//    fun parallelJustThreads() {
//        runBlocking(Dispatchers.Default) {
//            list.mapParallel(LIST_SIZE, sumClosure)
//        }
//    }

}