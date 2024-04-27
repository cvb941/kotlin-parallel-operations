package net.kusik.coroutines.transformations.benchmark

import net.kusik.util.PlatformInfo

fun sleep(millis: Long) {
    val startTime =  PlatformInfo.getSystemTimeInMillis()
    while (PlatformInfo.getSystemTimeInMillis() - startTime < millis) {
        // do nothing
    }
}
