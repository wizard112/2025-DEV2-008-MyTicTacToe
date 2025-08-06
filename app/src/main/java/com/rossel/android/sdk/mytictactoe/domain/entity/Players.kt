package com.rossel.android.sdk.mytictactoe.domain.entity

import com.rossel.android.sdk.mytictactoe.domain.enums.Player
import com.rossel.android.sdk.mytictactoe.domain.interfaces.IPlayer


class Players: IPlayer {
    val playerX: Player = Player.X
    val playerO: Player = Player.O
    private var current: Player = Player.EMPTY

    override fun currentPlayer(): Player = current
    override fun turnTo() {
        current = when(current) {
            Player.EMPTY,
            Player.O -> Player.X
            Player.X -> Player.O
        }
    }
}