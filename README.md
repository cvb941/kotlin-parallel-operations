# Parallel Operations for Kotlin
Parallel *map*, *reduce*, and various indexed and in-place operations on collections for Kotlin using coroutines.

The parallel *map* implementation is called *.mapParallel()*. It is implemented like this.
```kotlin
suspend fun <T, R> Iterable<T>.mapParallel(transform: (T) -> R): List<R> = coroutineScope {
    map { async { transform(it) } }.map { it.await() }
}
```

Example of using the parallel *map* operation.
```kotlin
fun showCase() {
  val list = listOf(1,2,3)
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

## Gradle
The library is published in the Maven Central repository.
Include this line in your module build.gradle file.
```gradle
dependencies {
    implementation("io.github.cvb941:kotlin-parallel-operations:2.0.0")
}
```

## Future
In the future, I would like other transformation functions to be implemented.
