package com.lukaskusik.coroutines.transformations

fun <T> Array<T>.mapInPlace(transform: (T) -> T): Array<T> {
    for (i in this.indices) this[i] = transform(this[i])
    return this
}

fun ByteArray.mapInPlace(transform: (Byte) -> Byte): ByteArray {
    for (i in this.indices) this[i] = transform(this[i])
    return this
}

fun ShortArray.mapInPlace(transform: (Short) -> Short): ShortArray {
    for (i in this.indices) this[i] = transform(this[i])
    return this
}

fun IntArray.mapInPlace(transform: (Int) -> Int): IntArray {
    for (i in this.indices) this[i] = transform(this[i])
    return this
}

fun LongArray.mapInPlace(transform: (Long) -> Long): LongArray {
    for (i in this.indices) this[i] = transform(this[i])
    return this
}

fun FloatArray.mapInPlace(transform: (Float) -> Float): FloatArray {
    for (i in this.indices) this[i] = transform(this[i])
    return this
}

fun DoubleArray.mapInPlace(transform: (Double) -> Double): DoubleArray {
    for (i in this.indices) this[i] = transform(this[i])
    return this
}

fun BooleanArray.mapInPlace(transform: (Boolean) -> Boolean): BooleanArray {
    for (i in this.indices) this[i] = transform(this[i])
    return this
}
