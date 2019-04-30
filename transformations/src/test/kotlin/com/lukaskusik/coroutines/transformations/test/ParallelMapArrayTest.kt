package com.lukaskusik.coroutines.transformations.test

import com.lukaskusik.coroutines.transformations.map.mapParallel
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class ParallelMapArrayTest {


    @Test
    fun parallelMapArrayOfStrings() {
        val arraySequential = arrayOf("one", "two", "three")
        val arrayParallel = arraySequential.copyOf()

        val resultSequential = arraySequential.map { it + it }
        var resultParallel: List<String> = emptyList()
        runBlocking {
            resultParallel = arrayParallel.mapParallel { it + it }
        }

        Assert.assertEquals(resultSequential, resultParallel)
    }

    @Test
    fun parallelMapArrayOfBytes() {
        val arraySequential = byteArrayOf(1.toByte(), 2.toByte(), 3.toByte())
        val arrayParallel = arraySequential.copyOf()

        val resultSequential = arraySequential.map { it + it }
        var resultParallel: List<Int> = emptyList()
        runBlocking {
            resultParallel = arrayParallel.mapParallel { it + it }
        }

        Assert.assertEquals(resultSequential, resultParallel)
    }

    @Test
    fun parallelMapArrayOfShorts() {
        val arraySequential = shortArrayOf(1, 2, 3)
        val arrayParallel = arraySequential.copyOf()

        val resultSequential = arraySequential.map { it + it }
        var resultParallel: List<Int> = emptyList()
        runBlocking {
            resultParallel = arrayParallel.mapParallel { it + it }
        }

        Assert.assertEquals(resultSequential, resultParallel)
    }

    @Test
    fun parallelMapArrayOfInts() {
        val arraySequential = intArrayOf(1, 2, 3)
        val arrayParallel = arraySequential.copyOf()

        val resultSequential = arraySequential.map { it + it }
        var resultParallel: List<Int> = emptyList()
        runBlocking {
            resultParallel = arrayParallel.mapParallel { it + it }
        }

        Assert.assertEquals(resultSequential, resultParallel)
    }

    @Test
    fun parallelMapArrayOfLongs() {
        val arraySequential = longArrayOf(1, 2, 3)
        val arrayParallel = arraySequential.copyOf()

        val resultSequential = arraySequential.map { it + it }
        var resultParallel: List<Long> = emptyList()
        runBlocking {
            resultParallel = arrayParallel.mapParallel { it + it }
        }

        Assert.assertEquals(resultSequential, resultParallel)
    }

    @Test
    fun parallelMapArrayOfFloats() {
        val arraySequential = floatArrayOf(1F, 2F, 3F)
        val arrayParallel = arraySequential.copyOf()

        val resultSequential = arraySequential.map { it + it }
        var resultParallel: List<Float> = emptyList()
        runBlocking {
            resultParallel = arrayParallel.mapParallel { it + it }
        }

        Assert.assertEquals(resultSequential, resultParallel)
    }

    @Test
    fun parallelMapArrayOfDoubles() {
        val arraySequential = doubleArrayOf(1.0, 2.0, 3.0)
        val arrayParallel = arraySequential.copyOf()

        val resultSequential = arraySequential.map { it + it }
        var resultParallel: List<Double> = emptyList()
        runBlocking {
            resultParallel = arrayParallel.mapParallel { it + it }
        }

        Assert.assertEquals(resultSequential, resultParallel)
    }

    @Test
    fun parallelMapArrayOfBooleans() {
        val arraySequential = booleanArrayOf(true, false, true)
        val arrayParallel = arraySequential.copyOf()

        val resultSequential = arraySequential.map { !it }
        var resultParallel: List<Boolean> = emptyList()
        runBlocking {
            resultParallel = arrayParallel.mapParallel { !it }
        }

        Assert.assertEquals(resultSequential, resultParallel)
    }


}