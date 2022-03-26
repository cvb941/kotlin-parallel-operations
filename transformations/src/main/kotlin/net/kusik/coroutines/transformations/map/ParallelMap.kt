package net.kusik.coroutines.transformations.map

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

/**
 *  Performs map transformation on the iterable using coroutines.
 */
suspend inline fun <T, R> Iterable<T>.mapParallel(
    crossinline transform: suspend (T) -> R
): List<R> = coroutineScope {
    map { async { transform(it) } }.map { it.await() }
}

//region Arrays
/**
 *  Performs map transformation on the array using coroutines.
 */
suspend inline fun <T, R> Array<out T>.mapParallel(
    crossinline transform: suspend (T) -> R
): List<R> = coroutineScope {
    map { async { transform(it) } }.map { it.await() }
}

/**
 *  Performs map transformation on the array using coroutines.
 */
suspend inline fun <R> ByteArray.mapParallel(
    crossinline transform: suspend (Byte) -> R
): List<R> = coroutineScope {
    map { async { transform(it) } }.map { it.await() }
}

/**
 *  Performs map transformation on the array using coroutines.
 */
suspend inline fun <R> ShortArray.mapParallel(
    crossinline transform: suspend (Short) -> R
): List<R> = coroutineScope {
    map { async { transform(it) } }.map { it.await() }
}

/**
 *  Performs map transformation on the array using coroutines.
 */
suspend inline fun <R> IntArray.mapParallel(
    crossinline transform: suspend (Int) -> R
): List<R> = coroutineScope {
    map { async { transform(it) } }.map { it.await() }
}

/**
 *  Performs map transformation on the array using coroutines.
 */
suspend inline fun <R> LongArray.mapParallel(
    crossinline transform: suspend (Long) -> R
): List<R> = coroutineScope {
    map { async { transform(it) } }.map { it.await() }
}

/**
 *  Performs map transformation on the array using coroutines.
 */
suspend inline fun <R> FloatArray.mapParallel(
    crossinline transform: suspend (Float) -> R
): List<R> = coroutineScope {
    map { async { transform(it) } }.map { it.await() }
}

/**
 *  Performs map transformation on the array using coroutines.
 */
suspend inline fun <R> DoubleArray.mapParallel(
    crossinline transform: suspend (Double) -> R
): List<R> = coroutineScope {
    map { async { transform(it) } }.map { it.await() }
}

/**
 *  Performs map transformation on the array using coroutines.
 */
suspend inline fun <R> BooleanArray.mapParallel(
    crossinline transform: suspend (Boolean) -> R
): List<R> = coroutineScope {
    map { async { transform(it) } }.map { it.await() }
}
//endregion
