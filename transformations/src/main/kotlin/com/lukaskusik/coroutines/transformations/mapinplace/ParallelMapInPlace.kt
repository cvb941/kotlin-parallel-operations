package com.lukaskusik.coroutines.transformations.mapinplace

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch


/**
 *  Performs in place map transformation on the array using coroutines.
 */
suspend fun <T> Array<T>.mapInPlaceParallel(
    transform: (T) -> T
): Array<T> = coroutineScope {
    for (i in indices) {
        launch { this@mapInPlaceParallel[i] = transform(this@mapInPlaceParallel[i]) }
    }
    this@mapInPlaceParallel
}


/**
 *  Performs in place map transformation on the array using coroutines.
 */
suspend fun ByteArray.mapInPlaceParallel(
    transform: (Byte) -> Byte
): ByteArray = coroutineScope {
    for (i in indices) {
        launch { this@mapInPlaceParallel[i] = transform(this@mapInPlaceParallel[i]) }
    }
    this@mapInPlaceParallel
}


/**
 *  Performs in place map transformation on the array using coroutines.
 */
suspend fun ShortArray.mapInPlaceParallel(
    transform: (Short) -> Short
): ShortArray = coroutineScope {
    for (i in indices) {
        launch { this@mapInPlaceParallel[i] = transform(this@mapInPlaceParallel[i]) }
    }
    this@mapInPlaceParallel
}

/**
 *  Performs in place map transformation on the array using coroutines.
 */
suspend fun IntArray.mapInPlaceParallel(
    transform: (Int) -> Int
): IntArray = coroutineScope {
    for (i in indices) {
        launch { this@mapInPlaceParallel[i] = transform(this@mapInPlaceParallel[i]) }
    }
    this@mapInPlaceParallel
}

/**
 *  Performs in place map transformation on the array using coroutines.
 */
suspend fun LongArray.mapInPlaceParallel(
    transform: (Long) -> Long
): LongArray = coroutineScope {
    for (i in indices) {
        launch { this@mapInPlaceParallel[i] = transform(this@mapInPlaceParallel[i]) }
    }
    this@mapInPlaceParallel
}

/**
 *  Performs in place map transformation on the array using coroutines.
 */
suspend fun FloatArray.mapInPlaceParallel(
    transform: (Float) -> Float
): FloatArray = coroutineScope {
    for (i in indices) {
        launch { this@mapInPlaceParallel[i] = transform(this@mapInPlaceParallel[i]) }
    }
    this@mapInPlaceParallel
}

/**
 *  Performs in place map transformation on the array using coroutines.
 */
suspend fun DoubleArray.mapInPlaceParallel(
    transform: (Double) -> Double
): DoubleArray = coroutineScope {
    for (i in indices) {
        launch { this@mapInPlaceParallel[i] = transform(this@mapInPlaceParallel[i]) }
    }
    this@mapInPlaceParallel
}

/**
 *  Performs in place map transformation on the array using coroutines.
 */
suspend fun BooleanArray.mapInPlaceParallel(
    transform: (Boolean) -> Boolean
): BooleanArray = coroutineScope {
    for (i in indices) {
        launch { this@mapInPlaceParallel[i] = transform(this@mapInPlaceParallel[i]) }
    }
    this@mapInPlaceParallel
}
