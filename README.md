# Parallel coroutine operations on Kotlin collections [![](https://jitpack.io/v/cvb941/kotlin-parallel-collection-operations.svg)](https://jitpack.io/#cvb941/kotlin-parallel-collection-operations)
Provides parallelized *map*, *reduce*, etc. operations using coroutines in Kotlin.

The parallel *map* implementation is called *.mapParallel()*. It is implemented like this.
```kotlin
suspend fun <T, R> Iterable<T>.mapParallel(transform: (T) -> R): List<R> = coroutineScope {
    map { async { transform(it) } }.map { it.await() }
}
```

Example of using the parallel *map* operation.
```kotlin
fun showCase() {
  var list = listOf(1,2,3)
  runBlocking(Dispatchers.Default) {
      var mappedList = list.mapParallel { it * 2 } // Results in [2,4,6]
  }
}
```

There is also the parallel *reduce* operation with chunked variations, which can be used to perform **associative** operations on a collection, like *sum*.

**Note:** If you want to achieve multithreading, make sure to run the coroutine with the Default dispatcher.

## Chunked operations
Chunked operations improve performance since they split the collection into just a couple of segments,
which are processed each by a single thread. That benefits from data locality and lesser thread management.
It is particularly useful (pretty much needed for operations like sum) in the reduce operation when using multithreading,
since each thread takes one chunk that it reduces on its own. After all coroutines finish, their results are then reduced again to the final result.

## Benchmarks
This source includes some benchmarks in the test source folder using [JUnitBenchmarks](http://labs.carrotsearch.com/junit-benchmarks-tutorial.html).
Performance of the methods (chunked vs. not chunked and Dispatcher.Default vs Dispatcher.Main) depends on the transformation operation (whether it's blocking for a long time, suspending or really quick).

Example benchmarks will be included here soon.

## Gradle
To include this in you gradle project add the following to you root build.gradle file.
```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```
After that, include this line in your module build.gradle.
```gradle
dependencies {
    implementation 'com.github.cvb941:kotlin-parallel-collection-operations:1.1'
}
```

## Future
In the future, I would like other transformation functions to be implemented.
