package net.kusik.util

import kotlin.experimental.ExperimentalNativeApi
import kotlin.system.getTimeMillis

actual object PlatformInfo {
    @OptIn(ExperimentalNativeApi::class)
    actual fun availableProcessors(): Int {
        return Platform.getAvailableProcessors()
    }

    actual fun getSystemTimeInMillis(): Long = getTimeMillis()

}
