package net.kusik.coroutines.transformations.reduce

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlin.math.ceil


/**
 *  The reduce operation must be associative, since the reduce will be most likely out of order.
 *  This method splits the original collection into chunks and reduces each of the chunks separately on their own coroutines and then reduces the result again.
 *
 *  @param chunkSize Size of each sub-collection that will be reduced in each coroutine.
 */
suspend inline fun <T> Iterable<T>.reduceParallel(
    chunkSize: Int,
    crossinline operation: suspend (T, T) -> T
): T = coroutineScope {
    chunked(chunkSize).map { subChunk ->
        async {
            subChunk.reduce { acc, t -> operation(acc, t) }
        }
    }.map { it.await() }.reduce { acc, t -> operation(acc, t) }
}

/**
 *  The operation must be associative, since the reduce will be most likely out of order.
 *  This method splits the original collection into chunks and reduces each of the chunks separately on their own coroutines and then reduces the result again.
 *  The recommended chunksCount for multithreading is the number of CPU threads, e.g. 4 or 8.
 *
 *  @param chunksCount How many chunks should the collection be split into. Defaults to the number of available processors.
 */
suspend inline fun <T> Collection<T>.reduceParallel(
    chunksCount: Int = Runtime.getRuntime().availableProcessors(),
    crossinline operation: (T, T) -> T
): T {
    if (chunksCount <= 0) throw IllegalArgumentException("chunksCount must be a positive integer")

    val chunkSize = ceil(size / chunksCount.toDouble()).toInt()
    return asIterable().reduceParallel(chunkSize, operation)
}
