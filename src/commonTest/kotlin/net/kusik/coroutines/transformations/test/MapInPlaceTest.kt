package net.kusik.coroutines.transformations.test

import net.kusik.coroutines.transformations.mapinplace.mapInPlace
import kotlin.test.Test
import kotlin.test.assertContentEquals

class MapInPlaceTest {

    @Test
    fun inPlaceMapArrayOfStrings() {
        val array = arrayOf("one", "two", "three")
        val resultArray = arrayOf("oneone", "twotwo", "threethree")

        array.mapInPlace { it + it }
        
        assertContentEquals(array, resultArray)
    }

    @Test
    fun inPlaceMapArrayOfBytes() {
        val array = byteArrayOf(1, 2, 3)
        val resultArray = byteArrayOf(2, 4, 6)

        array.mapInPlace { (it + it).toByte() }

        assertContentEquals(array, resultArray)
    }

    @Test
    fun inPlaceMapArrayOfShorts() {
        val array = shortArrayOf(1, 2, 3)
        val resultArray = shortArrayOf(2, 4, 6)

        array.mapInPlace { (it + it).toShort() }

        assertContentEquals(array, resultArray)
    }

    @Test
    fun inPlaceMapArrayOfInts() {
        val array = intArrayOf(1, 2, 3)
        val resultArray = intArrayOf(2, 4, 6)

        array.mapInPlace { it + it }

        assertContentEquals(array, resultArray)
    }

    @Test
    fun inPlaceMapArrayOfLongs() {
        val array = longArrayOf(1, 2, 3)
        val resultArray = longArrayOf(2, 4, 6)

        array.mapInPlace { it + it }

        assertContentEquals(array, resultArray)
    }


    @Test
    fun inPlaceMapArrayOfFloats() {
        val array = floatArrayOf(1F, 2F, 3F)
        val resultArray = floatArrayOf(2F, 4F, 6F)

        array.mapInPlace { it + it }

        assertContentEquals(array, resultArray)
    }


    @Test
    fun inPlaceMapArrayOfDoubles() {
        val array = doubleArrayOf(1.0, 2.0, 3.0)
        val resultArray = doubleArrayOf(2.0, 4.0, 6.0)

        array.mapInPlace { it + it }

        assertContentEquals(array, resultArray)
    }


    @Test
    fun inPlaceMapArrayOfBooleans() {
        val array = booleanArrayOf(true, false, true)
        val resultArray = booleanArrayOf(false, true, false)

        array.mapInPlace { !it }

        assertContentEquals(array, resultArray)
    }

}
