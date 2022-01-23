package com.lukaskusik.coroutines.transformations.mapinplace

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlin.math.ceil


/**
 *  Performs in place map transformation on the array using coroutines.
 */
suspend fun <T> Array<T>.mapInPlaceParallelChunked(
    chunksCount: Int = Runtime.getRuntime().availableProcessors(),
    transform: (T) -> T
): Array<T> = coroutineScope {
    assert(chunksCount > 0) { "Parameter chunksCount must be greater than 0" }
    if (isEmpty()) return@coroutineScope this@mapInPlaceParallelChunked

    val chunkSize = ceil(size / chunksCount.toDouble()).toInt()
    for (i in indices step chunkSize) {
        launch {
            for (j in i until (i + chunkSize).coerceAtMost(size))
                this@mapInPlaceParallelChunked[j] = transform(this@mapInPlaceParallelChunked[j])
        }
    }
    this@mapInPlaceParallelChunked
}


/**
 *  Performs in place map transformation on the array using coroutines.
 */
suspend fun ByteArray.mapInPlaceParallelChunked(
    chunksCount: Int = Runtime.getRuntime().availableProcessors(),
    transform: (Byte) -> Byte
): ByteArray = coroutineScope {
    assert(chunksCount > 0) { "Parameter chunksCount must be greater than 0" }
    if (isEmpty()) return@coroutineScope this@mapInPlaceParallelChunked

    val chunkSize = ceil(size / chunksCount.toDouble()).toInt()
    for (i in indices step chunkSize) {
        launch {
            for (j in i until (i + chunkSize).coerceAtMost(size))
                this@mapInPlaceParallelChunked[j] = transform(this@mapInPlaceParallelChunked[j])
        }
    }
    this@mapInPlaceParallelChunked
}


/**
 *  Performs in place map transformation on the array using coroutines.
 */
suspend fun ShortArray.mapInPlaceParallelChunked(
    chunksCount: Int = Runtime.getRuntime().availableProcessors(),
    transform: (Short) -> Short
): ShortArray = coroutineScope {
    assert(chunksCount > 0) { "Parameter chunksCount must be greater than 0" }
    if (isEmpty()) return@coroutineScope this@mapInPlaceParallelChunked

    val chunkSize = ceil(size / chunksCount.toDouble()).toInt()
    for (i in indices step chunkSize) {
        launch {
            for (j in i until (i + chunkSize).coerceAtMost(size))
                this@mapInPlaceParallelChunked[j] = transform(this@mapInPlaceParallelChunked[j])
        }
    }
    this@mapInPlaceParallelChunked
}

/**
 *  Performs in place map transformation on the array using coroutines.
 */
suspend fun IntArray.mapInPlaceParallelChunked(
    chunksCount: Int = Runtime.getRuntime().availableProcessors(),
    transform: (Int) -> Int
): IntArray = coroutineScope {
    assert(chunksCount > 0) { "Parameter chunksCount must be greater than 0" }
    if (isEmpty()) return@coroutineScope this@mapInPlaceParallelChunked

    val chunkSize = ceil(size / chunksCount.toDouble()).toInt()
    for (i in indices step chunkSize) {
        launch {
            for (j in i until (i + chunkSize).coerceAtMost(size))
                this@mapInPlaceParallelChunked[j] = transform(this@mapInPlaceParallelChunked[j])
        }
    }
    this@mapInPlaceParallelChunked
}

/**
 *  Performs in place map transformation on the array using coroutines.
 */
suspend fun LongArray.mapInPlaceParallelChunked(
    chunksCount: Int = Runtime.getRuntime().availableProcessors(),
    transform: (Long) -> Long
): LongArray = coroutineScope {
    assert(chunksCount > 0) { "Parameter chunksCount must be greater than 0" }
    if (isEmpty()) return@coroutineScope this@mapInPlaceParallelChunked

    val chunkSize = ceil(size / chunksCount.toDouble()).toInt()
    for (i in indices step chunkSize) {
        launch {
            for (j in i until (i + chunkSize).coerceAtMost(size))
                this@mapInPlaceParallelChunked[j] = transform(this@mapInPlaceParallelChunked[j])
        }
    }
    this@mapInPlaceParallelChunked
}

/**
 *  Performs in place map transformation on the array using coroutines.
 */
suspend fun FloatArray.mapInPlaceParallelChunked(
    chunksCount: Int = Runtime.getRuntime().availableProcessors(),
    transform: (Float) -> Float
): FloatArray = coroutineScope {
    assert(chunksCount > 0) { "Parameter chunksCount must be greater than 0" }
    if (isEmpty()) return@coroutineScope this@mapInPlaceParallelChunked

    val chunkSize = ceil(size / chunksCount.toDouble()).toInt()
    for (i in indices step chunkSize) {
        launch {
            for (j in i until (i + chunkSize).coerceAtMost(size))
                this@mapInPlaceParallelChunked[j] = transform(this@mapInPlaceParallelChunked[j])
        }
    }
    this@mapInPlaceParallelChunked
}

/**
 *  Performs in place map transformation on the array using coroutines.
 */
suspend fun DoubleArray.mapInPlaceParallelChunked(
    chunksCount: Int = Runtime.getRuntime().availableProcessors(),
    transform: (Double) -> Double
): DoubleArray = coroutineScope {
    assert(chunksCount > 0) { "Parameter chunksCount must be greater than 0" }
    if (isEmpty()) return@coroutineScope this@mapInPlaceParallelChunked

    val chunkSize = ceil(size / chunksCount.toDouble()).toInt()
    for (i in indices step chunkSize) {
        launch {
            for (j in i until (i + chunkSize).coerceAtMost(size))
                this@mapInPlaceParallelChunked[j] = transform(this@mapInPlaceParallelChunked[j])
        }
    }
    this@mapInPlaceParallelChunked
}

/**
 *  Performs in place map transformation on the array using coroutines.
 */
suspend fun BooleanArray.mapInPlaceParallelChunked(
    chunksCount: Int = Runtime.getRuntime().availableProcessors(),
    transform: (Boolean) -> Boolean
): BooleanArray = coroutineScope {
    assert(chunksCount > 0) { "Parameter chunksCount must be greater than 0" }
    if (isEmpty()) return@coroutineScope this@mapInPlaceParallelChunked

    val chunkSize = ceil(size / chunksCount.toDouble()).toInt()
    for (i in indices step chunkSize) {
        launch {
            for (j in i until (i + chunkSize).coerceAtMost(size))
                this@mapInPlaceParallelChunked[j] = transform(this@mapInPlaceParallelChunked[j])
        }
    }
    this@mapInPlaceParallelChunked
}
