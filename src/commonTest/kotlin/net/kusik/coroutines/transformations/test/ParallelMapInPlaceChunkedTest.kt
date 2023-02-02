package net.kusik.coroutines.transformations.test

import kotlinx.coroutines.test.runTest
import net.kusik.coroutines.transformations.mapinplace.mapInPlaceParallelChunked
import kotlin.test.Test
import kotlin.test.assertContentEquals

class ParallelMapInPlaceChunkedTest {

    @Test
    fun parallelInPlaceMapArrayOfStringsChunked4() = runTest {
        val array = arrayOf("one", "two", "three")
        val resultArray = arrayOf("oneone", "twotwo", "threethree")

        array.mapInPlaceParallelChunked(4) { it + it }

        assertContentEquals(array, resultArray)
    }

    @Test
    fun parallelInPlaceMapArrayOfBytesChunked4() = runTest {
        val array = byteArrayOf(1, 2, 3)
        val resultArray = byteArrayOf(2, 4, 6)

        array.mapInPlaceParallelChunked(4) { (it + it).toByte() }

        assertContentEquals(array, resultArray)
    }

    @Test
    fun parallelInPlaceMapArrayOfShortsChunked4() = runTest {
        val array = shortArrayOf(1, 2, 3)
        val resultArray = shortArrayOf(2, 4, 6)

        array.mapInPlaceParallelChunked(4) { (it + it).toShort() }

        assertContentEquals(array, resultArray)
    }

    @Test
    fun parallelInPlaceMapArrayOfIntsChunked4() = runTest {
        val array = intArrayOf(1, 2, 3)
        val resultArray = intArrayOf(2, 4, 6)

        array.mapInPlaceParallelChunked(4) { it + it }

        assertContentEquals(array, resultArray)
    }

    @Test
    fun parallelInPlaceMapArrayOfLongsChunked4() = runTest {
        val array = longArrayOf(1, 2, 3)
        val resultArray = longArrayOf(2, 4, 6)

        array.mapInPlaceParallelChunked(4) { it + it }

        assertContentEquals(array, resultArray)
    }


    @Test
    fun parallelInPlaceMapArrayOfFloatsChunked4() = runTest {
        val array = floatArrayOf(1F, 2F, 3F)
        val resultArray = floatArrayOf(2F, 4F, 6F)

        array.mapInPlaceParallelChunked(4) { it + it }

        assertContentEquals(array, resultArray)
    }


    @Test
    fun parallelInPlaceMapArrayOfDoublesChunked4() = runTest {
        val array = doubleArrayOf(1.0, 2.0, 3.0)
        val resultArray = doubleArrayOf(2.0, 4.0, 6.0)

        array.mapInPlaceParallelChunked(4) { it + it }

        assertContentEquals(array, resultArray)
    }


    @Test
    fun parallelInPlaceMapArrayOfBooleansChunked4() = runTest {
        val array = booleanArrayOf(true, false, true)
        val resultArray = booleanArrayOf(false, true, false)

        array.mapInPlaceParallelChunked(4) { !it }

        assertContentEquals(array, resultArray)
    }

    @Test
    fun parallelInPlaceEmptyChunked() = runTest {
        val array = booleanArrayOf()
        val resultArray = booleanArrayOf()

        array.mapInPlaceParallelChunked(4) { !it }

        assertContentEquals(array, resultArray)
    }
}
