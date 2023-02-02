package net.kusik.util

actual object PlatformInfo {
    @OptIn(ExperimentalStdlibApi::class)
    actual fun availableProcessors(): Int {
        return Platform.getAvailableProcessors()
    }

}
