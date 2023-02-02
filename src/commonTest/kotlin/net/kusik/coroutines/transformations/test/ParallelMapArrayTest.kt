package net.kusik.coroutines.transformations.test

import kotlinx.coroutines.test.runTest
import net.kusik.coroutines.transformations.map.mapParallel
import kotlin.test.Test
import kotlin.test.assertEquals

class ParallelMapArrayTest {


    @Test
    fun parallelMapArrayOfStrings() = runTest {
        val arraySequential = arrayOf("one", "two", "three")
        val arrayParallel = arraySequential.copyOf()

        val resultSequential = arraySequential.map { it + it }
        var resultParallel: List<String> = emptyList()
        resultParallel = arrayParallel.mapParallel { it + it }

        assertEquals(resultSequential, resultParallel)
    }

    @Test
    fun parallelMapArrayOfBytes() = runTest {
        val arraySequential = byteArrayOf(1.toByte(), 2.toByte(), 3.toByte())
        val arrayParallel = arraySequential.copyOf()

        val resultSequential = arraySequential.map { it + it }
        var resultParallel: List<Int> = emptyList()
        resultParallel = arrayParallel.mapParallel { it + it }

        assertEquals(resultSequential, resultParallel)
    }

    @Test
    fun parallelMapArrayOfShorts() = runTest {
        val arraySequential = shortArrayOf(1, 2, 3)
        val arrayParallel = arraySequential.copyOf()

        val resultSequential = arraySequential.map { it + it }
        var resultParallel: List<Int> = emptyList()
        resultParallel = arrayParallel.mapParallel { it + it }

        assertEquals(resultSequential, resultParallel)
    }

    @Test
    fun parallelMapArrayOfInts() = runTest {
        val arraySequential = intArrayOf(1, 2, 3)
        val arrayParallel = arraySequential.copyOf()

        val resultSequential = arraySequential.map { it + it }
        var resultParallel: List<Int> = emptyList()
        resultParallel = arrayParallel.mapParallel { it + it }

        assertEquals(resultSequential, resultParallel)
    }

    @Test
    fun parallelMapArrayOfLongs() = runTest {
        val arraySequential = longArrayOf(1, 2, 3)
        val arrayParallel = arraySequential.copyOf()

        val resultSequential = arraySequential.map { it + it }
        var resultParallel: List<Long> = emptyList()
        resultParallel = arrayParallel.mapParallel { it + it }

        assertEquals(resultSequential, resultParallel)
    }

    @Test
    fun parallelMapArrayOfFloats() = runTest {
        val arraySequential = floatArrayOf(1F, 2F, 3F)
        val arrayParallel = arraySequential.copyOf()

        val resultSequential = arraySequential.map { it + it }
        var resultParallel: List<Float> = emptyList()
        resultParallel = arrayParallel.mapParallel { it + it }

        assertEquals(resultSequential, resultParallel)
    }

    @Test
    fun parallelMapArrayOfDoubles() = runTest {
        val arraySequential = doubleArrayOf(1.0, 2.0, 3.0)
        val arrayParallel = arraySequential.copyOf()

        val resultSequential = arraySequential.map { it + it }
        var resultParallel: List<Double> = emptyList()
        resultParallel = arrayParallel.mapParallel { it + it }

        assertEquals(resultSequential, resultParallel)
    }

    @Test
    fun parallelMapArrayOfBooleans() = runTest {
        val arraySequential = booleanArrayOf(true, false, true)
        val arrayParallel = arraySequential.copyOf()

        val resultSequential = arraySequential.map { !it }
        var resultParallel: List<Boolean> = emptyList()
        resultParallel = arrayParallel.mapParallel { !it }

        assertEquals(resultSequential, resultParallel)
    }


}
