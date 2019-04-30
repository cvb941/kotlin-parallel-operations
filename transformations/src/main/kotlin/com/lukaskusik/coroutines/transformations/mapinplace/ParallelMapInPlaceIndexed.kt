package com.lukaskusik.coroutines.transformations.mapinplace

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch


/**
 *  Performs in place map transformation on the array using coroutines.
 */
suspend fun <T> Array<T>.mapInPlaceIndexedParallel(
    transform: (index:Int,T) -> T
): Array<T> = coroutineScope {
    for (i in indices) {
        launch { this@mapInPlaceIndexedParallel[i] = transform(i, this@mapInPlaceIndexedParallel[i]) }
    }
    this@mapInPlaceIndexedParallel
}


/**
 *  Performs in place map transformation on the array using coroutines.
 */
suspend fun ByteArray.mapInPlaceIndexedParallel(
    transform: (index:Int,Byte) -> Byte
): ByteArray = coroutineScope {
    for (i in indices) {
        launch { this@mapInPlaceIndexedParallel[i] = transform(i, this@mapInPlaceIndexedParallel[i]) }
    }
    this@mapInPlaceIndexedParallel
}


/**
 *  Performs in place map transformation on the array using coroutines.
 */
suspend fun ShortArray.mapInPlaceIndexedParallel(
    transform: (index:Int,Short) -> Short
): ShortArray = coroutineScope {
    for (i in indices) {
        launch { this@mapInPlaceIndexedParallel[i] = transform(i, this@mapInPlaceIndexedParallel[i]) }
    }
    this@mapInPlaceIndexedParallel
}

/**
 *  Performs in place map transformation on the array using coroutines.
 */
suspend fun IntArray.mapInPlaceIndexedParallel(
    transform: (index:Int,Int) -> Int
): IntArray = coroutineScope {
    for (i in indices) {
        launch { this@mapInPlaceIndexedParallel[i] = transform(i, this@mapInPlaceIndexedParallel[i]) }
    }
    this@mapInPlaceIndexedParallel
}

/**
 *  Performs in place map transformation on the array using coroutines.
 */
suspend fun LongArray.mapInPlaceIndexedParallel(
    transform: (index:Int,Long) -> Long
): LongArray = coroutineScope {
    for (i in indices) {
        launch { this@mapInPlaceIndexedParallel[i] = transform(i, this@mapInPlaceIndexedParallel[i]) }
    }
    this@mapInPlaceIndexedParallel
}

/**
 *  Performs in place map transformation on the array using coroutines.
 */
suspend fun FloatArray.mapInPlaceIndexedParallel(
    transform: (index:Int,Float) -> Float
): FloatArray = coroutineScope {
    for (i in indices) {
        launch { this@mapInPlaceIndexedParallel[i] = transform(i, this@mapInPlaceIndexedParallel[i]) }
    }
    this@mapInPlaceIndexedParallel
}

/**
 *  Performs in place map transformation on the array using coroutines.
 */
suspend fun DoubleArray.mapInPlaceIndexedParallel(
    transform: (index:Int,Double) -> Double
): DoubleArray = coroutineScope {
    for (i in indices) {
        launch { this@mapInPlaceIndexedParallel[i] = transform(i, this@mapInPlaceIndexedParallel[i]) }
    }
    this@mapInPlaceIndexedParallel
}

/**
 *  Performs in place map transformation on the array using coroutines.
 */
suspend fun BooleanArray.mapInPlaceIndexedParallel(
    transform: (index:Int,Boolean) -> Boolean
): BooleanArray = coroutineScope {
    for (i in indices) {
        launch { this@mapInPlaceIndexedParallel[i] = transform(i, this@mapInPlaceIndexedParallel[i]) }
    }
    this@mapInPlaceIndexedParallel
}
