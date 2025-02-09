package org.example.project

expect object Platform {
    val isAndroid: Boolean
    val isWasm: Boolean
    val isDesktop: Boolean
}
