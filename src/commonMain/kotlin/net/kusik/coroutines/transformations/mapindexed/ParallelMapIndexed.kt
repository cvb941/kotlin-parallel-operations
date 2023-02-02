package net.kusik.coroutines.transformations.mapindexed

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

/**
 *  Performs map transformation on the iterable using coroutines.
 */
suspend inline fun <T, R> Iterable<T>.mapIndexedParallel(
    crossinline transform: suspend (index: Int, T) -> R
): List<R> = coroutineScope {
    mapIndexed { i, elem -> async { transform(i, elem) } }.map { it.await() }
}

//region Arrays
/**
 *  Performs map transformation on the array using coroutines.
 */
suspend inline fun <T, R> Array<out T>.mapIndexedParallel(
    crossinline transform: suspend (index: Int, T) -> R
): List<R> = coroutineScope {
    mapIndexed { i, elem -> async { transform(i, elem) } }.map { it.await() }
}

/**
 *  Performs map transformation on the array using coroutines.
 */
suspend inline fun <R> ByteArray.mapIndexedParallel(
    crossinline transform: suspend (index: Int, Byte) -> R
): List<R> = coroutineScope {
    mapIndexed { i, elem -> async { transform(i, elem) } }.map { it.await() }
}

/**
 *  Performs map transformation on the array using coroutines.
 */
suspend inline fun <R> ShortArray.mapIndexedParallel(
    crossinline transform: suspend (index: Int, Short) -> R
): List<R> = coroutineScope {
    mapIndexed { i, elem -> async { transform(i, elem) } }.map { it.await() }
}

/**
 *  Performs map transformation on the array using coroutines.
 */
suspend inline fun <R> IntArray.mapIndexedParallel(
    crossinline transform: suspend (index: Int, Int) -> R
): List<R> = coroutineScope {
    mapIndexed { i, elem -> async { transform(i, elem) } }.map { it.await() }
}

/**
 *  Performs map transformation on the array using coroutines.
 */
suspend inline fun <R> LongArray.mapIndexedParallel(
    crossinline transform: suspend (index: Int, Long) -> R
): List<R> = coroutineScope {
    mapIndexed { i, elem -> async { transform(i, elem) } }.map { it.await() }
}

/**
 *  Performs map transformation on the array using coroutines.
 */
suspend inline fun <R> FloatArray.mapIndexedParallel(
    crossinline transform: suspend (index: Int, Float) -> R
): List<R> = coroutineScope {
    mapIndexed { i, elem -> async { transform(i, elem) } }.map { it.await() }
}

/**
 *  Performs map transformation on the array using coroutines.
 */
suspend inline fun <R> DoubleArray.mapIndexedParallel(
    crossinline transform: suspend (index: Int, Double) -> R
): List<R> = coroutineScope {
    mapIndexed { i, elem -> async { transform(i, elem) } }.map { it.await() }
}

/**
 *  Performs map transformation on the array using coroutines.
 */
suspend inline fun <R> BooleanArray.mapIndexedParallel(
    crossinline transform: suspend (index: Int, Boolean) -> R
): List<R> = coroutineScope {
    mapIndexed { i, elem -> async { transform(i, elem) } }.map { it.await() }
}
//endregion
