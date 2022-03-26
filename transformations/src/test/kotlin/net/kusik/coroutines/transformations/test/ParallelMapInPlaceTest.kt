package net.kusik.coroutines.transformations.test

import net.kusik.coroutines.transformations.mapinplace.mapInPlaceParallel
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class ParallelMapInPlaceTest {

    @Test
    fun parallelInPlaceMapArrayOfStrings() {
        val array = arrayOf("one", "two", "three")
        val resultArray = arrayOf("oneone", "twotwo", "threethree")

        runBlocking {
            array.mapInPlaceParallel { it + it }
        }

        Assert.assertArrayEquals(array, resultArray)
    }

    @Test
    fun parallelInPlaceMapArrayOfBytes() {
        val array = byteArrayOf(1, 2, 3)
        val resultArray = byteArrayOf(2, 4, 6)

        runBlocking {
            array.mapInPlaceParallel { (it + it).toByte() }
        }

        Assert.assertArrayEquals(array, resultArray)
    }

    @Test
    fun parallelInPlaceMapArrayOfShorts() {
        val array = shortArrayOf(1, 2, 3)
        val resultArray = shortArrayOf(2, 4, 6)

        runBlocking {
            array.mapInPlaceParallel { (it + it).toShort() }
        }

        Assert.assertArrayEquals(array, resultArray)
    }

    @Test
    fun parallelInPlaceMapArrayOfInts() {
        val array = intArrayOf(1, 2, 3)
        val resultArray = intArrayOf(2, 4, 6)

        runBlocking {
            array.mapInPlaceParallel { it + it }
        }

        Assert.assertArrayEquals(array, resultArray)
    }

    @Test
    fun parallelInPlaceMapArrayOfLongs() {
        val array = longArrayOf(1, 2, 3)
        val resultArray = longArrayOf(2, 4, 6)

        runBlocking {
            array.mapInPlaceParallel { it + it }
        }

        Assert.assertArrayEquals(array, resultArray)
    }


    @Test
    fun parallelInPlaceMapArrayOfFloats() {
        val array = floatArrayOf(1F, 2F, 3F)
        val resultArray = floatArrayOf(2F, 4F, 6F)

        runBlocking {
            array.mapInPlaceParallel { it + it }
        }

        Assert.assertArrayEquals(array, resultArray, 0.01f)
    }


    @Test
    fun parallelInPlaceMapArrayOfDoubles() {
        val array = doubleArrayOf(1.0, 2.0, 3.0)
        val resultArray = doubleArrayOf(2.0, 4.0, 6.0)

        runBlocking {
            array.mapInPlaceParallel { it + it }
        }

        Assert.assertArrayEquals(array, resultArray, 0.01)
    }


    @Test
    fun parallelInPlaceMapArrayOfBooleans() {
        val array = booleanArrayOf(true, false, true)
        val resultArray = booleanArrayOf(false, true, false)

        runBlocking {
            array.mapInPlaceParallel { !it }
        }

        Assert.assertArrayEquals(array, resultArray)
    }
}
