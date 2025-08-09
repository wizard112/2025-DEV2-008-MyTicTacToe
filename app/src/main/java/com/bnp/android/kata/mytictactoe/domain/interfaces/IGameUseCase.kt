package com.bnp.android.kata.mytictactoe.domain.interfaces

import com.bnp.android.kata.mytictactoe.domain.enums.Player

interface IGameUseCase/*: IGameState, IGamePlayers*/ {
    fun play(column: Int, row: Int, player: Player)
    fun reset()
    fun board(): Map<Int, List<Player>>
}