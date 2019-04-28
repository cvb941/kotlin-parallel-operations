package com.lukaskusik.coroutines.transformations

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope


/**
 *  The reduce operation must be associative, since the reduce will be most likely out of order.
 *  This method splits the original collection into chunks and reduces each of the chunks separately on their own coroutines and then reduces the result again.
 *
 *  @param chunkSize Size of each sub-collection that will be reduced in each coroutine.
 */
suspend fun <T> Iterable<T>.reduceParallel(
    chunkSize: Int,
    operation: (T, T) -> T
): T = coroutineScope {
    chunked(chunkSize).map { subChunk ->
        async {
            subChunk.reduce(operation)
        }
    }.map { it.await() }.reduce(operation)
}

/**
 *  The operation must be associative, since the reduce will be most likely out of order.
 *  This method splits the original collection into chunks and reduces each of the chunks separately on their own coroutines and then reduces the result again.
 *  The recommended chunksCount for multithreading is the number of CPU threads, e.g. 4 or 8.
 *
 *  @param chunksCount How many chunks should the collection be split into. Defaults to the number of available processors.
 */
suspend fun <T> Collection<T>.reduceParallel(
    chunksCount: Int = Runtime.getRuntime().availableProcessors(),
    operation: (T, T) -> T
): T {
    if (chunksCount <= 0) throw IllegalArgumentException("chunksCount must be a positive integer")

    val chunkSize = Math.ceil(size / chunksCount.toDouble()).toInt()
    return asIterable().reduceParallel(chunkSize, operation)
}