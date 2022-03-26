package com.lukaskusik.coroutines.transformations.mapinplace

inline fun <T> Array<T>.mapInPlaceIndexed(transform: (index: Int, T) -> T): Array<T> {
    for (i in this.indices) this[i] = transform(i, this[i])
    return this
}

inline fun ByteArray.mapInPlaceIndexed(transform: (index: Int, Byte) -> Byte): ByteArray {
    for (i in this.indices) this[i] = transform(i, this[i])
    return this
}

inline fun ShortArray.mapInPlaceIndexed(transform: (index: Int, Short) -> Short): ShortArray {
    for (i in this.indices) this[i] = transform(i, this[i])
    return this
}

inline fun IntArray.mapInPlaceIndexed(transform: (index: Int, Int) -> Int): IntArray {
    for (i in this.indices) this[i] = transform(i, this[i])
    return this
}

inline fun LongArray.mapInPlaceIndexed(transform: (index: Int, Long) -> Long): LongArray {
    for (i in this.indices) this[i] = transform(i, this[i])
    return this
}

inline fun FloatArray.mapInPlaceIndexed(transform: (index: Int, Float) -> Float): FloatArray {
    for (i in this.indices) this[i] = transform(i, this[i])
    return this
}

inline fun DoubleArray.mapInPlaceIndexed(transform: (index: Int, Double) -> Double): DoubleArray {
    for (i in this.indices) this[i] = transform(i, this[i])
    return this
}

inline fun BooleanArray.mapInPlaceIndexed(transform: (index: Int, Boolean) -> Boolean): BooleanArray {
    for (i in this.indices) this[i] = transform(i, this[i])
    return this
}
