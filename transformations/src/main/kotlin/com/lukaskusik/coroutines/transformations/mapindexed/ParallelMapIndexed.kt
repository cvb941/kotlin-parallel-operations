package com.lukaskusik.coroutines.transformations.mapindexed

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

/**
 *  Performs map transformation on the iterable using coroutines.
 */
suspend fun <T, R> Iterable<T>.mapIndexedParallel(
    transform: (index: Int, T) -> R
): List<R> = coroutineScope {
    mapIndexed { i, elem -> async { transform(i, elem) } }.map { it.await() }
}

//region Arrays
/**
 *  Performs map transformation on the array using coroutines.
 */
suspend fun <T, R> Array<out T>.mapIndexedParallel(
    transform: (index: Int, T) -> R
): List<R> = coroutineScope {
    mapIndexed { i, elem -> async { transform(i, elem) } }.map { it.await() }
}

/**
 *  Performs map transformation on the array using coroutines.
 */
suspend fun <R> ByteArray.mapIndexedParallel(
    transform: (index: Int, Byte) -> R
): List<R> = coroutineScope {
    mapIndexed { i, elem -> async { transform(i, elem) } }.map { it.await() }
}

/**
 *  Performs map transformation on the array using coroutines.
 */
suspend fun <R> ShortArray.mapIndexedParallel(
    transform: (index: Int, Short) -> R
): List<R> = coroutineScope {
    mapIndexed { i, elem -> async { transform(i, elem) } }.map { it.await() }
}

/**
 *  Performs map transformation on the array using coroutines.
 */
suspend fun <R> IntArray.mapIndexedParallel(
    transform: (index: Int, Int) -> R
): List<R> = coroutineScope {
    mapIndexed { i, elem -> async { transform(i, elem) } }.map { it.await() }
}

/**
 *  Performs map transformation on the array using coroutines.
 */
suspend fun <R> LongArray.mapIndexedParallel(
    transform: (index: Int, Long) -> R
): List<R> = coroutineScope {
    mapIndexed { i, elem -> async { transform(i, elem) } }.map { it.await() }
}

/**
 *  Performs map transformation on the array using coroutines.
 */
suspend fun <R> FloatArray.mapIndexedParallel(
    transform: (index: Int, Float) -> R
): List<R> = coroutineScope {
    mapIndexed { i, elem -> async { transform(i, elem) } }.map { it.await() }
}

/**
 *  Performs map transformation on the array using coroutines.
 */
suspend fun <R> DoubleArray.mapIndexedParallel(
    transform: (index: Int, Double) -> R
): List<R> = coroutineScope {
    mapIndexed { i, elem -> async { transform(i, elem) } }.map { it.await() }
}

/**
 *  Performs map transformation on the array using coroutines.
 */
suspend fun <R> BooleanArray.mapIndexedParallel(
    transform: (index: Int, Boolean) -> R
): List<R> = coroutineScope {
    mapIndexed { i, elem -> async { transform(i, elem) } }.map { it.await() }
}
//endregion