package net.kusik.coroutines.transformations.benchmark

import com.carrotsearch.junitbenchmarks.AbstractBenchmark
import net.kusik.coroutines.transformations.map.mapParallel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.random.Random

class ParallelMapPrimitiveArrayBenchmark : AbstractBenchmark() {

    companion object {
        const val ARRAY_SIZE = 100
    }

    private val random = Random(468)
    private val list = IntArray(ARRAY_SIZE) { random.nextInt() }


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



}
