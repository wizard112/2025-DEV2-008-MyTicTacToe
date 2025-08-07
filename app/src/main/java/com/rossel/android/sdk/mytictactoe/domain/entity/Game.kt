package com.rossel.android.sdk.mytictactoe.domain.entity

import com.rossel.android.sdk.mytictactoe.domain.interfaces.IPlayer

class Game {
    val players: IPlayer = Players()
    val state: GameState = GameState()

    fun play(position: Int) {
        players.turnTo()
        state.moveTo(position = position, player = players.currentPlayer())
    }
}