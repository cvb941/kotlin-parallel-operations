package net.kusik.coroutines.transformations.benchmark

import kotlinx.benchmark.Benchmark
import kotlinx.benchmark.Scope
import kotlinx.benchmark.State
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.runTest
import net.kusik.coroutines.transformations.map.mapParallel
import net.kusik.coroutines.transformations.map.mapParallelChunked
import net.kusik.coroutines.transformations.test.ParallelMapListTest

@State(Scope.Benchmark)
class ParallelMapListBenchmark {

    companion object {
        const val LIST_SIZE = 100
    }

    private val list = ParallelMapListTest.getRandomListOfSize(LIST_SIZE)


    @Benchmark
    fun sequential() = runTest {
        list.map { sleep(1); it / 2 }
    }

    @Benchmark
    fun coroutineOnMain() {
        runTest {
            list.mapParallel { sleep(1); it / 2 }
        }
    }

    @Benchmark
    fun coroutineOnThreadPool() {
        runTest(Dispatchers.Default) {
            list.mapParallel { sleep(1); it / 2 }
        }
    }

    @Benchmark
    fun coroutineOnThreadPoolChunked4() {
        runTest(Dispatchers.Default) {
            list.mapParallelChunked(4) { sleep(1); it / 2 }
        }
    }

    @Benchmark
    fun coroutineOnThreadPoolChunked8() {
        runTest(Dispatchers.Default) {
            list.mapParallelChunked(8) { sleep(1); it / 2 }
        }
    }


}
