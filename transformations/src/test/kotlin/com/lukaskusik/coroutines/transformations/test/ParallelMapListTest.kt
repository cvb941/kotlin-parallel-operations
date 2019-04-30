package com.lukaskusik.coroutines.transformations.test

import com.lukaskusik.coroutines.transformations.map.mapParallel
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import kotlin.random.Random

class ParallelMapListTest {

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
    fun parallelMapNoChunks() {
        var listSequential = getRandomListOfSize(100)
        var listParallel = listSequential.toList()

        listSequential = listSequential.map { it * 2 }
        runBlocking {
            listParallel = listParallel.mapParallel { it * 2 }
        }


        Assert.assertEquals(listSequential, listParallel)
    }
}