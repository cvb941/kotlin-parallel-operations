package com.lukaskusik.coroutines.transformations.mapinplace

inline fun <T> Array<T>.mapInPlace(transform: (T) -> T): Array<T> {
    for (i in this.indices) this[i] = transform(this[i])
    return this
}

inline fun ByteArray.mapInPlace(transform: (Byte) -> Byte): ByteArray {
    for (i in this.indices) this[i] = transform(this[i])
    return this
}

inline fun ShortArray.mapInPlace(transform: (Short) -> Short): ShortArray {
    for (i in this.indices) this[i] = transform(this[i])
    return this
}

inline fun IntArray.mapInPlace(transform: (Int) -> Int): IntArray {
    for (i in this.indices) this[i] = transform(this[i])
    return this
}

inline fun LongArray.mapInPlace(transform: (Long) -> Long): LongArray {
    for (i in this.indices) this[i] = transform(this[i])
    return this
}

inline fun FloatArray.mapInPlace(transform: (Float) -> Float): FloatArray {
    for (i in this.indices) this[i] = transform(this[i])
    return this
}

inline fun DoubleArray.mapInPlace(transform: (Double) -> Double): DoubleArray {
    for (i in this.indices) this[i] = transform(this[i])
    return this
}

inline fun BooleanArray.mapInPlace(transform: (Boolean) -> Boolean): BooleanArray {
    for (i in this.indices) this[i] = transform(this[i])
    return this
}
