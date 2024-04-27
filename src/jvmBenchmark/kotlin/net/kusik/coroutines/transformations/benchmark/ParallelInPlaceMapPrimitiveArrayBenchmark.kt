package net.kusik.coroutines.transformations.benchmark

import kotlinx.benchmark.Benchmark
import kotlinx.benchmark.Scope
import kotlinx.benchmark.State
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.runTest
import net.kusik.coroutines.transformations.mapinplace.mapInPlace
import net.kusik.coroutines.transformations.mapinplace.mapInPlaceParallel
import net.kusik.coroutines.transformations.mapinplace.mapInPlaceParallelChunked
import kotlin.random.Random

@State(Scope.Benchmark)
class ParallelInPlaceMapPrimitiveArrayBenchmark {

    companion object {
        const val ARRAY_SIZE = 100
    }

    private val random = Random(468)
    private val array = IntArray(ARRAY_SIZE) { random.nextInt() }
    private val operation = { it: Int ->
        sleep(1)
        it + it
    }


    @Benchmark
    fun sequential() {
        array.mapInPlace(operation)
    }

    @Benchmark
    fun coroutineOnMain() {
        runTest {
            array.mapInPlaceParallel(operation)
        }
    }

    @Benchmark
    fun coroutineOnThreadPool() {
        runTest(Dispatchers.Default) {
            array.mapInPlaceParallel(operation)
        }
    }

    @Benchmark
    fun coroutineOnThreadPoolChunked4() {
        runTest(Dispatchers.Default) {
            array.mapInPlaceParallelChunked(4, operation)
        }
    }

    @Benchmark
    fun coroutineOnThreadPoolChunked8() {
        runTest(Dispatchers.Default) {
            array.mapInPlaceParallelChunked(8, operation)
        }
    }

}
