package net.kusik.util

actual object PlatformInfo {
    actual fun availableProcessors(): Int {
        return Runtime.getRuntime().availableProcessors()
    }

    actual fun getSystemTimeInMillis(): Long = System.currentTimeMillis()

}
