package com.lukaskusik.coroutines.transformations.map

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

/**
 *  Performs map transformation on the iterable using coroutines.
 */
suspend fun <T, R> Iterable<T>.mapParallel(
    transform: (T) -> R
): List<R> = coroutineScope {
    map { async { transform(it) } }.map { it.await() }
}

//region Arrays
/**
 *  Performs map transformation on the array using coroutines.
 */
suspend fun <T, R> Array<out T>.mapParallel(
    transform: (T) -> R
): List<R> = coroutineScope {
    map { async { transform(it) } }.map { it.await() }
}

/**
 *  Performs map transformation on the array using coroutines.
 */
suspend fun <R> ByteArray.mapParallel(
    transform: (Byte) -> R
): List<R> = coroutineScope {
    map { async { transform(it) } }.map { it.await() }
}

/**
 *  Performs map transformation on the array using coroutines.
 */
suspend fun <R> ShortArray.mapParallel(
    transform: (Short) -> R
): List<R> = coroutineScope {
    map { async { transform(it) } }.map { it.await() }
}

/**
 *  Performs map transformation on the array using coroutines.
 */
suspend fun <R> IntArray.mapParallel(
    transform: (Int) -> R
): List<R> = coroutineScope {
    map { async { transform(it) } }.map { it.await() }
}

/**
 *  Performs map transformation on the array using coroutines.
 */
suspend fun <R> LongArray.mapParallel(
    transform: (Long) -> R
): List<R> = coroutineScope {
    map { async { transform(it) } }.map { it.await() }
}

/**
 *  Performs map transformation on the array using coroutines.
 */
suspend fun <R> FloatArray.mapParallel(
    transform: (Float) -> R
): List<R> = coroutineScope {
    map { async { transform(it) } }.map { it.await() }
}

/**
 *  Performs map transformation on the array using coroutines.
 */
suspend fun <R> DoubleArray.mapParallel(
    transform: (Double) -> R
): List<R> = coroutineScope {
    map { async { transform(it) } }.map { it.await() }
}

/**
 *  Performs map transformation on the array using coroutines.
 */
suspend fun <R> BooleanArray.mapParallel(
    transform: (Boolean) -> R
): List<R> = coroutineScope {
    map { async { transform(it) } }.map { it.await() }
}
//endregion