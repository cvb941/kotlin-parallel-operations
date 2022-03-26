package net.kusik.coroutines.transformations.test

import net.kusik.coroutines.transformations.mapinplace.mapInPlaceParallelChunked
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import kotlin.test.assertFails

class ParallelMapInPlaceChunkedTest {

    @Test
    fun parallelInPlaceMapArrayOfStringsChunked4() {
        val array = arrayOf("one", "two", "three")
        val resultArray = arrayOf("oneone", "twotwo", "threethree")

        runBlocking {
            array.mapInPlaceParallelChunked(4) { it + it }
        }

        Assert.assertArrayEquals(array, resultArray)
    }

    @Test
    fun parallelInPlaceMapArrayOfBytesChunked4() {
        val array = byteArrayOf(1, 2, 3)
        val resultArray = byteArrayOf(2, 4, 6)

        runBlocking {
            array.mapInPlaceParallelChunked(4) { (it + it).toByte() }
        }

        Assert.assertArrayEquals(array, resultArray)
    }

    @Test
    fun parallelInPlaceMapArrayOfShortsChunked4() {
        val array = shortArrayOf(1, 2, 3)
        val resultArray = shortArrayOf(2, 4, 6)

        runBlocking {
            array.mapInPlaceParallelChunked(4) { (it + it).toShort() }
        }

        Assert.assertArrayEquals(array, resultArray)
    }

    @Test
    fun parallelInPlaceMapArrayOfIntsChunked4() {
        val array = intArrayOf(1, 2, 3)
        val resultArray = intArrayOf(2, 4, 6)

        runBlocking {
            array.mapInPlaceParallelChunked(4) { it + it }
        }

        Assert.assertArrayEquals(array, resultArray)
    }

    @Test
    fun parallelInPlaceMapArrayOfLongsChunked4() {
        val array = longArrayOf(1, 2, 3)
        val resultArray = longArrayOf(2, 4, 6)

        runBlocking {
            array.mapInPlaceParallelChunked(4) { it + it }
        }

        Assert.assertArrayEquals(array, resultArray)
    }


    @Test
    fun parallelInPlaceMapArrayOfFloatsChunked4() {
        val array = floatArrayOf(1F, 2F, 3F)
        val resultArray = floatArrayOf(2F, 4F, 6F)

        runBlocking {
            array.mapInPlaceParallelChunked(4) { it + it }
        }

        Assert.assertArrayEquals(array, resultArray, 0.01f)
    }


    @Test
    fun parallelInPlaceMapArrayOfDoublesChunked4() {
        val array = doubleArrayOf(1.0, 2.0, 3.0)
        val resultArray = doubleArrayOf(2.0, 4.0, 6.0)

        runBlocking {
            array.mapInPlaceParallelChunked(4) { it + it }
        }

        Assert.assertArrayEquals(array, resultArray, 0.01)
    }


    @Test
    fun parallelInPlaceMapArrayOfBooleansChunked4() {
        val array = booleanArrayOf(true, false, true)
        val resultArray = booleanArrayOf(false, true, false)

        runBlocking {
            array.mapInPlaceParallelChunked(4) { !it }
        }

        Assert.assertArrayEquals(array, resultArray)
    }

    @Test
    fun parallelInPlaceEmptyChunked() {
        val array = booleanArrayOf()
        val resultArray = booleanArrayOf()

        runBlocking {
            array.mapInPlaceParallelChunked(4) { !it }
        }

        Assert.assertArrayEquals(array, resultArray)
    }
}
