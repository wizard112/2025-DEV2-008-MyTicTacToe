package com.rossel.android.sdk.mytictactoe.domain.entity

import com.rossel.android.sdk.mytictactoe.domain.IPlayer

class Players: IPlayer {
    val playerX = "X"
    val playerO = "O"
    var current: String = ""

    override fun turnTo() {
        current = when {
            current.isEmpty() -> playerX
            else -> {
                if (current == playerX) playerO else playerX
            }
        }
    }
}