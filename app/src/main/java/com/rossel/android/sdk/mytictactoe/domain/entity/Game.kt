package com.rossel.android.sdk.mytictactoe.domain.entity

import com.rossel.android.sdk.mytictactoe.data.exceptions.GameException

class Game {
    private val playerX = "X"
    private val player0 = "O"
    private var currentPlayer: String = ""
    private val positions: MutableList<Int> = mutableListOf()

    fun giveMeCurrentPlayer(): String = currentPlayer
    fun giveMePositions(): List<Int> = positions
    fun turnTo() {
        currentPlayer =
        if (currentPlayer.isEmpty()) playerX
        else if (currentPlayer == playerX) player0 else playerX
    }
    fun play(position: Int) {
        if (positions.contains(element = position))
            throw GameException(msg = "the position is already taken")
        positions.add(element = position)
    }
}