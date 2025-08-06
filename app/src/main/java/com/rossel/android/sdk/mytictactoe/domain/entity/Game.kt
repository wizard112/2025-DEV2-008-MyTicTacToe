package com.rossel.android.sdk.mytictactoe.domain.entity

import com.rossel.android.sdk.mytictactoe.data.exceptions.GameException
import com.rossel.android.sdk.mytictactoe.domain.constants.FIELD_ALREADY_TAKEN
import com.rossel.android.sdk.mytictactoe.domain.interfaces.IPlayer

class Game {
    val players: IPlayer = Players()
    private val positions: MutableList<Int> = mutableListOf()

    fun giveMePositions(): List<Int> = positions

    fun play(position: Int) {
        players.turnTo()
        if (positions.contains(element = position))
            throw GameException(msg = FIELD_ALREADY_TAKEN)
        positions.add(element = position)
    }
}