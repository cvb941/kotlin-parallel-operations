package net.kusik.util

expect object PlatformInfo {

    fun availableProcessors(): Int
    fun getSystemTimeInMillis(): Long

}
