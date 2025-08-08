package com.rossel.android.sdk.mytictactoe.domain.interfaces

interface IGameUseCase: IGameState, IGamePlayers {
    fun play(position: Int)
}