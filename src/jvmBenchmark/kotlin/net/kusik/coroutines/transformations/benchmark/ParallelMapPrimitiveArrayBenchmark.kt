package net.kusik.coroutines.transformations.benchmark

import kotlinx.benchmark.Benchmark
import kotlinx.benchmark.Scope
import kotlinx.benchmark.State
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.runTest
import net.kusik.coroutines.transformations.map.mapParallel
import kotlin.random.Random

@State(Scope.Benchmark)
class ParallelMapPrimitiveArrayBenchmark {

    companion object {
        const val ARRAY_SIZE = 100
    }

    private val random = Random(468)
    private val list = IntArray(ARRAY_SIZE) { random.nextInt() }


    @Benchmark
    fun sequential() {
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


}
