package com.lukaskusik.coroutines.transformations.test

import com.lukaskusik.coroutines.transformations.mapParallel
import com.lukaskusik.coroutines.transformations.mapParallelChunked
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import kotlin.random.Random

class ParallelMapListChunkedTest {

    companion object {
        fun getRandomListOfSize(listSize: Int): List<Int> {
            val random = Random(648)
            val list = ArrayList<Int>(listSize)
            repeat(listSize) {
                list.add(random.nextInt())
            }
            return list
        }
    }

    @Test
    fun parallelMap4Chunks() {
        var listSequential = listOf(1, 3, 3, 4, 5)
        var listParallel = listSequential.toList()

        listSequential = listSequential.map { it * 2 }
        runBlocking {
            listParallel = listParallel.mapParallelChunked(4) { it * 2 }
        }


        Assert.assertEquals(listSequential, listParallel)
    }

}