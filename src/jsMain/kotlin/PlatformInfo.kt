package net.kusik.util

actual object PlatformInfo {
    actual fun availableProcessors(): Int = 1
    actual fun getSystemTimeInMillis(): Long = kotlin.js.Date.now().toLong()
}
