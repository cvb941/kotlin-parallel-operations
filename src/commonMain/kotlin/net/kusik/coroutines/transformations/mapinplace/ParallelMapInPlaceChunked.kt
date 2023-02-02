package net.kusik.coroutines.transformations.mapinplace

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import net.kusik.util.PlatformInfo
import kotlin.math.ceil


/**
 *  Performs in place map transformation on the array using coroutines.
 */
suspend inline fun <T> Array<T>.mapInPlaceParallelChunked(
    chunksCount: Int = PlatformInfo.availableProcessors(),
    crossinline transform: suspend (T) -> T
): Array<T> = coroutineScope {
    require(chunksCount > 0) { "Parameter chunksCount must be greater than 0" }
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
suspend inline fun ByteArray.mapInPlaceParallelChunked(
    chunksCount: Int = PlatformInfo.availableProcessors(),
    crossinline transform: suspend (Byte) -> Byte
): ByteArray = coroutineScope {
    require(chunksCount > 0) { "Parameter chunksCount must be greater than 0" }
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
suspend inline fun ShortArray.mapInPlaceParallelChunked(
    chunksCount: Int = PlatformInfo.availableProcessors(),
    crossinline transform: suspend (Short) -> Short
): ShortArray = coroutineScope {
    require(chunksCount > 0) { "Parameter chunksCount must be greater than 0" }
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
suspend inline fun IntArray.mapInPlaceParallelChunked(
    chunksCount: Int = PlatformInfo.availableProcessors(),
    crossinline transform: suspend (Int) -> Int
): IntArray = coroutineScope {
    require(chunksCount > 0) { "Parameter chunksCount must be greater than 0" }
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
suspend inline fun LongArray.mapInPlaceParallelChunked(
    chunksCount: Int = PlatformInfo.availableProcessors(),
    crossinline transform: suspend (Long) -> Long
): LongArray = coroutineScope {
    require(chunksCount > 0) { "Parameter chunksCount must be greater than 0" }
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
suspend inline fun FloatArray.mapInPlaceParallelChunked(
    chunksCount: Int = PlatformInfo.availableProcessors(),
    crossinline transform: suspend (Float) -> Float
): FloatArray = coroutineScope {
    require(chunksCount > 0) { "Parameter chunksCount must be greater than 0" }
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
suspend inline fun DoubleArray.mapInPlaceParallelChunked(
    chunksCount: Int = PlatformInfo.availableProcessors(),
    crossinline transform: suspend (Double) -> Double
): DoubleArray = coroutineScope {
    require(chunksCount > 0) { "Parameter chunksCount must be greater than 0" }
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
suspend inline fun BooleanArray.mapInPlaceParallelChunked(
    chunksCount: Int = PlatformInfo.availableProcessors(),
    crossinline transform: suspend (Boolean) -> Boolean
): BooleanArray = coroutineScope {
    require(chunksCount > 0) { "Parameter chunksCount must be greater than 0" }
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
