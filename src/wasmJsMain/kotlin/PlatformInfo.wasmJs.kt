package net.kusik.util

actual object PlatformInfo {
    actual fun availableProcessors(): Int = 1

    actual fun getSystemTimeInMillis(): Long = 0

}
