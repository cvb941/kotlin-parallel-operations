package net.kusik.coroutines.transformations.benchmark

import com.carrotsearch.junitbenchmarks.AbstractBenchmark
import net.kusik.coroutines.transformations.mapinplace.mapInPlace
import net.kusik.coroutines.transformations.mapinplace.mapInPlaceParallel
import net.kusik.coroutines.transformations.mapinplace.mapInPlaceParallelChunked
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import kotlin.random.Random

class ParallelInPlaceMapPrimitiveArrayBenchmark : AbstractBenchmark() {

    companion object {
        const val ARRAY_SIZE = 100
    }

    private val random = Random(468)
    private val array = IntArray(ARRAY_SIZE) { random.nextInt() }
    private val operation = { it: Int ->
//        Thread.sleep(1)
        it + it
    }


    @Test
    fun sequential() {
        array.mapInPlace(operation)
    }

    @Test
    fun coroutineOnMain() {
        runBlocking {
            array.mapInPlaceParallel(operation)
        }
    }

    @Test
    fun coroutineOnThreadPool() {
        runBlocking(Dispatchers.Default) {
            array.mapInPlaceParallel(operation)
        }
    }

    @Test
    fun coroutineOnThreadPoolChunked4() {
        runBlocking(Dispatchers.Default) {
            array.mapInPlaceParallelChunked(4, operation)
        }
    }

    @Test
    fun coroutineOnThreadPoolChunked8() {
        runBlocking(Dispatchers.Default) {
            array.mapInPlaceParallelChunked(8, operation)
        }
    }

}
