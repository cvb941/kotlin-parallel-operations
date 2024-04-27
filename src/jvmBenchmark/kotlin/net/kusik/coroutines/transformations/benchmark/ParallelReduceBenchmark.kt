package net.kusik.coroutines.transformations.benchmark

import kotlinx.benchmark.Benchmark
import kotlinx.benchmark.Scope
import kotlinx.benchmark.State
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.runTest
import net.kusik.coroutines.transformations.reduce.reduceParallel
import net.kusik.coroutines.transformations.test.ParallelMapListTest

@State(Scope.Benchmark)
class ParallelReduceBenchmark {

    companion object {
        const val LIST_SIZE = 1000
    }

    private val list = ParallelMapListTest.getRandomListOfSize(LIST_SIZE)

    private val operation = { acc: Int, i: Int -> sleep(1); acc + i }

    @Benchmark
    fun sequential() {
        list.reduce(operation)
    }

    @Benchmark
    fun coroutineOnMain() {
        runTest {
            list.reduceParallel(1, operation)
        }
    }

    @Benchmark
    fun coroutineOnThreadPool() {
        runTest(Dispatchers.Default) {
            list.reduceParallel(1, operation)
        }
    }

    @Benchmark
    fun coroutineOnThreadPoolChunked4() {
        runTest(Dispatchers.Default) {
            list.reduceParallel(4, operation)
        }
    }

    @Benchmark
    fun coroutineOnThreadPoolChunked8() {
        runTest(Dispatchers.Default) {
            list.reduceParallel(8, operation)
        }
    }


}
