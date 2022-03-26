package com.lukaskusik.coroutines.transformations.mapinplace

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch


/**
 *  Performs in place map transformation on the array using coroutines.
 */
suspend inline fun <T> Array<T>.mapInPlaceIndexedParallel(
    crossinline transform: suspend (index: Int, T) -> T
): Array<T> = coroutineScope {
    for (i in indices) {
        launch { this@mapInPlaceIndexedParallel[i] = transform(i, this@mapInPlaceIndexedParallel[i]) }
    }
    this@mapInPlaceIndexedParallel
}


/**
 *  Performs in place map transformation on the array using coroutines.
 */
suspend inline fun ByteArray.mapInPlaceIndexedParallel(
    crossinline transform: suspend (index: Int, Byte) -> Byte
): ByteArray = coroutineScope {
    for (i in indices) {
        launch { this@mapInPlaceIndexedParallel[i] = transform(i, this@mapInPlaceIndexedParallel[i]) }
    }
    this@mapInPlaceIndexedParallel
}


/**
 *  Performs in place map transformation on the array using coroutines.
 */
suspend inline fun ShortArray.mapInPlaceIndexedParallel(
    crossinline transform: suspend (index: Int, Short) -> Short
): ShortArray = coroutineScope {
    for (i in indices) {
        launch { this@mapInPlaceIndexedParallel[i] = transform(i, this@mapInPlaceIndexedParallel[i]) }
    }
    this@mapInPlaceIndexedParallel
}

/**
 *  Performs in place map transformation on the array using coroutines.
 */
suspend inline fun IntArray.mapInPlaceIndexedParallel(
    crossinline transform: suspend (index: Int, Int) -> Int
): IntArray = coroutineScope {
    for (i in indices) {
        launch { this@mapInPlaceIndexedParallel[i] = transform(i, this@mapInPlaceIndexedParallel[i]) }
    }
    this@mapInPlaceIndexedParallel
}

/**
 *  Performs in place map transformation on the array using coroutines.
 */
suspend inline fun LongArray.mapInPlaceIndexedParallel(
    crossinline transform: suspend (index: Int, Long) -> Long
): LongArray = coroutineScope {
    for (i in indices) {
        launch { this@mapInPlaceIndexedParallel[i] = transform(i, this@mapInPlaceIndexedParallel[i]) }
    }
    this@mapInPlaceIndexedParallel
}

/**
 *  Performs in place map transformation on the array using coroutines.
 */
suspend inline fun FloatArray.mapInPlaceIndexedParallel(
    crossinline transform: suspend (index: Int, Float) -> Float
): FloatArray = coroutineScope {
    for (i in indices) {
        launch { this@mapInPlaceIndexedParallel[i] = transform(i, this@mapInPlaceIndexedParallel[i]) }
    }
    this@mapInPlaceIndexedParallel
}

/**
 *  Performs in place map transformation on the array using coroutines.
 */
suspend inline fun DoubleArray.mapInPlaceIndexedParallel(
    crossinline transform: suspend (index: Int, Double) -> Double
): DoubleArray = coroutineScope {
    for (i in indices) {
        launch { this@mapInPlaceIndexedParallel[i] = transform(i, this@mapInPlaceIndexedParallel[i]) }
    }
    this@mapInPlaceIndexedParallel
}

/**
 *  Performs in place map transformation on the array using coroutines.
 */
suspend inline fun BooleanArray.mapInPlaceIndexedParallel(
    crossinline transform: suspend (index: Int, Boolean) -> Boolean
): BooleanArray = coroutineScope {
    for (i in indices) {
        launch { this@mapInPlaceIndexedParallel[i] = transform(i, this@mapInPlaceIndexedParallel[i]) }
    }
    this@mapInPlaceIndexedParallel
}
