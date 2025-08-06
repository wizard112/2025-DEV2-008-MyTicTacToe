package com.rossel.android.sdk.mytictactoe.domain.entity

class Players {
    val playerX = "X"
    val playerO = "O"
    var current: String = ""

    fun turnTo() {
        current = when {
            current.isEmpty() -> playerX
            else -> {
                if (current == playerX) playerO else playerX
            }
        }
    }
}