package com.bnp.android.kata.mytictactoe.domain.entity

import com.bnp.android.kata.mytictactoe.domain.enums.Player
import com.bnp.android.kata.mytictactoe.domain.interfaces.IPlayer


class Players: IPlayer {
    private val playerX: Player = Player.X
    private val playerO: Player = Player.O
    private var current: Player = Player.EMPTY

    override fun playerX(): Player = playerX
    override fun playerO(): Player = playerO
    override fun currentPlayer(): Player = current
    override fun turnTo() {
        current = when(current) {
            Player.EMPTY,
            Player.O -> Player.X
            Player.X -> Player.O
        }
    }
}