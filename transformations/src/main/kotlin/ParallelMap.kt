package com.lukaskusik.coroutines.transformations

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope


suspend fun <T, R> Iterable<T>.mapParallel(transform: (T) -> R): List<R> = coroutineScope {
    map { async { transform(it) } }.map { it.await() }
}

// TODO mapParallelChunked
//suspend fun <T, E> Iterable<T>.mapParallelChunked(chunks: Int = 1, transform: (T) -> E): List<E> = coroutineScope {
//    chunked(chunks) { subChunk ->
//        System.out.println("Original: $subChunk")
//        async {
//            val transformedSubchunk = subChunk.map(transform)
//            System.out.println("Transformed: $transformedSubchunk")
//            transformedSubchunk
//        }
//    }.flatMap {
//        val flattmap = it.await()
//        System.out.println("flatmap: $flattmap")
//        flattmap
//    }
//}