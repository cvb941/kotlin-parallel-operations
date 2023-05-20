import net.kusik.coroutines.transformations.mapinplace.mapInPlace
import net.kusik.coroutines.transformations.mapinplace.mapInPlaceParallel
import net.kusik.coroutines.transformations.mapinplace.mapInPlaceParallelChunked

@State(Scope.Benchmark)
open class ParallelInPlaceMapArrayBenchmark {

    companion object {
        const val ARRAY_SIZE = 100
    }

    private val random = Random(468)
    private val array = Array(ARRAY_SIZE) { 0 }
    private val operation = { it: Int ->
        var counter = it
            for (i in 0..100000) {
                counter+=1
            }
        counter
    }

    @Benchmark
    open fun sequential() {
        array.mapInPlace(operation)
    }

    @Benchmark
    open fun coroutineOnMain() = runTest {
        array.mapInPlaceParallel(operation)
    }

    @Benchmark
    open fun coroutineOnThreadPool() = runTest(Dispatchers.Default) {
        array.mapInPlaceParallel(operation)
    }

    @Benchmark
    open fun coroutineOnThreadPoolChunked4() = runTest(Dispatchers.Default) {
        array.mapInPlaceParallelChunked(4, operation)
    }

    @Benchmark
    open fun coroutineOnThreadPoolChunked8() = runTest(Dispatchers.Default) {
        array.mapInPlaceParallelChunked(8, operation)
    }


}
