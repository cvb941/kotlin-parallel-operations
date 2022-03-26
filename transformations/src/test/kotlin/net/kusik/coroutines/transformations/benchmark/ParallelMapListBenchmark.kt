package net.kusik.coroutines.transformations.benchmark

import com.carrotsearch.junitbenchmarks.AbstractBenchmark
import net.kusik.coroutines.transformations.map.mapParallel
import net.kusik.coroutines.transformations.map.mapParallelChunked
import net.kusik.coroutines.transformations.test.ParallelMapListTest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.junit.Test

class ParallelMapListBenchmark : AbstractBenchmark() {

    companion object {
        const val LIST_SIZE = 100
    }

    private val list = ParallelMapListTest.getRandomListOfSize(LIST_SIZE)


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
