package com.lukaskusik.coroutines.transformations

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

/**
 *  Performs map transformation on the iterable using coroutines.
 *  The chunkSize parameter is used to run multiple transformations on a single coroutine.
 *
 *  @param chunkSize Size of each sub-collection that will be reduced in each coroutine.
 */
suspend fun <T, R> Iterable<T>.mapParallelChunked(
    chunkSize: Int,
    transform: (T) -> R
): List<R> = coroutineScope {
    chunked(chunkSize).map { subChunk ->
        async {
            subChunk.map(transform)
        }
    }.flatMap {
        it.await()
    }
}

/**
 *  Performs map transformation on the collection using coroutines.
 *
 *  It can split the collection into multiple chunks using the chunksCount parameter.
 *  Each chunk will then run on a single coroutine, minimizing thread management, etc.
 *  The default and recommended chunksCount for multithreading is the number of CPU threads, e.g. 4 or 8.
 *
 *  @param chunksCount How many chunks should the collection be split into. Defaults to the number of available processors.
 *
 */
suspend fun <T, E> Collection<T>.mapParallelChunked(
    chunksCount: Int = Runtime.getRuntime().availableProcessors(),
    transform: (T) -> E
): List<E> {
    val chunkSize = Math.ceil(size / chunksCount.toDouble()).toInt()
    return asIterable().mapParallelChunked(chunkSize, transform)
}