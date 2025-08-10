package com.bnp.android.kata.mytictactoe.domain.interfaces

import com.bnp.android.kata.mytictactoe.domain.enums.Player

interface IGamePlay {
    fun play(column: Int, row: Int, player: Player)
}