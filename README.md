# Parallel coroutine operations on Kotlin collections
Provides parallelized map, ~~reduce~~, ~~etc.~~ operations using coroutines in Kotlin.

At this point, there is only a parallel map implementation called .mapParallel(). It is implemented like this.
```kotlin
suspend fun <T, R> Iterable<T>.mapParallel(transform: (T) -> R): List<R> = coroutineScope {
    map { async { transform(it) } }.map { it.await() }
}
```

Example of using the parallel map operation.
```kotlin
fun showCase() {
  var list = listOf(1,2,3)
  runBlocking(Dispatchers.Default) {
      var mappedList = list.mapParallel { it * 2 } // Results in [2,4,6]
  }
}
```
If you want to achieve multithreading, make sure to run the coroutine with the Default dispatcher.

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
    implementation 'com.github.cvb941:kotlin-parallel-collection-operations:1.0'
}
```

## Future
In the future, I would like parallel reduce and other transformation functions to be implemented,
as well as chunked variations of the map and future operations.
Chunked operations could potentially improve performance since they would split the collection into just a couple of segments,
which would be processed each by a single thread. That could benefit from data locality and lesser thread management.
