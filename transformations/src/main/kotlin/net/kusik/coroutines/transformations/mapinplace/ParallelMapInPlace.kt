package net.kusik.coroutines.transformations.mapinplace

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch


/**
 *  Performs in place map transformation on the array using coroutines.
 */
suspend inline fun <T> Array<T>.mapInPlaceParallel(
    crossinline transform: suspend (T) -> T
): Array<T> = coroutineScope {
    for (i in indices) {
        launch { this@mapInPlaceParallel[i] = transform(this@mapInPlaceParallel[i]) }
    }
    this@mapInPlaceParallel
}


/**
 *  Performs in place map transformation on the array using coroutines.
 */
suspend inline fun ByteArray.mapInPlaceParallel(
    crossinline transform: suspend (Byte) -> Byte
): ByteArray = coroutineScope {
    for (i in indices) {
        launch { this@mapInPlaceParallel[i] = transform(this@mapInPlaceParallel[i]) }
    }
    this@mapInPlaceParallel
}


/**
 *  Performs in place map transformation on the array using coroutines.
 */
suspend inline fun ShortArray.mapInPlaceParallel(
    crossinline transform: suspend (Short) -> Short
): ShortArray = coroutineScope {
    for (i in indices) {
        launch { this@mapInPlaceParallel[i] = transform(this@mapInPlaceParallel[i]) }
    }
    this@mapInPlaceParallel
}

/**
 *  Performs in place map transformation on the array using coroutines.
 */
suspend inline fun IntArray.mapInPlaceParallel(
    crossinline transform: suspend (Int) -> Int
): IntArray = coroutineScope {
    for (i in indices) {
        launch { this@mapInPlaceParallel[i] = transform(this@mapInPlaceParallel[i]) }
    }
    this@mapInPlaceParallel
}

/**
 *  Performs in place map transformation on the array using coroutines.
 */
suspend inline fun LongArray.mapInPlaceParallel(
    crossinline transform: suspend (Long) -> Long
): LongArray = coroutineScope {
    for (i in indices) {
        launch { this@mapInPlaceParallel[i] = transform(this@mapInPlaceParallel[i]) }
    }
    this@mapInPlaceParallel
}

/**
 *  Performs in place map transformation on the array using coroutines.
 */
suspend inline fun FloatArray.mapInPlaceParallel(
    crossinline transform: suspend (Float) -> Float
): FloatArray = coroutineScope {
    for (i in indices) {
        launch { this@mapInPlaceParallel[i] = transform(this@mapInPlaceParallel[i]) }
    }
    this@mapInPlaceParallel
}

/**
 *  Performs in place map transformation on the array using coroutines.
 */
suspend inline fun DoubleArray.mapInPlaceParallel(
    crossinline transform: suspend (Double) -> Double
): DoubleArray = coroutineScope {
    for (i in indices) {
        launch { this@mapInPlaceParallel[i] = transform(this@mapInPlaceParallel[i]) }
    }
    this@mapInPlaceParallel
}

/**
 *  Performs in place map transformation on the array using coroutines.
 */
suspend inline fun BooleanArray.mapInPlaceParallel(
    crossinline transform: suspend (Boolean) -> Boolean
): BooleanArray = coroutineScope {
    for (i in indices) {
        launch { this@mapInPlaceParallel[i] = transform(this@mapInPlaceParallel[i]) }
    }
    this@mapInPlaceParallel
}
