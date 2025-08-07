package com.rossel.android.sdk.mytictactoe.domain.entity

import com.rossel.android.sdk.mytictactoe.domain.interfaces.IPlayer
import com.rossel.android.sdk.mytictactoe.domain.interfaces.IState

class Game {
    val players: IPlayer = Players()
    val state: IState = GameState()

    fun play(position: Int) {
        players.turnTo()
        state.moveTo(position = position, player = players.currentPlayer())
    }
}