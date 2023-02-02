package net.kusik.coroutines.transformations.test

import kotlinx.coroutines.test.runTest
import net.kusik.coroutines.transformations.mapinplace.mapInPlaceParallel
import kotlin.test.Test
import kotlin.test.assertContentEquals

class ParallelMapInPlaceTest {

    @Test
    fun parallelInPlaceMapArrayOfStrings() = runTest {
        val array = arrayOf("one", "two", "three")
        val resultArray = arrayOf("oneone", "twotwo", "threethree")

        array.mapInPlaceParallel { it + it }

        assertContentEquals(array, resultArray)
    }

    @Test
    fun parallelInPlaceMapArrayOfBytes() = runTest {
        val array = byteArrayOf(1, 2, 3)
        val resultArray = byteArrayOf(2, 4, 6)

        array.mapInPlaceParallel { (it + it).toByte() }

        assertContentEquals(array, resultArray)
    }

    @Test
    fun parallelInPlaceMapArrayOfShorts() = runTest {
        val array = shortArrayOf(1, 2, 3)
        val resultArray = shortArrayOf(2, 4, 6)

        array.mapInPlaceParallel { (it + it).toShort() }

        assertContentEquals(array, resultArray)
    }

    @Test
    fun parallelInPlaceMapArrayOfInts() = runTest {
        val array = intArrayOf(1, 2, 3)
        val resultArray = intArrayOf(2, 4, 6)

        array.mapInPlaceParallel { it + it }

        assertContentEquals(array, resultArray)
    }

    @Test
    fun parallelInPlaceMapArrayOfLongs() = runTest {
        val array = longArrayOf(1, 2, 3)
        val resultArray = longArrayOf(2, 4, 6)

        array.mapInPlaceParallel { it + it }

        assertContentEquals(array, resultArray)
    }


    @Test
    fun parallelInPlaceMapArrayOfFloats() = runTest {
        val array = floatArrayOf(1F, 2F, 3F)
        val resultArray = floatArrayOf(2F, 4F, 6F)

        array.mapInPlaceParallel { it + it }

        assertContentEquals(array, resultArray)
    }


    @Test
    fun parallelInPlaceMapArrayOfDoubles() = runTest {
        val array = doubleArrayOf(1.0, 2.0, 3.0)
        val resultArray = doubleArrayOf(2.0, 4.0, 6.0)

        array.mapInPlaceParallel { it + it }

        assertContentEquals(array, resultArray)
    }


    @Test
    fun parallelInPlaceMapArrayOfBooleans() = runTest {
        val array = booleanArrayOf(true, false, true)
        val resultArray = booleanArrayOf(false, true, false)

        array.mapInPlaceParallel { !it }

        assertContentEquals(array, resultArray)
    }
}
