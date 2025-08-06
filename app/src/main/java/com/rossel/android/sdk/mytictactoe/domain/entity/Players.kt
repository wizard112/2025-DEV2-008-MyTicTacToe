package com.rossel.android.sdk.mytictactoe.domain.entity

import com.rossel.android.sdk.mytictactoe.domain.interfaces.IPlayerCurrent
import com.rossel.android.sdk.mytictactoe.domain.interfaces.IPlayerTurnTo


class Players: IPlayerTurnTo, IPlayerCurrent {
    val playerX = "X"
    val playerO = "O"
    private var current: String = ""

    override fun currentPlayer(): String = current
    override fun turnTo() {
        current = when {
            current.isEmpty() -> playerX
            else -> {
                if (current == playerX) playerO else playerX
            }
        }
    }
}