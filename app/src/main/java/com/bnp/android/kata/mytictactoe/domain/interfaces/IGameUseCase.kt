package com.bnp.android.kata.mytictactoe.domain.interfaces

interface IGameUseCase: IGameState, IGamePlayers {
    fun play(position: Int)
}