package com.lukaskusik.coroutines.transformations.mapinplace

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlin.math.ceil


/**
 *  Performs in place map transformation on the array using coroutines.
 */
suspend inline fun <T> Array<T>.mapInPlaceIndexedParallelChunked(
    chunksCount: Int = Runtime.getRuntime().availableProcessors(),
    crossinline transform: suspend (index: Int, T) -> T
): Array<T> = coroutineScope {
    assert(chunksCount > 0) { "Parameter chunksCount must be greater than 0" }
    if (isEmpty()) return@coroutineScope this@mapInPlaceIndexedParallelChunked

    val chunkSize = ceil(size / chunksCount.toDouble()).toInt()
    for (i in indices step chunkSize) {
        launch {
            for (j in i until (i + chunkSize).coerceAtMost(size))
                this@mapInPlaceIndexedParallelChunked[j] = transform(j, this@mapInPlaceIndexedParallelChunked[j])
        }
    }
    this@mapInPlaceIndexedParallelChunked
}


/**
 *  Performs in place map transformation on the array using coroutines.
 */
suspend inline fun ByteArray.mapInPlaceIndexedParallelChunked(
    chunksCount: Int = Runtime.getRuntime().availableProcessors(),
    crossinline transform: suspend (index: Int, Byte) -> Byte
): ByteArray = coroutineScope {
    assert(chunksCount > 0) { "Parameter chunksCount must be greater than 0" }
    if (isEmpty()) return@coroutineScope this@mapInPlaceIndexedParallelChunked

    val chunkSize = ceil(size / chunksCount.toDouble()).toInt()
    for (i in indices step chunkSize) {
        launch {
            for (j in i until (i + chunkSize).coerceAtMost(size))
                this@mapInPlaceIndexedParallelChunked[j] = transform(j, this@mapInPlaceIndexedParallelChunked[j])
        }
    }
    this@mapInPlaceIndexedParallelChunked
}


/**
 *  Performs in place map transformation on the array using coroutines.
 */
suspend inline fun ShortArray.mapInPlaceIndexedParallelChunked(
    chunksCount: Int = Runtime.getRuntime().availableProcessors(),
    crossinline transform: suspend (index: Int, Short) -> Short
): ShortArray = coroutineScope {
    assert(chunksCount > 0) { "Parameter chunksCount must be greater than 0" }
    if (isEmpty()) return@coroutineScope this@mapInPlaceIndexedParallelChunked

    val chunkSize = ceil(size / chunksCount.toDouble()).toInt()
    for (i in indices step chunkSize) {
        launch {
            for (j in i until (i + chunkSize).coerceAtMost(size))
                this@mapInPlaceIndexedParallelChunked[j] = transform(j, this@mapInPlaceIndexedParallelChunked[j])
        }
    }
    this@mapInPlaceIndexedParallelChunked
}

/**
 *  Performs in place map transformation on the array using coroutines.
 */
suspend inline fun IntArray.mapInPlaceIndexedParallelChunked(
    chunksCount: Int = Runtime.getRuntime().availableProcessors(),
    crossinline transform: suspend (index: Int, Int) -> Int
): IntArray = coroutineScope {
    assert(chunksCount > 0) { "Parameter chunksCount must be greater than 0" }
    if (isEmpty()) return@coroutineScope this@mapInPlaceIndexedParallelChunked

    val chunkSize = ceil(size / chunksCount.toDouble()).toInt()
    for (i in indices step chunkSize) {
        launch {
            for (j in i until (i + chunkSize).coerceAtMost(size))
                this@mapInPlaceIndexedParallelChunked[j] = transform(j, this@mapInPlaceIndexedParallelChunked[j])
        }
    }
    this@mapInPlaceIndexedParallelChunked
}

/**
 *  Performs in place map transformation on the array using coroutines.
 */
suspend inline fun LongArray.mapInPlaceIndexedParallelChunked(
    chunksCount: Int = Runtime.getRuntime().availableProcessors(),
    crossinline transform: suspend (index: Int, Long) -> Long
): LongArray = coroutineScope {
    assert(chunksCount > 0) { "Parameter chunksCount must be greater than 0" }
    if (isEmpty()) return@coroutineScope this@mapInPlaceIndexedParallelChunked

    val chunkSize = ceil(size / chunksCount.toDouble()).toInt()
    for (i in indices step chunkSize) {
        launch {
            for (j in i until (i + chunkSize).coerceAtMost(size))
                this@mapInPlaceIndexedParallelChunked[j] = transform(j, this@mapInPlaceIndexedParallelChunked[j])
        }
    }
    this@mapInPlaceIndexedParallelChunked
}

/**
 *  Performs in place map transformation on the array using coroutines.
 */
suspend inline fun FloatArray.mapInPlaceIndexedParallelChunked(
    chunksCount: Int = Runtime.getRuntime().availableProcessors(),
    crossinline transform: suspend (index: Int, Float) -> Float
): FloatArray = coroutineScope {
    assert(chunksCount > 0) { "Parameter chunksCount must be greater than 0" }
    if (isEmpty()) return@coroutineScope this@mapInPlaceIndexedParallelChunked

    val chunkSize = ceil(size / chunksCount.toDouble()).toInt()
    for (i in indices step chunkSize) {
        launch {
            for (j in i until (i + chunkSize).coerceAtMost(size))
                this@mapInPlaceIndexedParallelChunked[j] = transform(j, this@mapInPlaceIndexedParallelChunked[j])
        }
    }
    this@mapInPlaceIndexedParallelChunked
}

/**
 *  Performs in place map transformation on the array using coroutines.
 */
suspend inline fun DoubleArray.mapInPlaceIndexedParallelChunked(
    chunksCount: Int = Runtime.getRuntime().availableProcessors(),
    crossinline transform: suspend (index: Int, Double) -> Double
): DoubleArray = coroutineScope {
    assert(chunksCount > 0) { "Parameter chunksCount must be greater than 0" }
    if (isEmpty()) return@coroutineScope this@mapInPlaceIndexedParallelChunked

    val chunkSize = ceil(size / chunksCount.toDouble()).toInt()
    for (i in indices step chunkSize) {
        launch {
            for (j in i until (i + chunkSize).coerceAtMost(size))
                this@mapInPlaceIndexedParallelChunked[j] = transform(j, this@mapInPlaceIndexedParallelChunked[j])
        }
    }
    this@mapInPlaceIndexedParallelChunked
}

/**
 *  Performs in place map transformation on the array using coroutines.
 */
suspend inline fun BooleanArray.mapInPlaceIndexedParallelChunked(
    chunksCount: Int = Runtime.getRuntime().availableProcessors(),
    crossinline transform: suspend (index: Int, Boolean) -> Boolean
): BooleanArray = coroutineScope {
    assert(chunksCount > 0) { "Parameter chunksCount must be greater than 0" }
    if (isEmpty()) return@coroutineScope this@mapInPlaceIndexedParallelChunked

    val chunkSize = ceil(size / chunksCount.toDouble()).toInt()
    for (i in indices step chunkSize) {
        launch {
            for (j in i until (i + chunkSize).coerceAtMost(size))
                this@mapInPlaceIndexedParallelChunked[j] = transform(j, this@mapInPlaceIndexedParallelChunked[j])
        }
    }
    this@mapInPlaceIndexedParallelChunked
}
